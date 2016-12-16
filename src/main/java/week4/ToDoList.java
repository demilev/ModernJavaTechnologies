package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
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
		tasks.stream().filter(task -> task.isInProcess()).forEach(task -> result.append(task.toString()).append("\n"));
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

	public void importTasksFromFile(String path) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				tasks.add(taskFromValuse(values));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void exportTasksToFile(String path) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

			for (Task task : tasks)
				bw.write(task.toExportString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Task taskFromValuse(String[] values) {
		String title = values[0];
		String description = values[1];
		Status status = Status.valueOf(values[2]);
		int priority = Integer.parseInt(values[3]);
		String[] date = values[4].split("-");
		int year = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int dayOfMonth = Integer.parseInt(date[2]);
		LocalDate endDate = LocalDate.of(year, month, dayOfMonth);
		return new Task(title, description, status, priority, endDate);
	}
}
