package objects;

import java.util.ArrayList;

public class Snake {

	ArrayList<Integer> snakePosition = new ArrayList<Integer>();
	
	// Store the previous tail position to add if apple eaten.
	
	
	public void updatePosition(int direction) {
		// Update whole list with new coordinates.
		
		// Update previous tail position.
	}
	
	public void eatApple() {
		// Add new tail X.
		snakePosition.add(snakePosition.size(), null);
		
		// Add new tail Y.
		snakePosition.add(snakePosition.size(), null);
	}
}
