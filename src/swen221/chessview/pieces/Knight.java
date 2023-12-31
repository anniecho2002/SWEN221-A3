package swen221.chessview.pieces;

import swen221.chessview.*;

/**
 * Represents a knight on the board.
 *
 * @author David J. Pearce
 *
 */
public class Knight extends PieceImpl implements Piece {
	/**
	 * Construct a new knight.
	 *
	 * @param isWhite True if the knight is white.
	 */
	public Knight(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public boolean isValidMove(Position oldPosition, Position newPosition, Piece isTaken, Board board) {
		int diffCol = Math.max(oldPosition.column(), newPosition.column())
				- Math.min(oldPosition.column(), newPosition.column());
		int diffRow = Math.max(oldPosition.row(), newPosition.row())
				- Math.min(oldPosition.row(), newPosition.row());
		Piece p = board.pieceAt(oldPosition);
		Piece t = board.pieceAt(newPosition);
		
		return this.equals(p)
				&& (t == isTaken || (isTaken != null && isTaken.equals(t)))
				&& ((diffCol == 2 && diffRow == 1) || (diffCol == 1 && diffRow == 2));
	}

	@Override
	public String toString() {
		if(isWhite) {
			return "N";
		} else {
			return "n";
		}
	}
}
