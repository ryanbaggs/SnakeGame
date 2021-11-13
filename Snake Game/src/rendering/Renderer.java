/**
 * 
 */
package rendering;

import java.awt.Graphics;

import engine.Engine;
import engine.EngineEvents;
import objects.World;

/**
 * Renders game objects to the JPanel. This runs on the Window thread and is 
 * instantiated in the GamePanel class.
 * 
 * @author Ryan Baggs
 * @date Nov 9, 2021
 */
public class Renderer {
	
	// Screen size.
	
	public Renderer() {
		
	}
	
	/**
	 * Draws the game objects to the JPanel.
	 * 
	 * @param g
	 * @param GAME_STATE
	 */
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
		// Draw snake.
		for(int i = 0; i < EngineEvents.getSnakeXLocation().size(); i++)
			g.fillRect(EngineEvents.getSnakeXLocation().get(i), 
					EngineEvents.getSnakeYLocation().get(i), 
					World.BLOCK_SIZE, World.BLOCK_SIZE);
		
		// Draw apple.
		g.fillRect(EngineEvents.getAppleX(), EngineEvents.getAppleY(), 
				World.BLOCK_SIZE, World.BLOCK_SIZE);
		
		// Draw current score.
		g.drawString("Score: " + Long.toString(EngineEvents.getScore()), 20, 20);
	}
	
	public void drawGameOver(Graphics g) {
		g.drawString("Game Over", 20, 20);
	}
	
	public void drawReset(Graphics g) {
		g.drawString("Game is reset", 20, 20);
	}
	
	public void drawMessage(Graphics g, String message) {
		
	}

}
