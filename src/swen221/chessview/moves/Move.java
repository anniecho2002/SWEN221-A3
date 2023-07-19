package swen221.chessview.moves;

import swen221.chessview.*;

/**
 * A move is any move which is permitted by either the white or black player.
 * This includes simple moves (where pieces just take on new positions), take
 * moves (where a piece is taken as well), and check moves (where the opponent
 * is put into check)
 *
 * @author David J. Pearce
 *
 */
public interface Move {
	/**
	 * Check whether this move is valid or not.
	 *
	 * @param board The board state on which this move is being validated.
	 * @return True if the move can be applied on this board.
	 */
	public boolean isValid(Board board);

	/**
	 * Update the board to reflect the board after the move is played.
	 *
	 * @param board The board state on which this move is to be applied.
	 */
	public void apply(Board board);

	/**
	 * Is this move for white or black?
	 *
	 * @return True if this move is for white.s
	 */
	public boolean isWhite();
}
