package week3;

public class Field {
	private char symbol;
	private boolean isMarked;
	Field() {
		isMarked=false;
	}

	public char getChar() {
		return symbol;
	}

	public boolean isMarked(){
		return isMarked;
	}
	
	public void setChar(char symbol) {
		this.symbol = symbol;

	}

	public void setMarked() {
		isMarked=true;
	}
}
