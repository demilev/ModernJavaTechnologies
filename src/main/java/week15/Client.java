package week15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {

	public void connect() {
		try {
			Socket socket = new Socket(InetAddress.getLocalHost(), 2222);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String message = new String();
			Scanner scanner = new Scanner(System.in);
			do {
				message = scanner.nextLine();
				bw.write(message);
				bw.newLine();
				bw.flush();
				System.out.println(br.readLine());
			} while (!message.equals("quit"));
			scanner.close();
			br.close();
			bw.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		connect();
	}
}
