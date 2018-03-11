package model;

public class Cell {
	public static final char ALIVE = '1';
	public static final char DEAD = '0';
	
	private int yPosition;
	private int xPosition;
	private char value;
	
	public Cell(int yPosition, int xPosition, char value) {
		this.yPosition = yPosition;
		this.xPosition = xPosition;
		this.value = value;
	}
	
	public char getValue () {
		return value;
	}
	
	public void setValue(char value) {
		this.value = value;
	}
	
	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public boolean isAlive() {
		return value == ALIVE;
	}
	
	public boolean isDead() {
		return !isAlive();
	}
	
}
