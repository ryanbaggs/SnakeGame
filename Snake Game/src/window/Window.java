/**
 * 
 */
package window;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Ryan Baggs
 * @date Oct 18, 2021
 */
public class Window extends JFrame {
	
	// Game title.
	private static final String TITLE = "Snake Game";
	
	// Game version.
	private static final String VERSION = "V: 0.1.3";
	
	private static final long serialVersionUID = -9035835475837563194L;
	private static final boolean VISIBLE = true, FOCUSABLE = true;
	public static final int HEIGHT = 400, WIDTH = 800;
	
	private static boolean windowClosed;
	
	public Window() {
		show();
	}

	public void show() {
		// Create new JFrame with title Snake Game.
		JFrame frame = new JFrame(TITLE + " " + VERSION);
		
		// Set the windowClosed flag for the engine.
		windowClosed = false;
		
		// What happens when JFrame closes.
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Enable Focus for the JFrame.
		frame.setFocusable(FOCUSABLE);
		
		// Add the GamePanel to the JFrame.
		frame.add(new GamePanel());
		
		// Pack the frame around the GamePanel.
		frame.pack();
		
		// Center the JFrame.
		frame.setLocationRelativeTo(null);
		
		// Show the JFrame.
		frame.setVisible(VISIBLE);
	}

	@Override
	protected void processWindowEvent(WindowEvent e) {
		// TODO Auto-generated method stub
		super.processWindowEvent(e);
		
		if(e.getID() == WindowEvent.WINDOW_CLOSING) {
			// Flag Engine to stop running.
			windowClosed = true;
		}
	}
	
	static boolean isWindowClosed() {
		return windowClosed;
	}
	
	class GamePanel extends JPanel {
		
		private static final long serialVersionUID = 5489194219606210773L;
		
		public GamePanel() {
			setBackground(Color.black);
		}
		
		/**
		 * This will allow the GamePanel to determine its size rather than the 
		 * JFrame.
		 */
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(Window.WIDTH, Window.HEIGHT);
		}

		/**
		 * Paint within the GamePanel.
		 */
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			// Draw things.
			g.drawString("This is my custom Panel!",10,20);
		}
		
		
	}

}
