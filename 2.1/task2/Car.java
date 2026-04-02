public class Car {

   	private double speed;
    private double gasolineLevel;
    private String typeName;
	private float tank_capacity;

    public Car(String typeName, float cap, int speed) {
        speed = 0; gasolineLevel = 0;
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
