package pe.edu.pucp.johannmorales.thesis.algorithm.genetic.model;

import java.math.BigDecimal;
import java.util.BitSet;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

@Getter
@Setter
public class Chromosome {

  private Integer size;
  private BitSet data;
  private BigDecimal cost;

  public static Chromosome defaultFactory(int size) {
    Chromosome cromosome = new Chromosome();
    cromosome.size = size;
    cromosome.setData(new BitSet(size));
    for (int i = 0; i < size; i++) {
      cromosome.getData().set(i, Math.random() < 0.5);
    }
    return cromosome;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < data.length(); i++) {
      s.append(data.get(i) ? 1 : 0);
    }

    return "Chromosome{" +
        "data=" + StringUtils.rightPad(s.toString(), size, '0') +
        ", cost=" + cost +
        '}';
  }
}
