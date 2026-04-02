import java.util.ArrayList;

class GroceryListManager {

	static ArrayList <String>groceryList = new ArrayList<>();

	private static void addItem(String item){
		groceryList.add(item);
	}

	private static void removeItem(String item){	
		groceryList.remove(item);
	}

	private static void displayList(){
		for(int i = 0; i < groceryList.size(); i++){
			System.out.printf("%d: %s%n", i+1, groceryList.get(i));
		}	
	}

	private static boolean checkItem(String item){
		for(int i = 0; i < groceryList.size(); i++){
			if(groceryList.get(i).equals(item)) return true;
		}
		return false;
	}

	public static void main (String[] args) {
		
		GroceryListManager gm = new GroceryListManager();

		gm.addItem("Cheese");
		gm.addItem("Beer");
		gm.addItem("Cat food");
		System.out.println("Grocery List:");
		gm.displayList();
		System.out.println("\nIs \"Cheese\" in the grocery list?");
		boolean has_cheese = checkItem("Cheese");
		System.out.println(has_cheese ? "True" : "False");
		System.out.println("Removing \"Cheese\" from the list...");
		gm.removeItem("Cheese");
		gm.displayList();
	}
}

