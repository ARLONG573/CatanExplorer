package game.state.player;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * This class stores and applies changes to information related to some player.
 * 
 * @author Aaron Tetens
 */
public class Player {

	// TODO make this class abstract, implement subclasses HumanPlayer and AIPlayer

	/**
	 * How much horizontal space it takes to paint a player
	 */
	public static final int PAINT_WIDTH = 225;

	/**
	 * How much vertical space it takes to paint a player
	 */
	public static final int PAINT_HEIGHT = 200;

	private static final int BORDER_WIDTH = 10;
	private static final int TEXT_PADDING = 20;

	private static final Font STATUS_FONT = new Font("Arial", Font.PLAIN, 20);

	private static final String NEW_LINE = System.lineSeparator();

	// UI variables - consider refactoring if additional member variables make these
	// variables redundant
	private final String name;
	private final Color color;
	private final boolean isAIPlayer;
	public boolean isCurrentPlayer;
	private int numResources;
	private int numDevCards;
	private int longestRoadSegment;
	private int numKnightsPlayed;
	private int visibleVP;

	public Player(final String name, final Color color, final boolean isAIPlayer) {
		this.name = name;
		this.color = color;
		this.isAIPlayer = isAIPlayer;
		this.isCurrentPlayer = false;
		this.numResources = 0;
		this.numDevCards = 0;
		this.longestRoadSegment = 0;
		this.numKnightsPlayed = 0;
		this.visibleVP = 0;
	}

	/**
	 * @return A copy of this player that can be modified without affecting this one
	 */
	public Player copy() {
		// TODO once member variables are implemented
		return null;
	}

	/**
	 * Paints the current state of this player
	 * 
	 * @param g
	 *            The graphics context to paint this board on
	 * @param xOffset
	 *            How far over to start painting the player - this value will always
	 *            be (k * PAINT_WIDTH), where k is in the range [0, numPlayers)
	 */
	public void paint(final Graphics g, final int xOffset) {
		// background color for a player is same as their piece color
		g.setColor(this.color);
		g.fillRect(xOffset, 0, PAINT_WIDTH, PAINT_HEIGHT);

		// if this player is the current player, give them black border by drawing
		// BORDER_WIDTH concentric rectangles
		if (this.isCurrentPlayer) {
			g.setColor(Color.BLACK);

			for (int i = 0; i < BORDER_WIDTH; i++) {
				g.drawRect(xOffset + i, i, PAINT_WIDTH - 2 * i, PAINT_HEIGHT - 2 * i);
			}
		}

		// display data - it will look like the example below
		// [name] (AI)
		// Resource Cards: [numResources]
		// Development Cards: [numDevCards]
		// Road Progress: [longestRoadSegment]
		// Army Progress: [numKnightsPlayed]
		// VP: [visibleVP]
		final StringBuilder nameBuilder = new StringBuilder();
		nameBuilder.append(this.name);
		if (this.isAIPlayer) {
			nameBuilder.append(" (AI)");
		}

		g.setColor(Color.BLACK);
		g.setFont(STATUS_FONT);
		g.drawString(nameBuilder.toString(), xOffset + BORDER_WIDTH, BORDER_WIDTH + TEXT_PADDING);
		g.drawString("Resource Cards: " + this.numResources + NEW_LINE, xOffset + BORDER_WIDTH,
				BORDER_WIDTH + 3 * TEXT_PADDING);
		g.drawString("Development Cards: " + this.numDevCards + NEW_LINE, xOffset + BORDER_WIDTH,
				BORDER_WIDTH + 4 * TEXT_PADDING);
		g.drawString("Road Progress: " + this.longestRoadSegment + NEW_LINE, xOffset + BORDER_WIDTH,
				BORDER_WIDTH + 5 * TEXT_PADDING);
		g.drawString("Army Progress: " + this.numKnightsPlayed + NEW_LINE, xOffset + BORDER_WIDTH,
				BORDER_WIDTH + 6 * TEXT_PADDING);
		g.drawString("VP: " + this.visibleVP, xOffset + BORDER_WIDTH, BORDER_WIDTH + 7 * TEXT_PADDING);
	}
}
