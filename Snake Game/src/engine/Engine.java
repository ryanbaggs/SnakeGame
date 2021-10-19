package engine;

import window.WindowEvents;

public class Engine extends Thread{
	
	private static boolean running;
	
	/**
	 * Starts the game Engine Thread.
	 */
	@Override
	public synchronized void start() {
		super.start();
		
		// Set running.
		running = true;
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
