package week4;

import java.util.Scanner;

public class ToDoListMenu {
	private ToDoList list;

	public ToDoListMenu(ToDoList list) {
		this.list = list;
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		int option;
		do {
			System.out.println("Choose option\n");
			printOptions();
			System.out.println("\nYour choice (1-4):");
			option = scanner.nextInt();
			switch (option) {
			case 1:
				list.printByPriority();
				break;
			case 2:
				list.printTasksInProcess();
				break;
			case 3:
				list.printUpcommingTasks();
				break;
			case 4:
				break;
			default:
				System.out.println("Invalid input!");
				break;
			}
		} while (option != 4);
		scanner.close();
	}

	private void printOptions() {
		System.out.println("1) All tasks ordered by priority");
		System.out.println("2) Tasks with status IN PROCESS");
		System.out.println("3) Tasks which should be finished in three days");
		System.out.println("4) Exit");
	}
}
