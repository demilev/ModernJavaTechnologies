package week14;

public class TransferEmployee implements Runnable {

	private PayDesk payDesk;
	private Vault vault;

	public TransferEmployee(PayDesk payDesk, Vault vault) {
		this.payDesk = payDesk;
		this.vault = vault;

	}

	@Override
	public void run() {
		while (true) {
			payDesk.transferToVault(vault);
		}
	}
}
