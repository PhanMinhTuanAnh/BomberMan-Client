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
	FileOutputStream fos = null;
	InputStream is = null;
	byte[] b;
	
	public Client(InetAddress host, int port) throws IOException {
		this.host = host;
		this.port = port;
		this.client = new Socket(host, port);
		this.dis = new DataInputStream(this.client.getInputStream());
		this.dos = new DataOutputStream(this.client.getOutputStream());
		fos = new FileOutputStream("D:\\JAvaws\\ProjectBomberMan\\res\\levels\\MAP.txt");
		is = client.getInputStream();
		b = new byte[2002];
	}
	
	public boolean checkLogin(String username, String password)  {
		try {
			dos.writeUTF("check login");
			dos.writeUTF(username);
			dos.writeUTF(password);
			String response = dis.readUTF();
			if(response.equalsIgnoreCase("ok"))
				return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void getMap()  {
		try {
			dos.writeUTF("get map");
			is = client.getInputStream();
			is.read(b, 0, b.length);
			// viết vào file mới
			fos.write(b, 0, b.length);
		} catch (IOException e) {
			System.out.println("get map fail");
			// TODO Auto-generated catch block
		}
	}

}

