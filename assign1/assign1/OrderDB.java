package assign1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class OrderDB implements OrderDBInterface {

	private Order[] orders = new Order[25];
	private int orderCount = 0;

	@Override
	public int loadOrders(String fileName) {

		clear();

		try (BufferedReader reader =
				new BufferedReader(new FileReader(fileName))) {

			String line;

			// Skip header
			reader.readLine();

			while ((line = reader.readLine()) != null) {

				String[] data = line.split(",");

				int orderID = Integer.parseInt(data[0]);
				String customerName = data[1];
				String product = data[2];
				double totalAmount = Double.parseDouble(data[3]);
				String orderDate = data[4];

				Order order = new Order(
						orderID,
						customerName,
						product,
						totalAmount,
						orderDate
				);

				add(order);
			}

		} catch (IOException e) {
			System.out.println(
					"Error loading orders: " + e.getMessage());
		}

		return orderCount;
	}

	@Override
	public int saveOrders(String fileName) {

		int recordsWritten = 0;

		try (PrintWriter writer =
				new PrintWriter(new FileWriter(fileName))) {

			writer.println(
					"Order_ID,Customer_Name,Product,Total_Amount,Order_Date");

			for (int i = 0; i < orderCount; i++) {

				Order order = orders[i];

				writer.printf(
						"%d,%s,%s,%.2f,%s%n",
						order.getOrderId(),
						order.getCustomerName(),
						order.getProductName(),
						order.getTotalAmt(),
						order.getOrderDate()
				);

				recordsWritten++;
			}

		} catch (IOException e) {
			System.out.println(
					"Error saving orders: " + e.getMessage());
		}

		return recordsWritten;
	}

	@Override
	public void showOrders() {

		System.out.printf(
				"%-8s %-31s %9s%n",
				"Order ID",
				"Product",
				"Total Amt"
		);

		System.out.printf(
				"%-8s %-31s %9s%n",
				"--------",
				"-------",
				"---------"
		);

		for (int i = 0; i < orderCount; i++) {

			System.out.printf(
					"%-8d %-31s %9.2f%n",
					orders[i].getOrderId(),
					orders[i].getProductName(),
					orders[i].getTotalAmt()
			);
		}
	}

	@Override
	public boolean add(Order order) {

		if (orderCount == orders.length) {
			resize();
		}

		orders[orderCount] = order;
		orderCount++;

		return true;
	}

	@Override
	public void add(int index, Order order) {

		if (index < 0 || index > orderCount) {
			throw new IndexOutOfBoundsException();
		}

		if (orderCount == orders.length) {
			resize();
		}

		for (int i = orderCount; i > index; i--) {
			orders[i] = orders[i - 1];
		}

		orders[index] = order;
		orderCount++;
	}

	@Override
	public void clear() {

		for (int i = 0; i < orderCount; i++) {
			orders[i] = null;
		}

		orderCount = 0;
	}

	@Override
	public Order get(int index) {

		if (index < 0 || index >= orderCount) {
			throw new IndexOutOfBoundsException();
		}

		return orders[index];
	}

	@Override
	public int searchByOrderID(int orderID) {

		for (int i = 0; i < orderCount; i++) {

			if (orders[i].getOrderId() == orderID) {
				return i;
			}
		}

		return -1;
	}

	@Override
	public Order remove(int index) {

		if (index < 0 || index >= orderCount) {
			throw new IndexOutOfBoundsException();
		}

		Order removedOrder = orders[index];

		for (int i = index; i < orderCount - 1; i++) {
			orders[i] = orders[i + 1];
		}

		orders[orderCount - 1] = null;
		orderCount--;

		return removedOrder;
	}

	@Override
	public Order set(int index, Order order) {

		if (index < 0 || index >= orderCount) {
			throw new IndexOutOfBoundsException();
		}

		Order oldOrder = orders[index];
		orders[index] = order;

		return oldOrder;
	}

	@Override
	public int size() {
		return orderCount;
	}

	@Override
	public int capacity() {
		return orders.length;
	}

	@Override
	public void resize() {

		Order[] largerArray =
				new Order[orders.length + 25];

		for (int i = 0; i < orderCount; i++) {
			largerArray[i] = orders[i];
		}

		orders = largerArray;
	}
}