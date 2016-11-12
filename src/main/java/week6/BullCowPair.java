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
				return "1 ���, 1 �����";
			} else {
				return "1 ���, " + cows + " �����";
			}
		} else {
			if (cows == 1) {
				return bulls + " ����, 1 �����";
			} else {
				return bulls + " ����, " + cows + " �����";
			}
		}
	}

}
