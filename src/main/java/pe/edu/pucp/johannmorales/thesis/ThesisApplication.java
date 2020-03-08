package pe.edu.pucp.johannmorales.thesis;

import io.reactivex.rxjava3.schedulers.Schedulers;
import java.math.BigDecimal;
import java.net.URL;
import java.util.BitSet;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import pe.edu.pucp.johannmorales.thesis.algorithm.genetic.GeneticAlgorithm;
import pe.edu.pucp.johannmorales.thesis.algorithm.genetic.GeneticAlgorithmParameters;
import pe.edu.pucp.johannmorales.thesis.algorithm.genetic.model.Chromosome;
import pe.edu.pucp.johannmorales.thesis.utl.ResourceLoader;

@Slf4j
public class ThesisApplication {

  public static void main(String[] args) {

    String target = "1010100101010101010101010101001010010101001001010101";

    GeneticAlgorithm.run(GeneticAlgorithmParameters
        .builder()
        .iterations(500)
        .populationSize(25)
        .surviveRatio(0.2f)
        .recombinationRatio(0.6f)
        .mutationRatio(0.2f)
        .recombination((c1, c2) -> {
          Chromosome niu = new Chromosome();
          niu.setSize(target.length());
          niu.setData(new BitSet(target.length()));
          Integer threshold = Long.valueOf(Math.round(Math.random() * target.length())).intValue();
          for (Integer i = 0; i < threshold; i++) {
            niu.getData().set(i, c1.getData().get(i));

          }
          for (Integer i = threshold; i < target.length(); i++) {
            niu.getData().set(i, c2.getData().get(i));
          }
          return niu;
        })
        .mutation(c -> {
          Chromosome niu = new Chromosome();
          niu.setSize(target.length());
          niu.setData(new BitSet(target.length()));
          for (int i = 0; i < target.length(); i++) {
            if (Math.random() < 0.25) {
              niu.getData().set(i, !c.getData().get(i));
            } else {
              niu.getData().set(i, c.getData().get(i));
            }
          }
          return niu;
        })
        .fitness((c) -> {
          BigDecimal fitness = BigDecimal.valueOf(target.length());
          for (int i = 0; i < c.getData().length(); i++) {
            if ((target.charAt(i) == '1') != c.getData().get(i)) {
              fitness = fitness.subtract(BigDecimal.ONE);
            }
          }
          return fitness;
        })
        .chromosomesFactory(() -> Chromosome.defaultFactory(target.length()))
        .build())
        .subscribeOn(Schedulers.trampoline()).blockingGet();

  }

  public void start(Stage primaryStage) throws Exception {

    Parent root = FXMLLoader.load((URL) ResourceLoader.load("asdasd"));
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();
  }

}
