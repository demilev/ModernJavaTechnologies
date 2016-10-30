package week4;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		ToDoListMenu menu = new ToDoListMenu(new ToDoList(generateTasks()));
		menu.start();
	}	
	private static List<Task> generateTasks() {
		Task task1 = new Task("task1", "description of task1", Status.INITIAL, 3, LocalDate.of(2016, 10, 20));
		Task task2 = new Task("task2", "description of task2", Status.IN_PROCESS, 3, LocalDate.of(2016, 10, 20));
		Task task3 = new Task("task3", "description of task3", Status.DONE, 4, LocalDate.of(2016, 10, 18));
		Task task4 = new Task("task4", "description of task4", Status.INITIAL, 5, LocalDate.of(2016, 11, 1));
		Task task5 = new Task("task5", "description of task5", Status.IN_PROCESS, 2, LocalDate.of(2016, 10, 31));
		Task task6 = new Task("task6", "description of task6", Status.IN_PROCESS, 1, LocalDate.of(2016, 10, 29));
		Task task7 = new Task("task7", "description of task7", Status.INITIAL, 2, LocalDate.of(2016, 10, 30));
		List<Task> tasks = new LinkedList<Task>(Arrays.asList(task1,task2,task3,task4,task5,task6,task7));
		return tasks;
	}
}
