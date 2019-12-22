package ta.bomberman.entities.tile;


import ta.bomberman.Board;

import ta.bomberman.entities.Entity;
import ta.bomberman.entities.character.Bomber;
import ta.bomberman.graphics.Sprite;

public class Portal extends Tile {

	protected Board _board;
	
	public Portal(int x, int y, Sprite sprite, Board board) {
		super(x, y, sprite);
		_board = board;
	}
	
	@Override
	public boolean collide(Entity e) {
		// TODO: xử lý khi Bomber đi vào
		
		if(e instanceof Bomber ) {
			
			if(_board.detectNoEnemies() == false)
				return false;
			
			if(e.getXTile() == getX() && e.getYTile() == getY()) {
				if(_board.detectNoEnemies())
					_board.winGame();
			}
			
			return true;
		}
		return false;
	}

}
