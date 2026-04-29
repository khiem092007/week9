package bai;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Lớp quản lý các hoạt động của ngân hàng. */
public class Bank {
  private static final Logger logger = LoggerFactory.getLogger(Bank.class);
  private List<Customer> customerList;

  public Bank() {
    this.customerList = new ArrayList<>();
  }

  /** Đọc danh sách khách hàng từ InputStream. */
  public void readCustomerList(InputStream inputStream) {
    if (inputStream == null) {
      return;
    }
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;
      while ((line = reader.readLine()) != null) {
        // Logic xử lý line ở đây...
        logger.info("Đang xử lý dữ liệu khách hàng...");
      }
    } catch (Exception e) {
      logger.error("Lỗi khi đọc danh sách khách hàng", e);
    }
  }

  /** Trả về thông tin khách hàng sắp xếp theo ID. */
  public String getCustomersInfoByIdOrder() {
    customerList.sort(Comparator.comparingLong(Customer::getIdNumber));
    StringBuilder sb = new StringBuilder();
    for (Customer c : customerList) {
      sb.append(c.getCustomerInfo()).append("\n");
    }
    return sb.toString().trim();
  }

  public List<Customer> getCustomerList() {
    return customerList;
  }
}