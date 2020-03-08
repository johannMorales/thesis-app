package pe.edu.pucp.johannmorales.thesis.algorithm.genetic;

import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pe.edu.pucp.johannmorales.thesis.algorithm.general.MetaheuristicAlgorithmParameters;
import pe.edu.pucp.johannmorales.thesis.algorithm.genetic.lambda.ChromosomesFactory;
import pe.edu.pucp.johannmorales.thesis.algorithm.genetic.lambda.Fitness;
import pe.edu.pucp.johannmorales.thesis.algorithm.genetic.lambda.Mutation;
import pe.edu.pucp.johannmorales.thesis.algorithm.genetic.lambda.Recombination;

@Getter
@Setter
@ToString
@Builder

public final class GeneticAlgorithmParameters extends MetaheuristicAlgorithmParameters implements
    Serializable {

  private static final long serialVersionUID = -3327500268488329660L;

  private Integer iterations;
  private Float surviveRatio;
  private Float recombinationRatio;
  private Float mutationRatio;
  private Integer populationSize;
  private ChromosomesFactory chromosomesFactory;
  private Fitness fitness;
  private Mutation mutation;
  private Recombination recombination;

  public Integer getSurvivorsSize() {
    return Math.round(populationSize * surviveRatio);
  }

  public Integer getRecombinedSize() {
    return Math.round(populationSize * recombinationRatio);
  }

  public Integer getMutantsSize() {
    return Math.round(populationSize * mutationRatio);
  }
}
