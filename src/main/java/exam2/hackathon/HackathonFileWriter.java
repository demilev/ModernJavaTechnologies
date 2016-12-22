package exam2.hackathon;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class HackathonFileWriter {

	private static final String BACKUP = "backups";

	public static void teamsToFile(String fileName, List<Team> teams) throws FileNotFoundException {
		if (Files.notExists(Paths.get(fileName))) {
			throw new FileNotFoundException();
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
			for (int i = 0; i < teams.size(); i++) {
				bw.write((i + 1) + "." + teams.get(i).toExportFormat());
				bw.flush();
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void backup(String path) {
		String subPath = path.substring(0, path.lastIndexOf("\\"));
		if (Files.exists(Paths.get(subPath, BACKUP))) {
			try {
				String newFileName = "standing_" + System.currentTimeMillis() + ".txt";
				Files.copy(Paths.get(path), Paths.get(subPath, BACKUP, newFileName),
						StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				Files.createDirectories(Paths.get(subPath, BACKUP));
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				String newFileName = "standing_" + System.currentTimeMillis() + ".txt";
				Files.copy(Paths.get(path), Paths.get(subPath, BACKUP, newFileName),
						StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
