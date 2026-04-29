package bai;

import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lớp đại diện cho một giao dịch ngân hàng.
 * Lưu trữ thông tin về loại giao dịch, số tiền và biến động số dư.
 */
public class Transaction {
  private static final Logger logger = LoggerFactory.getLogger(Transaction.class);

  public static final int TYPE_DEPOSIT_CHECKING = 1;
  public static final int TYPE_WITHDRAW_CHECKING = 2;
  public static final int TYPE_DEPOSIT_SAVINGS = 3;
  public static final int TYPE_WITHDRAW_SAVINGS = 4;

  private int type;
  private double amount;
  private double initialBalance;
  private double finalBalance;

  /**
   * Khởi tạo một giao dịch mới.
   *
   * @param type           loại giao dịch (1-4)
   * @param amount         số tiền giao dịch
   * @param initialBalance số dư trước giao dịch
   * @param finalBalance   số dư sau giao dịch
   */
  public Transaction(int type, double amount, double initialBalance, double finalBalance) {
    this.type = type;
    this.amount = amount;
    this.initialBalance = initialBalance;
    this.finalBalance = finalBalance;
  }

  // Các hàm Getter/Setter nên thêm Javadoc đơn giản nếu Checkstyle yêu cầu
  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public double getInitialBalance() {
    return initialBalance;
  }

  public void setInitialBalance(double initialBalance) {
    this.initialBalance = initialBalance;
  }

  public double getFinalBalance() {
    return finalBalance;
  }

  public void setFinalBalance(double finalBalance) {
    this.finalBalance = finalBalance;
  }

  /**
   * Giup tra ve type cua giao dich.
   *
   * @param type The loai giao dich.
   */
  public static String getTypeString(int type) {
    switch (type) {
      case TYPE_DEPOSIT_CHECKING:
        return "Nạp tiền vãng lai";
      case TYPE_WITHDRAW_CHECKING:
        return "Rút tiền vãng lai";
      case TYPE_DEPOSIT_SAVINGS:
        return "Nạp tiền tiết kiệm";
      case TYPE_WITHDRAW_SAVINGS:
        return "Rút tiền tiết kiệm";
      default:
        return "Không rõ";
    }
  }

  /**
   *Tom tat phien giao dich.
   *
   * @return tra ve thong tin cua phien giao dich.
   */
  public String getTransactionSummary() {
    logger.debug("Generating summary for transaction type: {}", this.type);

    String typeStr = getTypeString(type);
    String initialStr = String.format(Locale.US, "%.2f", initialBalance);
    String amountStr = String.format(Locale.US, "%.2f", amount);
    String finalStr = String.format(Locale.US, "%.2f", finalBalance);

    return String.format("- Kiểu giao dịch: %s. "
                    + "Số dư ban đầu: $%s. "
                    + "Số tiền: $%s. "
                    + "Số dư cuối: $%s.",
            typeStr, initialStr, amountStr, finalStr);
  }
}