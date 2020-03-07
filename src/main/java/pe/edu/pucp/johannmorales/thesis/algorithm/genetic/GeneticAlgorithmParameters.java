package pe.edu.pucp.johannmorales.thesis.algorithm.genetic;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.johannmorales.thesis.algorithm.general.MetaheuristicAlgorithmParameters;

@Getter
@Setter
@Builder
public class GeneticAlgorithmParameters extends MetaheuristicAlgorithmParameters {

  private Double surviveRatio;
  private Double mutationRatio;
  private Double recombinationRatio;

}
