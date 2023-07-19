package swen221.chessview.pieces;

import swen221.chessview.*;

/**
 * Represents an arbitrary piece on the board.
 *
 * @author David J. Pearce
 *
 */
public interface Piece {
	/**
	 * Determine whether this piece is white or black.
	 *
	 * @return True if the piece is white.
	 */
	public boolean isWhite();

	/**
	 * Check whether or not a given move on a given board is valid. For takes,
	 * the piece being taken must be supplied.
	 *
	 * @param oldPosition
	 *            --- position of this piece before move.
	 * @param newPosition
	 *            --- position of this piece after move.
	 * @param isTaken
	 *            --- piece being taken, or null if no piece taken.
	 * @param board
	 *            --- board on which the validity of this move is being checked.
	 * @return True is the move is valid for this piece.
	 */
	public boolean isValidMove(Position oldPosition,
			Position newPosition, Piece isTaken, Board board);
}
