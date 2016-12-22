package exam1;

import java.util.Scanner;

public class Truck extends Vehicle {
	private static final double MAX_WEIGHT = 10000;
	double maxWeightCarrage;

	public double getMaxWeightCarrage() {
		return maxWeightCarrage;
	}

	public void setMaxWeightCarrage(double maxWeightCarrage) {
		this.maxWeightCarrage = maxWeightCarrage;
	}

	@Override
	public double price() {
		return 700 + 100 * maxWeightCarrage;
	}

	@Override
	public String toString() {
		return super.toString() + ", maxWeightCarrage=" + maxWeightCarrage + "]";
	}

	@Override
	public void create() throws IllegalInputException {
		super.create();
		System.out.println("Please input maximum tons weight carrage: ");
		Scanner scanner = new Scanner(System.in);
		double maxWeightCarrage=scanner.nextDouble();
		if(maxWeightCarrage<0||maxWeightCarrage>MAX_WEIGHT){
			throw new IllegalInputException("Invalid maxWeightCarrage!");
		}
		this.maxWeightCarrage=maxWeightCarrage;
	}

	public Truck(double maxWeightCarrage) {
		super();
		this.maxWeightCarrage = maxWeightCarrage;
	}
	public Truck(){
		super();
	}
}
