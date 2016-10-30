package week4;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ToDoList {
	private static final int THREE_DAYS = 3;
	private List<Task> tasks;

	public ToDoList() {
		this.tasks = new LinkedList<Task>();
	}
	public ToDoList(List<Task> tasks) {
		this.tasks = tasks;
	}

	public void add(Task task) {
		tasks.add(task);
	}

	public String tasksByPriority() {
		StringBuilder result = new StringBuilder();
		result.append("Tasks ordered by priority:\n");
		Collections.sort(tasks);
		tasks.stream().forEach(x -> result.append(x.toString()).append("\n"));
		return result.append("\n").toString();
	}

	public String tasksInProcess() {
		StringBuilder result = new StringBuilder();
		result.append("Tasks in process:\n");
		Collections.sort(tasks);
		tasks.stream().filter(task -> task.getStatus() == Status.IN_PROCESS)
				.forEach(task -> result.append(task.toString()).append("\n"));
		return result.append("\n").toString();
	}

	public String upcommingTasks() {
		StringBuilder result = new StringBuilder();
		result.append("Tasks ending in 3 days:\n");
		Collections.sort(tasks);
		tasks.stream().filter(task -> (task.isInProcess() && task.endsIn(THREE_DAYS)))
				.forEach(task -> result.append(task.toString()).append("\n"));
		return result.append("\n").toString();

	}
}
