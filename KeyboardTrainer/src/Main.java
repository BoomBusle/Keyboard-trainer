import com.boombusle.keyboardtreiner.UserInterface.AllMenu;
import java.io.IOException;

/**
 * @version 1.0
 * @author BoomBusle
 */
public class Main {

  /**
   * Method start program
   * @param args
   */
  public static void main(String[] args) {
    AllMenu mainMenu = new AllMenu();
    try {
      mainMenu.Menu();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}


