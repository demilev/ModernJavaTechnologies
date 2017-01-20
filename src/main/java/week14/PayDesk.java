package week14;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class PayDesk {

	private static final int SLEEP_TIME = 20;
	private static final int DEFAULT_MAX_CARD_HOLDERS = 1000;
	private static final int CARD_PRICE = 50;
	private static final int DEPOSIT = 1;
	private static final long DEPOSIT_WAIT = 200;
	private static final int TOO_MUCH_MONEY = 100;
	private int remaining;
	private int balance = 0;
	private Map<String, LocalDate> cardHolders = new HashMap<>();

	public PayDesk() {
		remaining = DEFAULT_MAX_CARD_HOLDERS;
	}

	public PayDesk(int remaining) {
		remaining = this.remaining;
	}

	public synchronized void sellCard(String name) {
		while (remaining <= 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		cardHolders.put(name, LocalDate.now());
		balance += CARD_PRICE + DEPOSIT;
		remaining--;

	}

	public synchronized void retrieveCard(String name) {
		balance -= DEPOSIT;
		cardHolders.remove(name);
		remaining++;
		this.notify();
	}

	public synchronized void transferToVault(Vault vault) {
		while (balance <= TOO_MUCH_MONEY) {
			try {
				this.wait(DEPOSIT_WAIT);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		vault.deposit(balance - TOO_MUCH_MONEY);
		balance -= TOO_MUCH_MONEY;
	}

	public int getBalance() {
		return balance;
	}

	public int getRemaining() {
		return remaining;
	}
}
