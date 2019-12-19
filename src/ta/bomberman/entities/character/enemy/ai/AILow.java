package ta.bomberman.entities.character.enemy.ai;

import java.util.Random;

public class AILow extends AI {

	@Override
	public int calculateDirection() {
		return new Random().nextInt(4);
	}

}
