package bai;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lớp đại diện cho một khách hàng của ngân hàng.
 * Một khách hàng có thể sở hữu nhiều tài khoản khác nhau.
 */
public class Customer {
  private static final Logger logger = LoggerFactory.getLogger(Customer.class);

  private long idNumber;
  private String fullName;
  private List<Account> accountList;

  /**
   * Constructor mặc định cho khách hàng.
   */
  public Customer() {
    this(0L, "");
  }

  /**
   * Khởi tạo khách hàng với thông tin cơ bản.
   *
   * @param idNumber số CMND/CCCD của khách hàng.
   * @param fullName họ và tên đầy đủ.
   */
  public Customer(long idNumber, String fullName) {
    this.idNumber = idNumber;
    this.fullName = fullName;
    this.accountList = new ArrayList<>();
  }

  /**
   * Trả về thông tin tóm tắt của khách hàng và danh sách tài khoản.
   *
   * @return chuỗi thông tin khách hàng định dạng chuẩn.
   */
  public String getCustomerInfo() {
    StringBuilder sb = new StringBuilder();
    String info = "CMND: " + idNumber + ".\n"
            + "Họ tên: " + fullName + ".\n"
            + "Danh sách tài khoản:\n";
    sb.append(info);

    for (Account account : accountList) {
      String type = "- " + account.getAccountNumber() + ": "
               + (account instanceof CheckingAccount ? "Tài khoản vãng lai" : "Tài khoản tiết kiệm")
               + "\n";
      sb.append(type);
    }
    return sb.toString().trim();
  }

  /**
   * Thêm một tài khoản mới cho khách hàng nếu chưa tồn tại.
   *
   * @param account tài khoản cần thêm.
   */
  public void addAccount(Account account) {
    if (account != null && !accountList.contains(account)) {
      accountList.add(account);
      logger.info("Đã thêm tài khoản {} cho khách hàng {}",
              account.getAccountNumber(), fullName);
    }
  }

  /**
   * Xóa tài khoản khỏi danh sách của khách hàng.
   *
   * @param account tài khoản cần xóa.
   */
  public void removeAccount(Account account) {
    if (account != null && accountList.remove(account)) {
      logger.info("Đã xóa tài khoản {} khỏi khách hàng {}",
              account.getAccountNumber(), fullName);
    }
  }

  // Getters và Setters
  public long getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(long idNumber) {
    this.idNumber = idNumber;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public List<Account> getAccountList() {
    return accountList;
  }
}