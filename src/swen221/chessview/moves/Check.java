package swen221.chessview.moves;

import swen221.chessview.*;

/**
 * This represents a "check move". Note that, a check move can only be made up
 * from an underlying simple move; that is, we can't check a check move.
 *
 * @author David J. Pearce
 *
 */
public class Check implements Move {
	private MultiPieceMove move;

	/**
	 * Create a new check move.
	 *
	 * @param move The move onto which check is being added.
	 */
	public Check(MultiPieceMove move) {
		this.move = move;
	}

	/**
	 * Get the move underlying this check move.
	 *
	 * @return The move.
	 */
	public MultiPieceMove move() {
		return move;
	}

	@Override
	public boolean isWhite() {
		return move.isWhite();
	}

	@Override
	public boolean isValid(Board board) {
		if (move.isValid(board)) {
			Board copy = new Board(board);
			copy.apply(move);
			return(copy.isInCheck(!isWhite()));
		}
		else{
			return false;
		}
	}

	@Override
	public void apply(Board board) {
		move.apply(board);
	}

	@Override
	public String toString() {
		return this.move().toString() + "+";
	}
}
