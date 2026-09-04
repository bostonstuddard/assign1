package assign1;

public class Driver {

	public static void main(String[] args) {

		OrderDB database = new OrderDB();

		// capacity()
		System.out.println(
				"Starting capacity: " + database.capacity());

		// loadOrders()
		int loaded = database.loadOrders("orders.txt");
		System.out.println("Orders loaded: " + loaded);

		// size()
		System.out.println(
				"Current size: " + database.size());

		// capacity()
		System.out.println(
				"Current capacity: " + database.capacity());

		// showOrders()
		System.out.println("\n--- SHOW ORDERS ---");
		database.showOrders();

		// get()
		System.out.println("\n--- GET ---");
		Order first = database.get(0);
		System.out.println(
				"Order at index 0: " + first.getOrderId());

		// searchByOrderID()
		System.out.println("\n--- SEARCH ---");
		int location = database.searchByOrderID(1004);
		System.out.println(
				"Order 1004 found at index: " + location);

		// add(Order)
		System.out.println("\n--- ADD TO END ---");

		Order newOrder = new Order(
				2001,
				"Test Customer",
				"Test Product",
				99.99,
				"2026-09-04"
		);

		boolean added = database.add(newOrder);

		System.out.println("Added: " + added);
		System.out.println(
				"New size: " + database.size());

		// add(index, Order)
		System.out.println("\n--- INSERT ---");

		Order insertedOrder = new Order(
				2002,
				"Inserted Customer",
				"Inserted Product",
				49.99,
				"2026-09-04"
		);

		database.add(1, insertedOrder);

		System.out.println(
				"Order at index 1: "
				+ database.get(1).getOrderId());

		// set()
		System.out.println("\n--- SET ---");

		Order replacement = new Order(
				2003,
				"Replacement Customer",
				"Replacement Product",
				25.00,
				"2026-09-04"
		);

		Order oldOrder =
				database.set(1, replacement);

		System.out.println(
				"Replaced order: "
				+ oldOrder.getOrderId());

		System.out.println(
				"New order: "
				+ database.get(1).getOrderId());

		// remove()
		System.out.println("\n--- REMOVE ---");

		Order removed = database.remove(1);

		System.out.println(
				"Removed order: "
				+ removed.getOrderId());

		System.out.println(
				"Size after removal: "
				+ database.size());

		// saveOrders()
		System.out.println("\n--- SAVE ---");

		int saved =
				database.saveOrders("savedOrders.txt");

		System.out.println(
				"Orders saved: " + saved);

		// resize()
		System.out.println("\n--- RESIZE ---");

		int oldCapacity = database.capacity();

		database.resize();

		System.out.println(
				"Old capacity: " + oldCapacity);

		System.out.println(
				"New capacity: " + database.capacity());

		// clear()
		System.out.println("\n--- CLEAR ---");

		database.clear();

		System.out.println(
				"Size after clear: " + database.size());
	}
}