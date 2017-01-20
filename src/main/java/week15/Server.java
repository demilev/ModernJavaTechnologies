package week15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
	public void start() {
		try {
			ServerSocket serverSocket = new ServerSocket(2222);
			Socket socket = serverSocket.accept();
			System.out.println("CONNECTED");
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String message = br.readLine();
			while (!message.equals("quit")) {
				bw.write(message);
				bw.newLine();
				bw.flush();
				message = br.readLine();
			}
			bw.write("bye");
			bw.newLine();
			bw.flush();
			br.close();
			bw.close();
			serverSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		start();
	}
}
