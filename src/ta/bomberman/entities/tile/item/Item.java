package ta.bomberman.entities.tile.item;

import ta.bomberman.entities.tile.Tile;
import ta.bomberman.graphics.Sprite;

public abstract class Item extends Tile {

	public Item(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}
}
