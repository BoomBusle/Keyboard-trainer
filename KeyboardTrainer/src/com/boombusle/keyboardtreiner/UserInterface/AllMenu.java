package com.boombusle.keyboardtreiner.UserInterface;

import com.boombusle.keyboardtreiner.BusinessLogic.Authorization;
import com.boombusle.keyboardtreiner.BusinessLogic.EditTextGame;
import com.boombusle.keyboardtreiner.BusinessLogic.KeyGame;
import com.boombusle.keyboardtreiner.BusinessLogic.Registration;
import com.boombusle.keyboardtreiner.BusinessLogic.ReviewResult;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class AllMenu have all menus in program
 */
public class AllMenu {

  private static int userChoice;

  /**
   * Method menu is start menu program
   * @throws IOException
   */
  public static void Menu() throws IOException {
    Scanner mainInput = new Scanner(System.in);
    Authorization authorization = new Authorization();
    Registration registration = new Registration();
    System.out.println("☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰");
    System.out.println("Ви увiйшли до програми для тренування навичок друкування на клавiатурi");
    System.out.println("☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰");
    System.out.println("① Авторизуватись ✔");
    System.out.println("② Зареєструватись ✍");
    System.out.println("③ Вихiд ❌");
    System.out.println("☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰");
    userChoice = mainInput.nextInt();
    switch (userChoice) {
      case 1 -> {
        authorization.auth();
        fullMenu();
      }
      case 2 -> {
        registration.reg();
        fullMenu();
      }
      case 3 -> {
        System.out.println("Жаль що ви нас покидаєте \uD83D\uDC94");
        System.exit(3);
      }
      default -> {
        System.out.println("Невiрний вибiр");
        Menu();
      }
    }
  }

  /**
   * Method returnMenu is return menu program
   */
  static void returnMenu() {
    Scanner returnInMenu = new Scanner(System.in);
    int choice;

    System.out.println("☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰");
    System.out.println("① Повернутися до меню ☺ ");
    System.out.println("② Вийти з програми ☹");
    System.out.println("☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰");
    choice = returnInMenu.nextInt();
    switch (choice) {
      case 1 -> {
        try {
          Menu();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      case 2 -> {
        System.out.println();
        System.out.println("Жаль що ви нас покидаєте \uD83D\uDC94");
        System.exit(2);
      }
      default -> {
        System.out.println("Невiрний вибiр");
        returnMenu();
      }
    }
  }

  /**
   * Method fullMenu is menu after authorization or registration program
   */
  public static void fullMenu() {
    Scanner fullInMenu = new Scanner(System.in);
    int choice;
    System.out.println("☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰");
    System.out.println("① Почати гру ☺ ");
    System.out.println("② Переглянути результати \uD83D\uDD0E");
    System.out.println("② Вийти з програми ☹");
    System.out.println("☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰");
    choice = fullInMenu.nextInt();
    switch (choice) {
      case 1 -> {
        KeyGame.game();
      }
      case 2 -> ReviewResult.reviewResult();
      case 3 -> {
        System.out.println();
        System.out.println("Жаль що ви нас покидаєте \uD83D\uDC94");
        System.exit(2);
      }
      default -> {
        System.out.println("Невiрний вибiр");
        fullMenu();
      }
    }
  }

  /**
   * Method adminMenu is admin panel
   */
  public static void adminMenu(){
    Scanner adminInMenu = new Scanner(System.in);
    int choice;
    System.out.println("☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰");
    System.out.println("① Почати гру ☺ ");
    System.out.println("② Переглянути результати \uD83D\uDD0E");
    System.out.println("③ Редагувати текст гри ✍");
    System.out.println("④ Вийти з програми ☹");
    System.out.println("☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰");
    choice = adminInMenu.nextInt();
    switch (choice) {
      case 1 -> KeyGame.game();
      case 2 -> ReviewResult.reviewResult();
      case 3 -> EditTextGame.editText();
      case 4 -> {
        System.out.println();
        System.out.println("Жаль що ви нас покидаєте \uD83D\uDC94");
        System.exit(2);
      }
      default -> {
        System.out.println("Невiрний вибiр");
        fullMenu();
      }
    }
  }
}