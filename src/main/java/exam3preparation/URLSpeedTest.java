package exam3preparation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class URLSpeedTest {
	public static void main(String[] args) throws IOException {
		Long start = System.currentTimeMillis();
		int nOfThreads = 5;
		ExecutorService executor = Executors.newFixedThreadPool(nOfThreads);
		Optional<Long> minSpeed = Files.lines(Paths.get("C:\\Users\\Mitko\\workspace\\JavaTechnologies\\hosts.txt"))
				.map(host -> wrappedConnectionTester(host, executor)).filter(speed -> speed > 0)
				.min((x, y) -> (int) (x - y));
		Long end = System.currentTimeMillis();
		System.out.println(minSpeed.orElse((long) 0) + " is the min speed found for " + (end - start));
		executor.shutdown();
	}

	public static Long wrappedConnectionTester(String host, ExecutorService executor) {

		try {
			return executor.submit(new ConnectionSpeedTester(host)).get();
		} catch (InterruptedException e) {
			return (long) -1;
		} catch (ExecutionException e) {
			return (long) -1;
		}

	}

}
