interface Vehicle {
	void start();
	void stop();
	void getInfo();
}

abstract class AbstractVehicle implements Vehicle {

	protected String model;
	protected double top_speed;

	public AbstractVehicle(String model, double top_speed){
		this.model = model;
		this.top_speed = top_speed;
	}

	public void getInfo(){
		System.out.printf("Model:%s%nTop speed: %.1f%n",
				this.model, this.top_speed);
	}

	public abstract void start();
	public abstract void stop();
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
