package objects;

import java.util.ArrayList;

/**
 * Represents the in game snake. Holds and updates its own position 
 * information and adds more to itself when an apple is eaten.
 *
 * @author Ryan Baggs
 * @date Oct 18, 2021
 */
public class Snake {
	
	// Directions.
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	
	// Head index.
	public static final int HEAD_INDEX = 0;

	// Contains the X and Y values for the Snake.
	ArrayList<Integer> snakePositionX = new ArrayList<Integer>();
	ArrayList<Integer> snakePositionY = new ArrayList<Integer>();
	
	// Store the previous tail position to add if apple eaten.
	int[] prevTailPos = new int[2];
	
	// The X and Y indices for integer Array prevTailPos.
	private static final byte X_INDEX = 0;
	private static final byte Y_INDEX = 1;
	
	/**
	 * Updates the position of the Snake using the direction that it is 
	 * headed.
	 * 
	 * @param direction that the Snake is heading. Represented as 0 to 3.
	 */
	public void updatePosition(int direction) {
		// Create variables to store direction info.
		int xDir = 0;
		int yDir = 0;
		
		// Update the X and Y direction info.
		switch(direction) {
			case UP: // Up -Y direction.
				yDir = -1;
				break;
			case DOWN: // Down, +Y direction.
				yDir = 1;
				break;
			case LEFT: // Left, -X direction.
				xDir = -1;
				break;
			case RIGHT: // Right, +X direction.
				xDir = 1;
				break;
		}
		
		// Add to the head of the snake moving in the specified direction.
		snakePositionX.add(0, snakePositionX.get(0 + xDir));
		snakePositionY.add(0, snakePositionY.get(0) + yDir);
		
		// Update previous tail position to use if apple has been eaten.
		prevTailPos[X_INDEX] = snakePositionX.get(snakePositionX.size() - 1);
		prevTailPos[Y_INDEX] = snakePositionY.get(snakePositionY.size() - 1);
		
		// Remove the tail.
		snakePositionX.remove(snakePositionX.size() - 1);
		snakePositionY.remove(snakePositionY.size() - 1);
	}
	
	/**
	 * Adds to the tail of the Snake using the previous X and Y coordinates.
	 */
	public void eatApple() {
		// Add new tail X.
		snakePositionX.add(snakePositionX.size(), prevTailPos[X_INDEX]);
		
		// Add new tail Y.
		snakePositionX.add(snakePositionY.size(), prevTailPos[Y_INDEX]);
	}

	public ArrayList<Integer> getSnakePositionX() {
		return snakePositionX;
	}

	public ArrayList<Integer> getSnakePositionY() {
		return snakePositionY;
	}
	
}
