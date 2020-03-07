package pe.edu.pucp.johannmorales.thesis.algorithm.exception;

public abstract class ValidatorUtils {

  public static void greaterThanZero(Double d) throws InvalidParametersException {
    if (d == null || d <= 0) {
      throw new InvalidParametersException();
    }
  }

  public static void greaterThanZero(Integer d) throws InvalidParametersException {
    if (d == null || d <= 0) {
      throw new InvalidParametersException();
    }
  }

}
