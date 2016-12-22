package exam2.hackathon;

public class Team implements Comparable<Team> {

	private String teamName;
	private String projectName;
	private int points;

	public Team(String teamName, String projectName, int points) {
		this.teamName = teamName;
		this.projectName = projectName;
		this.points = points;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String toExportFormat() {
		return teamName + "-" + projectName + "-" + points + "\n";
	}

	@Override
	public String toString() {
		return "Team [teamName=" + teamName + ", projectName=" + projectName + ", points=" + points + "]";
	}

	@Override
	public int compareTo(Team other) {
		if (this.points == other.points) {
			return this.teamName.compareTo(other.teamName);
		}
		return this.points - other.points;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + points;
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		return true;
	}

}
