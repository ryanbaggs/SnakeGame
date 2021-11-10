/**
 * 
 */
package rendering;

import java.awt.Graphics;

import engine.Engine;

/**
 * Renders game objects to the JPanel. This runs on the Window thread and is 
 * instantiated in the GamePanel class.
 * 
 * @author Ryan Baggs
 * @date Nov 9, 2021
 */
public class Renderer {
	
	public Renderer() {
		
	}
	
	public void draw(Graphics g, int GAME_STATE) {
		
		switch(GAME_STATE) {
			case Engine.PLAYING:
				// Draw game.
				drawGame(g);
				break;
			case Engine.GAME_OVER:
				drawGameOver(g);
				break;
			case Engine.RESET:
				drawReset(g);
				break;
			default:
				drawMessage(g, "Game Not Ready");
				break;
		}
		
	}
	
	public void drawGame(Graphics g) {
		g.drawString("Game is playing", 20, 20);
	}
	
	public void drawGameOver(Graphics g) {
		g.drawString("Game is Over", 20, 20);
	}
	
	public void drawReset(Graphics g) {
		g.drawString("Game is reset", 20, 20);
	}
	
	public void drawMessage(Graphics g, String message) {
		
	}

}
