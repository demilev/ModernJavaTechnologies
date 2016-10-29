package week3;

import java.util.Scanner;

public class Player {
	private String name;
	private char usedSymbol;

	public Player() {
		name = new String();
	}

	public Player(String name, char symbol) {
		this.name = name;
		usedSymbol = symbol;
	}

	public void setSymbol(char symbol) {
		usedSymbol = symbol;
	}

	public String getName() {
		return name;
	}

	public char getSymbol() {
		return usedSymbol;
	}

	public void create() {
		System.out.println("Please input your name: ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		this.name = input;
	}
}
