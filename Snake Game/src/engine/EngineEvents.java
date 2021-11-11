package engine;

import java.util.ArrayList;

/**
 * 
 *
 * @author Ryan Baggs
 * @date Nov 9, 2021
 */
public class EngineEvents {

	public static int getGameState() {
		return Engine.gameState;
	}
	
	public static ArrayList<Integer> getSnakeXLocation() {
		return Engine.getSnakeXLocation();
	}
	
	public static ArrayList<Integer> getSnakeYLocation() {
		return Engine.getSnakeYLocation();
	}
	
	public static int getAppleX() {
		return Engine.getAppleX();
	}
	
	public static int getAppleY() {
		return Engine.getAppleX();
	}
	
	public static long getScore() {
		return Engine.getScore();
	}
}
