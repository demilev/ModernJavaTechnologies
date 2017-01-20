package week14;

public class Snowboarder implements Runnable {

	private static final long USAGE_TIME = 200;
	private String name;
	private PayDesk payDesk;

	public Snowboarder(String name, PayDesk payDesk) {
		this.name = name;
		this.payDesk = payDesk;
	}

	@Override
	public void run() {
		payDesk.sellCard(this.name);
		System.out.println(name + " has buyed card!");
		try {
			System.out.println(name + " is using card!");
			Thread.sleep(USAGE_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		payDesk.retrieveCard(this.name);
		System.out.println(name + " has retrieved card!");
	}

}
