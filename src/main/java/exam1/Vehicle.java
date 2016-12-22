package exam1;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Vehicle implements Comparable<Vehicle> {
	private int year;
	private String model;
	private boolean isUsed;
	private LocalDate startDate;
	private LocalDate endDate;

	public abstract double price();
	
	public void create() throws IllegalInputException{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please input year: ");
		int year=scanner.nextInt();
		if(year<1950||year>2016){
			throw new IllegalInputException("Invalid year");
		}
		this.year=year;
		System.out.println("Please input model: ");
		model=scanner.next();
		isUsed=false;
		startDate=null;
		endDate=null;
		
	};
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public int compareTo(Vehicle other) {
		if (other.year < this.year)
			return 1;
		if (other.year > this.year)
			return -1;

		return this.model.compareTo(other.model);
	}

	@Override
	public String toString() {
		String firstPart = "Vehicle [year=" + year + ", model=" + model;
		if (isUsed)
			return firstPart + ", startDate=" + startDate + ", endDate=" + endDate;
		return firstPart;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public boolean isFreeAt(LocalDate date) {
		return (date.isEqual(startDate)||date.isAfter(startDate))&&
			   (date.isEqual(endDate)||date.isBefore(endDate));
	}

}
