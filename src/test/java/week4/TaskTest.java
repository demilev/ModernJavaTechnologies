package week4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class TaskTest {
	private Task task;

	@Before
	public void setup() {
		task = new Task("TestTask", "This is test task", Status.IN_PROCESS, 2, LocalDate.now().plusDays(2));
	}

	@Test
	public void testEndsIn() {
		assertTrue(task.endsIn(2));
	}

	@Test
	public void testDoesNotEndIn() {
		assertFalse(task.endsIn(1));
	}

}
