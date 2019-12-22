package ta.bomberman.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import ta.bomberman.BombermanGame;
import ta.bomberman.Game;
import ta.bomberman.input.Keyboard;



//Port Server va` Port Socket khac nhau
/*
 * Luồng :
 * 
 */

public class Client {
	private InetAddress host;
	private int port;
	Socket client;
	DataInputStream dis;
	DataOutputStream dos;
	
	public Client(InetAddress host, int port) throws IOException {
		this.host = host;
		this.port = port;
		this.client = new Socket(host, port);
		this.dis = new DataInputStream(this.client.getInputStream());
		this.dos = new DataOutputStream(this.client.getOutputStream());

	}
	
	public boolean checkLogin(String username, String password)  {
		try {
			dos.writeUTF("check login");
			dos.writeUTF(username);
			dos.writeUTF(password);
			System.out.println("123");
			String response = dis.readUTF();
			System.out.println(response);
			if(response.equalsIgnoreCase("ok"))
				return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}

