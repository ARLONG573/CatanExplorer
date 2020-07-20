package game.state.player;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class stores and applies changes to information related to some player.
 * 
 * @author Aaron Tetens
 */
public class Player {

	/**
	 * How much horizontal space it takes to paint a player
	 */
	public static final int PAINT_WIDTH = 225;

	/**
	 * How much vertical space it takes to paint a player
	 */
	public static final int PAINT_HEIGHT = 200;

	// UI variables - consider refactoring if additional member variables make these
	// variables redundant
	private final String name;
	private final boolean isAIPlayer;
	private boolean isCurrentPlayer;
	private int numResources;
	private int numDevCards;
	private int longestRoadSegment;
	private int numKnightsPlayed;
	private boolean hasLongestRoad;
	private boolean hasLargestArmy;
	private int visibleVP;

	public Player(final String name, final boolean isAIPlayer) {
		this.name = name;
		this.isAIPlayer = isAIPlayer;
		this.isCurrentPlayer = false;
		this.numResources = 0;
		this.numDevCards = 0;
		this.longestRoadSegment = 0;
		this.numKnightsPlayed = 0;
		this.hasLongestRoad = false;
		this.hasLargestArmy = false;
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
		// TODO this is a placeholder until member variables are implemented
		final Color color;

		switch (xOffset) {
		case 0 * PAINT_WIDTH:
			color = Color.RED;
			break;
		case 1 * PAINT_WIDTH:
			color = Color.WHITE;
			break;
		case 2 * PAINT_WIDTH:
			color = Color.BLUE;
			break;
		case 3 * PAINT_WIDTH:
			color = Color.ORANGE;
			break;
		default:
			color = Color.BLACK;
			break;
		}

		g.setColor(color);
		g.fillRect(xOffset, 0, PAINT_WIDTH, PAINT_HEIGHT);
	}
}
