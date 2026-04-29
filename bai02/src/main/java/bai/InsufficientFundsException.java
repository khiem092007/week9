package bai;

import java.util.Locale;

/** Ngoại lệ khi số dư tài khoản không đủ. */
public class InsufficientFundsException extends BankException {
  /** Ngoại lệ khi số dư tài khoản không đủ.
   *
   * @param amount so du.
   * */
  public InsufficientFundsException(double amount) {
    super(
        "Số dư tài khoản không đủ $"
            + String.format(Locale.US, "%.2f", amount)
            + " để thực hiện giao dịch");
  }
}
