package pe.edu.pucp.johannmorales.thesis.algorithm.greywolf;

import pe.edu.pucp.johannmorales.thesis.algorithm.general.MetaheuristicAlgorithm;
import pe.edu.pucp.johannmorales.thesis.algorithm.general.MetaheuristicAlgorithmParameters;
import pe.edu.pucp.johannmorales.thesis.algorithm.general.model.Individual;

public final class GreyWolfAlgorithm extends MetaheuristicAlgorithm {

  @Override
  public Individual run(MetaheuristicAlgorithmParameters parameters) {
    return this.run((GreyWolfAlgorithmParameters) parameters);
  }

  public Individual run(GreyWolfAlgorithmParameters parameters) {
    return null;
  }
}
