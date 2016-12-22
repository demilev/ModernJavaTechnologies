package exam2.hackathon;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exam2.exceptions.NegativePointsException;
import exam2.exceptions.TeamAlreadyExistsException;
import exam2.exceptions.TeamDoesNotExistsException;

public class HackathonHelperSystem {

	private Map<String, Team> teams;

	public HackathonHelperSystem() {
		teams = new HashMap<String, Team>();
	}

	public void addTeam(Team newTeam) throws TeamAlreadyExistsException {

		if (teams.containsKey(newTeam.getTeamName())) {
			throw new TeamAlreadyExistsException("The team " + newTeam.getTeamName() + " already exists!");
		} else {
			teams.put(newTeam.getTeamName(), newTeam);
		}
	}

	public boolean contains(String key) {
		return teams.containsKey(key);
	}

	public Team getTeam(String key) {
		return teams.get(key);
	}

	public void addPointsToTeam(String teamName, int points)
			throws NegativePointsException, TeamDoesNotExistsException {
		if (points < 0) {
			throw new NegativePointsException("Negative points can not be added!");
		}
		if (teams.containsKey(teamName) == false) {
			throw new TeamDoesNotExistsException("Team " + teamName + " does not exists!");
		}
		teams.get(teamName).setPoints(teams.get(teamName).getPoints() + points);
	}

	public List<Team> teamsSortedAscending() {
		List<Team> result = new ArrayList<>();
		Collection<Team> values = teams.values();
		for (Team team : values) {
			result.add(team);
		}
		Collections.sort(result);
		return result;
	}
	//filePath is the whole path of the file
	public void exportToFile(String filePath) throws FileNotFoundException {
		List<Team> teamsSorted = teamsSortedAscending();
		HackathonFileWriter.teamsToFile(filePath, teamsSorted);
		HackathonFileWriter.backup(filePath);
	}

	public static void main(String[] args) throws TeamAlreadyExistsException, FileNotFoundException {
		//some testing
		Team first = new Team("btbor1", "proekt1", 10);
		Team second = new Team("atbor2", "proekt2", 10);
		HackathonHelperSystem system = new HackathonHelperSystem();
		system.addTeam(first);
		system.addTeam(second);
		// List<Team> sorted =system.teamsSortedAscending();
		// for(Team team : sorted){
		// System.out.println(team);
		// }
		system.exportToFile("C:\\Users\\Mitko\\workspace\\JavaTechnologies\\teams.txt");
	}
}
