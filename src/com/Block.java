package com;

public class Block {
	
	public static final int BLOCK_SIZE = 100;
	
	int x;
	int y;
	
	public Block(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean isInside(int x2, int y2) {
		return (x <= x2 && x2 <= x + BLOCK_SIZE)
			 &&(y <= y2 && y2 <= y + BLOCK_SIZE);
	}
	
	public Direction getDirection(int oldX, int oldY) {
		if (oldX < x) {
			return Direction.LEFT;
		}
		if (x + BLOCK_SIZE - 1 < oldX) {
			return Direction.RIGHT;
		}
		if (oldY < y) {
			return Direction.TOP;
		}
		if (y + BLOCK_SIZE - 1 < oldY) {
			return Direction.BOTTOM;
		}
		return null;
	}
}
