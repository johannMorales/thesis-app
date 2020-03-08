package pe.edu.pucp.johannmorales.thesis.algorithm.genetic.lambda;

import pe.edu.pucp.johannmorales.thesis.algorithm.genetic.model.Chromosome;

@FunctionalInterface
public interface ChromosomesFactory {

  Chromosome create();

}
