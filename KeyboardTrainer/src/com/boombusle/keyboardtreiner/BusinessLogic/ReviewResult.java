package com.boombusle.keyboardtreiner.BusinessLogic;

import com.boombusle.keyboardtreiner.DataException.PathToFile;
import com.boombusle.keyboardtreiner.DataException.Reader;
import com.boombusle.keyboardtreiner.UserInterface.AllMenu;
import java.io.IOException;
import java.util.Scanner;
/**
 * Class result user last session
 */
public class ReviewResult {

  /**
   * Method check result user last session
   */
  public static void reviewResult(){
    Scanner scanner = new Scanner(System.in);
    try {
      System.out.println(Reader.readAllText("./Resources/Result"+Authorization.userName+".txt"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    System.out.println("Уведiть 1 якшо хочете повернутись до гри i 2 якшо хочете вийти ");
    int choice ;
    choice = Integer.parseInt(scanner.nextLine());
    switch (choice) {
      case 1 -> AllMenu.fullMenu();
      case 2 ->{
        System.out.println();
        System.out.println("Жаль що ви нас покидаєте \uD83D\uDC94");
        System.exit(2);
      }
      default -> System.out.println("Невiрний вибiр");
    }
  }
}
