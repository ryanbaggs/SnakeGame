package input;

import java.awt.event.*;

import engine.Engine;
import engine.EngineEvents;

/**
 * 
 *
 * @author Ryan Baggs
 * @date Oct 18, 2021
 */
public class Input implements KeyListener{
	
	// FLags for the W, S, A, and D keys on the keyboard. 
	private static boolean up = false, down = false, left = false, right = false, play = false;
	
	@Override
	public void keyTyped(KeyEvent e) {
		updateFlags(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	/**
	 * Update the flags for up, down, left, and right based on what key is 
	 * typed. Update play flag based on game state and space pressed.
	 * 
	 * @param e The KeyEvent that occurred.
	 */
	void updateFlags(KeyEvent e) {
		switch(e.getID()) {
			case KeyEvent.VK_W:
				up = true;
				down = false;
				left = false;
				right = false;
				break;
			case KeyEvent.VK_S:
				up = false;
				down = true;
				left = false;
				right = false;
				break;
			case KeyEvent.VK_A:
				up = false;
				down = false;
				left = true;
				right = false;
				break;
			case KeyEvent.VK_D:
				up = false;
				down = false;
				left = false;
				right = true;
				break;
			case KeyEvent.VK_SPACE:
				play = true;
				break;
		}
		
		// Check game state, before updating play.
		if(EngineEvents.getGameState() == Engine.GAME_OVER 
				|| EngineEvents.getGameState() == Engine.RESET) {
			// If space bar pressed, update play.
			if(e.getID() == KeyEvent.VK_SPACE)
				play = true;
		}
	}

	static boolean isUp() {
		return up;
	}

	static boolean isDown() {
		return down;
	}

	static boolean isLeft() {
		return left;
	}

	static boolean isRight() {
		return right;
	}
	
	static boolean getPlay() {
		if(play) {
			play = false;
			return true;
		} else
			return play;
	}
	
}
