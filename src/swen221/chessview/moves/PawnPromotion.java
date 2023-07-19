package swen221.chessview.moves;

import swen221.chessview.*;
import swen221.chessview.pieces.*;

/**
 * This represents a "check move". Note that, a check move can only be made up
 * from an underlying simple move; that is, we can't check a check move.
 *
 * @author David J. Pearce
 *
 */
public class PawnPromotion implements MultiPieceMove {
	private Piece promotion;
	private SinglePieceMove move;

	/**
	 * Construct a new pawn promotion move.
	 *
	 * @param move      The underlying move which lead to a pawn promotion.
	 * @param promotion The piece to which the pawn is promoted.
	 */
	public PawnPromotion(SinglePieceMove move, Piece promotion) {
		this.promotion = promotion;
		this.move = move;
	}

	@Override
	public boolean isWhite() {
		return move.isWhite();
	}

	@Override
	public boolean isValid(Board board) {
		this.toString();
		int finalRow = this.isWhite() ? 8 : 1;
		return (move.isValid(board)) 
				&& (move.piece() instanceof Pawn) 
				&& (move.newPosition.row() == finalRow) 
				&& (!(promotion instanceof King));
	}

	@Override
	public void apply(Board board) {
		Piece piece = board.pieceAt(move.oldPosition());
		move.apply(board);
		board.setPieceAt(move.newPosition(), promotion);
	}

	@Override
	public String toString() {
		return super.toString() + "=" + SinglePieceMove.pieceChar(promotion);
	}
}
