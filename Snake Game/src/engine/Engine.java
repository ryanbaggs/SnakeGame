package engine;

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
	
	// Game objects.
	private Snake snake;
	private Apple apple;
	
	// Collision detection.
	private Collision collision;
	
	/**
	 * Starts the game Engine thread.
	 */
	@Override
	public synchronized void start() {
		super.start();
		
		// Set running.
		running = true;
		
		// Initialize objects.
		snake = new Snake();
		apple = new Apple();
		collision = new Collision();
	}

	/**
	 * Own separate Thread ran from here. The Engine loop for updating in 
	 * game items. Add game updates to the updateGame method.
	 */
	@Override
	public void run() {
		super.run();
		
		// Game Engine loop.
		do {
			
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
		} while(running);
		
		// Terminate the Engine Thread.
		stopThread();
	}
	
	/**
	 * Where all game updates occur.
	 */
	private void updateGame() {
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
		}
		if(InputEvents.isDown()) {
			// Move down.
			snake.updatePosition(Snake.DOWN);
		}
		if(InputEvents.isLeft()) {
			// Move left.
			snake.updatePosition(Snake.LEFT);
		}
		if(InputEvents.isRight()) {
			// Move right.
			snake.updatePosition(Snake.RIGHT);
		}
	}
	
	/**
	 * Checks if any collision events have occurred.
	 */
	private void checkCollision() {
		if(collision.appleCollision(apple.getX(), apple.getY(), 
				snake.getSnakePositionX().get(Snake.HEAD_INDEX), 
				snake.getSnakePositionY().get(Snake.HEAD_INDEX))) {
			// Apple collision, update apple location.
			apple.update();
			
			//TODO: Update score;
			
		}
		
		if(collision.worldCollision(snake.getSnakePositionX().get(Snake.HEAD_INDEX), 
				snake.getSnakePositionY().get(Snake.HEAD_INDEX))) {
			//TODO: World collision.
			gameOver();
		}
		
		if(collision.snakeCollision(snake.getSnakePositionX(), 
				snake.getSnakePositionY())) {
			// Snake collision.
			gameOver();
		}
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
	
}
