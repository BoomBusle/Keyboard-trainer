package com.boombusle.keyboardtreiner.BusinessLogic;

import static com.boombusle.keyboardtreiner.UserInterface.AllMenu.fullMenu;

import com.boombusle.keyboardtreiner.DataException.PathToFile;
import com.boombusle.keyboardtreiner.UserInterface.AllMenu;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Class Authorization for user authorization
 */
public class Authorization {
  public static String userName;
  String login;
  String pass;
  String adminCheck = "admin";

  String [] userInfo = new String[2];
  Scanner scanner = new Scanner(System.in);
  public void auth () throws IOException {
    System.out.println("Уведiть логiн :");
    login = scanner.nextLine();
    System.out.println("Уведiть пароль :");
    pass = scanner.nextLine();
    if(login.length() < 4 && pass.length() < 4)
    {
      System.out.println("Ви увели дуже малий логiн або пароль");
    }
    else if(Objects.equals(login, adminCheck)){
      System.out.println("Ви увiйшли в адмiн панель");
      AllMenu.adminMenu();
    }
    else {
      userInfo[0] = login;
      userInfo[1] = pass;
    }


    String[] user = PathToFile.pathToUser.split("\n");
    String[][] log = new String[user.length][2];
    boolean isLogin = false ;

    for (int i = 0 ; i < user.length; i++){
      log[i][0] = user[i].split("█")[0];
      log[i][1] = user[i].split("█")[1].split("\r")[0];
    }
    while (isLogin != true){
      for (int i = 0 ; log.length > i; i++) {
        if(log[i][0].equals(userInfo[0])){
          if(log[i][1].equals(userInfo[1])){
            System.out.println("Авторизацiя успiшна");
            userName = login;
            File userFile = new File("./Resources/Result"+userName+".txt");
            isLogin = true;
            fullMenu();
          }else {
            System.out.println("Некоректно введений пароль");
          }
        }
      }
    }
    if (isLogin == false){
      System.out.println("Користувач з данним iменем не зареєстрований");
    }
  }
}

