package week15;
// to do 
// at connection class
// multiple users
// bonus tasks
import java.net.URL;

public class EchoChat {
	public static void main(String[] args) {
		//Server server = new Server();
		//new Thread(server).start();
		//new Thread(new Client()).start();
		String test = "hi   gosho   kak eeeee";
		String [] separated = test.split("\\s+");
		for(int i = 0;i<4;i++)
			System.out.println(separated[i]);
	}
}
