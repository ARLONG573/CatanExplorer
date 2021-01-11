package game.state;

import java.awt.Graphics;

import game.state.board.Board;
import game.state.player.Player;

/**
 * This class stores and applies changes to information related to some game
 * state. This class also contains methods that are used by the UI and MCTS
 * components to gather/render data.
 * 
 * @author Aaron Tetens
 */
public class State {

	private final Board board;
	private final Player[] players;
	// private final Deck deck; // refers to the dev card deck

	private int currentPlayerIndex;

	/**
	 * Creates a new game state
	 * 
	 * @param board
	 *            The current state of the board
	 * @param players
	 *            An array of the players in the game (in turn order)
	 * @param deck
	 *            The current state of the development card deck
	 * @param currentPlayerIndex
	 *            The index of the current player in the players array
	 */
	public State(final Board board, final Player[] players, /* final Deck deck, */final int currentPlayerIndex) {
		this.board = board;
		this.players = players;
		// this.deck = deck;

		this.setCurrentPlayerIndex(currentPlayerIndex);
	}

	/**
	 * @return A copy of this game state that can be modified without affecting this
	 *         one.
	 */
	public State copy() {

		// copy board
		final Board boardCopy = this.board.copy();

		// copy players
		final int numPlayers = this.getNumPlayers();
		final Player[] playersCopy = new Player[numPlayers];

		for (int i = 0; i < numPlayers; i++) {
			playersCopy[i] = this.players[i].copy();
		}

		// copy deck
		// final Deck deckCopy = this.deck.copy();

		return new State(boardCopy, playersCopy, /* deckCopy, */this.currentPlayerIndex);
	}

	/**
	 * Paints the current board state
	 * 
	 * @param g
	 *            The graphics context to paint the board state on
	 */
	public void paintBoard(final Graphics g) {
		this.board.paint(g);
	}

	/**
	 * Paints the current state of the players
	 * 
	 * @param g
	 *            The graphics context to paint the players on
	 */
	public void paintPlayers(final Graphics g) {
		final int numPlayers = this.getNumPlayers();

		for (int i = 0; i < numPlayers; i++) {
			players[i].paint(g, i * Player.PAINT_WIDTH);
		}
	}

	/**
	 * Paints the current state of the development card deck
	 * 
	 * @param g
	 *            The graphics context to paint the deck on
	 */
	public void paintDeck(final Graphics g) {
		// this.deck.paint(g);
	}

	/**
	 * @return The number of players in the game
	 */
	private int getNumPlayers() {
		return this.players.length;
	}

	/**
	 * Sets the index of the current player and updates all players within the game
	 * to reflect the change.
	 * 
	 * @param currentPlayerIndex
	 *            The index of the new current player
	 */
	private void setCurrentPlayerIndex(final int currentPlayerIndex) {
		this.currentPlayerIndex = currentPlayerIndex;

		for (int i = 0; i < this.players.length; i++) {
			this.players[i].isCurrentPlayer = (i == this.currentPlayerIndex);
		}
	}
}
