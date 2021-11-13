package engine;

import java.util.ArrayList;

import input.InputEvents;
import objects.Apple;
import objects.Snake;
import window.WindowEvents;

/**
 * 
 *
 * @author Ryan Baggs
 * @date Oct 18, 2021
 */
public class Engine extends Thread{
	
	// Engine thread running.
	private static boolean running;
	
	// Game update variables.
	// Updates per second.
	private static final long ups = 5l;
	// Milliseconds per update.
	private static final long mspu = 1000 / ups;
	// Initialize the start time for the first update.
	private static long startTime = System.currentTimeMillis();
	// End time for the update.
	private static long endTime;
	// Time elapsed during the update.
	private static long delta;
	
	// Game States.
	// Current game state.
	static volatile byte gameState;
	// User is actively playing.
	public static final byte PLAYING = 0;
	// Game is over.
	public static final byte GAME_OVER = 1;
	// Game is reset, waiting for player to play.
	public static final byte RESET = 2;
	// Apple is eaten.
	public static final byte APPLE_EATEN = 3;
	// User opted to end game.
	public static final byte END_GAME = 4;
	
	// Game objects.
	private static Snake snake;
	private static Apple apple;
	
	// Collision detection.
	private Collision collision;
	
	// Score.
	private static long score;
	
	/**
	 * Starts the game Engine thread.
	 */
	@Override
	public synchronized void start() {
		super.start();
		
		// Set running.
		running = true;
		
		// Set the game state to request user to play.
		gameState = RESET;
		
		// Initialize objects.
		snake = new Snake();
		apple = new Apple();
		collision = new Collision();
		
		// Initialize the score.
		score = 0;
	}

	/**
	 * Own separate Thread ran from here. The Engine loop for updating in 
	 * game items. Add game updates to the updateGame method.
	 */
	@Override
	public void run() {
		super.run();
		
		// Game Engine loop.
		while(running) {
			
			endTime = System.currentTimeMillis();
			
			delta = endTime - startTime;
			
			if(delta < mspu) {
				// Wait before beginning next update.
				try {
					Thread.sleep(mspu - delta);
				} catch (InterruptedException e) {
					// Error attempting to sleep Engine thread.
					e.printStackTrace();
				}
			}
			
			// Set the updates per second to 5 per second.
			startTime = System.currentTimeMillis();
			
			// Update stuff.
			updateGame();
			
			// Check if Window is closed.
			if(WindowEvents.isWindowClosed()) {
				// Stop the run loop.
				running = false;
			}
		}
		
		// Terminate the Engine Thread.
		stopThread();
	}
	
	/**
	 * Where all game updates occur.
	 */
	private void updateGame() {
		switch(gameState) {
			case PLAYING:
				playGame();
				break;
			case GAME_OVER:
				gameOver();
				break;
			case RESET:
				resetGame();
				break;
			case APPLE_EATEN:
				updateScore();
			case END_GAME:
				endGame();
		}
	}
	
	private void playGame() {
		updateSnakeLocation();
		checkCollision();
	}
	
	/**
	 * Updates the snake locations based off the InputEvents flags.
	 */
	private void updateSnakeLocation() {
		if(InputEvents.isUp()) {
			// Move up.
			snake.updatePosition(Snake.UP);
		} else if(InputEvents.isDown()) {
			// Move down.
			snake.updatePosition(Snake.DOWN);
		} else if(InputEvents.isLeft()) {
			// Move left.
			snake.updatePosition(Snake.LEFT);
		} else if(InputEvents.isRight()) {
			// Move right.
			snake.updatePosition(Snake.RIGHT);
		} else {
			// No flags set, move up.
			snake.updatePosition(Snake.UP);
		}
	}
	
	/**
	 * Checks if any collision events have occurred.
	 */
	private void checkCollision() {
		if(collision.appleCollision(apple.getX(), apple.getY(), 
				snake.getSnakePositionX().get(Snake.HEAD_INDEX), 
				snake.getSnakePositionY().get(Snake.HEAD_INDEX))) {
			gameState = APPLE_EATEN;
		}
		
		if(collision.worldCollision(snake.getSnakePositionX().get(Snake.HEAD_INDEX), 
				snake.getSnakePositionY().get(Snake.HEAD_INDEX))) {
			// World collision.
			gameState = GAME_OVER;
		}
		
		if(collision.snakeCollision(snake.getSnakePositionX(), 
				snake.getSnakePositionY())) {
			// Snake collision.
			gameState = GAME_OVER;
		}
	}
	
	/**
	 * Checks if the user has opted to play.
	 * 
	 * @return if the user opted to play.
	 */
	private boolean checkPlaying() {
		return InputEvents.getPlay();
	}
	
	private void gameOver() {
		// Display final score and options.
		
		// Pause game and wait for user input.
		
		// Reset or end game.
	}
	
	private void resetGame() {
		// TODO: Reset game.
	}
	
	private void endGame() {
		// TODO: End game.
		
		// Save high score.
		
		// Close window.
		
		// Stop the game engine.
		running = false;
	}
	
	/**
	 * Updates the current game score.
	 */
	private void updateScore() {
		// Increase score by 50 points.
		score += 50l;
	}

	/**
	 * Ends the execution of this thread. This properly terminates the thread 
	 * when no longer needed.
	 */
	private void stopThread() {
		try {
			this.join();
		} catch (InterruptedException e) {
			// Error occurred in trying to terminate thread.
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Integer> getSnakeXLocation() {
		return snake.getSnakePositionX();
	}
	
	public static ArrayList<Integer> getSnakeYLocation() {
		return snake.getSnakePositionY();
	}
	
	public static int getAppleX() {
		return apple.getX();
	}
	
	public static int getAppleY() {
		return apple.getY();
	}

	public static long getScore() {
		return score;
	}
	
}
