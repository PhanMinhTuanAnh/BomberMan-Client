package ta.bomberman.entities.tile;

import ta.bomberman.entities.Entity;
import ta.bomberman.graphics.Sprite;

public class Portal extends Tile {

	public Portal(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}
	
	@Override
	public boolean collide(Entity e) {
		// TODO: xử lý khi Bomber đi vào
		return false;
	}

}
