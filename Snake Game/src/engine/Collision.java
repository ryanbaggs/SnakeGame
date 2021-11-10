package engine;

import java.util.ArrayList;

import objects.World;

/**
 * Checks each game object to see if they have collided with the Snake.
 *
 * @author Ryan Baggs
 * @date Oct 18, 2021
 */
public class Collision {
	
	/**
	 * This checks to see if the Snake has collided with the Apple, eating it.
	 * 
	 * @param appleX Apple x coordinate.
	 * @param appleY Apple y coordinate.
	 * @param headX Snake head x coordinate.
	 * @param headY Snake head y coordinate.
	 * @return true if the snake has collided with the apple and false if not.
	 */
	public boolean appleCollision(int appleX, int appleY, int headX, 
			int headY) {
		// Check if the Snake head coordinates and the Apple coordinates are 
		// the same.
		if(appleX == headX && appleY == headY)
			// Snake has collided with the apple.
			return true;
		
		return false;
	}
	
	/**
	 * This checks for collision between the Snake head and the World edges.
	 * 
	 * @param headX Snake head x coordinate.
	 * @param headY Snake head y coordinate.
	 * @return true if the Snake head has collided with any of the World 
	 * edges.
	 */
	public boolean worldCollision(int headX, int headY) {
		// Check each side of the World to see if the snake head collided 
		// with it.
		if(headY == World.TOP || headY == World.BOTTOM ||headX == World.START 
				|| headX == World.END)
			// Collided with World edges.
			return true;
		
		return false;
	}
	
	/**
	 * This checks if the Snake head has collided with the rest of itself.
	 * 
	 * @param snakeX all x values of the snake body parts.
	 * @param snakeY all y values of the snake body parts.
	 * @return true if the snake head has collided with any part of itself.
	 */
	public boolean snakeCollision(ArrayList<Integer> snakeX, 
			ArrayList<Integer> snakeY) {
		// Check each part of the Snake after the head to see if the head has 
		// collided with itself.
		for(int i = 1; i < snakeX.size(); i++) {
			if(snakeX.get(0) == snakeX.get(i) 
					&& snakeY.get(0) == snakeY.get(i))
				return true;
		}
		return false;
	}

}
