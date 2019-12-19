package ta.bomberman.entities.tile.item;

import ta.bomberman.entities.Entity;
import ta.bomberman.graphics.Sprite;

public class FlameItem extends Item {

	public FlameItem(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}

	@Override
	public boolean collide(Entity e) {
		// TODO: xử lý Bomber ăn Item
		return false;
	}

}
