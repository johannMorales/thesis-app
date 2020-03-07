package pe.edu.pucp.johannmorales.thesis.utl;

import java.net.URL;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResourceLoader {

  private static final String BASE_PATH;

  static {
    BASE_PATH = System.class.getClassLoader().getResource("pom.xml").getPath();
  }

  public static URL load(String relativeToRootPath) {
    URL obj = System.class.getResource(relativeToRootPath);
    if (obj == null) {
      log.error("Could not load resource: {} [{}]", relativeToRootPath, BASE_PATH);
    }
    return obj;
  }

}
