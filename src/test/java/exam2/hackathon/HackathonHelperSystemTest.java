package exam2.hackathon;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exam2.exceptions.NegativePointsException;
import exam2.exceptions.TeamAlreadyExistsException;
import exam2.exceptions.TeamDoesNotExistsException;

public class HackathonHelperSystemTest {
	private HackathonHelperSystem system;

	@Before
	public void setup() throws TeamAlreadyExistsException {
		system = new HackathonHelperSystem();
		system.addTeam(new Team("testTeam", "testProject", 0));

	}

	@Test
	public void testAddTeam() throws TeamAlreadyExistsException {
		system.addTeam(new Team("newTeam", "newProject", 0));

		assertTrue(system.contains("newTeam"));
	}

	@Test(expected = TeamAlreadyExistsException.class)
	public void testAddExistingTeam() throws TeamAlreadyExistsException {
		system.addTeam(new Team("testTeam", "asa", 0));
	}

	@Test
	public void testAddPoints() throws NegativePointsException, TeamDoesNotExistsException {
		system.addPointsToTeam("testTeam", 5);
		assertEquals(5, system.getTeam("testTeam").getPoints());
	}

	@Test(expected = NegativePointsException.class)
	public void testAddNegativePoints() throws NegativePointsException, TeamDoesNotExistsException {
		system.addPointsToTeam("testTeam", -2);
	}

	@Test(expected = TeamDoesNotExistsException.class)
	public void testAddPointsToNotExistingTeam() throws NegativePointsException, TeamDoesNotExistsException {
		system.addPointsToTeam("random", 5);
	}
}
