import java.util.HashMap;

class GroceryListManager {

	static HashMap <String, Double>groceryList = 
		new HashMap<String, Double>();

	static HashMap <String, String>categoryList = 
		new HashMap<String, String>();

	static HashMap <String, Double>Quantities = 
		new HashMap<String, Double>();

	private static double total_cost = 0.0f;


	private static void _print_delim(final int DELIM_LEN){
		for(int i = 0; i < DELIM_LEN; i++) System.out.print("_");
		System.out.println();
	}

	private static void updateQuantity(String item, double newQuantity){
		if(Quantities.containsKey(item)){
			Quantities.put(item, (double) newQuantity);
		}
	}

	private static void addItem(String item, double cost, 
			String category, double quantity){
		groceryList.put(item, cost);
		categoryList.put(item, category);
		Quantities.put(item, quantity);
		updateQuantity(item, quantity);
	}

	private static void removeItem(String item){	
		groceryList.remove(item);
	}

	private static double calculateTotalCost(){
		for(String key : groceryList.keySet()){
			double price = groceryList.getOrDefault(key, 0.0);
			double q = Quantities.getOrDefault(key, 0.0);
			total_cost += price * q;
		}
		return total_cost;
	}

	private static void displayList(){
		System.out.println("Grocery List:");
		System.out.printf("# | ITEM       | PRICE | QUANTITY%n");
		_print_delim(35);
		
		int idx = 1;
		for(String key : groceryList.keySet()){
			System.out.printf("%d | %-10s | %.2f  | %.0f%n", idx++, key, 
					groceryList.get(key), Quantities.get(key));
		}
		_print_delim(35);
		final double total = calculateTotalCost();
		System.out.printf("TOTAL:%8s | %.2f€%n", "", total); 
	}

	private static void displayByCategory(final String category){
		System.out.printf("%nDisplaying products from category '%s'%n",
				category);

		int idx = 1;
		for(HashMap.Entry<String, String> entry : categoryList.entrySet()){
			if(entry.getValue().equals(category))
				System.out.printf("%d: %s%n", idx++, entry.getKey());
		}
		if(idx == 1)
			System.out.println("\nNo products found");
	}

	private static void displayAvailableItems(){

		int idx = 1;
		System.out.println("\nAVAILABLE ITEMS");

		System.out.printf("# | ITEM%6s | COUNT%n", "");
		_print_delim(25);

		for(String key : groceryList.keySet()){
			double q = Quantities.get(key);
			if(q > 0){
				System.out.printf("%d | %-10s | %.0f%n", idx++, key, q);
			}
		}
	}

	private static boolean checkItem(String item){
		return groceryList.containsKey(item);
	}

	public static void main (String[] args) {
		
		GroceryListManager gm = new GroceryListManager();

		gm.addItem("Cheese", 3.5f, "Dairy", 2);
		gm.addItem("Beer", 1.24f, "Beverages", 8);
		gm.addItem("Pepsi", 2.5f, "Beverages", 1);
		gm.addItem("Cat food", 3.97f, "Pet supplies", 1);
		gm.displayList();

		System.out.print("\nIs \"Cheese\" in the grocery list? ");
//		boolean has_cheese = checkItem("Cheese");
		System.out.println(checkItem("Cheese") ? "True" : "False");
		System.out.println("Removing \"Cheese\" from the list...");
		gm.removeItem("Cheese");
		gm.displayList();

		gm.displayByCategory("Beverages");
		gm.displayByCategory("Pet supplies");
		// Testing with nonexistent category
		gm.displayByCategory("oogabooga");
		gm.displayAvailableItems();
	}
}
