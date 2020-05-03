package startup.board.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * This is the frame that holds all of the UI components necessary for
 * initializing the board.
 * 
 * @author Aaron Tetens
 */
public class StartupBoardFrame extends JFrame {

	private static final long serialVersionUID = -6828179314114088769L;

	private static StartupBoardFrame theInstance;

	private StartupBoardFrame() {
		super.setLayout(new BorderLayout());
		super.add(BoardEditor.getInstance(), BorderLayout.CENTER);
		super.add(BoardToolbar.getInstance(), BorderLayout.EAST);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.pack();
	}

	/**
	 * @return The StartupBoardFrame instance
	 */
	public static StartupBoardFrame getInstance() {
		if (theInstance == null) {
			theInstance = new StartupBoardFrame();
		}

		return theInstance;
	}
}
