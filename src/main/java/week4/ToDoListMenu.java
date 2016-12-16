package week4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ToDoListMenu {
	private static final String COPY_TASKS = "copy-of-tasks.txt";
	private static final String BACKUP = "Backup.zip";
	private static final long DAY = 86400000;
	private ToDoList list;

	public ToDoListMenu(ToDoList list) {
		this.list = list;
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		int option = -1;
		do {
			System.out.println("Choose option\n");
			printOptions();
			System.out.println("\nYour choice (1-6):");
			try {
				option = parseInput(scanner);
			} catch (IllegalArgumentException e) {
				System.out.println("INVALID INPUT!" + e.getMessage() + "\n");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("INVALID FILE!" + e.getMessage() + "\n");
			}
		} while (option != 6);
		scanner.close();
	}

	private int parseInput(Scanner scanner) throws IOException {
		int option = scanner.nextInt();
		switch (option) {
		case 1:
			System.out.print(list.tasksByPriority());
			break;
		case 2:
			System.out.print(list.tasksInProcess());
			break;
		case 3:
			System.out.print(list.upcommingTasks());
			break;
		case 4:
			String importPath = inputPath();
			list.importTasksFromFile(importPath);
			break;
		case 5:
			String exportPath = inputPath();
			String pathForZipping = exportPath;
			if (Files.exists(Paths.get(exportPath))) {
				String newExportPath = exportPath.substring(0, exportPath.lastIndexOf('\\') + 1) + COPY_TASKS;
				Files.copy(Paths.get(exportPath), Paths.get(newExportPath), StandardCopyOption.REPLACE_EXISTING);
				exportPath = newExportPath;
			}
			list.exportTasksToFile(exportPath);
			toArchiveIfNecessary(pathForZipping);
			break;
		case 6:
			System.out.println("Bye!");
			break;
		default:
			throw new IllegalArgumentException("No such an option!");
		}
		return option;
	}

	// todo
	private void toArchiveIfNecessary(String path) {

		if (millisFromLastFileEdit(path) >= DAY) {
			try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(BACKUP))) {

				ZipEntry entry = new ZipEntry(
						LocalDate.now().toString() + "/" + path.substring(path.lastIndexOf("\\") + 1));
				zos.putNextEntry(entry);
				zos.closeEntry();
			}

			catch (IOException e) {
				System.out.println("NO SUCH FILE! " + e.getMessage());
			}

			Map<String, String> env = new HashMap<>();
			env.put("create", "true");
			URI uri = URI.create("jar:file:" + "///Users/Mitko/workspace/JavaTechnologies/" + BACKUP);

			try (FileSystem zipfs = FileSystems.newFileSystem(uri, env)) {
				Path externalTxtFile = Paths.get(path);
				Path pathInZipfile = zipfs.getPath("/" + LocalDate.now().toString(),
						path.substring(path.lastIndexOf("\\") + 1));
				Files.move(externalTxtFile, pathInZipfile, StandardCopyOption.REPLACE_EXISTING);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private long millisFromLastFileEdit(String path) {
		try {
			return System.currentTimeMillis() - Files.getLastModifiedTime(Paths.get(path)).toMillis();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private String inputPath() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input the whole path of the file: ");
		String path = scanner.nextLine();
		return path;
	}

	private void printOptions() {
		System.out.println("1) All tasks ordered by priority");
		System.out.println("2) Tasks with status IN PROCESS");
		System.out.println("3) Tasks which should be finished in three days");
		System.out.println("4) Import tasks from file");
		System.out.println("5) Export tasks to file");
		System.out.println("6) Exit");
	}
}
