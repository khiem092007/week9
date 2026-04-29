package bai;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Lớp trừu tượng đại diện cho một tài khoản ngân hàng. */
public abstract class Account {
  private static final Logger logger = LoggerFactory.getLogger(Account.class);

  public static final String CHECKING_TYPE = "CHECKING";
  public static final String SAVINGS_TYPE = "SAVINGS";

  protected long accountNumber;
  protected double balance;
  protected List<Transaction> transactionList;

  /**
   * Khởi tạo tài khoản.
   *
   * @param accountNumber số tài khoản.
   * @param balance số dư ban đầu.
   */
  public Account(long accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.transactionList = new ArrayList<>();
  }

  public abstract void withdraw(double amount);

  public abstract void deposit(double amount);

  protected void doDepositing(double amount) throws InvalidFundingAmountException {
    if (amount <= 0) {
      throw new InvalidFundingAmountException(amount);
    }
    this.balance += amount;
  }

  protected void doWithdrawing(double amount)
          throws InvalidFundingAmountException, InsufficientFundsException {
    if (amount <= 0) {
      throw new InvalidFundingAmountException(amount);
    }
    if (amount > this.balance) {
      throw new InsufficientFundsException(amount);
    }
    this.balance -= amount;
  }

  /** Trả về lịch sử giao dịch định dạng chuỗi. */
  public String getTransactionHistory() {
    StringBuilder sb = new StringBuilder();
    sb.append("Lịch sử giao dịch của tài khoản ").append(accountNumber).append(":\n");
    for (int i = 0; i < transactionList.size(); i++) {
      sb.append(transactionList.get(i).getTransactionSummary());
      if (i < transactionList.size() - 1) {
        sb.append("\n");
      }
    }
    logger.debug("Truy xuất lịch sử giao dịch cho tài khoản: {}", accountNumber);
    return sb.toString();
  }

  /**
   * Them phien giao dich.
   *
   * @param transaction phien giao dich.
   */
  public void addTransaction(Transaction transaction) {
    if (transaction != null) {
      transactionList.add(transaction);
    }
  }

  public double getBalance() {
    return balance;
  }

  public long getAccountNumber() {
    return accountNumber;
  }
}