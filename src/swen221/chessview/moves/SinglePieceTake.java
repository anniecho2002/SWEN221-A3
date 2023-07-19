package swen221.chessview.moves;

import swen221.chessview.*;
import swen221.chessview.pieces.Piece;

/**
 * Represents a single piece move which results in another piece being taken.
 *
 * @author David J. Pearce
 *
 */
public class SinglePieceTake extends SinglePieceMove {
	private Piece isTaken;

	/**
	 * Construct a new single piece take move.
	 *
	 * @param piece       The piece being moved.
	 * @param isTaken     The piece being taken.
	 * @param oldPosition The starting position of the piece being moved.
	 * @param newPosition The ending position of the piece being moved.
	 */
	public SinglePieceTake(Piece piece, Piece isTaken, Position oldPosition, Position newPosition) {
		super(piece, oldPosition, newPosition);
		this.isTaken = isTaken;
	}

	@Override
	public boolean isValid(Board board) {
		return piece.isValidMove(oldPosition, newPosition, isTaken, board);
		
	}

	@Override
	public String toString() {
		return pieceChar(piece) + oldPosition + "x" + pieceChar(isTaken) + newPosition;
	}
}
