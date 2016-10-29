package week4;

import java.util.Arrays;

public class ToDoList {
	private Task[] tasks;

	public ToDoList(Task[] tasks) {
		this.tasks = tasks;
	}

	public void printByPriority() {
		System.out.println("Tasks ordered by priority:\n");
		Arrays.sort(tasks);
		for (Task task : tasks) {
			System.out.println(task.toString());
		}
		System.out.println();
	}

	public void printTasksInProcess() {
		System.out.println("Tasks in process:\n");
		Arrays.sort(tasks);
		for (Task task : tasks) {
			if (task.getStatus() == Status.IN_PROCESS) {
				System.out.println(task.toString());
			}
		}
		System.out.println();
	}

	public void printUpcommingTasks() {
		System.out.println("Tasks ending in 3 days:\n");
		Arrays.sort(tasks);
		for (Task task : tasks) {
			if (task.isInProcess() && task.endsInThreeDays()) {
				System.out.println(task.toString());
			}
		}
		System.out.println();
	}
}
