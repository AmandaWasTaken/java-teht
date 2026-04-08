class Car {

   	public double speed;
    public double gasolineLevel;
    public String typeName;
	public float tank_capacity;

    public Car(String typeName, float cap, int speed) {
		this.gasolineLevel = cap;
        this.typeName = typeName;      
		this.tank_capacity = cap;
		this.speed = speed;
	}

    public void accelerate() {
        if (gasolineLevel > 0)
            speed += 10;
        else
            speed = 0;
    }

    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else {
            speed = 0;
		}
    }

    double getSpeed() {
        return speed;
    }

    String getTypeName() {
        return typeName;
    }

    void fillTank() {
        gasolineLevel = 100;
    }

    double getGasolineLevel() {
        return gasolineLevel;
    }
}

class SportsCar extends Car {

	public SportsCar(String typeName, float cap, int speed){
		super(typeName, cap, speed);
	}

    public void accelerate() {
        if (gasolineLevel > 0)
            speed += 20;
        else
            speed = 0;
    }

    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else {
            speed = 0;
		}
    }
}

class Bus extends Car {

	private int curr_passengers;
	private int max_passengers;

	public Bus(String typeName, float cap, int speed, int curr_passengers,
			   int max_passengers){

		super(typeName, cap, speed);
		this.curr_passengers = curr_passengers;
		this.max_passengers = max_passengers;
	}

    public void accelerate() {
        if (gasolineLevel > 0)
            speed += 10;
        else
            speed = 0;
    }

    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else {
            speed = 0;
		}
    }

	public int get_passengers() { return curr_passengers; }

	public void passengerEnter(int new_passengers){
		if(curr_passengers + new_passengers > max_passengers){
			System.out.println("Not enough room for all passengers");
		} else {
			System.out.printf("%d new passengers entered%n", new_passengers);
			this.curr_passengers += new_passengers;
		}
	}

	public void passengerExit(int n_passengers){
		if(curr_passengers - n_passengers < 0){
			System.out.println("[warning] Trying to remove more passengers " +
					           "than the bus has");
		} else {
			System.out.printf("%d passengers exited%n", n_passengers);
			curr_passengers -= n_passengers;
		}
	}
}

class CarTests {

	public static void main (String[] args) {

		Car car = new Car("Toyota Corolla", 60, 50);
		SportsCar sc = new SportsCar("Lamborghini Aventador", 200, 110);
		System.out.printf("Regular car speed: %.2f km/h%n", car.getSpeed());
		System.out.printf("Sports car speed: %.2f km/h%n", sc.getSpeed());
		System.out.println("Both cars accelerating");
		car.accelerate();
		sc.accelerate();
		System.out.printf("Regular car speed: %.2f km/h%n", car.getSpeed());
		System.out.printf("Sports car speed: %.2f km/h%n", sc.getSpeed());
		System.out.println();

		Bus bus = new Bus("OnniBus", 800, 120, 32, 80);
		System.out.printf("%d passengers on the bus%n%d are exiting%n",
						 bus.get_passengers(), 6);
		bus.passengerExit(6);
		System.out.printf("%d passengers on the bus%n", bus.get_passengers());

	}
}
