package pe.edu.pucp.johannmorales.thesis.algorithm.general;

import pe.edu.pucp.johannmorales.thesis.algorithm.exception.InvalidParametersException;
import pe.edu.pucp.johannmorales.thesis.algorithm.exception.ValidatorUtils;
import pe.edu.pucp.johannmorales.thesis.algorithm.general.model.Individual;

public abstract class MetaheuristicAlgorithm {

  public abstract Individual run(MetaheuristicAlgorithmParameters parameters);

  protected void validateParameters(MetaheuristicAlgorithmParameters parameters)
      throws InvalidParametersException {
    ValidatorUtils.greaterThanZero(parameters.getIterations());
  }
}
