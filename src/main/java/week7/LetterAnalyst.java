package week7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class LetterAnalyst {
	private static final String ALPHABET = "alphabet.txt";
	private Map<Character, Integer> lettersFrequency;

	private void setup() {
		String line = null;
		try (BufferedReader br = new BufferedReader(new FileReader(ALPHABET))) {
			while ((line = br.readLine()) != null) {
				String[] pair = line.split(":");
				lettersFrequency.put(pair[1].charAt(0), 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public LetterAnalyst() {
		lettersFrequency=new HashMap<Character,Integer>();
		setup();
	}

	public void countFrequency(String filePath) {
		int crrChar = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			while ((crrChar = br.read()) != -1) {
				Character character=new Character((char)crrChar);
				if(lettersFrequency.containsKey(character)){
					lettersFrequency.replace(character, lettersFrequency.get(character)+1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String topFrequencies(int n){ //top n frequencies 
		StringBuilder result=new StringBuilder();
		result.append("The top " + n + " most used letters are :\n");
		lettersFrequency.entrySet()
						.stream()
						.sorted((entry1,entry2)->(entry2.getValue()-entry1.getValue()))
						.limit(n)
						.forEach(e->result.append(e.getKey() + " : " + e.getValue() + "\n"));
		return result.toString();
	}
	public static void main(String[] args) {
		LetterAnalyst analyst=new LetterAnalyst();
		analyst.countFrequency("output.txt");
		System.out.println(analyst.topFrequencies(7));
	}
}
