package bai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lớp đại diện cho tài khoản vãng lai.
 * Loại tài khoản này không có giới hạn rút tiền như tài khoản tiết kiệm.
 */
public class CheckingAccount extends Account {
  private static final Logger logger = LoggerFactory.getLogger(CheckingAccount.class);

  /**
   * Khởi tạo tài khoản vãng lai.
   *
   * @param accountNumber số tài khoản.
   * @param balance số dư ban đầu.
   */
  public CheckingAccount(long accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public void deposit(double amount) {
    double initialBalance = getBalance();
    try {
      doDepositing(amount);
      double finalBalance = getBalance();

      Transaction t = new Transaction(
              Transaction.TYPE_DEPOSIT_CHECKING,
              amount,
              initialBalance,
              finalBalance
      );
      addTransaction(t);
      logger.info("Nạp tiền vãng lai thành công. Số tiền: {}, Số dư mới: {}",
              amount, finalBalance);

    } catch (BankException e) {
      logger.error("Lỗi nạp tiền vãng lai: {}", e.getMessage());
    }
  }

  @Override
  public void withdraw(double amount) {
    double initialBalance = getBalance();
    try {
      doWithdrawing(amount);
      double finalBalance = getBalance();

      Transaction t = new Transaction(
              Transaction.TYPE_WITHDRAW_CHECKING,
              amount,
              initialBalance,
              finalBalance
      );
      addTransaction(t);
      logger.info("Rút tiền vãng lai thành công. Số tiền: {}, Số dư còn lại: {}",
              amount, finalBalance);

    } catch (BankException e) {
      logger.warn("Rút tiền vãng lai thất bại: {}", e.getMessage());
    }
  }
}