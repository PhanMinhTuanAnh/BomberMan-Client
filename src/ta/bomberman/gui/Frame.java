package ta.bomberman.gui;

import ta.bomberman.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Swing Frame chứa toàn bộ các component
 */
public class Frame extends JFrame {
	private JPanel _containerpane;
	public GamePanel _gamepane;
	private InfoPanel _infopanel;
	
	private Game _game;

	public Frame() {
		
		_containerpane = new JPanel(new BorderLayout());
		_gamepane = new GamePanel(this);
		
		//khai báo phần info phía trên Time and Score
		_infopanel = new InfoPanel(_gamepane.getGame());
		
		// info trên cùng, còn game bên dưới
		_containerpane.add(_infopanel, BorderLayout.PAGE_START);
		_containerpane.add(_gamepane, BorderLayout.PAGE_END);
		
		_game = _gamepane.getGame();
		
		add(_containerpane);
		
		// các nút thu nhỏ phóng to, tắt
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//pack() sẽ tự động thay đổi kích thước của JFrame dựa trên kích thước của các component mà nó chứa
		pack();
		
		setLocationRelativeTo(null);
		setVisible(true);	
		
		_game.start();
	}
	
	public void setTime(int time) {
		_infopanel.setTime(time);
	}
	
	public void setPoints(int points) {
		_infopanel.setPoints(points);
	}
	
}
