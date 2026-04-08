interface Vehicle {
	void start();
	void stop();
	void getInfo();
}

class Car implements Vehicle {

	private String model;
	private double top_speed;

	public Car(String model, double top_speed){
		this.model = model;
		this.top_speed = top_speed;
	}

	public void start(){
		System.out.println("Car is starting");
	}

	public void stop(){
		System.out.println("Car is stopping");
	}

	public void getInfo(){
		System.out.printf("Type: Car%nModel: %s%nTop speed: %.1f%n",
				this.model, this.top_speed);
	}

}

class Motorcycle implements Vehicle {
	
	private String model;
	private double top_speed;

	public Motorcycle(String model, double top_speed){
		this.model = model;
		this.top_speed = top_speed;
	}

	public void start(){
		System.out.println("Motorcycle starting");
	}

	public void stop(){
		System.out.println("Motorcycle is stopping");
	}

	public void getInfo(){
		System.out.printf("Type: Motorcycle%nModel: %s%nTop speed: %.1f%n",
				this.model, this.top_speed);
	} 
}


class Bus implements Vehicle {	

	private String model;
	private double top_speed;
	private int max_passengers;

	public Bus(String model, double top_speed, int max_passengers){
		this.model = model;
		this.top_speed = top_speed;
		this.max_passengers = max_passengers;
	}

	public void start(){
		System.out.println("Bus is starting");
	}

	public void stop(){
		System.out.println("Bus is stopping");
	}

	public void getInfo(){
		System.out.printf("Type: Bus%nModel: %s%nTop speed: %.1f%n" + 
				"Capacity: %d passengers%n",
				this.model, this.top_speed, this.max_passengers);
	} 
}

class Main {

	public static void main (String[] args) {
		
		Car car = new Car("Toyota Corolla", 170);
		Motorcycle mc = new Motorcycle("Kawasaki Ninja", 210);
		Bus bus = new Bus("OnniBus", 160, 70);

		car.start();
		car.stop();
		car.getInfo();
		mc.start();
		mc.stop();
		mc.getInfo();
		bus.start();
		bus.stop();
		bus.getInfo();
	}
}
