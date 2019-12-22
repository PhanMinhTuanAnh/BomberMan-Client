package ta.bomberman;

import javax.swing.SwingUtilities;

import ta.bomberman.gui.Frame;
import ta.bomberman.tcp.Client;

public class BombermanGame {
	public static Client client;
	public static boolean isLogin; 
	
	public static void main(String[] args) {
		new Frame();
	}
}
