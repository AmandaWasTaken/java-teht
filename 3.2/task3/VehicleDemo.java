class Utils {
	
	public void _print_delim(final int DELIM_LEN){
		for(int i = 0; i < DELIM_LEN; i++) System.out.print("_");
		System.out.println();
	}
}

interface Vehicle {
	void start();
	void stop();
	void getInfo();
	void refuel();
}

interface ElectricVehicle extends Vehicle {
	void charge();
}

abstract class AbstractVehicle implements Vehicle {

	protected String model;
	protected double top_speed;

	public AbstractVehicle(String model, double top_speed){
		this.model = model;
		this.top_speed = top_speed;
	}

	public void getInfo(){
		System.out.printf("Model: %s%nTop speed: %.1f%n",
				this.model, this.top_speed);
	}

	public abstract void start();
	public abstract void stop();
	public abstract void charge();
	public abstract void refuel();
}

class Car extends AbstractVehicle {

	public Car(String model, double top_speed){
		super(model, top_speed);
	}

	public void start(){
		System.out.println("Car is starting");
	}

	public void stop(){
		System.out.println("Car is stopping");
	}

	@Override
	public void getInfo(){
		System.out.println("Type: car");
		super.getInfo();
	}

	public void charge(){
		System.out.println("This car cannot be charged!");
	}

	public void refuel(){
		System.out.println("Car is being refueled. . .");
	}
}

class Motorcycle extends AbstractVehicle {
	
	private String model;
	private double top_speed;

	public Motorcycle(String model, double top_speed){
		super(model, top_speed);
	}

	public void start(){
		System.out.println("Motorcycle starting");
	}

	public void stop(){
		System.out.println("Motorcycle is stopping");
	}

	@Override
	public void getInfo(){
		System.out.println("Type: Motorcycle");
		super.getInfo();
	}

	public void charge(){
		System.out.println("This motorcycle cannot be charged!");
	}

	public void refuel(){
		System.out.println("Motorcycle is being refueled. . .");
	}
}


class Bus extends AbstractVehicle {	

	private String model;
	private double top_speed;
	private int max_passengers;

	public Bus(String model, double top_speed, int max_passengers){
		super(model, top_speed);
		this.max_passengers = max_passengers;
	}

	public void start(){
		System.out.println("Bus is starting");
	}

	public void stop(){
		System.out.println("Bus is stopping");
	}

	@Override
	public void getInfo(){
		System.out.println("Type: bus");
		super.getInfo();
	}
	
	public void charge(){
		System.out.println("This bus cannot be charged!");
	}

	public void refuel(){
		System.out.println("Bus is being refueled. . .");
	}
}

class ElectricCar extends AbstractVehicle implements ElectricVehicle {

	private String model;
	private double top_speed;
	private double battery_output;

	public ElectricCar(String model, double top_speed, double battery_output){
		super(model, top_speed);
		this.battery_output = battery_output;
	} 

	public void start(){
		System.out.println("Electric car is starting");
	}

	public void stop(){
		System.out.println("Electric car is stopping");
	}

	public void charge(){
		System.out.println("Charging electric car. . .");
	}

	public void refuel(){
		System.out.println("Don't try to refuel an electric vehicle, silly");
	}

	@Override
	public void getInfo(){
		System.out.println("Type: Electric car");
		super.getInfo();
		System.out.printf("Battery output: %.1f kW%n", this.battery_output);
	}
}

class ElectricBike extends AbstractVehicle implements ElectricVehicle {

	private String model;
	private double top_speed;
	private double battery_output;

	public ElectricBike(String model, double top_speed, double battery_output){
		super(model, top_speed);
		this.battery_output = battery_output;
	} 

	public void start(){
		System.out.println("Electric motorbike is starting");
	}

	public void stop(){
		System.out.println("Electric motorbike is stopping");
	}

	public void charge(){
		System.out.println("Charging electric motorbike. . .");
	}

	public void refuel(){
		System.out.println("Don't try to refuel an electric vehicle, silly");
	}

	@Override
	public void getInfo(){
		System.out.println("Type: Electric motorbike");
		super.getInfo();
		System.out.printf("Battery output: %.1f kW%n", this.battery_output);
	}
}

class Main {

	public static void main (String[] args) {
		
		Utils u = new Utils();

		Vehicle[] vehicles = {
			new Car("Toyota Corolla", 170),
			new Motorcycle("Kawasaki Ninja", 210),
			new Bus("OnniBus", 160, 70),
			new ElectricCar("Tesla Model S", 200, 310),
			new ElectricBike("EBike", 110, 150),
		};

		for(Vehicle v : vehicles){
			u._print_delim(25);

			v.start();
			v.stop();

			if(v instanceof ElectricVehicle ev) { 
				ev.charge();
			} else {
				v.refuel();
			}

			u._print_delim(25);
			v.getInfo();
		}
	}	
}
