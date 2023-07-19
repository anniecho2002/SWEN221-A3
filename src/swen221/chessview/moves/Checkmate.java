package swen221.chessview.moves;

import swen221.chessview.*;

/**
 * This represents a "check mate".
 * Check mate is when the king can be captured regardless of where it moves to.
 *
 */

public class Checkmate implements Move {
	private MultiPieceMove move;

	public Checkmate(MultiPieceMove move) {
		this.move = move;
	}

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
			
			if(copy.isInCheck(!isWhite())){
				if(copy.isCheckmate(!isWhite())){
					return true;
				}
			}else{
				return false;
			}
		}
		return false;
	} 

	@Override
	public void apply(Board board) {
		move.apply(board);
	}

	@Override
	public String toString() {
		return this.move().toString() + "#";
	}
} 
