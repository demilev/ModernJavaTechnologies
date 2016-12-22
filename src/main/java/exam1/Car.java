package exam1;

import java.util.Scanner;

public class Car extends Vehicle {
	private static final int MAX_PASSENGERS = 10;
	CarType type;
	int numberOfPassangers;

	@Override
	public double price() {
		return 500 + 50 * numberOfPassangers;
	}

	@Override
	public String toString() {
		return super.toString() + ", type=" + type + ", numberOfPassangers=" + numberOfPassangers + "]";
	}

	public CarType getType() {
		return type;
	}

	public Car(CarType type, int numberOfPassangers) {
		super();
		this.type = type;
		this.numberOfPassangers = numberOfPassangers;
	}

	public Car() {
		super();
	}

	public void setType(CarType type) {
		this.type = type;
	}

	public int getNumberOfPassangers() {
		return numberOfPassangers;
	}

	public void setNumberOfPassangers(int numberOfPassangers) {
		this.numberOfPassangers = numberOfPassangers;
	}

	@Override
	public void create() throws IllegalInputException {
		super.create();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please choose type (1-Combi,2-Hetchbeck,3-Cabrio,4-Sedan) :");
		int type = scanner.nextInt();
		switch (type) {
		case 1:
			this.type = CarType.COMBI;
			break;
		case 2:
			this.type = CarType.HETCHBECK;
			break;
		case 3:
			this.type = CarType.CABRIO;
			break;
		case 4:
			this.type = CarType.SEDAN;
			break;
		default:
			throw new IllegalInputException("Invalid type!");
		}
		System.out.println("Please input number of passengers: ");
		int numOfPassengers = scanner.nextInt();
		if (numOfPassengers < 0 || numOfPassengers > MAX_PASSENGERS) {
			throw new IllegalInputException("No car can have that much passengers!");
		}
		numberOfPassangers=numOfPassengers;
		
	}
}
