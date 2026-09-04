package assign1;

public class Order {

	private int orderId;
	private String customerName;
	private String productName;
	private double totalAmt;
	private String orderDate;

	public Order(int orderId, String customerName, String productName,
			double totalAmt, String orderDate) {

		this.orderId = orderId;
		this.customerName = customerName;
		this.productName = productName;
		this.totalAmt = totalAmt;
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getProductName() {
		return productName;
	}

	public double getTotalAmt() {
		return totalAmt;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
}