package ta.bomberman;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.SwingUtilities;

import ta.bomberman.gui.Frame;
import ta.bomberman.gui.Login;
import ta.bomberman.gui.Table;
import ta.bomberman.gui.Welcome;
import ta.bomberman.tcp.Client;

public class BombermanGame {
	public static Client client;
	public static boolean isLogin = false; 
	public static int isGamePlay = 0;
	public static int countPlay = 1;
	public static String username = "";
	public static Frame frame ;
	
	public static void main(String[] args) {

		try {
			client = new Client(InetAddress.getLocalHost(), 15790);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Login();
		while(!isLogin) {
			System.out.print("");
		}
		new Welcome();
		while(isGamePlay == 0) {
			System.out.print("");
		}
		frame = new Frame();
//		while(!isGameClose) {
//			System.out.print("");
//		}
//		new BombermanGame();
	}
}
