package ta.bomberman.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ta.bomberman.Game;

/**
 * Tiếp nhận và xử lý các sự kiện nhập từ bàn phím
 */
public class Keyboard implements KeyListener {
	
	private boolean[] keys = new boolean[120]; //120 is enough to this game
	public boolean up, down, left, right, space;
	
	public void update() {
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		space = keys[KeyEvent.VK_SPACE] || keys[KeyEvent.VK_X];
	}
	
	public void update(String str) {
		if(str.equalsIgnoreCase("up")) {
			up = true;
			down = false;
			left = false;
			right = false;
		}
		else if(str.equalsIgnoreCase("down")) {
			up = false;
			down = true;
			left = false;
			right = false;
		}
		else if(str.equalsIgnoreCase("left")) {
			up = false;
			down = false;
			left = true;
			right = false;
		}
		else if(str.equalsIgnoreCase("right")){
			up = false;
			down = false;
			left = false;
			right = true;
		}
		else {
			up = false;
			down = false;
			left = false;
			right = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}

}
