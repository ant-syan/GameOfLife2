package model;

import java.util.ArrayList;

public class GameBoard {
	private Cell board[][];
	private int boardLength;
	public static final int MINIMUM_POSITION = 0;
	public static final int UNDER_POPULATED_BORDERLINE = 2;
	public static final int OVER_POPULATED_BORDERLINE = 3;
	public static final int REPRODUCTION_BORDERLINE = 3;
	
	public GameBoard(String board) {
		boardLength = (int) Math.sqrt(board.length());
		this.board = new Cell[boardLength][boardLength];
		initializeBoard (board);
	}
	
	public void initializeBoard (String board) {
		int stringPosition = 0;
		for (int vertical = 0; vertical < boardLength; vertical++) {
			for (int horizontal = 0; horizontal < boardLength; horizontal++) {
				this.board[vertical][horizontal] = new Cell (vertical, horizontal, board.charAt(stringPosition));
				stringPosition++;
			}
		}
	}
	
	public String getBoardAsString() {
		String boardString = "";
		for (int vertical = 0; vertical < boardLength; vertical++) {
			for (int horizontal = 0; horizontal < boardLength; horizontal++) {
				boardString+= board[vertical][horizontal].getValue();
			}
		}
		return boardString;
	}
	
	public String getCellsAsString(ArrayList<Cell> cells) {
		String boardString = "";
		for (Cell cell : cells) {
			boardString += cell.getValue();
		}
		return boardString;
	}
	
	public boolean isMinimumPositionExisting (int position) {
		return position >= MINIMUM_POSITION;
	}
	
	public boolean isMaximumPositionExisting (int position) {
		return position < boardLength;
	}
	
	public void addLeftAdjacentCells (int yPosition, int leftPosition, ArrayList<Cell> cells) {
		if (isMinimumPositionExisting(leftPosition)) {
			cells.add(board[yPosition][leftPosition]);
		}
	}
	
	public void addRightAdjacentCells (int yPosition, int rightPosition, ArrayList<Cell> cells) {
		if (isMaximumPositionExisting(rightPosition)) {
			cells.add(board[yPosition][rightPosition]);
		}
	}
	
	public ArrayList<Cell> getHorizontalAdjacentCells (Cell targetCell) {
		ArrayList<Cell> cells = new ArrayList<Cell>();
		int xPosition = targetCell.getxPosition();
		int leftPosition = xPosition - 1;
		int rightPosition = xPosition + 1;
		addLeftAdjacentCells(targetCell.getyPosition(), leftPosition, cells);
		addRightAdjacentCells(targetCell.getyPosition(), rightPosition, cells);
		return cells;
	}
	
	public void addTopAdjacentCells (int topPosition, int xPosition, ArrayList<Cell> cells) {
		if (isMinimumPositionExisting(topPosition)) {
			cells.add(board[topPosition][xPosition]);
		}
	}
	
	public void addBottomAdjacentCells (int bottomPosition, int xPosition, ArrayList<Cell> cells) {
		if (isMaximumPositionExisting(bottomPosition)) {
			cells.add(board[bottomPosition][xPosition]);
		}
	}
	
	public ArrayList<Cell> getVerticalAdjacentCells (Cell targetCell) {
		ArrayList<Cell> cells = new ArrayList<Cell>();
		int yPosition = targetCell.getyPosition();
		int topPosition = yPosition - 1;
		int bottomPosition = yPosition + 1;
		addTopAdjacentCells (topPosition, targetCell.getxPosition(), cells);
		addBottomAdjacentCells (bottomPosition, targetCell.getxPosition(), cells);
		return cells;
	}

	public ArrayList<Cell> getDiagonalAdjacentCells (Cell targetCell) {
		ArrayList<Cell> cells = new ArrayList<Cell>();
		int xPosition = targetCell.getxPosition();
		int yPosition = targetCell.getyPosition();
		int leftPosition = xPosition - 1;
		int rightPosition = xPosition + 1;
		int topPosition = yPosition - 1;
		int bottomPosition = yPosition + 1;
		if (isMinimumPositionExisting(topPosition)) {
			addLeftAdjacentCells(topPosition, leftPosition, cells);
			addRightAdjacentCells(topPosition, rightPosition, cells);
		}
		if (isMaximumPositionExisting(bottomPosition)) {
			addLeftAdjacentCells(bottomPosition, leftPosition, cells);
			addRightAdjacentCells(bottomPosition, rightPosition, cells);
		}
		return cells;
	}

	public char getNextState(Cell cell) {
		ArrayList<Cell> cells = new ArrayList<Cell>();
		cells.addAll(getHorizontalAdjacentCells(cell));
		cells.addAll(getVerticalAdjacentCells(cell));
		cells.addAll(getDiagonalAdjacentCells(cell));
		
		if (isUnderPopulated(cell, cells) || isOverPopulated(cell, cells)) {
			return Cell.DEAD;
		}
		if (isForReproduction(cell, cells)) {
			return Cell.ALIVE;
		}
		return cell.getValue();
	}
	
	public boolean isUnderPopulated (Cell cell, ArrayList<Cell> cells) {
		if (cell.isDead()) {
			return false;
		}
		return getNumberOfAliveCells(cells) < UNDER_POPULATED_BORDERLINE;
	}
	
	public boolean isOverPopulated (Cell cell, ArrayList<Cell> cells) {
		if (cell.isDead()) {
			return false;
		}
		return getNumberOfAliveCells(cells) > OVER_POPULATED_BORDERLINE;
	}
	
	public boolean isForReproduction (Cell cell, ArrayList<Cell> cells) {
		if (cell.isAlive()) {
			return false;
		}
		return getNumberOfDeadCells(cells) == REPRODUCTION_BORDERLINE;
	}
	
	public int getNumberOfAliveCells (ArrayList<Cell> cells) {
		return getNumberOfCellsBasedOnState (cells, Cell.ALIVE);
	}
	
	public int getNumberOfDeadCells (ArrayList<Cell> cells) {
		return getNumberOfCellsBasedOnState (cells, Cell.DEAD);
	}
	
	public int getNumberOfCellsBasedOnState (ArrayList<Cell> cells, char state) {
		int cellsCount = 0;
		for (Cell tempCell : cells) {
			if (tempCell.getValue() == state) {
				cellsCount++;
			}
		}
		return cellsCount;
	}
	
	public void tick() {
		for (int vertical = 0; vertical < boardLength; vertical++) {
			for (int horizontal = 0; horizontal < boardLength; horizontal++) {
				board[vertical][horizontal].setValue(getNextState(board[vertical][horizontal]));
			}
		}
	}

	public String getNextBoard() {
		tick();
		return getBoardAsString();
	}

}
