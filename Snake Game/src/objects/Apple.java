package objects;

import java.util.Random;

/**
 * Represents the Snake Game apple.
 *
 * @author Ryan Baggs
 * @date Oct 19, 2021
 */
public class Apple {
	// In game x and y.
	private int x = 0;
	private int y = 0;
	
	// Random number generator.
	Random random = new Random();
	
	public Apple() {
		// Initialize the new Apple coordinates upon creation.
		update();
	}
	
	/**
	 * Update the Apple location by generating random coordinates within the 
	 * World Coordinates.
	 */
	public void update() {
		x = random.nextInt(World.END);
		y = random.nextInt(World.BOTTOM);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
