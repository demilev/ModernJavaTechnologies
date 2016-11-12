package week6;

public class BullCowPair {
	int bulls;
	int cows;

	BullCowPair(int bulls, int cows) {
		this.bulls = bulls;
		this.cows = cows;
	}

	@Override
	public String toString() {
		if (bulls == 1) {
			if (cows == 1) {
				return "1 бик, 1 крава";
			} else {
				return "1 бик, " + cows + " крави";
			}
		} else {
			if (cows == 1) {
				return bulls + " бика, 1 крава";
			} else {
				return bulls + " бика, " + cows + " крави";
			}
		}
	}

}
