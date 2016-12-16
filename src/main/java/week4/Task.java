package week4;

import java.time.LocalDate;

public class Task implements Comparable<Task> {
	private String title;
	private String description;
	private Status status;
	private int priority;
	private LocalDate date;

	@Override
	public int compareTo(Task other) {
		return this.priority - other.priority;
	}

	public Task(String title, String description, Status status, int priority, LocalDate date) {
		this.title = title;
		this.description = description;
		this.status = status;
		this.priority = priority;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Task [title=" + title + ", status=" + status + ", priority=" + priority + ", date=" + date + "]";
	}

	public Status getStatus() {
		return status;
	}

	public boolean isInProcess() {
		return status != Status.DONE;
	}

	public boolean endsIn(int days) {
		LocalDate checkDate = LocalDate.now().plusDays(days);
		return (date.isBefore(checkDate) || date.isEqual(checkDate))
				&& (date.isAfter(LocalDate.now()) || date.isEqual(LocalDate.now()));
	}

	public String toExportString() {
		return title + "," + description + "," + status + "," + priority + "," + date + "\n";
	}
}
