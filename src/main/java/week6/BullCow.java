package week6;

import week3.Playable;

public class BullCow<T extends Inputable & Randomizable & Creatable<T>> implements Playable {
	Combination<T> combination;
	Creatable<T> genericType;

	public BullCow(Creatable<T> type) {
		genericType = type;
		createCombination();
	}

	private void createCombination() {
		System.out.println("Въведете дължината на вашето предположение>");
		Combination.chooseSize();
		combination = new Combination<T>(genericType);
		combination.generate();
	}

	@Override
	public void play() {
		Combination<T> guess = new Combination<T>(genericType);
		while (!guess.matches(combination)) {
			guess = makeGuess();
			BullCowPair pair = combination.getResult(guess);
			System.out.println(pair);
		}
		System.out.println("БРАВО, познахте!");
	}

	private Combination<T> makeGuess() {
		Combination<T> guess = new Combination<T>(genericType);
		System.out.println("Моля, сега въвеждайте един по един елементите на вашето предположение.");
		guess.input();
		return guess;
	}

	public static void main(String[] args) {
		BullCow<BullCowInteger> game = new BullCow<BullCowInteger>(new BullCowInteger());
		game.play();

	}

}
