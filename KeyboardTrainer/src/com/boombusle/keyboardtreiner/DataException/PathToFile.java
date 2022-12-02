package com.boombusle.keyboardtreiner.DataException;

import com.boombusle.keyboardtreiner.BusinessLogic.Authorization;
import java.io.IOException;

/**
 * Class PathToFile have all method paths to files
 */
public class PathToFile {
        public static String pathToUser;
        static {
          try {
            pathToUser = Reader.readAllText("./Resources/User.txt");
          }
          catch (IOException exception){
            throw new RuntimeException(exception);
          }
        }
  public static String pathToGame;
  static {
    try {
      pathToGame = Reader.readAllText("./Resources/Game.txt");
    }
    catch (IOException exception){
      throw new RuntimeException(exception);
    }
  }

}
