import java.util.HashMap;

class GroceryListManager {

	static HashMap <String, Double>groceryList = 
		new HashMap<String, Double>();

	static HashMap <String, String>categoryList = 
		new HashMap<String, String>();

	private static double total_cost = 0.0f;

	private static void addItem(String item, double cost, String category){
		groceryList.put(item, cost);
		categoryList.put(item, category);
	}

	private static void removeItem(String item){	
		groceryList.remove(item);
	}

	private static void displayList(){
		System.out.println("Grocery List:");
		int idx = 1;
		for(String key : groceryList.keySet()){
			System.out.printf("%n%d: %s - %.2f%n", idx++, key, 
					groceryList.get(key));
		}
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

	private static boolean checkItem(String item){
		return groceryList.containsKey(item);
	}

	private static double calculateTotalCost(){
		for(double value : groceryList.values()){
			total_cost += value;
		}
		return total_cost;
	}

	public static void main (String[] args) {
		
		GroceryListManager gm = new GroceryListManager();

		gm.addItem("Cheese", 3.5f, "Dairy");
		gm.addItem("Beer", 1.24f, "Beverages");
		gm.addItem("Pepsi", 2.5f, "Beverages");
		gm.addItem("Cat food", 3.97f, "Pet supplies");
		gm.displayList();

		System.out.print("\nIs \"Cheese\" in the grocery list? ");
		boolean has_cheese = checkItem("Cheese");
		System.out.println(has_cheese ? "True" : "False");
		System.out.println("Removing \"Cheese\" from the list...");
		gm.removeItem("Cheese");
		gm.displayList();

		gm.displayByCategory("Beverages");
		gm.displayByCategory("Pet supplies");
		// Testing with nonexistent category
		gm.displayByCategory("oogabooga");

		double total_cost = calculateTotalCost();
		System.out.printf("Total cost: %.2f%n", total_cost);
	}
}
