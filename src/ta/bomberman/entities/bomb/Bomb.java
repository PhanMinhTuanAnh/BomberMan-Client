package ta.bomberman.entities.bomb;

import ta.bomberman.level.Coordinates;
import ta.bomberman.Game;
import ta.bomberman.entities.character.Character;
import ta.bomberman.Board;
import ta.bomberman.entities.AnimatedEntitiy;
import ta.bomberman.entities.Entity;
import ta.bomberman.graphics.Screen;
import ta.bomberman.graphics.Sprite;
import ta.bomberman.entities.bomb.Flame;
import ta.bomberman.entities.character.Bomber;

public class Bomb extends AnimatedEntitiy {

	protected double _timeToExplode = 120; //2 seconds
	public int _timeAfter = 20;
	
	protected Board _board;
	protected Flame[] _flames;
	protected boolean _exploded = false;
	protected boolean _allowedToPassThru = true;
	
	public Bomb(int x, int y, Board board) {
		_x = x;
		_y = y;
		_board = board;
		_sprite = Sprite.bomb;
	}
	
	@Override
	public void update() {
		if(_timeToExplode > 0) 
			_timeToExplode--;
		else {
			if(!_exploded) 
				explode();
			else
				updateFlames();
			
			if(_timeAfter > 0) 
				_timeAfter--;
			else
				remove();
		}
			
		animate();
	}
	
	@Override
	public void render(Screen screen) {
		if(_exploded) {
			_sprite =  Sprite.bomb_exploded2;
			renderFlames(screen);
		} else
			_sprite = Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, _animate, 60);
		
		int xt = (int)_x << 4;
		int yt = (int)_y << 4;
		
		screen.renderEntity(xt, yt , this);
	}
	
	public void renderFlames(Screen screen) {
		for (int i = 0; i < _flames.length; i++) {
			_flames[i].render(screen);
		}
	}
	
	public void updateFlames() {
		for (int i = 0; i < _flames.length; i++) {
			_flames[i].update();
		}
	}

    /**
     * Xử lý Bomb nổ
     */
	protected void explode() {
		_exploded = true;
		_allowedToPassThru = true;
		// TODO: xử lý khi Character đứng tại vị trí Bomb
		Character character = _board.getCharacterAtExcluding((int)_x, (int)_y, null);
		if (character != null) {
			character.kill();
		}
		// TODO: tạo các Flame
		_flames = new Flame[4];

		for (int i = 0; i < _flames.length; i++) {
			_flames[i] = new Flame((int) _x, (int) _y, i, Game.getBombRadius(), _board);
		}
	}
	
	public FlameSegment flameAt(int x, int y) {
		if(!_exploded) return null;
		
		for (int i = 0; i < _flames.length; i++) {
			if(_flames[i] == null) return null;
			FlameSegment e = _flames[i].flameSegmentAt(x, y);
			if(e != null) return e;
		}
		
		return null;
	}

	@Override
	public boolean collide(Entity e) {
        // TODO: xử lý khi Bomber đi ra sau khi vừa đặt bom (_allowedToPassThru)
		if(e instanceof Bomber) {
			double diffX = e.getX() - Coordinates.tileToPixel(getX());
			double diffY = e.getY() - Coordinates.tileToPixel(getY());
			
			if(!(diffX >= -10 && diffX < 16 && diffY >= 1 && diffY <= 28)) { 
				// xem thằng user đã đi ra khỏi bom chưa
				
				_allowedToPassThru = false;
			}
			
			return _allowedToPassThru;
		}
		
		
		// TODO: xử lý va chạm với Flame của Bomb khác
		if (e instanceof Flame) {
			// thời gian nổ
			_timeToExplode = 0;
			return true;
		}
        return false;
	}
}
