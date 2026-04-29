package bai;

import java.util.Scanner;

/**O day thuc thi code. */
public class Main {
  /**
   * Phan chay code.
   *
   * @param args tham so la mot danh sach cac string.
   */
  public static void main(String[] args) {
    Calculator casioFx580 = new Calculator();
    Scanner inp = new Scanner(System.in);
    System.out.print("A= ");
    double a = inp.nextDouble();
    System.out.println("B= ");
    double b = inp.nextDouble();
    System.out.println("A + B= ");
    double add = casioFx580.plus(a, b);
    System.out.println("A/B= ");
    double divide = casioFx580.divide(a, b);
  }
}
