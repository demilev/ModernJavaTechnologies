package week14;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class WorkDay {
	public static void main(String[] args) throws InterruptedException {
		int N = 5;
		String[] names = { "gosho", "mitko", "toshko", "ivan", "pesho" };
		PayDesk payDesk = new PayDesk(3);
		Thread[] threads = new Thread[5];
		// for (int i = 0; i < N; i++) {
		// Snowboarder snowboarder = new Snowboarder(names[i], payDesk);
		// threads[i] = new Thread(snowboarder);
		// threads[i].start();
		//
		// }
		// for (int i = 0; i < N; i++) {
		// threads[i].join();
		// }
		Vault vault = new Vault(0);
		Thread vaultThread = new Thread(new TransferEmployee(payDesk, vault));
		vaultThread.setDaemon(true);
		vaultThread.start();

		

		ExecutorService executor = Executors.newFixedThreadPool(N);
		for (int i = 0; i < N; i++) {
			executor.execute(new Snowboarder(names[i], payDesk));
		}
		Thread.sleep(5000);
		System.out.println(vault.getMoney());
		System.out.println(payDesk.getBalance());
		executor.shutdown();
	}
}
