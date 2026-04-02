class CoffeeMaker {

	private boolean on = false;
	private String coffee_type;
	private int amount;
 
	public void is_on(){
		System.out.println(on ? "Coffee maker is on" : 
								"Coffee maker is off");
	} 

	public void toggle(){
		on = !on;
	}

	public String get_type(){
		return coffee_type;
	}

	public void set_type(String type){
		this.coffee_type = type;
	} 

	public String get_amount(){
		return new String("Coffee amount is " + this.amount + " ml");
	}

	public void set_amount(int amount){
		this.amount = amount;
	}
}

class Main {

	public static void main (String[] args) {
		CoffeeMaker cm = new CoffeeMaker();
		cm.is_on();
		cm.toggle();		
		cm.is_on();

		cm.set_type("Espresso");
		System.out.println("Type: " + cm.get_type());
		cm.set_amount(200);
		System.out.println("Amount: " + cm.get_amount());
	}
}



