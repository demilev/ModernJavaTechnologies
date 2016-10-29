package week3;

public class TicTacToeBoard {
	private Field[][] fields;
	public static final int SIZE = 3;

	public TicTacToeBoard() {
		fields = new Field[SIZE][SIZE];
		initializeEmptyFields();
	}

	private void initializeEmptyFields() {
		for (int i = 0; i < SIZE; i++) {
			for (int k = 0; k < SIZE; k++) {
				fields[i][k] = new Field();
			}
		}

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < SIZE; i++) {
			if (i < SIZE - 1) {
				rowToString(builder, i);
				for (int k = 0; k < SIZE - 1; k++) {
					builder.append("-").append(" | ");
				}
				builder.append("-").append("\n");
			} else {
				rowToString(builder, i);
			}
		}
		String result = builder.toString();
		return result;
	}

	private void rowToString(StringBuilder builder, int i) {
		for (int k = 0; k < SIZE - 1; k++) {
			if (fields[i][k].isMarked()) {
				char currentFieldSymbol = fields[i][k].getChar();
				builder.append(currentFieldSymbol).append(" | ");
			} else {
				builder.append(i * SIZE + k + 1).append(" | ");
			}
		}
		if (fields[i][SIZE - 1].isMarked()) {
			builder.append(fields[i][SIZE - 1].getChar()).append("\n");
		} else {
			builder.append((i + 1) * SIZE).append("\n");
		}
	}

	public boolean canNotBePlayed() {
		return hasWinner() || hasNoWinner();
	}

	public boolean hasWinner() {
		return hasRowFilled() || hasColumnFilled() || hasDiagonalFilled();
	}

	private boolean isFull() {

		for (int i = 0; i < SIZE; i++) {
			for (int k = 0; k < SIZE; k++) {
				if (!fields[i][k].isMarked())
					return false;
			}
		}
		return true;
	}

	private boolean hasDiagonalFilled() {
		return hasMainDiagonalFilled() || hasSecondaryDiagonalFilled();
	}

	private boolean hasSecondaryDiagonalFilled() {
		
		if (fields[0][SIZE - 1].isMarked()) {
			char symbol = fields[0][SIZE - 1].getChar();
			int i = 1;
			while (i < SIZE) {
				if (fields[i][SIZE - i - 1].getChar() != symbol) {
					return false;
				}
				i++;
			}
			if (i == SIZE)
				return true;
		}
		return false;
	}

	private boolean hasMainDiagonalFilled() {
		
		if (fields[0][0].isMarked()) {
			char symbol = fields[0][0].getChar();
			int i = 1;
			while (i < SIZE) {
				if (fields[i][i].getChar() != symbol) {
					return false;
				}
				i++;
			}
			if (i == SIZE)
				return true;
		}
		return false;
	}

	private boolean hasColumnFilled() {
		for (int i = 0; i < SIZE; i++) {
			if(isColumnFilled(i))
				return true;
		}
		return false;
	}

	private boolean isColumnFilled(int i) {
		if (fields[0][i].isMarked()) {
			char symbol = fields[0][i].getChar();
			int k = 1;
			while (k < SIZE) {
				if (fields[k][i].getChar() != symbol) {
					break;
				}
				k++;
			}
			if (k == SIZE) {
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}

	private boolean hasRowFilled() {
		for (int i = 0; i < SIZE; i++) {
			if(isRowFilled(i))
				return true;;
		}
		return false;
	}

	private boolean isRowFilled(int i) {
		if (fields[i][0].isMarked()) {
			char symbol = fields[i][0].getChar();
			int k = 1;
			while (k < SIZE) {
				if (fields[i][k].getChar() != symbol) {
					break;
				}
				k++;
			}
			if (k == SIZE) {
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}

	public boolean canBePlayed(int field) {
		return !fields[(field - 1) / SIZE][(field - 1) % SIZE].isMarked();
	}

	public void setField(int field, char symbol) {
		fields[(field - 1) / SIZE][(field - 1) % SIZE].setChar(symbol);
		fields[(field - 1) / SIZE][(field - 1) % SIZE].setMarked();

	}

	public boolean hasNoWinner() {
		return !hasColumnFilled() && !hasDiagonalFilled() && !hasRowFilled()&&isFull();
	}

	public int size() {
		return SIZE;
	}
}
