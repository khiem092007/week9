package bai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**Class giup tinh 2 phep tinh cong va chia.*/
public class Calculator {
  private static final Logger logger = LoggerFactory.getLogger(Calculator.class);

  /**
   * Method thuc hien phep cong.
   *
   * @param a so thuc.
   * @param b so thuc .
   * @return ra tong cua a va b.
   */
  public double plus(double a, double b) {
    logger.info("Thực hiện phép cộng: {} + {}", a, b);
    return a + b;
  }

  /**
   * Method thuc hien phep chia.
   *
   * @param a tu so.
   * @param b mau so.
   * @return tra ve thuong cua a chia b.
   */
  public double divide(double a, double b) {
    if (b == 0) {
      logger.error("Lỗi chia cho 0 với tử số: {}", a);
      throw new ArithmeticException("Mau so phai khac 0");
    }
    logger.info("Thực hiện phép chia: {} / {}", a, b);
    return a / b;
  }
}
