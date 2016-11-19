package week7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

	int countTranslatedWords(String filePath) {
		return countWords(translatedTextFromFile(filePath));
	}

	private String translatedTextFromFile(String filePath) {
		StringBuilder content = new StringBuilder();
		String line = null;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			while ((line = br.readLine()) != null) {
				content.append(line).append("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content.toString();
	}

	private int countWords(String text) {
		int result = 0;
		Pattern p = Pattern.compile("\\b([^\\s\\d]+?)\\b");
		Matcher m = p.matcher(text);
		while (m.find()) {
			result++;
		}
		return result;
	}

	public static void main(String[] args) {
		WordCounter counter = new WordCounter();
		System.out.println("Броят на думите във файла е : " + counter.countTranslatedWords("output.txt"));
	}
}
