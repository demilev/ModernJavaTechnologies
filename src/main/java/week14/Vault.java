package week14;

public class Vault {
	private int money;
	Vault(int money){
		this.money = money;
	}
	public synchronized void deposit(int i) {
		money+=i;
	}
	public int getMoney() {
		return money;
	} 
}
