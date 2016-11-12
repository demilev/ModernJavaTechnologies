package week6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Combination<T extends Inputable & Randomizable & Creatable<T>> {
	static int combinationSize;
	List<T> combination;

	Combination(Creatable<T> factory) {
		combination = new ArrayList<T>(combinationSize);
		for (int i = 0; i < combinationSize; i++)
			combination.add(factory.create());

	}

	public void generate() {
		for (int i = 0; i < combinationSize; i++) {
			combination.get(i).generateRandom();
			while (isNotUnique(combination.get(i), i)) {
				combination.get(i).generateRandom();
			}
		}
	}

	private boolean isNotUnique(T t, int i) {
		for(int k=0;k<combinationSize;k++){
			if(i!=k&&combination.get(k).equals(t)){
				return true;
			}
		}
		return false;
	}

	static void chooseSize() {
		Scanner scanner = new Scanner(System.in);
		int result = scanner.nextInt();
		if (result <= 0)
			throw new IllegalArgumentException();
		combinationSize = result;
	}

	public boolean matches(Combination<T> other) {
		for (int i = 0; i < combinationSize; i++) {
			if (!combination.get(i).equals(other.combination.get(i)))
				return false;
		}
		return true;
	}

	public BullCowPair getResult(Combination<T> guess) {
		int bulls = getBulls(guess);
		int cows = getCows(guess);
		return new BullCowPair(bulls, cows);

	}

	private int getCows(Combination<T> guess) {
		int cows = 0;
		for (int i = 0; i < combinationSize; i++) {
			T crr = combination.get(i);
			for (int k = 0; k < combinationSize; k++) {
				if (i != k && crr.equals(guess.combination.get(k)))
					cows++;
			}
		}
		return cows;
	}

	private int getBulls(Combination<T> guess) {
		int bulls = 0;
		for (int i = 0; i < combinationSize; i++) {
			if (combination.get(i).equals(guess.combination.get(i)))
				bulls++;
		}
		return bulls;
	}

	public void input() {
		for (int i = 0; i < combinationSize; i++) {
			combination.get(i).input();
		}
	}

}
