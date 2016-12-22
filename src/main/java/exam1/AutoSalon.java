package exam1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class AutoSalon {
	Vehicle[] vehicles;
	int size;
	public static final int MAX_LENGTH = 100;
	AutoSalon(){
		vehicles=new Vehicle[MAX_LENGTH];
		size=0;
	}
	public boolean addVehicle() {
		if (size == MAX_LENGTH)
			return false;
		printOptions();
		System.out.println("Choose an option <1-3> : ");
		Scanner scanner = new Scanner(System.in);
		
		try {
			Vehicle newVehicle = parseInput(scanner);
			vehicles[size++]=newVehicle;
		} catch (IllegalInputException e) {
			System.out.println("This vehicle can't be added! " + e.getMessage());
			return false;
		}
		return true;
	}

	private Vehicle parseInput(Scanner scanner) throws IllegalInputException {
		int option=scanner.nextInt();
		Vehicle result;
		switch(option){
		case 1: 
			result=new Car();
			result.create();
			break;
		case 2: 
			result=new Motorcylce();
			result.create();
			break;
		case 3: 
			result=new Truck();
			result.create();
			break;
		default: 
			throw new IllegalInputException("No such an option!");
		}
		return result;
	}

	private void printOptions() {
		System.out.println("You can add one of the following: ");
		System.out.println("1)Car");
		System.out.println("2)Motorcycle");
		System.out.println("3)Truck");
	}

	public void listVehicles() {
		Vehicle[] vehicles=new Vehicle[size];
		System.arraycopy(this.vehicles, 0, vehicles, 0, size);
		Arrays.sort(vehicles);
		System.out.println("List of all the vehicles: ");
		for (int i = 0; i <size; i++)
			System.out.println(vehicles[i].toString());
	}

	public void listNotUsedAt(LocalDate date) {
		System.out.println("The free vehicles at " + date + " are: ");
		for (int i = 0; i < size; i++)
			if (!vehicles[i].isUsed() || vehicles[i].isFreeAt(date))
				System.out.println(vehicles[i].toString());

	}

	public double getVehiclePrice(int index) {
		return vehicles[index].price();
	}

}
