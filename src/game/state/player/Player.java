package game.state.player;

import java.awt.Graphics;

/**
 * This class stores and applies changes to information related to some player.
 * 
 * @author Aaron Tetens
 */
public class Player {

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
	 */
	public void paint(final Graphics g) {
		// TODO once member variables are implemented
	}
}
