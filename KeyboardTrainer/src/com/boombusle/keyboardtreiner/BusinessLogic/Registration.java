package com.boombusle.keyboardtreiner.BusinessLogic;

import com.boombusle.keyboardtreiner.DataException.PathToFile;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *  Class Registration for user registration
 */
public class Registration {
  String login;
  String pass;

  String confpass;
  String [] userInfo = new String[2];

  /**
   * Method reg for user registration
   */
  public void reg()
  {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Уведiть логiн :");
    login = scanner.nextLine();
    System.out.println("Уведiть пароль :");
    pass = scanner.nextLine();
    System.out.println("Повторно уведiть пароль :");
    confpass = scanner.nextLine();
    if(login.length() < 4 && pass.length() < 4)
    {
      System.out.println("Ви увели дуже малий логiн або пароль");
    }else if(pass == confpass)
    {
      System.out.println("Паролi не спiвпадають \uD83D\uDE3F");
    } else {
      userInfo[0] = login;
      userInfo[1] = pass;
      writingTextToFile(PathToFile.pathToUser ,userInfo[0] +"█"+ userInfo[1] );
      Authorization.userName = login;
      File userFile = new File("./Resources/Result"+Authorization.userName+".txt");
    }
  }

  /**
   * Method writingTextToFile write text to file
   * @param pastText past text to file or path to file
   * @param textWritten text written in file
   */
  void writingTextToFile( String pastText, String textWritten) {
    File file = new File("./Resources/User.txt");
    PrintWriter pw = null;
    try {
      pw = new PrintWriter(file);
      String newText = pastText;
      newText += textWritten;
      pw.write(newText);
      pw.close();
    } catch (IOException e) {
      System.out.println("Error: " + e);
    }
  }
}
