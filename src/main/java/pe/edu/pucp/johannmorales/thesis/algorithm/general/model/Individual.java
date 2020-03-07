package pe.edu.pucp.johannmorales.thesis.algorithm.general.model;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Individual implements Serializable {

  private static final long serialVersionUID = 6502792323702631204L;

  public BigDecimal cost;

}
