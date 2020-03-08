package pe.edu.pucp.johannmorales.thesis.algorithm.genetic.lambda;

import pe.edu.pucp.johannmorales.thesis.algorithm.genetic.model.Chromosome;

@FunctionalInterface
public interface Recombination {

  Chromosome recombine(final Chromosome cA, final Chromosome cB);

}
