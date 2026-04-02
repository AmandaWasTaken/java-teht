import java.util.HashMap;

class GroceryListManager {

	static HashMap <String, Double>groceryList = 
		new HashMap<String, Double>();
	private static double total_cost = 0.0f;

	private static void addItem(String item, double cost){
		groceryList.put(item, cost);
	}

	private static void removeItem(String item){	
		groceryList.remove(item);
	}

	private static void displayList(){
		int idx = 1;
		for(String key : groceryList.keySet()){
			System.out.printf("%d: %s - %.2f%n", idx++, key, 
					groceryList.get(key));
		}
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

		gm.addItem("Cheese", 3.5f);
		gm.addItem("Beer", 1.24f);
		gm.addItem("Cat food", 3.97f);
		System.out.println("Grocery List:");
		gm.displayList();
		System.out.print("\nIs \"Cheese\" in the grocery list? ");
		boolean has_cheese = checkItem("Cheese");
		System.out.println(has_cheese ? "True" : "False");
		System.out.println("Removing \"Cheese\" from the list...");
		gm.removeItem("Cheese");
		gm.displayList();

		double total_cost = calculateTotalCost();
		System.out.printf("Total cost: %.2f%n", total_cost);
	}
}
