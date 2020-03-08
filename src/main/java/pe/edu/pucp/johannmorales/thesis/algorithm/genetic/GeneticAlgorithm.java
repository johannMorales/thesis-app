package pe.edu.pucp.johannmorales.thesis.algorithm.genetic;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import pe.edu.pucp.johannmorales.thesis.algorithm.exception.MissingParameterException;
import pe.edu.pucp.johannmorales.thesis.algorithm.genetic.model.Chromosome;

@Slf4j
public class GeneticAlgorithm {

  private GeneticAlgorithm() {
  }

  public static Single<Chromosome> run(GeneticAlgorithmParameters parameters)
      throws MissingParameterException {
    Observable<Chromosome> population = processGeneration(parameters.getIterations(), parameters);
    return population.firstOrError();
  }


  private static Observable<Chromosome> processGeneration(Integer n, GeneticAlgorithmParameters parameters) {
    if (n == 0) {
      return Observable
          .just((Callable<Chromosome>) () -> parameters.getChromosomesFactory().create())
          .repeat(parameters.getPopulationSize())
          .map(Callable::call)
          .map(c -> {
            c.setCost(parameters.getFitness().calculate(c));
            return c;
          })
          .sorted(Comparator.comparing(Chromosome::getCost).reversed())
          .subscribeOn(Schedulers.computation());
    } else {

      Observable<Chromosome> population = processGeneration(n - 1, parameters)
          .toList()
          .doOnSuccess(c -> log.info("Processed {}", StringUtils.leftPad(n.toString(), 3, '0')))
          .flatMapObservable(populationList -> {
            List<Integer> range = IntStream.range(0, parameters.getPopulationSize()).boxed()
                .collect(Collectors.toCollection(ArrayList::new));

            Observable<Chromosome> lastPopulation = Observable.fromIterable(populationList);
            Single<List<Chromosome>> lastPopulationList = lastPopulation
                .toList();

            Collections.shuffle(range);
            Observable<Chromosome> survivors = lastPopulation.take(parameters.getSurvivorsSize());
            Observable<Chromosome> recombined = lastPopulationList
                .map(last -> {
                  LinkedList<Chromosome> chromosomes = new LinkedList<>();
                  System.out.println(parameters.getRecombinedSize());
                  System.out.println(populationList.size());
                  System.out.println(range.size());
                  for (int i = 0; i < parameters.getRecombinedSize(); i++) {
                    chromosomes
                        .add(parameters.getRecombination()
                            .recombine(populationList.get(new Random().nextInt(parameters.getPopulationSize())),
                                populationList.get(new Random().nextInt(parameters.getPopulationSize()))));
                  }
                  return chromosomes;
                })
                .flatMapObservable(Observable::fromIterable)
                .map(c -> {
                  c.setCost(parameters.getFitness().calculate(c));
                  return c;
                })
                .doOnNext(c -> log.info("{}", c))
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.single());

            Collections.shuffle(range);
            Observable<Chromosome> mutants = lastPopulationList
                .map(last -> {
                  LinkedList<Chromosome> chromosomes = new LinkedList<>();
                  for (int i = 0; i < parameters.getMutantsSize(); i++) {
                    chromosomes
                        .add(parameters.getMutation()
                            .mutate(populationList.get(range.get(i))));
                  }
                  return chromosomes;
                })
                .flatMapObservable(Observable::fromIterable)
                .map(c -> {
                  c.setCost(parameters.getFitness().calculate(c));
                  return c;
                })
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.single());

            return Observable.merge(survivors, recombined, mutants)
                .sorted(Comparator.comparing(Chromosome::getCost).reversed())
                .take(parameters.getPopulationSize())
                .doOnNext(c -> log.info("\tGen[{}] {}", n, c))
                .subscribeOn(Schedulers.single());
          });
      return population;

    }
  }
}

