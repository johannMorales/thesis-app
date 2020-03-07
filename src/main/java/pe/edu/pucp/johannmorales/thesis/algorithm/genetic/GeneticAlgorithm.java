package pe.edu.pucp.johannmorales.thesis.algorithm.genetic;

import pe.edu.pucp.johannmorales.thesis.algorithm.exception.InvalidParametersException;
import pe.edu.pucp.johannmorales.thesis.algorithm.exception.ValidatorUtils;
import pe.edu.pucp.johannmorales.thesis.algorithm.general.MetaheuristicAlgorithm;
import pe.edu.pucp.johannmorales.thesis.algorithm.general.MetaheuristicAlgorithmParameters;
import pe.edu.pucp.johannmorales.thesis.algorithm.genetic.model.Genoma;

public final class GeneticAlgorithm extends MetaheuristicAlgorithm {

  @Override
  public Genoma run(MetaheuristicAlgorithmParameters genericParameters) {
    GeneticAlgorithmParameters parameters = (GeneticAlgorithmParameters) genericParameters;
    this.validateParameters(parameters);
    return this.run(parameters);
  }

  private void validateParameters(GeneticAlgorithmParameters parameters)
      throws InvalidParametersException {
    super.validateParameters(parameters);
    ValidatorUtils.greaterThanZero(parameters.getSurviveRatio());
    ValidatorUtils.greaterThanZero(parameters.getRecombinationRatio());
    ValidatorUtils.greaterThanZero(parameters.getMutationRatio());
  }

  public Genoma run(GeneticAlgorithmParameters parameters) {
    this.validateParameters(parameters);
    return null;
  }

}
