package com.boombusle.keyboardtreiner.BusinessLogic;

import com.boombusle.keyboardtreiner.DataException.PathToFile;
import com.boombusle.keyboardtreiner.UserInterface.AllMenu;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Class edit text to file
 */
public class EditTextGame {
  public static String editText;

  /**
   * Method edit text to file
   */
  public static void editText(){
    Scanner edit = new Scanner(System.in);
    System.out.println(PathToFile.pathToGame);
    System.out.println("☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰\nУведiть текст який хочете вiдредагувати\n☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰");
    editText = edit.nextLine();
    writingTextToFile("",editText);
    AllMenu.adminMenu();
  }
  /**
   * Method writingTextToFile write text to file
   * @param pastText past text to file or path to file
   * @param textWritten text written in file
   */
  static void writingTextToFile(String pastText, String textWritten) {
    File result = new File("./Resources/Game.txt");
    PrintWriter pw = null;
    try {
      pw = new PrintWriter(result);
      String newText = pastText;
      newText += textWritten;
      pw.write(newText);
      pw.close();
    } catch (IOException e) {
      System.out.println("Error: " + e);
    }
  }
}
