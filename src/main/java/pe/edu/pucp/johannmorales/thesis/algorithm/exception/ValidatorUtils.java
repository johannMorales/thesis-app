package pe.edu.pucp.johannmorales.thesis.algorithm.exception;

public abstract class ValidatorUtils {

  public static void greaterThanZero(Double d) throws InvalidParameterValueException {
    if (d == null || d <= 0) {
      throw new InvalidParameterValueException();
    }
  }

  public static void greaterThanZero(Integer d) throws InvalidParameterValueException {
    if (d == null || d <= 0) {
      throw new InvalidParameterValueException();
    }
  }

}
