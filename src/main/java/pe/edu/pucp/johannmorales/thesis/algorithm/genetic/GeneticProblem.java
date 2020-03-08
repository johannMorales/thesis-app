package pe.edu.pucp.johannmorales.thesis.algorithm.genetic;

import pe.edu.pucp.johannmorales.thesis.algorithm.genetic.model.Chromosome;

public interface GeneticProblem {

  Chromosome cromosomeFactory();

  Double fitness();

  Chromosome mutation(Chromosome chromosome);

  Chromosome recombination(Chromosome chromosomeA, Chromosome chromosomeB);

}
