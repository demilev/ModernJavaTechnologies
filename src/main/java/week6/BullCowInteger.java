package week6;

import java.util.Random;
import java.util.Scanner;

public class BullCowInteger implements Inputable,Randomizable,Creatable<BullCowInteger> {
	int n;
	
	@Override
	public void generateRandom() {
		Random generator = new Random();
		n = generator.nextInt(10);
	
	}

	@Override
	public void input() {
		Scanner scanner=new Scanner(System.in);
		int i=scanner.nextInt();
		if(i<0||i>9)
			throw new IllegalArgumentException();
		n=i;
	}

	@Override
	public BullCowInteger create() {
		return new BullCowInteger();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BullCowInteger other = (BullCowInteger) obj;
		if (n != other.n)
			return false;
		return true;
	}
	
}
