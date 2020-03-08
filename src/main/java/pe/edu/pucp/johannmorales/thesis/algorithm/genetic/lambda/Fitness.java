package pe.edu.pucp.johannmorales.thesis.algorithm.genetic.lambda;

import java.math.BigDecimal;
import pe.edu.pucp.johannmorales.thesis.algorithm.genetic.model.Chromosome;

@FunctionalInterface
public interface Fitness {

  BigDecimal calculate(final Chromosome c);

}
