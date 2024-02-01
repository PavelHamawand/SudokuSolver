package Sudoku;

import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SudokoTest extends Sudoku {
	private Sudoku sudoku;
	
	@BeforeEach
	void setUp() throws Exception {
		sudoku = new Sudoku();
	}

	@AfterEach
	void tearDown() throws Exception {
		sudoku = null;
	}

	/**
	 * Test if a newly created sudoku is solvable.
	 */
	@Test
	void testEmptyBoard() {
	    Sudoku sudoku = new Sudoku();
	    int[][] emptyBoard = new int[9][9];
	    sudoku.setBoard(emptyBoard);
	    assertTrue(sudoku.solve());
	}
	
	@Test
	void testSolve() {
		//Lösbart sudoku
		int[][] board = {
			{ 8, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 3, 6, 0, 0, 0, 0, 0 },
			{ 0, 7, 0, 0, 9, 0, 2, 0, 0 },
			{ 0, 5, 0, 0, 0, 7, 0, 0, 0 },
			{ 0, 0, 0, 0, 4, 5, 7, 0, 0 },
			{ 0, 0, 0, 1, 0, 0, 0, 3, 0 },
			{ 0, 0, 1, 0, 0, 0, 0, 6, 8 },
			{ 0, 0, 8, 5, 0, 0, 0, 1, 0 },
			{ 0, 9, 0, 0, 0, 0, 4, 0, 0 } 
		  };
		  //lösbart sudoku från figur1 i handledning
		  sudoku.setBoard(board);
		  assertTrue(sudoku.solve());
		  int[][] board2 = {
			{ 1, 2, 3, 0, 0, 0, 0, 0, 0 },
			{ 4, 5, 6, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 7, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } 
		  };
		  sudoku.setBoard(board2);
		  assertFalse(sudoku.solve());

		  //olösbart sudoku
		  int[][] board3 = {
			{ 8, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 3, 6, 0, 0, 0, 0, 0 },
			{ 0, 7, 0, 0, 9, 0, 2, 0, 0 },
			{ 0, 5, 0, 6, 0, 7, 0, 0, 0 },
			{ 0, 0, 0, 0, 4, 5, 7, 0, 0 },
			{ 0, 0, 0, 1, 0, 0, 0, 3, 0 },
			{ 0, 0, 1, 0, 0, 0, 0, 6, 8 },
			{ 0, 0, 8, 5, 0, 0, 0, 1, 0 },
			{ 0, 9, 0, 0, 0, 0, 4, 0, 0 } 
		  };

		  sudoku.setBoard(board3);
		  assertFalse(sudoku.solve());
	}

	/** Test Legal */
	@Test
	void testLegal() {
	int[][] board = {
			{ 8, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 3, 6, 0, 0, 0, 0, 0 },
			{ 0, 7, 0, 0, 9, 0, 2, 0, 0 },
			{ 0, 5, 0, 0, 0, 7, 0, 0, 0 },
			{ 0, 0, 0, 0, 4, 5, 7, 0, 0 },
			{ 0, 0, 0, 1, 0, 0, 0, 3, 0 },
			{ 0, 0, 1, 0, 0, 0, 0, 6, 8 },
			{ 0, 0, 8, 5, 0, 0, 0, 1, 0 },
			{ 0, 9, 0, 0, 0, 0, 4, 0, 0 } 
		  };

		sudoku.setBoard(board);

		//*Testar med 8 i samma rad
		assertFalse(sudoku.isLegal(0,3,8), "Wrong legal in row");
		//*Testar med 8 i samma col
		assertFalse(sudoku.isLegal(2,0,8), "Wrong legal in col");
		//*Testar med 8 i samma region
		assertFalse(sudoku.isLegal(2,2,8), "Wrong legal in region");

		
	}

}
