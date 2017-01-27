package cs4800.hw02;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public Solution() {
  }

  public static void main(String args[]) {
    List<String> strings = readStrings();
    List<Integer> integers = convertToInt(strings);
    Integer[][] matrix = initMatrix(strings, integers);
    Boolean b = solveSquare(matrix);
    printMatrix(matrix);
  }

  private static boolean isZero(Integer[][] matrix, int row, int col) {
    if (matrix[row][col] == 0) {
      return true;
    } else {
      return false;
    }
  }

  private static boolean usedInRow(Integer[][] matrix, int row, int num) {
    boolean used = false;
    for (int col = 0; col < matrix.length; col++) {
      if (matrix[row][col] == num) {
        used = true;
      }
    }
    return used;
  }

  private static boolean usedInCol(Integer[][] matrix, int col, int num) {
    boolean used = false;
    for (int row = 0; row < matrix.length; row++) {
      if (matrix[row][col] == num) {
        used = true;
      }
    }
    return used;
  }

  private static boolean isSafe(Integer[][] matrix, int row, int col, int num) {
    return !usedInRow(matrix, row, num) && !usedInCol(matrix, col, num);
  }

  private static boolean solveSquare(Integer[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        if (!isZero(matrix, i, j)) {
          continue;
        }
        for (int num = 1; num <= matrix.length; num++) {
          if (isSafe(matrix, i, j, num)) {
            matrix[i][j] = num;
            if (solveSquare(matrix)) {
              return true;
            } else {
              matrix[i][j] = 0;
            }
          }
        }
        return false;
      }
    }
    return true;
  }

  private static void printMatrix(Integer[][] matrix) {
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix.length; col++) {
        System.out.printf("%d ", matrix[row][col]);
        if (col == matrix.length - 1) {
          System.out.printf("\n");
        }
      }
    }
  }

  private static Integer[][] initMatrix(List<String> strings, List<Integer> integers) {
    Integer matrix[][];
    matrix = new Integer[strings.size()][strings.size()];
    int count = -1;
    for (int i = 0; i < matrix.length; i++) {
      count++;
      for (int r = 0; r < matrix[i].length; r++) {
        if (i != 0) {
          matrix[i][r] = integers.get(r + (strings.size() * count));
        } else {
          matrix[i][r] = integers.get(r);
        }
      }
    }
    return matrix;
  }


  private static List<Integer> convertToInt(List<String> strings) {
    List<Integer> integer = new ArrayList<>();
    for (int i = 0; i < strings.size(); i++) {
      String splitLine[] = strings.get(i).split(" ");
      for (int r = 0; r < strings.size(); r++) {
        integer.add(Integer.parseInt(splitLine[r].replaceAll("\\D", "")));
      }
    }
    return integer;
  }

  private static List<String> readStrings() {
    List<String> myStrings = new ArrayList<String>();
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      String line = scanner.nextLine();
      myStrings.add(line + "\n");
    }
    return myStrings;
  }

}