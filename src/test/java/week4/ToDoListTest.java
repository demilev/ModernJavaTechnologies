package week4;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class ToDoListTest {

	private ToDoList toDoList;

	@Before
	public void setup() {
		Task task1 = new Task("task1", "description of task1", Status.DONE, 4, LocalDate.of(2016, 12, 3));
		Task task2 = new Task("task2", "description of task2", Status.INITIAL, 5, LocalDate.of(2016, 12, 6));
		Task task3 = new Task("task3", "description of task3", Status.IN_PROCESS, 2, LocalDate.of(2016, 12, 4));
		Task task4 = new Task("task4", "description of task4", Status.IN_PROCESS, 1, LocalDate.of(2016, 12, 5));
		toDoList = new ToDoList(Arrays.asList(task1, task2, task3, task4));
	}

	@Test
	public void testTasksByPriority() {
		String tasksByPriority = toDoList.tasksByPriority();
		String expectedString = "Tasks ordered by priority:\n"+
								"Task [title=task4, status=IN_PROCESS, priority=1, date=2016-12-05]\n"+
								"Task [title=task3, status=IN_PROCESS, priority=2, date=2016-12-04]\n"+
								"Task [title=task1, status=DONE, priority=4, date=2016-12-03]\n"+
								"Task [title=task2, status=INITIAL, priority=5, date=2016-12-06]\n\n";
								
		assertEquals(expectedString , tasksByPriority);
	}
	
	@Test
	public void testTasksInProcess(){
		String tasksInProcess = toDoList.tasksInProcess();
		String expectedString = "Tasks in process:\n"+
								"Task [title=task4, status=IN_PROCESS, priority=1, date=2016-12-05]\n"+
								"Task [title=task3, status=IN_PROCESS, priority=2, date=2016-12-04]\n"+
								"Task [title=task2, status=INITIAL, priority=5, date=2016-12-06]\n\n";
								
		assertEquals(expectedString , tasksInProcess);
	}
	
	@Test
	public void testUpcommingTasks(){
		String upcommingTasks = toDoList.upcommingTasks();
		String expectedString = "Tasks ending in 3 days:\n"+
								"Task [title=task4, status=IN_PROCESS, priority=1, date=2016-12-05]\n"+
								"Task [title=task3, status=IN_PROCESS, priority=2, date=2016-12-04]\n"+
								"Task [title=task2, status=INITIAL, priority=5, date=2016-12-06]\n\n";
								
		assertEquals(expectedString , upcommingTasks);
	}
}
