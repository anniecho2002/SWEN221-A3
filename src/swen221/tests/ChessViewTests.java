package swen221.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.Test;

import swen221.chessview.Board;
import swen221.chessview.ChessGame;
import swen221.chessview.pieces.Bishop;
import swen221.chessview.pieces.King;
import swen221.chessview.pieces.Knight;
import swen221.chessview.pieces.Pawn;
import swen221.chessview.pieces.Queen;
import swen221.chessview.pieces.Rook;
import swen221.chessview.ChessGame;
import swen221.chessview.Position;
import swen221.chessview.Round;
import swen221.chessview.moves.Move;

public class ChessViewTests {

	// ================================================
	// Valid Tests (Pawn)
	// ================================================

	@Test public void testPawnValid_01() {
		String input =
			"a2-a3\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|P|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 * Valid white and black move (pawn)
	 */
	@Test public void testPawnValid_02() {
		String input =
			"a2-a3 b7-b6\n";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|_|p|p|p|p|p|p|\n" +
			"6|_|p|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|P|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 * Checks that white pawn can move forward two places
	 */
	@Test public void testPawnValid_03() {
		String input =
			"a2-a4\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|P|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 * Checks that black pawn can move forward two places
	 */
	@Test public void testPawnValid_04() {
		String input =
			"Nb1-c3 c7-c5\n";
		
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|_|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|p|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|N|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|_|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 * White pawn captures black pawn
	 */
	@Test public void testPawnValid_05() {
		String input =
			"a2-a4 b7-b5\n"
			+ "a4xb5\n";
		
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|_|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|P|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 * Black pawn captures white pawn
	 */
	@Test public void testPawnValid_06() {
		String input =
			"a2-a4 b7-b5\n"
			+ "e2-e3 b5xa4\n";
		
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|_|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|p|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|P|_|_|_|\n" +
			"2|_|P|P|P|_|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";
		
		check(input,output);
	}
	
	
	/**
	 * Moving all the pawns
	 */
	@Test public void testPawnValid_07() {
		String input =
			"a2-a4 a7-a5\n"+ "b2-b4 b7-b5\n"+ "c2-c4 c7-c5\n"+ "d2-d4 d7-d5\n"+
			"e2-e4 e7-e5\n"+ "f2-f4 f7-f5\n"+ "g2-g4 g7-g5\n"+ "h2-h4 h7-h5\n"+
			"\n"+
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|_|_|_|_|_|_|_|_|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|p|p|p|p|p|p|p|p|\n" +
			"4|P|P|P|P|P|P|P|P|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|_|_|_|_|_|_|_|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";
		
		check(input,output);
	}
	
	
	/**
	 * Pawn captures a non-pawn piece
	 */
	@Test public void testPawnValid_08() {
		String input =
			"a2-a3 e7-e5\n"
			+ "h2-h3 Bf8-b4\n"
			+ "a3xBb4\n";
		
		String output =
			"8|r|n|b|q|k|_|n|r|\n" +
			"7|p|p|p|p|_|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|p|_|_|_|\n" +
			"4|_|P|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|P|\n" +
			"2|_|P|P|P|P|P|P|_|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";
		
		check(input,output);
	}
	
	
	
	
	/**
	 * Check boundaries of the board
	 */
	@Test public void testPawnInvalid_01() {
		String input =
			"a2-a9 b7-b0\n"
			+ "i2-i3\n";
		
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";
		
		check(input,output);
	}
	
	/**
	 * Checks that white can not move a black piece 
	 */
	@Test public void testPawnInvalid_02() {
		String input =
			"a7-a6\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 * Checks that black can not move a white piece (white cannot move twice)
	 */
	@Test public void testPawnInvalid_03() {
		String input =
			"a2-a3\n" +
			"h2-h3\n";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|P|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 * Checks invalid row (moving pawn three places)
	 */
	@Test public void testPawnInvalid_04() {
		String input =
			"a2-a5\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Checks invalid placement (moving backwards)
	 */
	@Test public void testPawnInvalid_05() {
		String input =
			"a2-a1\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 * Checks invalid placement (moving sideways)
	 */
	@Test public void testPawnInvalid_06() {
		String input =
			"a2-a3 a7-a6\n"
			+ "a3-b3\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|_|p|p|p|p|p|p|p|\n" +
			"6|p|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|P|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 * Checks invalid placement (moving diagonal without killing)
	 */
	@Test public void testPawnInvalid_07() {
		String input =
			"a2-b3\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 * Stepping where there is a piece
	 */
	@Test public void testPawnInvalid_08() {
		String input =
			"a2-a3 a7-a5\n"
			+ "b2-b3 Ra8-a6\n"
			+ "c2-c3 Ra6-b6\n"
			+ "d2-d3 b7-b6\n" +
			"";
		String output =
			"8|_|n|b|q|k|b|n|r|\n" +
			"7|_|p|p|p|p|p|p|p|\n" +
			"6|_|r|_|_|_|_|_|_|\n" +
			"5|p|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|P|P|P|P|_|_|_|_|\n" +
			"2|_|_|_|_|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 * Double Stepping where there is a piece
	 */
	@Test public void testPawnInvalid_09() {
		String input =
			"a2-a3 a7-a5\n"
			+ "b2-b3 Ra8-a6\n"
			+ "c2-c3 Ra6-b6\n"
			+ "d2-d3 Rb6-b5\n"
			+ "e2-e3 b7-b5\n" +
			"";
		String output =
			"8|_|n|b|q|k|b|n|r|\n" +
			"7|_|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|p|r|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|P|P|P|P|P|_|_|_|\n" +
			"2|_|_|_|_|_|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 * Can't capture vertically
	 */
	@Test public void testPawnInvalid_10() {
		String input =
			"a2-a4 a7-a5\n"
			+ "a4xa5\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|_|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|p|_|_|_|_|_|_|_|\n" +
			"4|P|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 * Can't capture same color
	 */
	@Test public void testPawnInvalid_11() {
		String input =
			"a2-a3 a7-a5\n"
			+ "b2xa3\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|_|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|p|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|P|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 * Can't jump over pieces
	 */
	@Test public void testPawnInvalid_12() {
		String input =
			"Nb1-c3 a7-a5\n"
			+ "c2-c4\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|_|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|p|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|N|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|_|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 * Can't move a null pawn
	 */
	@Test public void testPawnInvalid_13() {
		String input =
			"Nb1-c3 a7-a5\n"
			+ "a3-a4\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|_|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|p|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|N|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|_|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 * Can't move a null pawn, double step
	 */
	@Test public void testPawnInvalid_14() {
		String input =
			"Nb1-c3 a7-a5\n"
			+ "a3-a5\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|_|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|p|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|N|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|_|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	// ================================================
	// Rook Tests (ALL BRANCHES COVERED)
	// ================================================
	
	
	/**
	 *  Move white and black rooks left side
	 */
	@Test public void testRookValid_01() {
		String input =
			"a2-a4 a7-a5\n"
			+ "Ra1-a3 Ra8-a6\n";
		
		String output =
			"8|_|n|b|q|k|b|n|r|\n" +
			"7|_|p|p|p|p|p|p|p|\n" +
			"6|r|_|_|_|_|_|_|_|\n" +
			"5|p|_|_|_|_|_|_|_|\n" +
			"4|P|_|_|_|_|_|_|_|\n" +
			"3|R|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|_|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Move white and black rooks right side
	 */
	@Test public void testRookValid_02() {
		String input =
			"h2-h4 h7-h5\n"
			+ "Rh1-h3 Rh8-h6\n";
		
		String output =
			"8|r|n|b|q|k|b|n|_|\n" +
			"7|p|p|p|p|p|p|p|_|\n" +
			"6|_|_|_|_|_|_|_|r|\n" +
			"5|_|_|_|_|_|_|_|p|\n" +
			"4|_|_|_|_|_|_|_|P|\n" +
			"3|_|_|_|_|_|_|_|R|\n" +
			"2|P|P|P|P|P|P|P|_|\n" +
			"1|R|N|B|Q|K|B|N|_|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Move rook horizontally
	 */
	@Test public void testRookValid_03() {
		String input =
			"h2-h4 h7-h5\n"
			+ "Rh1-h3 Rh8-h6\n"
			+ "Rh3-a3 Rh6-a6";
		
		String output =
			"8|r|n|b|q|k|b|n|_|\n" +
			"7|p|p|p|p|p|p|p|_|\n" +
			"6|r|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|p|\n" +
			"4|_|_|_|_|_|_|_|P|\n" +
			"3|R|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|_|\n" +
			"1|R|N|B|Q|K|B|N|_|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Rook captures another piece
	 */
	@Test public void testRookValid_04() {
		String input =
			"a2-a4 h7-h5\n" +
			"Ra1-a3 Rh8-h6\n" +
			"Ra3-d3 Rh6-g6\n" +
			"Rd3xd7\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|_|\n" +
			"7|p|p|p|R|p|p|p|_|\n" +
			"6|_|_|_|_|_|_|r|_|\n" +
			"5|_|_|_|_|_|_|_|p|\n" +
			"4|P|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|_|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Rook captures a rook
	 */
	@Test public void testRookValid_05() {
		String input =
			"a2-a4 b7-b5\n" + 
			"a4-a5 h7-h6\n" +
			"a5xb6ep g7-g6\n" +
			"Ra1xa7 f7-f6\n" +
			"Ra7xRa8\n" +
			"";
		String output =
			"8|R|n|b|q|k|b|n|r|\n"+
			"7|_|_|p|p|p|_|_|_|\n"+
			"6|_|P|_|_|_|p|p|p|\n"+
			"5|_|_|_|_|_|_|_|_|\n"+
			"4|_|_|_|_|_|_|_|_|\n"+
			"3|_|_|_|_|_|_|_|_|\n"+
			"2|_|P|P|P|P|P|P|P|\n"+
			"1|_|N|B|Q|K|B|N|R|\n"+
			"  a b c d e f g h";

			check(input,output);
	}
	
	
	/**
	 *  Checks invalid placement of rooks (rook takes a invalid piece)
	 */
	@Test public void testRookInvalid_01() {
		String input =
			"Rh1xh2\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Checks invalid placement of rooks (rook takes a null piece)
	 */
	@Test public void testRookInvalid_02() {
		String input =
			"h2-h4 h7-h6\n"
			+ "Rh1xh3\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|_|\n" +
			"6|_|_|_|_|_|_|_|p|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|P|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|_|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 * Checks invalid placement of rooks (rook isn't there)
	 */
	@Test public void testRookInvalid_03() {
		String input =
			"a2-a4 Re8-e6" +
			"";
			String output =
			"8|r|n|b|q|k|b|n|r|\n"+
			"7|p|p|p|p|p|p|p|p|\n"+
			"6|_|_|_|_|_|_|_|_|\n"+
			"5|_|_|_|_|_|_|_|_|\n"+
			"4|P|_|_|_|_|_|_|_|\n"+
			"3|_|_|_|_|_|_|_|_|\n"+
			"2|_|P|P|P|P|P|P|P|\n"+
			"1|R|N|B|Q|K|B|N|R|\n"+
			"  a b c d e f g h";

			check(input,output);
	}
	
	
	
	/**
	 *  Checks invalid placement of rook (piece in the way)
	 */
	@Test public void testRookInvalid_04() {
		String input =
			"Ra1-h1\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 *  Checks invalid placement of knight (can't go that far)
	 */
	@Test public void testRookInvalid_05() {
		String input =
			"Ra1-d3\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	

	
	
	
	// ================================================
	// Tests (Knight) ALL BRANCHES COVERED
	// ================================================
	
	/**
	 *  Move left white and black knights
	 */
	@Test public void testKnightValid_01() {
		String input =
			"Nb1-c3 Nb8-c6\n";
		
		String output =
			"8|r|_|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|n|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|N|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|_|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Move right white and black knights
	 */
	@Test public void testKnightValid_02() {
		String input =
			"Ng1-f3 Ng8-f6\n";
		
		String output =
			"8|r|n|b|q|k|b|_|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|n|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|N|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|_|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Knight captures another piece
	 */
	@Test public void testKnightValid_03() {
		String input =
			"d2-d4 Nb8-c6\n" +
			"e2-e4 Nc6xd4\n" +
			"";
		String output =
			"8|r|_|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|n|P|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|_|_|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Checks invalid placement of knight (piece in the way)
	 */
	@Test public void testKnightInvalid_01() {
		String input =
			"Nb1-d2\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 *  Checks invalid placement of knight (can't go that far)
	 */
	@Test public void testKnightInvalid_02() {
		String input =
			"Nb1-d3\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	

	/**
	 *  Checks invalid take by knight
	 */
	@Test public void testKnightInvalid_03() {
		String input =
			"Nb1xd2\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 *  Checks invalid take by knight (capturing a null piece)
	 */
	@Test public void testKnightInvalid_04() {
		String input =
			"Nb1xa1\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 *  Checks invalid move by knight (knight isn't there)
	 */
	@Test public void testKnightInvalid_05() {
		String input =
			"Na3-c4\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	

	
	// ================================================
	// Tests (Bishop) ALL BRANCHES COVERED
	// ================================================
	
	
	/**
	 *  Move white and black bishops, one side
	 */
	@Test public void testBishopValid_01() {
		String input =
			"b2-b4 g7-g5\n"
			+ "Bc1-a3 Bf8-h6\n";
		
		String output =
			"8|r|n|b|q|k|_|n|r|\n" +
			"7|p|p|p|p|p|p|_|p|\n" +
			"6|_|_|_|_|_|_|_|b|\n" +
			"5|_|_|_|_|_|_|p|_|\n" +
			"4|_|P|_|_|_|_|_|_|\n" +
			"3|B|_|_|_|_|_|_|_|\n" +
			"2|P|_|P|P|P|P|P|P|\n" +
			"1|R|N|_|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Move white and black bishops, other side
	 */
	@Test public void testBishopValid_02() {
		String input =
			"g2-g4 b7-b5\n"
			+ "Bf1-h3 Bc8-a6\n";
		
		String output =
			"8|r|n|_|q|k|b|n|r|\n" +
			"7|p|_|p|p|p|p|p|p|\n" +
			"6|b|_|_|_|_|_|_|_|\n" +
			"5|_|p|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|P|_|\n" +
			"3|_|_|_|_|_|_|_|B|\n" +
			"2|P|P|P|P|P|P|_|P|\n" +
			"1|R|N|B|Q|K|_|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Bishop captures another piece
	 */
	@Test public void testBishopValid_04() {
		String input =
			"e2-e4 e7-e5\n" +
			"Bf1-a6 Bf8-a3\n" +
			"Ba6xb7 Ba3xb2"+
						"";
			String output =
			"8|r|n|b|q|k|_|n|r|\n"+
			"7|p|B|p|p|_|p|p|p|\n"+
			"6|_|_|_|_|_|_|_|_|\n"+
			"5|_|_|_|_|p|_|_|_|\n"+
			"4|_|_|_|_|P|_|_|_|\n"+
			"3|_|_|_|_|_|_|_|_|\n"+
			"2|P|b|P|P|_|P|P|P|\n"+
			"1|R|N|B|Q|K|_|N|R|\n"+
			"  a b c d e f g h";

			check(input,output);
	}
	
	
	@Test public void testBishopValid_05() {
		String input =
				"f2-f4 e7-e5\n" +
				"g2-g3 Bf8-c5\n" +
				"Nb1-c3 Bc5xNg1"+
						"";
			String output =
					"8|r|n|b|q|k|_|n|r|\n"+
					"7|p|p|p|p|_|p|p|p|\n"+
					"6|_|_|_|_|_|_|_|_|\n"+
					"5|_|_|_|_|p|_|_|_|\n"+
					"4|_|_|_|_|_|P|_|_|\n"+
					"3|_|_|N|_|_|_|P|_|\n"+
					"2|P|P|P|P|P|_|_|P|\n"+
					"1|R|_|B|Q|K|B|b|R|\n"+
					"  a b c d e f g h";

			check(input,output);
	}
	
	
	/**
	 *  Checks invalid placement of bishop (piece in the way)
	 */
	@Test public void testBishopInvalid_01() {
		String input =
			"Bc1-d2\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 *  Checks invalid placement of bishop (can't go that far)
	 */
	@Test public void testBishopInvalid_02() {
		String input =
			"Bc1-h6\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	

	/**
	 *  Checks invalid take by bishop
	 */
	@Test public void testBishopInvalid_03() {
		String input =
			"Bc1xd2\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 *  Checks invalid take by bishop (capturing a null piece)
	 */
	@Test public void testBishopInvalid_04() {
		String input =
			"d2-d3 h7-h6\n"
			+ "Bc1xd2\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|_|\n" +
			"6|_|_|_|_|_|_|_|p|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|P|_|_|_|_|\n" +
			"2|P|P|P|_|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 *  Checks invalid take by bishop (bishop isn't there)
	 */
	@Test public void testBishopInvalid_05() {
		String input =
			"Ba3-b4\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	

	@Test public void testBishopInvalid_06() {
		String input =
				"d2-d3 e7-e6\n" +
				"Bc1-f4 f7-f6\n" +
				"Bf4xNb8"+
				"";
			String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|_|_|p|p|\n" +
			"6|_|_|_|_|p|p|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|B|_|_|\n" +
			"3|_|_|_|P|_|_|_|_|\n" +
			"2|P|P|P|_|P|P|P|P|\n" +
			"1|R|N|_|Q|K|B|N|R|\n" +
				"  a b c d e f g h";

			check(input,output);
		}
	

	
	@Test public void testBishopInvalid_07() {
		String input =
			"f1-a3 a7-a6\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	// ================================================
	// Tests (King) ALL BRANCHES COVERED
	// ================================================
	
	
	/**
	 *  Move kings horizontally
	 */
	@Test public void testKingValid_01() {
		String input =
			"d2-d4 d7-d5\n"
			+ "Qd1-d3 Qd8-d6\n"
			+ "Ke1-d1 Ke8-d8\n";
		
		String output =
			"8|r|n|b|k|_|b|n|r|\n" +
			"7|p|p|p|_|p|p|p|p|\n" +
			"6|_|_|_|q|_|_|_|_|\n" +
			"5|_|_|_|p|_|_|_|_|\n" +
			"4|_|_|_|P|_|_|_|_|\n" +
			"3|_|_|_|Q|_|_|_|_|\n" +
			"2|P|P|P|_|P|P|P|P|\n" +
			"1|R|N|B|K|_|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Move kings vertically
	 */
	@Test public void testKingValid_02() {
		String input =
			"e2-e4 e7-e5\n"
			+ "Ke1-e2 Ke8-e7\n";
		
		String output =
			"8|r|n|b|q|_|b|n|r|\n"+
			"7|p|p|p|p|k|p|p|p|\n"+
			"6|_|_|_|_|_|_|_|_|\n"+
			"5|_|_|_|_|p|_|_|_|\n"+
			"4|_|_|_|_|P|_|_|_|\n"+
			"3|_|_|_|_|_|_|_|_|\n"+
			"2|P|P|P|P|K|P|P|P|\n"+
			"1|R|N|B|Q|_|B|N|R|\n"+
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 *  Move kings on spot
	 */
	@Test public void testKingValid_03() {
		String input =
			"e2-e4 e7-e5\n"
			+ "Ke1-e1 Ke8-e8\n";
		
		String output =
			"8|r|n|b|q|k|b|n|r|\n"+
			"7|p|p|p|p|_|p|p|p|\n"+
			"6|_|_|_|_|_|_|_|_|\n"+
			"5|_|_|_|_|p|_|_|_|\n"+
			"4|_|_|_|_|P|_|_|_|\n"+
			"3|_|_|_|_|_|_|_|_|\n"+
			"2|P|P|P|P|_|P|P|P|\n"+
			"1|R|N|B|Q|K|B|N|R|\n"+
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  King captures another piece
	 */
	@Test public void testKingValid_04() {
		String input =
			"a2-a4 e7-e5\n"
			+ "Ra1-a3 Ke8-e7\n"
			+ "Ra3-d3 Ke7-e6\n"
			+ "Rd3-d6+ Ke6xRd6\n";
		
		String output =
			"8|r|n|b|q|_|b|n|r|\n"+
			"7|p|p|p|p|_|p|p|p|\n"+
			"6|_|_|_|k|_|_|_|_|\n"+
			"5|_|_|_|_|p|_|_|_|\n"+
			"4|P|_|_|_|_|_|_|_|\n"+
			"3|_|_|_|_|_|_|_|_|\n"+
			"2|_|P|P|P|P|P|P|P|\n"+
			"1|_|N|B|Q|K|B|N|R|\n"+
			"  a b c d e f g h";
		check(input,output);
	}
	
	
	/**
	 *  Checks invalid placement of king (piece in the way)
	 */
	@Test public void testKingInvalid_01() {
		String input =
			"Ke1-e2\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 *  Checks invalid placement of king (can't go that far)
	 */
	@Test public void testKingInvalid_02() {
		String input =
			"e2-e4 h7-h6\n"
			+ "Ke1-e3\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|_|\n" +
			"6|_|_|_|_|_|_|_|p|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|P|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|_|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	

	/**
	 *  Checks invalid take by king
	 */
	@Test public void testKingnvalid_03() {
		String input =
			"Ke1xe2\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 *  Checks invalid take by king (capturing a null piece)
	 */
	@Test public void testKingInvalid_04() {
		String input =
			"e2-e3 h7-h6\n"
			+ "Ke1xRe2\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|_|\n" +
			"6|_|_|_|_|_|_|_|p|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|P|_|_|_|\n" +
			"2|P|P|P|P|_|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 *  Checks invalid by king (king isn't there)
	 */
	@Test public void testKingInvalid_05() {
		String input =
			"Ka3-a4\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	
	
	
	// ================================================
	// Tests (Queen) ALL BRANCHES COVERED
	// ================================================
	
	
	/**
	 *  Move queen diagonally
	 */
	@Test public void testQueenValid_01() {
		String input =
			"c2-c4 e7-e5\n"
			+ "Qd1-a4 Qd8-h4\n";
		
		String output =
			"8|r|n|b|_|k|b|n|r|\n" +
			"7|p|p|p|p|_|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|p|_|_|_|\n" +
			"4|Q|_|P|_|_|_|_|q|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|_|P|P|P|P|P|\n" +
			"1|R|N|B|_|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Move queen vertically
	 */
	@Test public void testQueenValid_02() {
		String input =
			"d2-d4 d7-d5\n"
			+ "Qd1-d3 Qd8-d6\n";
		
		String output =
			"8|r|n|b|_|k|b|n|r|\n"+
			"7|p|p|p|_|p|p|p|p|\n"+
			"6|_|_|_|q|_|_|_|_|\n"+
			"5|_|_|_|p|_|_|_|_|\n"+
			"4|_|_|_|P|_|_|_|_|\n"+
			"3|_|_|_|Q|_|_|_|_|\n"+
			"2|P|P|P|_|P|P|P|P|\n"+
			"1|R|N|B|_|K|B|N|R|\n"+
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Move queen horizontally
	 */
	@Test public void testQueenValid_03() {
		String input =
			"b2-b4 h7-h5\n"
			+ "Bc1-b2 g7-g5\n"
			+ "Qd1-c1\n";
		
		String output =
			"8|r|n|b|q|k|b|n|r|\n"+
			"7|p|p|p|p|p|p|_|_|\n"+
			"6|_|_|_|_|_|_|_|_|\n"+
			"5|_|_|_|_|_|_|p|p|\n"+
			"4|_|P|_|_|_|_|_|_|\n"+
			"3|_|_|_|_|_|_|_|_|\n"+
			"2|P|B|P|P|P|P|P|P|\n"+
			"1|R|N|Q|_|K|B|N|R|\n"+
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Queen captures another piece
	 */
	@Test public void testQueenValid_04() {
		String input =
			"e2-e4 e7-e5\n" +
			"Qd1-g4 Qd8-h4\n" +
			"Qg4-f4 Qh4-h6\n" +
			"Qf4-f6 Qh6xh2\n" +
			"";
		String output =
			"8|r|n|b|_|k|b|n|r|\n" +
			"7|p|p|p|p|_|p|p|p|\n" +
			"6|_|_|_|_|_|Q|_|_|\n" +
			"5|_|_|_|_|p|_|_|_|\n" +
			"4|_|_|_|_|P|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|_|P|P|q|\n" +
			"1|R|N|B|_|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	

	
	/**
	 *  Checks invalid placement of queen (piece in the way)
	 */
	@Test public void testQueenInvalid_01() {
		String input =
			"Qd1-e2\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 *  Checks invalid placement of queen (can't go that way)
	 */
	@Test public void testQueenInvalid_02() {
		String input =
			"Qd1-b3\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	

	/**
	 *  Checks invalid take by queen
	 */
	@Test public void testQueenInvalid_03() {
		String input =
			"Qd1xe2\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Checks invalid take by queen (capturing a null piece)
	 */
	@Test public void testQueenInvalid_04() {
		String input =
			"d2-d3 h7-h6\n"
			+ "Qd1xd2\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|_|\n" +
			"6|_|_|_|_|_|_|_|p|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|P|_|_|_|_|\n" +
			"2|P|P|P|_|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Checks invalid take by queen (bishop isn't there)
	 */
	@Test public void testQueenInvalid_05() {
		String input =
			"Qa3-b4\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	
	
	// ================================================
	// Tests (EnPassant)
	// ================================================
	
	
	/**
	 *  Testing an en passant play
	 */
	@Test public void testEnPassantValid_01() {
		String input =
			"a2-a4 h7-h5\n" + 
			"Ra1-a3 Rh8-h6\n" + 
			"Ra3-h3 Rh6-a6\n" + 
			"Rh3xh1"+
			"";
		String output =
			"8|r|n|b|q|k|b|n|_|\n"+
			"7|p|p|p|p|p|p|p|_|\n"+
			"6|r|_|_|_|_|_|_|_|\n"+
			"5|_|_|_|_|_|_|_|p|\n"+
			"4|P|_|_|_|_|_|_|_|\n"+
			"3|_|_|_|_|_|_|_|R|\n"+
			"2|_|P|P|P|P|P|P|P|\n"+
			"1|_|N|B|Q|K|B|N|R|\n"+
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	
	/**
	 *  Testing an en passant play
	 */
	@Test public void testEnPassantValid_02() {
		
		String input =
			"h2-h3 b7-b5\n" + 
			"g2-g3 b5-b4\n" + 
			"a2-a4 b4xa3ep\n" + 
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n"+
			"7|p|_|p|p|p|p|p|p|\n"+
			"6|_|_|_|_|_|_|_|_|\n"+
			"5|_|_|_|_|_|_|_|_|\n"+
			"4|_|_|_|_|_|_|_|_|\n"+
			"3|p|_|_|_|_|_|P|P|\n"+
			"2|_|P|P|P|P|P|_|_|\n"+
			"1|R|N|B|Q|K|B|N|R|\n"+
			"  a b c d e f g h";

		check(input,output);
		
	}
	

	/**
	 *  Testing an invalid en passant play, where there is a piece in the way)
	 */
	@Test public void testEnPassantInvalid_01() {
		
		String input =
			"d2-d4 e7-e5\n" + 
			"d4-d5 d7-d6\n" + 
			"a2-a3 Bc8-e6\n" + 
			"d5xe6ep\n" + 
			"";
		String output =
			"8|r|n|_|q|k|b|n|r|\n"+
			"7|p|p|p|_|_|p|p|p|\n"+
			"6|_|_|_|p|b|_|_|_|\n"+
			"5|_|_|_|P|p|_|_|_|\n"+
			"4|_|_|_|_|_|_|_|_|\n"+
			"3|P|_|_|_|_|_|_|_|\n"+
			"2|_|P|P|_|P|P|P|P|\n"+
			"1|R|N|B|Q|K|B|N|R|\n"+
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Testing an invalid en passant play, where it is not a pawn)
	 */
	@Test public void testEnPassantInvalid_02() {
		
		String input =
			"e2-e4 Nb8-c6\n" + 
			"f2-f4 Nc6-d4\n" + 
			"e4xd5ep\n" + 
			"";
		String output =
			"8|r|_|b|q|k|b|n|r|\n"+
			"7|p|p|p|p|p|p|p|p|\n"+
			"6|_|_|_|_|_|_|_|_|\n"+
			"5|_|_|_|_|_|_|_|_|\n"+
			"4|_|_|_|n|P|P|_|_|\n"+
			"3|_|_|_|_|_|_|_|_|\n"+
			"2|P|P|P|P|_|_|P|P|\n"+
			"1|R|N|B|Q|K|B|N|R|\n"+
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Testing an invalid en passant play, where it is a piece of the same color)
	 */
	@Test public void testEnPassantInvalid_03() {
		
		String input =
			"d2-d4 h7-h6\n"
			+ "d4xd3ep\n" + 
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n"+
			"7|p|p|p|p|p|p|p|_|\n"+
			"6|_|_|_|_|_|_|_|p|\n"+
			"5|_|_|_|_|_|_|_|_|\n"+
			"4|_|_|_|P|_|_|_|_|\n"+
			"3|_|_|_|_|_|_|_|_|\n"+
			"2|P|P|P|_|P|P|P|P|\n"+
			"1|R|N|B|Q|K|B|N|R|\n"+
			"  a b c d e f g h";

		check(input,output);
	}
	

	/**
	 *  Testing an invalid en passant play, where there is no piece there
	 */
	@Test public void testEnPassantInvalid_04() {
		
		String input =
			"d2-d4 f7-f5\n"
			+ "d4xe5ep" + 
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n"+
			"7|p|p|p|p|p|_|p|p|\n"+
			"6|_|_|_|_|_|_|_|_|\n"+
			"5|_|_|_|_|_|p|_|_|\n"+
			"4|_|_|_|P|_|_|_|_|\n"+
			"3|_|_|_|_|_|_|_|_|\n"+
			"2|P|P|P|_|P|P|P|P|\n"+
			"1|R|N|B|Q|K|B|N|R|\n"+
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Checks invalid en passant play (not double move)
	 */
	@Test public void testEnPassantInvalid_05() {
		String input =
			"b2-b4 c7-c5\n" +
			"b4-b5 c5xb4ep";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|_|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|P|p|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|_|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	
	// ================================================
	// Tests (Pawn Promotion) ALL BRANCHES COVERED
	// ================================================
	
	/**
	 *  Pawn promotes to a queen
	 */
	@Test public void testPPValid_01() {
		String input =
				"a2-a4 b7-b5\n"+ "a4xb5 Nb8-c6\n"+ 
				"b5-b6 a7-a5\n"+ "Nb1-c3 Bc8-a6\n"+ 
				"b6-b7 d7-d5\n" + 
				"b7-b8=Q\n" +
				"";	
		
		String output =
				"8|r|Q|_|q|k|b|n|r|\n"+
				"7|_|_|p|_|p|p|p|p|\n"+
				"6|b|_|n|_|_|_|_|_|\n"+
				"5|p|_|_|p|_|_|_|_|\n"+
				"4|_|_|_|_|_|_|_|_|\n"+
				"3|_|_|N|_|_|_|_|_|\n"+
				"2|_|P|P|P|P|P|P|P|\n"+
				"1|R|_|B|Q|K|B|N|R|\n"+
				"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Pawn promotes to a bishop
	 */
	@Test public void testPPValid_02() {
		String input =
				"a2-a4 b7-b5\n"+ "a4xb5 Nb8-c6\n"+ 
				"b5-b6 a7-a6\n"+ "b6-b7 a6-a5\n" + 
				"b7-b8=B\n" +
				"";
		String output =
				"8|r|B|b|q|k|b|n|r|\n"+
				"7|_|_|p|p|p|p|p|p|\n"+
				"6|_|_|n|_|_|_|_|_|\n"+
				"5|p|_|_|_|_|_|_|_|\n"+
				"4|_|_|_|_|_|_|_|_|\n"+
				"3|_|_|_|_|_|_|_|_|\n"+
				"2|_|P|P|P|P|P|P|P|\n"+
				"1|R|N|B|Q|K|B|N|R|\n"+
				"  a b c d e f g h";

		check(input,output);
	
	}
	
	
	/**
	 *  Pawn promotes to a knight
	 */
	@Test public void testPPValid_03() {
		String input =
				"a2-a4 b7-b5\n"+ "a4xb5 Nb8-c6\n"+ 
				"b5-b6 a7-a6\n"+ "b6-b7 a6-a5\n" + 
				"b7-b8=N\n" +
				"";
		String output =
				"8|r|N|b|q|k|b|n|r|\n"+
				"7|_|_|p|p|p|p|p|p|\n"+
				"6|_|_|n|_|_|_|_|_|\n"+
				"5|p|_|_|_|_|_|_|_|\n"+
				"4|_|_|_|_|_|_|_|_|\n"+
				"3|_|_|_|_|_|_|_|_|\n"+
				"2|_|P|P|P|P|P|P|P|\n"+
				"1|R|N|B|Q|K|B|N|R|\n"+
				"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 * Pawn promotes to a bishop
	 */
	@Test public void testPPValid_04() {
		String input =
				"a2-a4 b7-b5\n"+ "a4xb5 Nb8-c6\n"+ 
				"b5-b6 a7-a6\n"+ "b6-b7 a6-a5\n" + 
				"b7-b8=R\n" +
				"";
		String output =
				"8|r|R|b|q|k|b|n|r|\n"+
				"7|_|_|p|p|p|p|p|p|\n"+
				"6|_|_|n|_|_|_|_|_|\n"+
				"5|p|_|_|_|_|_|_|_|\n"+
				"4|_|_|_|_|_|_|_|_|\n"+
				"3|_|_|_|_|_|_|_|_|\n"+
				"2|_|P|P|P|P|P|P|P|\n"+
				"1|R|N|B|Q|K|B|N|R|\n"+
				"  a b c d e f g h";

		check(input,output);
	}
	
	
	@Test public void testPPValid_06() {
		String input =
				"a2-a4 b7-b5\n"+
				"a4xb5 Nb8-c6\n"+
				"b5-b6 a7-a5\n"+
				"Nb1-c3 Bc8-a6\n"+
				"b6-b7 Qd8-c8\n"+
				"b7xQc8=Q" +
				"";
		String output =
				"8|r|_|Q|_|k|b|n|r|\n"+
				"7|_|_|p|p|p|p|p|p|\n"+
				"6|b|_|n|_|_|_|_|_|\n"+
				"5|p|_|_|_|_|_|_|_|\n"+
				"4|_|_|_|_|_|_|_|_|\n"+
				"3|_|_|N|_|_|_|_|_|\n"+
				"2|_|P|P|P|P|P|P|P|\n"+
				"1|R|_|B|Q|K|B|N|R|\n"+
				"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Pawn promotion to rook, also puts the king in check
	 */
	@Test public void testPPValid_07() {
		String input =
				"a2-a3 d7-d5\n"
				+ "b2-b3 d5-d4\n"
				+ "c2-c4 d4xc3ep\n"
				+ "Bc1-b2 c3xBb2\n"
				+ "Qd1-c1 b2xQc1=R+" +
				"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
				"7|p|p|p|_|p|p|p|p|\n"+
				"6|_|_|_|_|_|_|_|_|\n"+
				"5|_|_|_|_|_|_|_|_|\n"+
				"4|_|_|_|_|_|_|_|_|\n"+
				"3|P|P|_|_|_|_|_|_|\n"+
				"2|_|_|_|P|P|P|P|P|\n"+
				"1|R|N|r|_|K|B|N|R|\n"+
				"  a b c d e f g h";

		check(input,output);
	}
	
	
	
	/**
	 *  Illegal pawn promotion (white has not reached its final row)
	 */
	@Test public void testPPInvalid_01() {
		String input =
				"a2-a4=N" +
				"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
				"7|p|p|p|p|p|p|p|p|\n"+
				"6|_|_|_|_|_|_|_|_|\n"+
				"5|_|_|_|_|_|_|_|_|\n"+
				"4|_|_|_|_|_|_|_|_|\n"+
				"3|_|_|_|_|_|_|_|_|\n"+
				"2|P|P|P|P|P|P|P|P|\n"+
				"1|R|N|B|Q|K|B|N|R|\n"+
				"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Illegal pawn promotion (black has not reached its final row)
	 */
	@Test public void testPPInvalid_02() {
		String input =
				"a2-a4 h7-h5=N" +
				"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
				"7|p|p|p|p|p|p|p|p|\n"+
				"6|_|_|_|_|_|_|_|_|\n"+
				"5|_|_|_|_|_|_|_|_|\n"+
				"4|P|_|_|_|_|_|_|_|\n"+
				"3|_|_|_|_|_|_|_|_|\n"+
				"2|_|P|P|P|P|P|P|P|\n"+
				"1|R|N|B|Q|K|B|N|R|\n"+
				"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 *  Illegal pawn promotion(move is invalid)
	 */
	@Test public void testPPInvalid_03() {
		String input =
				"b2-b4 a7-a5\n"
				+ "b4-b5 h7-h6\n"
				+ "b5xa6ep g7-g6\n"
				+ "a6-a7 f7-f6\n"
				+ "a7-a8=B\n" +
				"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
				"7|P|p|p|p|p|_|_|_|\n"+
				"6|_|_|_|_|_|p|p|p|\n"+
				"5|_|_|_|_|_|_|_|_|\n"+
				"4|_|_|_|_|_|_|_|_|\n"+
				"3|_|_|_|_|_|_|_|_|\n"+
				"2|P|_|P|P|P|P|P|P|\n"+
				"1|R|N|B|Q|K|B|N|R|\n"+
				"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Illegal pawn promotion(piece is not a pawn)
	 */
	@Test public void testPPInvalid_04() {
		String input =
				"a2-a4 b7-b5\n"
				+ "a4xb5 h7-h6\n"
				+ "Ra1xa7 Nb8-c6\n"
				+ "Ra7xRa8=Q\n" +
				"";
		String output =
				"8|r|_|b|q|k|b|n|r|\n"+
				"7|R|_|p|p|p|p|p|_|\n"+
				"6|_|_|n|_|_|_|_|p|\n"+
				"5|_|P|_|_|_|_|_|_|\n"+
				"4|_|_|_|_|_|_|_|_|\n"+
				"3|_|_|_|_|_|_|_|_|\n"+
				"2|_|P|P|P|P|P|P|P|\n"+
				"1|_|N|B|Q|K|B|N|R|\n"+
				"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Illegal pawn promotion(piece cannot be promoted to king)
	 */
	@Test public void testPPInvalid_05() {
		String input =
				"a2-a4 b7-b5\n"+ "a4xb5 Nb8-c6\n"+ 
				"b5-b6 a7-a6\n"+ "b6-b7 a6-a5\n" + 
				"b7-b8=K\n" +
				"";
		String output =
				"8|r|_|b|q|k|b|n|r|\n"+
				"7|_|P|p|p|p|p|p|p|\n"+
				"6|_|_|n|_|_|_|_|_|\n"+
				"5|p|_|_|_|_|_|_|_|\n"+
				"4|_|_|_|_|_|_|_|_|\n"+
				"3|_|_|_|_|_|_|_|_|\n"+
				"2|_|P|P|P|P|P|P|P|\n"+
				"1|R|N|B|Q|K|B|N|R|\n"+
				"  a b c d e f g h";

		check(input,output);
	}
	
	
	
	
	// ================================================
	// Tests (Castling)
	// ================================================
	
	
	/**
	 *  White, king's side
	 */
	@Test public void testValidCastling_01() {
		
		String input =
				"e2-e4 e7-e5\n"+
				"Ng1-h3 d7-d5\n"+
				"Bf1-c4 c7-c5\n"+
				"O-O\n"+
				"";
		
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
				"7|p|p|_|_|_|p|p|p|\n"+
				"6|_|_|_|_|_|_|_|_|\n"+
				"5|_|_|p|p|p|_|_|_|\n"+
				"4|_|_|B|_|P|_|_|_|\n"+
				"3|_|_|_|_|_|_|_|N|\n"+
				"2|P|P|P|P|_|P|P|P|\n"+
				"1|R|N|B|Q|_|R|K|_|\n"+
				"  a b c d e f g h";

			check(input, output);
	}
	
	
	/**
	 *  Black, queen's side
	 */
	@Test public void testValidCastling_02() {
		String input =
				"h2-h3 d7-d5\n" + "g2-g3 Qd8-d6\n" +
				"f2-f3 Bc8-g4\n" + "e2-e3 Nb8-a6\n" +
				"d2-d3 O-O-O\n"+
				"";
		
		String output =
				"8|_|_|k|r|_|b|n|r|\n"+
				"7|p|p|p|_|p|p|p|p|\n"+
				"6|n|_|_|q|_|_|_|_|\n"+
				"5|_|_|_|p|_|_|_|_|\n"+
				"4|_|_|_|_|_|_|b|_|\n"+
				"3|_|_|_|P|P|P|P|P|\n"+
				"2|P|P|P|_|_|_|_|_|\n"+
				"1|R|N|B|Q|K|B|N|R|\n"+
				"  a b c d e f g h";

			check(input,output);
	}
	
	
	/**
	 *  Black, king's side
	 */
	@Test public void testValidCastling_03() {
		String input =
				"e2-e3 e7-e6\n"+
				"d2-d3 Ng8-f6\n"+
				"c2-c3 Bf8-b4\n"+
				"a2-a4 O-O\n"+
				"";
			String output =
					"8|r|n|b|q|_|r|k|_|\n"+
					"7|p|p|p|p|_|p|p|p|\n"+
					"6|_|_|_|_|p|n|_|_|\n"+
					"5|_|_|_|_|_|_|_|_|\n"+
					"4|P|b|_|_|_|_|_|_|\n"+
				    "3|_|_|P|P|P|_|_|_|\n"+
					"2|_|P|_|_|_|P|P|P|\n"+
					"1|R|N|B|Q|K|B|N|R|\n"+
					"  a b c d e f g h";

			check(input,output);
	}
	
	
	/**
	 *  White, queen's side
	 */
	@Test public void testValidCastling_05() {
		String input =
			"d2-d4 a7-a6\n" +
			"Qd1-d3 b7-b6\n" +
			"Bc1-e3 c7-c6\n" +
			"Nb1-a3 d7-d6\n" +
			"O-O-O"+
			"";
			String output =
				"8|r|n|b|q|k|b|n|r|\n"+
				"7|_|_|_|_|p|p|p|p|\n"+
				"6|p|p|p|p|_|_|_|_|\n"+
				"5|_|_|_|_|_|_|_|_|\n"+
				"4|_|_|_|P|_|_|_|_|\n"+
				"3|N|_|_|Q|B|_|_|_|\n"+
				"2|P|P|P|_|P|P|P|P|\n"+
				"1|_|_|K|R|_|B|N|R|\n"+
				"  a b c d e f g h";

			check(input,output);
	}

	
	
	/**
	 *  Cannot castle with pieces in the way
	 */
	@Test public void testInvalidCastling_01() {
		String input =
				"e2-e4 e7-e6\n"+
				"Ng1-f3 d7-d6\n"+
				"O-O-O"+
				"";
			String output =
					"8|r|n|b|q|k|b|n|r|\n"+
					"7|p|p|p|_|_|p|p|p|\n"+
					"6|_|_|_|p|p|_|_|_|\n"+
					"5|_|_|_|_|_|_|_|_|\n"+
					"4|_|_|_|_|P|_|_|_|\n"+
					"3|_|_|_|_|_|N|_|_|\n"+
					"2|P|P|P|P|_|P|P|P|\n"+
					"1|R|N|B|Q|K|B|_|R|\n"+
					"  a b c d e f g h";

			check(input,output);
	}
	
	
	
	/**
	 *  Cannot castle when the rook has moved (white, queen's side O-O-O)
	 */
	@Test public void testInvalidCastling_03() {
		String input =
				"Nb1-a3 h7-h6\n"
				+ "b2-b3 g7-g6\n"
				+ "Bc1-b2 f7-f6\n"
				+ "c2-c3 e7-e6\n"
				+ "Qd1-c2 d7-d6\n"
				+ "Ra1-b1 c7-c6\n" +
				"O-O-O"+
				"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
				"7|p|p|_|_|_|_|_|_|\n"+
				"6|_|_|p|p|p|p|p|p|\n"+
				"5|_|_|_|_|_|_|_|_|\n"+
				"4|_|_|_|_|_|_|_|_|\n"+
				"3|N|P|P|_|_|_|_|_|\n"+
				"2|P|B|Q|P|P|P|P|P|\n"+
				"1|_|R|_|_|K|B|N|R|\n"+
				"  a b c d e f g h";

			check(input,output);
	}
	
	
	/**
	 * Cannot castle when the rook has moved (white, queen's side O-O-O)
	 * Same as above but rook moves back into same place
	 */
	@Test public void testInvalidCastling_04() {
		String input =
				"Nb1-a3 h7-h6\n"
				+ "b2-b3 g7-g6\n"
				+ "Bc1-b2 f7-f6\n"
				+ "c2-c3 e7-e6\n"
				+ "Qd1-c2 d7-d6\n"
				+ "Ra1-b1 c7-c6\n"
				+ "Rb1-a1 b7-b6\n" +
				"O-O-O"+
				"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
				"7|p|_|_|_|_|_|_|_|\n"+
				"6|_|p|p|p|p|p|p|p|\n"+
				"5|_|_|_|_|_|_|_|_|\n"+
				"4|_|_|_|_|_|_|_|_|\n"+
				"3|N|P|P|_|_|_|_|_|\n"+
				"2|P|B|Q|P|P|P|P|P|\n"+
				"1|R|_|_|_|K|B|N|R|\n"+
				"  a b c d e f g h";

			check(input,output);
	}
	
	
	/**
	 *  Cannot castle when the king has moved
	 */
	@Test public void testInvalidCastling_05() {
		String input =
				"Nb1-a3 h7-h6\n"
				+ "b2-b3 g7-g6\n"
				+ "Bc1-b2 f7-f6\n"
				+ "c2-c3 e7-e6\n"
				+ "Qd1-c2 d7-d6\n"
				+ "Ke1-d1 c7-c6\n" +
				"O-O-O"+
				"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
				"7|p|p|_|_|_|_|_|_|\n"+
				"6|_|_|p|p|p|p|p|p|\n"+
				"5|_|_|_|_|_|_|_|_|\n"+
				"4|_|_|_|_|_|_|_|_|\n"+
				"3|N|P|P|_|_|_|_|_|\n"+
				"2|P|B|Q|P|P|P|P|P|\n"+
				"1|R|_|_|K|_|B|N|R|\n"+
				"  a b c d e f g h";

			check(input,output);
	}
	
	
	/**
	 *  Cannot castle when the king has moved
	 *  Same as above but the king moves back into the same place
	 */
	@Test public void testInvalidCastling_06() {
		String input =
				"Nb1-a3 h7-h6\n"
				+ "b2-b3 g7-g6\n"
				+ "Bc1-b2 f7-f6\n"
				+ "c2-c3 e7-e6\n"
				+ "Qd1-c2 d7-d6\n"
				+ "Ke1-d1 c7-c6\n"
				+ "Kd1-e1 b7-b6\n" +
				"O-O-O"+
				"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
				"7|p|_|_|_|_|_|_|_|\n"+
				"6|_|p|p|p|p|p|p|p|\n"+
				"5|_|_|_|_|_|_|_|_|\n"+
				"4|_|_|_|_|_|_|_|_|\n"+
				"3|N|P|P|_|_|_|_|_|\n"+
				"2|P|B|Q|P|P|P|P|P|\n"+
				"1|R|_|_|_|K|B|N|R|\n"+
				"  a b c d e f g h";

			check(input,output);
	}
	
	/**
	 * Final move should not execute
	 */
	@Test public void testInvalidCastling_07() {
		String input =
			"d2-d4 a7-a6\n" +
			"Qd1-d3 b7-b6\n" +
			"Bc1-e3 c7-c6\n" +
			"Nb1-a3 d7-d6\n" +
			"O-O-O+"+
			"";
			String output =
				"8|r|n|b|q|k|b|n|r|\n"+
				"7|_|_|_|_|p|p|p|p|\n"+
				"6|p|p|p|p|_|_|_|_|\n"+
				"5|_|_|_|_|_|_|_|_|\n"+
				"4|_|_|_|P|_|_|_|_|\n"+
				"3|N|_|_|Q|B|_|_|_|\n"+
				"2|P|P|P|_|P|P|P|P|\n"+
				"1|R|_|_|_|K|B|N|R|\n"+
				"  a b c d e f g h";

			check(input,output);
	}
	
	/**
	 * Final move should not execute
	 */
	@Test public void testInvalidCastling_08() {
		String input =
				"e2-e3 e7-e6\n"+
				"d2-d3 Ng8-f6\n"+
				"c2-c3 Bf8-b4\n"+
				"a2-a4 O-O+\n"+
				"";
			String output =
					"8|r|n|b|q|k|_|_|r|\n"+
					"7|p|p|p|p|_|p|p|p|\n"+
					"6|_|_|_|_|p|n|_|_|\n"+
					"5|_|_|_|_|_|_|_|_|\n"+
					"4|P|b|_|_|_|_|_|_|\n"+
				    "3|_|_|P|P|P|_|_|_|\n"+
					"2|_|P|_|_|_|P|P|P|\n"+
					"1|R|N|B|Q|K|B|N|R|\n"+
					"  a b c d e f g h";

			check(input,output);
	}
	
	
	
	
	// ================================================
	// Test (Check) ALL BRANCHES COVERED
	// ================================================
	

	@Test public void testValidCheck_01() {
		String input =
			"d2-d4 e7-e5\n"+
			"d4-d5 Ke8-e7\n"+
			"d5-d6+ c7xd6\n" +
			"";
		
		String output =
	 		 "8|r|n|b|q|_|b|n|r|\n"+
			 "7|p|p|_|p|k|p|p|p|\n"+
			 "6|_|_|_|p|_|_|_|_|\n"+
			 "5|_|_|_|_|p|_|_|_|\n"+
			 "4|_|_|_|_|_|_|_|_|\n"+
			 "3|_|_|_|_|_|_|_|_|\n"+
			 "2|P|P|P|_|P|P|P|P|\n"+
			 "1|R|N|B|Q|K|B|N|R|\n"+
			 "  a b c d e f g h";
		check(input,output);
	}
	
	
	@Test public void testValidCheck_02() {
		String input =
			"a2-a4 a7-a5\n"+
			"Ra1-a3 Ra8-a6\n"+
			"Ra3-h3 Ra6-e6\n"+
			"Rh3xh7 Re6xe2+\n"+
			"Bf1xRe2\n" +
			"";
		String output =
			 "8|_|n|b|q|k|b|n|r|\n"+
			 "7|_|p|p|p|p|p|p|R|\n"+
			 "6|_|_|_|_|_|_|_|_|\n"+
			 "5|p|_|_|_|_|_|_|_|\n"+
			 "4|P|_|_|_|_|_|_|_|\n"+
			 "3|_|_|_|_|_|_|_|_|\n"+
			 "2|_|P|P|P|B|P|P|P|\n"+
			 "1|_|N|B|Q|K|_|N|R|\n"+
			 "  a b c d e f g h";
		check(input,output);
	}
	
	
	
	/**
	 * White must move out of check
	 */
	@Test public void testValidCheck_03() {
		String input =
			"e2-e4 a7-a5\n"
			+ "Ke1-e2 Ra8-a6\n"
			+ "Ke2-e3 Ra6-d6\n"
			+ "h2-h3 Rd6-d3+\n"
			+ "c2xRd3\n"+
			"";
		
		String output =
	 		 "8|_|n|b|q|k|b|n|r|\n"+
			 "7|_|p|p|p|p|p|p|p|\n"+
			 "6|_|_|_|_|_|_|_|_|\n"+
			 "5|p|_|_|_|_|_|_|_|\n"+
			 "4|_|_|_|_|P|_|_|_|\n"+
			 "3|_|_|_|P|K|_|_|P|\n"+
			 "2|P|P|_|P|_|P|P|_|\n"+
			 "1|R|N|B|Q|_|B|N|R|\n"+
			 "  a b c d e f g h";
		check(input,output);
	}
	
	
	/**
	 * Not actually in check
	 */
	@Test public void invalidTestCheck_01() {
		String input =
			"e2-e4+" +
			"";
		String output =
	 		 "8|r|n|b|q|k|b|n|r|\n"+
			 "7|p|p|p|p|p|p|p|p|\n"+
			 "6|_|_|_|_|_|_|_|_|\n"+
			 "5|_|_|_|_|_|_|_|_|\n"+
			 "4|_|_|_|_|_|_|_|_|\n"+
			 "3|_|_|_|_|_|_|_|_|\n"+
			 "2|P|P|P|P|P|P|P|P|\n"+
			 "1|R|N|B|Q|K|B|N|R|\n"+
			 "  a b c d e f g h";
		check(input,output);
	}
	
	
	/**
	 * King must be moved/protected when in check
	 */
	@Test public void invalidTestCheck_02() {
		String input =
			"Nb1-c3 e7-e6\n"+
			"Nc3-d5 e6-e5\n"+
			"Nd5xc7+ h7-h6" +
			"";
		String output =
	 		 "8|r|n|b|q|k|b|n|r|\n"+
			 "7|p|p|N|p|_|p|p|p|\n"+
			 "6|_|_|_|_|_|_|_|_|\n"+
			 "5|_|_|_|_|p|_|_|_|\n"+
			 "4|_|_|_|_|_|_|_|_|\n"+
			 "3|_|_|_|_|_|_|_|_|\n"+
			 "2|P|P|P|P|P|P|P|P|\n"+
			 "1|R|_|B|Q|K|B|N|R|\n"+
			 "  a b c d e f g h";
			check(input,output);
	}
	
	
	/**
	 * Invalid move
	 */
	@Test public void invalidTestCheck_03() {
		String input =
			"Bc1-e3+" +
			"";
		String output =
	 		 "8|r|n|b|q|k|b|n|r|\n"+
			 "7|p|p|p|p|p|p|p|p|\n"+
			 "6|_|_|_|_|_|_|_|_|\n"+
			 "5|_|_|_|_|_|_|_|_|\n"+
			 "4|_|_|_|_|_|_|_|_|\n"+
			 "3|_|_|_|_|_|_|_|_|\n"+
			 "2|P|P|P|P|P|P|P|P|\n"+
			 "1|R|N|B|Q|K|B|N|R|\n"+
			 "  a b c d e f g h";
		check(input,output);
	}
	
	
	
	// ================================================
	// Valid Tests (Miscellaneous Tests)
	// ================================================
	
	
	/**
	 * Small game test 1
	 */
	@Test public void testValidMisc_01() {
		String input =
			"d2-d3 d7-d5\n" +
			"e2-e4 d5xe4\n" +
			"d3xe4\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|_|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|P|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|_|_|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";
		
		check(input,output);
	}
	
	
	/**
	 * Small game test 2
	 */
	@Test public void testValidMisc_02() {
		
		String input =
			"Nb1-c3 e7-e6\n"+
			"Nc3-d5 e6-e5\n"+
			"Nd5xc7 Ke8-e7\n"+
			"Nc7xRa8 h7-h6\n" +
			"";
		
		String output =
			"8|N|n|b|q|_|b|n|r|\n"+
			"7|p|p|_|p|k|p|p|_|\n"+
			"6|_|_|_|_|_|_|_|p|\n"+
			"5|_|_|_|_|p|_|_|_|\n"+
			"4|_|_|_|_|_|_|_|_|\n"+
    		"3|_|_|_|_|_|_|_|_|\n"+
			"2|P|P|P|P|P|P|P|P|\n"+
			"1|R|_|B|Q|K|B|N|R|\n"+
			"  a b c d e f g h";
		
			check(input,output);
	}
	
	
	/**
	 * Small game test 3 (putting king in check)
	 */
	@Test public void testValidMisc_03() {
		
		String input =
				"d2-d4 e7-e5\n"+
				"d4-d5 Ke8-e7\n"+
				"d5-d6+ c7xd6\n" +
				"";
		
		String output =
	 		 "8|r|n|b|q|_|b|n|r|\n"+
			 "7|p|p|_|p|k|p|p|p|\n"+
			 "6|_|_|_|p|_|_|_|_|\n"+
			 "5|_|_|_|_|p|_|_|_|\n"+
			 "4|_|_|_|_|_|_|_|_|\n"+
			 "3|_|_|_|_|_|_|_|_|\n"+
			 "2|P|P|P|_|P|P|P|P|\n"+
			 "1|R|N|B|Q|K|B|N|R|\n"+
			 "  a b c d e f g h";
		check(input,output);
	}
	
	
	/**
	 * Small game test 4
	 */
	@Test public void testValidMisc_04() {
		String input =
			"a2-a4 a7-a5\n"+
			"Ra1-a3 Ra8-a6\n"+
			"Ra3-h3 Ra6-e6\n"+
			"Rh3xh7 Re6xe2+\n"+
			"Bf1xRe2\n" +
			"";
		String output =
			 "8|_|n|b|q|k|b|n|r|\n"+
			 "7|_|p|p|p|p|p|p|R|\n"+
			 "6|_|_|_|_|_|_|_|_|\n"+
			 "5|p|_|_|_|_|_|_|_|\n"+
			 "4|P|_|_|_|_|_|_|_|\n"+
			 "3|_|_|_|_|_|_|_|_|\n"+
			 "2|_|P|P|P|B|P|P|P|\n"+
			 "1|_|N|B|Q|K|_|N|R|\n"+
			 "  a b c d e f g h";
		check(input,output);
	}
	
	
	@Test public void testValidMisc_05() {
		String input =
			"e2-e4 a7-a5\n"+
			"Bf1-c4 Ra8-a6\n"+
			"Bc4-b5 h7-h6\n"+
			"Bb5xRa6 b7xBa6\n" +
			"";
		
		String output =
				 "8|_|n|b|q|k|b|n|r|\n"+
				 "7|_|_|p|p|p|p|p|_|\n"+
				 "6|p|_|_|_|_|_|_|p|\n"+
				 "5|p|_|_|_|_|_|_|_|\n"+
				 "4|_|_|_|_|P|_|_|_|\n"+
				 "3|_|_|_|_|_|_|_|_|\n"+
				 "2|P|P|P|P|_|P|P|P|\n"+
				 "1|R|N|B|Q|K|_|N|R|\n"+
				 "  a b c d e f g h";
		check(input,output);
	}
	
	
	/**
	 * Testing all the to string methods
	 */
	@Test public void testValidMisc_06() {
		assertEquals(new Bishop(false).toString(), "b");
		assertEquals(new Bishop(true).toString(), "B");
		assertEquals(new King(false).toString(), "k");
		assertEquals(new King(true).toString(), "K");
		assertEquals(new Knight(false).toString(), "n");
		assertEquals(new Knight(true).toString(), "N");
		assertEquals(new Pawn(false).toString(), "p");
		assertEquals(new Pawn(true).toString(), "P");
		assertEquals(new Queen(false).toString(), "q");
		assertEquals(new Queen(true).toString(), "Q");
		assertEquals(new Rook(false).toString(), "r");
		assertEquals(new Rook(true).toString(), "R");
		
		assertEquals(new Position(0,0).hashCode(), 0);
	}
	
	
	/**
	 *  Pawn promotion to rook, also puts the king in check mate
	 *  Doesn't work yet (checkmate not fully implemented, but a test to cover)
	 */
	@Test public void testValid_07() {
		String input =
				"a2-a3 d7-d5\n"
				+ "b2-b3 d5-d4\n"
				+ "c2-c4 d4xc3ep\n"
				+ "Bc1-b2 c3xBb2\n"
				+ "Qd1-c1 b2xQc1=R#\n" +
				"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
				"7|p|p|p|_|p|p|p|p|\n"+
				"6|_|_|_|_|_|_|_|_|\n"+
				"5|_|_|_|_|_|_|_|_|\n"+
				"4|_|_|_|_|_|_|_|_|\n"+
				"3|P|P|_|_|_|_|_|_|\n"+
				"2|_|_|_|P|P|P|P|P|\n"+
				"1|R|N|r|_|K|B|N|R|\n"+
				"  a b c d e f g h";

		check(input,output);
	}
	
	
	
	
	// ================================================
	// Invalid Tests (Miscellaneous Tests)
	// ================================================
	
	
	/**
	 *  Testing boundaries of position
	 */
	@Test public void invalidTestMisc_01() {
		assertEquals(new Position(10,10).isValid(), false);
		assertEquals(new Position(5,5).isValid(), true);
		assertEquals(new Position(0,0).isValid(), false);
		assertEquals(new Position(1,1).isValid(), true);
		
		assertEquals(new Position(1,1).isValid(), true);
		assertEquals(new Position(0,1).isValid(), false);
	}
	

	
	@Test public void invalidTestMisc_02() {
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
				() -> new Round(null, null),
				"Expected an error, none thrown."
				);
		assertTrue(thrown.getMessage().contains("A round must always consist of a move by white"));
	}

	
	@Test public void invalidTestMisc_03() {
		assertEquals(new Position(5,5).equals(new Object()), false);
	}
	
	
	/**
	 *  Pawn attempts two double steps
	 */
	@Test public void testInvalidMisc_02() {
		String input =
			"b2-b4 c7-c5\n" +
			"b4-b6\n";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|_|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|p|_|_|_|_|_|\n" +
			"4|_|P|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|_|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Pawn attempts double step when not first move
	 */
	@Test public void testInvalidMisc_03() {
		String input =
			"b2-b3 c7-c5\n" +
			"b3-b5\n";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|_|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|p|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|P|_|_|_|_|_|_|\n" +
			"2|P|_|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Testing for an invalid empassant move
	 */
	@Test public void testInvalidMisc_04() {
		String input =
			"a2-a3 b7-b5\n" + 
			"a3-a4 b5-b4\n" + 
			"a4xb5ep\n" + 
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n"+
			"7|p|_|p|p|p|p|p|p|\n"+
			"6|_|_|_|_|_|_|_|_|\n"+
			"5|_|_|_|_|_|_|_|_|\n"+
			"4|P|p|_|_|_|_|_|_|\n"+
			"3|_|_|_|_|_|_|_|_|\n"+
			"2|_|P|P|P|P|P|P|P|\n"+
			"1|R|N|B|Q|K|B|N|R|\n"+
			"  a b c d e f g h";

		check(input,output);
	}
	
	/**
	 *  Testing for an invalid empassant move
	 */
	@Test public void testInvalidMisc_09() {
		String input =
			"a2-a3 b7-b5\n" + 
			"a3-a4 b5-b4\n" + 
			"a4xb4ep\n" + 
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n"+
			"7|p|_|p|p|p|p|p|p|\n"+
			"6|_|_|_|_|_|_|_|_|\n"+
			"5|_|_|_|_|_|_|_|_|\n"+
			"4|P|p|_|_|_|_|_|_|\n"+
			"3|_|_|_|_|_|_|_|_|\n"+
			"2|_|P|P|P|P|P|P|P|\n"+
			"1|R|N|B|Q|K|B|N|R|\n"+
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	
	/**
	 *  Testing for an invalid empassant move
	 */
	@Test public void testInvalidMisc_05() {
		String input =
			"h2-h3 b7-b5\n" + 
			"a2-a3 b5-b4\n" + 
			"a3-a4 b4xa5ep\n" + 
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n"+
			"7|p|_|p|p|p|p|p|p|\n"+
			"6|_|_|_|_|_|_|_|_|\n"+
			"5|_|_|_|_|_|_|_|_|\n"+
			"4|P|p|_|_|_|_|_|_|\n"+
			"3|_|_|_|_|_|_|_|P|\n"+
			"2|_|P|P|P|P|P|P|_|\n"+
			"1|R|N|B|Q|K|B|N|R|\n"+
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 *  Testing an invalid en passant play
	 */
	@Test public void testInvalidMisc_10() {
		
		String input =
			"h2-h3 b7-b5\n" + 
			"g2-g3 b5-b4\n" + 
			"a2-a4 b4xa1ep\n" + 
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n"+
			"7|p|_|p|p|p|p|p|p|\n"+
			"6|_|_|_|_|_|_|_|_|\n"+
			"5|_|_|_|_|_|_|_|_|\n"+
			"4|P|p|_|_|_|_|_|_|\n"+
			"3|_|_|_|_|_|_|P|P|\n"+
			"2|_|P|P|P|P|P|_|_|\n"+
			"1|R|N|B|Q|K|B|N|R|\n"+
			"  a b c d e f g h";

		check(input,output);
		
	}
	
	
	/**
	 * Test an invalid check mate
	 */
	@Test public void testInvalidMisc_06() {
		String input =
			"a2-a3#\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	
	/**
	 * Is a check, but not a check mate
	 * Doesn't work yet (checkmate not fully implemented, but a test to cover)
	 */
	@Test public void testInvalidMisc_07() {
		String input =
			"d2-d4 e7-e5\n"+
			"d4-d5 Ke8-e7\n"+
			"d5-d6# c7xd6\n" +
			"";
		
		String output =
	 		 "8|r|n|b|q|_|b|n|r|\n"+
			 "7|p|p|p|p|k|p|p|p|\n"+
			 "6|_|_|_|P|_|_|_|_|\n"+
			 "5|_|_|_|_|p|_|_|_|\n"+
			 "4|_|_|_|_|_|_|_|_|\n"+
			 "3|_|_|_|_|_|_|_|_|\n"+
			 "2|P|P|P|_|P|P|P|P|\n"+
			 "1|R|N|B|Q|K|B|N|R|\n"+
			 "  a b c d e f g h";
		check(input,output);
	}
	
	/**
	 * Invalid checkmate again
	 */
	@Test public void testInvalidMisc_08() {
		String input =
			"d2-d4 e7-e5\n"+
			"d4-d5# Ke8-e7\n"+
			"";
		
		String output =
	 		 "8|r|n|b|q|k|b|n|r|\n"+
			 "7|p|p|p|p|_|p|p|p|\n"+
			 "6|_|_|_|_|_|_|_|_|\n"+
			 "5|_|_|_|_|p|_|_|_|\n"+
			 "4|_|_|_|P|_|_|_|_|\n"+
			 "3|_|_|_|_|_|_|_|_|\n"+
			 "2|P|P|P|_|P|P|P|P|\n"+
			 "1|R|N|B|Q|K|B|N|R|\n"+
			 "  a b c d e f g h";
		check(input,output);
	}
	

	
	

	
	

	// The following provides a simple helper method for all tests.
	public static void check(String input, String expectedOutput) {
		try {
			ChessGame game = new ChessGame(input);
			List<Board> boards = game.boards();
			if (boards.isEmpty()) {
				fail("test failed with insufficient boards on input: " + input);
			}
			String actualOutput = boards.get(boards.size() - 1).toString();
			assertEquals(expectedOutput, actualOutput);
		} catch (Exception e) {
			fail("test failed because of exception on input: " + input);
		}
	}
}
