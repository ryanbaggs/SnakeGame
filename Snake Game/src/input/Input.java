package input;

import java.awt.event.*;

/**
 * 
 *
 * @author Ryan Baggs
 * @date Oct 18, 2021
 */
public class Input implements KeyListener{
	
	// FLags for the W, S, A, and D keys on the keyboard. 
	private static boolean up = false, down = false, left = false, right = false;
	
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
	 * Update the flags for up, down, left, and right based on what key is typed.
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
	
}
