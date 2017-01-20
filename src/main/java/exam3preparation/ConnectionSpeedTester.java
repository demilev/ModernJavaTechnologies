package exam3preparation;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;

public class ConnectionSpeedTester implements Callable<Long> {
	private String host;

	public ConnectionSpeedTester(String host) {
		this.host = host;
	}

	@Override
	public Long call() throws Exception {
		Long start = System.currentTimeMillis();
		try {
			URL connection = new URL("http://" + host);
			connection.openConnection().getInputStream();
		} catch (MalformedURLException e) {
			return (long) -1;
		} catch (IOException e) {
			return (long) -1;
		}
		Long end = System.currentTimeMillis();
		return end - start;
	}

}
