package week3;

import java.util.Scanner;

public class TicTacToe implements Playable{
	private TicTacToeBoard board;
	private Player[] players;
	public static final int NUM_OF_PLAYERS = 2;

	TicTacToe() {
		board = new TicTacToeBoard();
		players = new Player[NUM_OF_PLAYERS];
		initializePlayers();
		symbolSelection();
	}

	private void initializePlayers() {
		System.out.println("Who is going to play?");
		for (int i = 0; i < NUM_OF_PLAYERS; i++) {
			players[i] = new Player();
			System.out.println("Who will be player " + (i + 1) + " ?");
			players[i].create();
		}
	}

	private void symbolSelection() {
		for (int i = 0; i < NUM_OF_PLAYERS; i++) {
			System.out.println(players[i].getName() + " chose your symbol: ");
			Scanner scanner = new Scanner(System.in);
			char symbol = scanner.next().charAt(0);
			players[i].setSymbol(symbol);
		}
	}
	@Override
	public void play() {
		System.out.println(board.toString());
		while (!hasFinished()) {
			move();
		}
		System.out.println("Game over!");
	}

	private boolean hasFinished() {
		return board.canNotBePlayed();
	}
	
	private void move() {
		for (int i = 0; i < NUM_OF_PLAYERS; i++) {
			int field = fieldChoice(i);
			if (board.canBePlayed(field)) {
				board.setField(field, players[i].getSymbol());
				System.out.println(board.toString());
				if (board.hasWinner()) {
					System.out.println(players[i].getName() + " is winner!");
					break;
				}
				else if(board.hasNoWinner()){
					System.out.println("Draw!");
					break;
				}

			} else {
				System.out.println("Incorect input");
			}
		}

	}

	private int fieldChoice(int i) {
		int size = board.size() * board.size();
		System.out.println("Player " + players[i].getName() + " input your move (1-" + size + ")>");
		Scanner scanner = new Scanner(System.in);
		int field = scanner.nextInt();
		return field;
	}

}
