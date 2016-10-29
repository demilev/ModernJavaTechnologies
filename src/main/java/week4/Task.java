package week4;

import java.time.LocalDate;

public class Task implements Comparable<Task> {
	private String title;
	private String descripiton;
	private Status status;
	private int priority;
	private LocalDate date;

	@Override
	public int compareTo(Task other) {
		if (other.priority < this.priority)
			return 1;
		if (other.priority > this.priority)
			return -1;
		return 0;
	}

	public Task(String title, String description, Status status, int priority, LocalDate date) {
		this.title = title;
		this.descripiton = description;
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

	public boolean endsInThreeDays() {
		LocalDate checkDate = LocalDate.now().plusDays(3);
		return (date.isBefore(checkDate) || date.isEqual(checkDate))
				&& (date.isAfter(LocalDate.now()) || date.isEqual(LocalDate.now()));
	}

}
