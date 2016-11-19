package week7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Translator {

	private static final String FILE_PATH = "output.txt";

	private String translate() {
		StringBuilder sb = new StringBuilder();
		try (ShlokavicaReader sr = new ShlokavicaReader(new InputStreamReader(System.in))) {
			int c = 0;
			while ((c = sr.read()) != -1 && !endsWithKraj(sb)) {
				sb.append((char) c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String result = sb.toString();
		return result.substring(0, result.length() - 4);
	}

	private boolean endsWithKraj(StringBuilder sb) {
		Pattern p = Pattern.compile(".*край");
		Matcher m = p.matcher(sb.toString());
		return m.find();
	}

	public void saveTranslatedTextToFile() {
		String translatedText = translate();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
			bw.write(translatedText);
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Translator t = new Translator();
		t.saveTranslatedTextToFile();
	}
}
