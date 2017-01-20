package week15;

import java.net.URL;

public class EchoChat {
	public static void main(String[] args) {
		Server server = new Server();
		new Thread(server).start();
		new Thread(new Client()).start();

	}
}
