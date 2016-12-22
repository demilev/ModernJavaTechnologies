package exam1;

import java.util.Scanner;

public class Motorcylce extends Vehicle {
	private static final double MAX_CUBES = 500;
	double cubes;

	@Override
	public double price() {
		return 300+5*cubes;
	}

	public double getCubes() {
		return cubes;
	}

	public void setCubes(double cubes) {
		this.cubes = cubes;
	}

	@Override
	public String toString() {
		return super.toString() + ", cubes=" + cubes + "]";
	}

	@Override
	public void create() throws IllegalInputException {
		super.create();
		System.out.println("Please input cubes: ");
		Scanner scanner = new Scanner(System.in);
		double cubes=scanner.nextDouble();
		if(cubes<0||cubes>MAX_CUBES){
			throw new IllegalInputException("Invalid cubes!");
		}
		this.cubes=cubes;
		
	}

	public Motorcylce(double cubes) {
		super();
		this.cubes = cubes;
	}
	public Motorcylce(){
		super();
	}
	
	
}
