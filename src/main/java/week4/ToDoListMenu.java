package week4;

import java.util.Scanner;

public class ToDoListMenu {
	private ToDoList list;

	public ToDoListMenu(ToDoList list) {
		this.list = list;
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		int option = -1;
		do {
			System.out.println("Choose option\n");
			printOptions();
			System.out.println("\nYour choice (1-4):");
			try {
				option = parseInput(scanner);
			} catch (IllegalArgumentException e) {
				System.out.println("INVALID INPUT!" + e.getMessage() + "\n");
			}
		} while (option != 4);
		scanner.close();
	}

	private int parseInput(Scanner scanner) {
		int option = scanner.nextInt();
		switch (option) {
		case 1:
			System.out.print(list.tasksByPriority());
			break;
		case 2:
			System.out.print(list.tasksInProcess());
			break;
		case 3:
			System.out.print(list.upcommingTasks());
			break;
		case 4:
			System.out.println("Bye!");
			break;
		default:
			throw new IllegalArgumentException("No such an option!");
		}
		return option;
	}

	private void printOptions() {
		System.out.println("1) All tasks ordered by priority");
		System.out.println("2) Tasks with status IN PROCESS");
		System.out.println("3) Tasks which should be finished in three days");
		System.out.println("4) Exit");
	}
}
