package bai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Tài khoản tiết kiệm với các quy định về số dư tối thiểu. */
public class SavingsAccount extends Account {
  private static final Logger logger = LoggerFactory.getLogger(SavingsAccount.class);

  public static final double MIN_BALANCE = 5000.0;
  public static final double MAX_WITHDRAW = 1000.0;

  public SavingsAccount(long accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public void deposit(double amount) {
    try {
      doDepositing(amount);
      addTransaction(new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS, amount, balance - amount, balance));
      logger.info("Nạp tiền thành công: {}", amount);
    } catch (BankException e) {
      logger.warn("Nạp tiền thất bại: {}", e.getMessage());
    }
  }

  @Override
  public void withdraw(double amount) {
    try {
      if (amount > MAX_WITHDRAW) {
        throw new InvalidFundingAmountException(amount);
      }
      if (balance - amount < MIN_BALANCE) {
        throw new InsufficientFundsException(amount);
      }
      double initialBalance = balance;
      doWithdrawing(amount);
      addTransaction(new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS, amount, initialBalance, balance));
      logger.info("Rút tiền thành công: {}", amount);
    } catch (BankException e) {
      logger.error("Lỗi rút tiền : {}", e.getMessage());
    }
  }
}