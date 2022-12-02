package com.boombusle.keyboardtreiner.BusinessLogic;

import com.boombusle.keyboardtreiner.DataException.PathToFile;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

/**
 * Class game
 */
public class KeyGame {

  public static final String RESET = "\u001B[0m";
  public static final String RED = "\u001B[31m";

  public static final String BLUE = "\u001B[34m";
  static int trueWord;
  static int falseWord;
  static String[] gameWord = PathToFile.pathToGame.split(" ");

  /**
   * Method start game
   */
  public static void game() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Скiльки слiв має бути ?(до " + gameWord.length + ")");
    int howWord = Integer.parseInt(scanner.nextLine());
    long startTime = System.currentTimeMillis();
    for (int i = 0; howWord > i; i++) {
      String nowWord = gameWord[i];
      System.out.println(nowWord);
      String userWord = scanner.nextLine();
      if (!Objects.equals(userWord, nowWord)) {
        System.out.println(RED + userWord + RESET);
        falseWord++;
      } else {
        System.out.println(BLUE + userWord + RESET);
        trueWord++;
      }
    }
    long stopTime = System.currentTimeMillis();
    long elapsedTime = (long) (stopTime - startTime) / 1000;
    String localData = String.valueOf(dateFormatterNew.format(LocalDateTime.now()));
    writingTextToFile("Результати\n",
        "☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰\n" + localData
            + "\n☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰\nВашi результати \nПравильних слiв:"
            + trueWord + "\nНеправильних слiв:" + falseWord + "\nЧас проведений в iгрi:"
            + elapsedTime + " секунд\n☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰");
    falseWord = 0;
    trueWord = 0;
  }

  private static final DateTimeFormatter dateFormatterNew
      = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm:ss a").withLocale(Locale.ENGLISH);

  static void writingTextToFile(String pastText, String textWritten) {
    File result = new File("./Resources/Result" + Authorization.userName + ".txt");
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
