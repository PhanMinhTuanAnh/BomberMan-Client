/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta.bomberman.entities.character;

import ta.bomberman.Board;
import ta.bomberman.entities.bomb.Bomb;
import ta.bomberman.graphics.Sprite;

import java.util.List;
/**
 *
 * @author user
 */
public class Bomber2 extends Bomber {

    private List<Bomb> _bombs;

    public Bomber2(int x, int y, Board board) {
        super(x, y, board);
        _bombs = _board.getBombs();
        _input = _board.getInput2();
        _sprite = Sprite.player_right;
    }

}
