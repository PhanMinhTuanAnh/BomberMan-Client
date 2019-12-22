package ta.bomberman.level;

import ta.bomberman.Board;
import ta.bomberman.Game;
import ta.bomberman.entities.LayeredEntity;
import ta.bomberman.entities.character.Bomber;
import ta.bomberman.entities.character.Bomber2;
import ta.bomberman.entities.character.enemy.Balloon;
import ta.bomberman.entities.character.enemy.Oneal;
import ta.bomberman.entities.tile.Grass;
import ta.bomberman.entities.tile.Portal;
import ta.bomberman.entities.tile.Wall;
import ta.bomberman.entities.tile.destroyable.Brick;
import ta.bomberman.entities.tile.item.BombItem;
import ta.bomberman.entities.tile.item.FlameItem;
import ta.bomberman.entities.tile.item.SpeedItem;
import ta.bomberman.exceptions.LoadLevelException;
import ta.bomberman.graphics.Screen;
import ta.bomberman.graphics.Sprite;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileLevelLoader extends LevelLoader {

	/**
	 * Ma trận chứa thông tin bản đồ, mỗi phần tử lưu giá trị kí tự đọc được
	 * từ ma trận bản đồ trong tệp cấu hình
	 */
	private static char[][] _map;
	
	public FileLevelLoader(Board board, int level) throws LoadLevelException {
		super(board, level);
	}
	
	@Override
	public void loadLevel(int level) {
		// TODO: đọc file 
		// TODO: cập nhật các giá trị đọc được vào _width, _height, _level, _map
		
		//\\ DONE
		
		// NOTE: việc dở ỏ đây là bắt lỗi tào lao, không in ra, bên cạnh đó nên đọc về kiến thức bufferedReader ...
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("D:\\JAvaws\\ProjectBomberMan\\res\\levels\\Level3.txt"));
			String str[] = br.readLine().split(" ");
			_level = Integer.parseInt(str[0]); 
			_height = Integer.parseInt(str[1]);
			_width = Integer.parseInt(str[2]);
			_map = new char [_height][_width];
			System.out.println(_level + " " + _height + " " + _width);
			for (int i = 0; i < _height; i++) {
				String temp = br.readLine();
				for (int j = 0; j < _width; j++) {
					_map[i][j] = temp.charAt(j);
//					System.out.print(_map[i][j]);
				}
//				System.out.println();
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	@Override
	public void createEntities(int xStartBomberman, int yStartBomberman, int xStartOpponent, int yStartOpponent) {
		// TODO: tạo các Entity của màn chơi
		// TODO: sau khi tạo xong, gọi _board.addEntity() để thêm Entity vào game

		_map[yStartBomberman][xStartBomberman] = 'p';
		if(xStartOpponent != -1 && yStartOpponent != -1)
			_map[xStartOpponent][yStartOpponent] = 'd';

		for (int i = 0; i < _height; i++) {
			for (int j = 0; j < _width; j++) {	
				switch (_map[i][j]) {
					case '#':
						// thêm Wall
						_board.addEntity(i * _width + j, new Wall(j, i, Sprite.wall));
						break;
					case '*':
						// thêm Brick
						int xB = j, yB = i;
						_board.addEntity(xB + yB * _width,
								new LayeredEntity(xB, yB,
									new Grass(xB, yB, Sprite.grass),
									new Brick(xB, yB, Sprite.brick)
								)
						);
						break;
					case 'x':
						// thêm Portal kèm Brick che phủ ở trên
						int xP = j, yP = i;
						_board.addEntity(xP + yP * _width,
								new LayeredEntity(xP, yP,
									new Grass(xP ,yP, Sprite.grass),
									new Brick(xP, yP, Sprite.brick)
								)
						);
						break;
					case 'p':
                        // thêm Bomber
                        int xBomber = j, yBomber = i;
                        Bomber bomber = new Bomber(Coordinates.tileToPixel(xBomber), Coordinates.tileToPixel(yBomber) + Game.TILES_SIZE, _board);
                        _board.addCharacter(bomber);
                        Screen.setOffset(0, 0);
                        _board.addEntity(xBomber + yBomber * _width, new Grass(xBomber, yBomber, Sprite.grass));
                        break;
                        
					case 'd':
                        // thêm Bomber2
                        int xBomber2 = j, yBomber2 = i;
                        Bomber2 bomber2 = new Bomber2(Coordinates.tileToPixel(xBomber2), Coordinates.tileToPixel(yBomber2) + Game.TILES_SIZE, _board);
                        _board.addCharacter(bomber2);
                        Screen.setOffset(0, 0);
                        _board.addEntity(xBomber2 + yBomber2 * _width, new Grass(xBomber2, yBomber2, Sprite.grass));
                        break;
                       
					case '1':
						// thêm Enemy
						_board.addCharacter(new Balloon(Coordinates.tileToPixel(j),
                                Coordinates.tileToPixel(i) + Game.TILES_SIZE, _board));
						_board.addEntity(j + i * _width, new Grass(j, i, Sprite.grass));
						break;
					case '2':
						// thêm Enemy
						_board.addCharacter(new Oneal(Coordinates.tileToPixel(j),
                                Coordinates.tileToPixel(i) + Game.TILES_SIZE, _board));
						_board.addEntity(j + i * _width, new Grass(j, i, Sprite.grass));
						break;
					case 'b':
						// thêm Bomb Item kèm Brick che phủ ở trên
						int xBombI = j, yBombI = i;
						_board.addEntity(xBombI + yBombI * _width,
								new LayeredEntity(xBombI, yBombI,
									new Grass(xBombI, yBombI, Sprite.grass),
									new BombItem(xBombI, yBombI, Sprite.powerup_bombs),
									new Brick(xBombI, yBombI, Sprite.brick)
								)
						);
						break;
					case 'f':
						// thêm Flame Item kèm Brick che phủ ở trên
						int xFlameI = j, yFlameI = i;
						_board.addEntity(xFlameI + yFlameI * _width,
								new LayeredEntity(xFlameI, yFlameI,
									new Grass(xFlameI, yFlameI, Sprite.grass),
									new FlameItem(xFlameI, yFlameI, Sprite.powerup_flames),
									new Brick(xFlameI, yFlameI, Sprite.brick)
								)
						);
						break;
					case 's':
						// thêm Speed Item kèm Brick che phủ ở trên
						int xSpeedI = j, ySpeedI = i;
						_board.addEntity(xSpeedI + ySpeedI * _width,
								new LayeredEntity(xSpeedI, ySpeedI,
									new Grass(xSpeedI, ySpeedI, Sprite.grass),
									new SpeedItem(xSpeedI, ySpeedI, Sprite.powerup_speed),
									new Brick(xSpeedI, ySpeedI, Sprite.brick)
								)
						);
						break;
					default:
						_board.addEntity(i * _width + j, new Grass(j, i, Sprite.grass));
				}
			}
		}		
		
		// TODO: phần code mẫu ở dưới để hướng dẫn cách thêm các loại Entity vào game
		// TODO: hãy xóa nó khi hoàn thành chức năng load màn chơi từ tệp cấu hình
		
		// thêm Wall
		
//		_height = 20;
//		_width = 20;
//		for (int x = 0; x < 20; x++) {
//			for (int y = 0; y < 20; y++) {
//				int pos = x + y * _width;
//				Sprite sprite = y == 0 || x == 0 || x == 10 || y == 10 ? Sprite.wall : Sprite.grass;
//				_board.addEntity(pos, new Grass(x, y, sprite));
//			}
//		}
//
//		// thêm Bomber
//		int xBomber = 4, yBomber = 5;
//		_board.addCharacter( new Bomber(Coordinates.tileToPixel(xBomber), Coordinates.tileToPixel(yBomber) + Game.TILES_SIZE, _board) );
//		Screen.setOffset(0, 0);
//		_board.addEntity(xBomber + yBomber * _width, new Grass(xBomber, yBomber, Sprite.grass));
//
//		// thêm Enemy
//		int xE = 2, yE = 1;
//		_board.addCharacter( new Balloon(Coordinates.tileToPixel(xE), Coordinates.tileToPixel(yE) + Game.TILES_SIZE, _board));
//		_board.addEntity(xE + yE * _width, new Grass(xE, yE, Sprite.grass));
//
//		// thêm Brick
//		int xB = 3, yB = 1;
//		_board.addEntity(xB + yB * _width,
//				new LayeredEntity(xB, yB,
//					new Grass(xB, yB, Sprite.grass),
//					new Brick(xB, yB, Sprite.brick)
//				)
//		);
//
//		// thêm Item kèm Brick che phủ ở trên
//		int xI = 1, yI = 2;
//		_board.addEntity(xI + yI * _width,
//				new LayeredEntity(xI, yI,
//					new Grass(xI ,yI, Sprite.grass),
//					new SpeedItem(xI, yI, Sprite.powerup_flames),
//					new Brick(xI, yI, Sprite.brick)
//				)
//		);
	}
}
