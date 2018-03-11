package test.java;

import static org.junit.Assert.*;
import model.Cell;
import model.GameBoard;

import org.junit.Test;

public class GameOfLifeTest {


// test initialization of board
	// test initialization of board 1x1
	@Test
	public void testInitializationOfBoard1X1() {
		String input = "1";
		GameBoard gameBoard = new GameBoard(input);
		assertEquals (input, gameBoard.getBoardAsString());
	}
	
	// test initialization of board 2x2
	@Test
	public void testInitializationOfBoard2X2() {
		String input = "1010";
		GameBoard gameBoard = new GameBoard(input);
		assertEquals (input, gameBoard.getBoardAsString());
	}
	
	// test initialization of board 4x4
	@Test
	public void testInitializationOfBoard4X4() {
		String input = "1010010100001111";
		GameBoard gameBoard = new GameBoard(input);
		assertEquals (input, gameBoard.getBoardAsString());
	}

	
// test get horizontal adjacent cells
	
	// test get horizontal cells 1x1
	@Test
	public void testGetHorizontalCellsFor1x1() {
		String input = "1";
		GameBoard gameBoard = new GameBoard(input);
		Cell cell = new Cell (0, 0, '1');
		assertEquals ("", gameBoard.getCellsAsString(gameBoard.getHorizontalAdjacentCells(cell)));
	}
	
	// test get horizontal cells 2x2
	@Test
	public void testGetHorizontalCellsFor2x2_LeftMostPosition() {
		String input = "1010";
		GameBoard gameBoard = new GameBoard(input);
		Cell cell = new Cell (0, 0, '1');
		assertEquals ("0", gameBoard.getCellsAsString(gameBoard.getHorizontalAdjacentCells(cell)));
	}
	
	// test get horizontal cells 4x4
	@Test
	public void testGetHorizontalCellsFor4x4_MiddlePosition() {
		String input = "1010010100001111";
		GameBoard gameBoard = new GameBoard(input);
		Cell cell = new Cell (0, 1, '0');
		assertEquals ("11", gameBoard.getCellsAsString(gameBoard.getHorizontalAdjacentCells(cell)));
	}
	
	// test get horizontal cells 4x4
	@Test
	public void testGetHorizontalCellsFor4x4_MiddlePosition2() {
		String input = "1010010100001111";
		GameBoard gameBoard = new GameBoard(input);
		Cell cell = new Cell (0, 2, '1');
		assertEquals ("00", gameBoard.getCellsAsString(gameBoard.getHorizontalAdjacentCells(cell)));
	}

	// test get horizontal cells 4x4
	@Test
	public void testGetHorizontalCellsFor4x4_RightMostPosition() {
		String input = "1010010100001111";
		GameBoard gameBoard = new GameBoard(input);
		Cell cell = new Cell (0, 3, '0');
		assertEquals ("1", gameBoard.getCellsAsString(gameBoard.getHorizontalAdjacentCells(cell)));
	}

// test get vertical adjacent cells
	
	// test get vertical cells 1x1
	@Test
	public void testGetVerticalCellsFor1x1() {
		String input = "1";
		GameBoard gameBoard = new GameBoard(input);
		Cell cell = new Cell (0, 0, '1');
		assertEquals ("", gameBoard.getCellsAsString(gameBoard.getVerticalAdjacentCells(cell)));
	}

	// test get vertical cells 2x2
	@Test
	public void testGetVerticalCellsFor2x2() {
		String input = "1010";
		GameBoard gameBoard = new GameBoard(input);
		Cell cell = new Cell (0, 0, '1');
		assertEquals ("1", gameBoard.getCellsAsString(gameBoard.getVerticalAdjacentCells(cell)));
	}
	
	// test get vertical cells 4x4
	@Test
	public void testGetVerticalCellsFor4x4_MiddlePosition() {
		String input = "1010010100001111";
		GameBoard gameBoard = new GameBoard(input);
		Cell cell = new Cell (1, 0, '0');
		assertEquals ("10", gameBoard.getCellsAsString(gameBoard.getVerticalAdjacentCells(cell)));
	}
	
	// test get Vertical cells 4x4
	@Test
	public void testGetVerticalCellsFor4x4_MiddlePosition2() {
		String input = "1010010100001111";
		GameBoard gameBoard = new GameBoard(input);
		Cell cell = new Cell (2, 0, '0');
		assertEquals ("01", gameBoard.getCellsAsString(gameBoard.getVerticalAdjacentCells(cell)));
	}
	
	// test get Vertical cells 4x4
	@Test
	public void testGetVerticalCellsFor4x4_BottomMostPosition() {
		String input = "1010010100001111";
		GameBoard gameBoard = new GameBoard(input);
		Cell cell = new Cell (3, 0, '1');
		assertEquals ("0", gameBoard.getCellsAsString(gameBoard.getVerticalAdjacentCells(cell)));
	}

	
// test get diagonal adjacent cells
	
	// test get Diagonal cells 1x1
	@Test
	public void testGetDiagonalCellsFor1x1() {
		String input = "1";
		GameBoard gameBoard = new GameBoard(input);
		Cell cell = new Cell (0, 0, '1');
		assertEquals ("", gameBoard.getCellsAsString(gameBoard.getDiagonalAdjacentCells(cell)));
	}
	
	// test get Diagonal cells 2x2
	@Test
	public void testGetDiagonalCellsFor2x2() {
		String input = "1010";
		GameBoard gameBoard = new GameBoard(input);
		Cell cell = new Cell (0, 0, '1');
		assertEquals ("0", gameBoard.getCellsAsString(gameBoard.getDiagonalAdjacentCells(cell)));
	}
	
	// test get Diagonal cells 4x4
	@Test
	public void testGetDiagonalCellsFor4x4_MiddlePosition() {
		String input = "1010010100001111";
		GameBoard gameBoard = new GameBoard(input);
		Cell cell = new Cell (1, 1, '1');
		assertEquals ("1100", gameBoard.getCellsAsString(gameBoard.getDiagonalAdjacentCells(cell)));
	}
	
	// test get Diagonal cells 4x4
	@Test
	public void testGetDiagonalCellsFor4x4_MiddlePosition2() {
		String input = "1010010100001111";
		GameBoard gameBoard = new GameBoard(input);
		Cell cell = new Cell (2, 2, '0');
		assertEquals ("1111", gameBoard.getCellsAsString(gameBoard.getDiagonalAdjacentCells(cell)));
	}
	
	// test get Diagonal cells 4x4
	@Test
	public void testGetDiagonalCellsFor4x4_BottomMostPosition() {
		String input = "1010010100001111";
		GameBoard gameBoard = new GameBoard(input);
		Cell cell = new Cell (3, 0, '1');
		assertEquals ("0", gameBoard.getCellsAsString(gameBoard.getDiagonalAdjacentCells(cell)));
	}

	// test get Diagonal cells 4x4
	@Test
	public void testGetDiagonalCellsFor4x4_BottomMostPosition2() {
		String input = "1010010100001111";
		GameBoard gameBoard = new GameBoard(input);
		Cell cell = new Cell (3, 3, '1');
		assertEquals ("0", gameBoard.getCellsAsString(gameBoard.getDiagonalAdjacentCells(cell)));
	}
	
// test next state of a cell
	
	// test alive cell to dead underpopulation for 1x1
	@Test
	public void testAliveToDeadFor1x1() {
		String input = "1";
		GameBoard gameBoard = new GameBoard(input);
		Cell cell = new Cell (0, 0, '1');
		assertEquals ('0', gameBoard.getNextState(cell));
	}
	
	// test alive cell to dead underpopulation for 1x1
	@Test
	public void testAliveToDeadFor2x2() {
		String input = "1010";
		GameBoard gameBoard = new GameBoard(input);
		Cell cell = new Cell (0, 0, '1');
		assertEquals ('0', gameBoard.getNextState(cell));
	}
	
	// test alive cell to alive within population for 2x2
	@Test
	public void testAliveToAliveFor2x2() {
		String input = "1111";
		GameBoard gameBoard = new GameBoard(input);
		Cell cell = new Cell (0, 0, '1');
		assertEquals ('1', gameBoard.getNextState(cell));
	}
	
	// test alive cell to dead within population for 4x4
	@Test
	public void testAliveToDeadOverPopulationFor4x4() {
		String input = "1111111111111111";
		GameBoard gameBoard = new GameBoard(input);
		Cell cell = new Cell (1, 1, '1');
		assertEquals ('0', gameBoard.getNextState(cell));
	}

	// test alive cell to dead within population for 4x4
	@Test
	public void testAliveToDeadUnderPopulationFor4x4_2() {
		String input = "1010010100001111";
		GameBoard gameBoard = new GameBoard(input);
		Cell cell = new Cell (0, 0, '1');
		assertEquals ('0', gameBoard.getNextState(cell));
	}
	
// test tick
	
	// test next tick for 1x1
	@Test
	public void testNextTickFor1x1() {
		String input = "1";
		GameBoard gameBoard = new GameBoard(input);
		assertEquals ("0", gameBoard.getNextBoard());
	}

	// test next tick for 2x2
	@Test
	public void testNextTickFor2x2() {
		String input = "0000";
		GameBoard gameBoard = new GameBoard(input);
		assertEquals ("1000", gameBoard.getNextBoard());
	}

	// test next tick for 2x2
	@Test
	public void testNextTickFor2x2_2() {
		String input = "1000";
		GameBoard gameBoard = new GameBoard(input);
		assertEquals ("0100", gameBoard.getNextBoard());
	}
	
	// test next tick for 2x2
	@Test
	public void testNextTickFor2x2_3() {
		String input = "0100";
		GameBoard gameBoard = new GameBoard(input);
		assertEquals ("0010", gameBoard.getNextBoard());
	}
	
	// test next tick for 2x2
	@Test
	public void testNextTickFor2x2_4() {
		String input = "0010";
		GameBoard gameBoard = new GameBoard(input);
		assertEquals ("0001", gameBoard.getNextBoard());
	}
	
	// test next tick for 2x2
	@Test
	public void testNextTickFor2x2_5() {
		String input = "0001";
		GameBoard gameBoard = new GameBoard(input);
		assertEquals ("0000", gameBoard.getNextBoard());
	}
	
	// test next tick for 4x4
	@Test
	public void testNextTickFor4x4() {
		String input = "1010010100001111";
		GameBoard gameBoard = new GameBoard(input);
		assertEquals ("0110110001101011", gameBoard.getNextBoard());
	}
}
