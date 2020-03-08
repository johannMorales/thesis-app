package pe.edu.pucp.johannmorales.thesis.algorithm.general;

import io.reactivex.rxjava3.core.Single;
import pe.edu.pucp.johannmorales.thesis.algorithm.exception.InvalidParameterValueException;
import pe.edu.pucp.johannmorales.thesis.algorithm.exception.ValidatorUtils;
import pe.edu.pucp.johannmorales.thesis.algorithm.general.model.Individual;

public abstract class MetaheuristicAlgorithm {

  public abstract Single<Individual> run(MetaheuristicAlgorithmParameters parameters);

  protected void validateParameters(MetaheuristicAlgorithmParameters parameters)
      throws InvalidParameterValueException {
    ValidatorUtils.greaterThanZero(parameters.getIterations());
  }
}
