package com.boombusle.keyboardtreiner.DataException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Class Reader read text to file
 */
public class Reader {
  public static String readAllText(String link) throws IOException {
    BufferedReader reader = Files.newBufferedReader(Paths.get(link));
    StringBuilder content = new StringBuilder();
    String line;

    while ((line = reader.readLine()) != null) {
      content.append(line);
      content.append(System.lineSeparator());
    }
    return content.toString();
  }

}
