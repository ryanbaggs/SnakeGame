package engine;

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
	 * @param appleX
	 * @param appleY
	 * @param headX
	 * @param headY
	 * @return true if the snake has collided with the apple and false if not.
	 */
	public boolean appleCollision(int appleX, int appleY, int headX, 
			int headY) {
		// Check if the Snake head coordinates and the Apple coordinates are 
		// the same.
		if(appleX == headX && appleY == headY) {
			// Snake has collided with the apple.
			return true;
		}
		return false;
	}
	
	public boolean worldCollision() {
		return true;
	}
	
	public boolean snakeCollision() {
		return true;
	}

}
