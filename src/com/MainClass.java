package com;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class MainClass extends PApplet{

	public static final int WALK_SPEED = 15;
	public static final int GRAVITY = 1;
	public static final int JUMP_HEIGHT = 25;
	
	ArrayList<Block> blocks = new ArrayList<Block>();
	
	Player p = new Player();

	boolean wPressed = false;
	boolean aPressed = false;
	boolean sPressed = false;
	boolean dPressed = false;
	boolean shPressed = false;
	
    @Override
    public void settings() {
        size(1080, 720);
    }

    @Override
    public void setup() {
    	p.x = 0;
    	p.y = 0;
    	p.xv = 0;
    	p.yv = 0;
    }
    
    int oldX;
    int oldY;
    
    @Override
    public void draw() {
    	background(0);
    	
    	for (Block b : blocks) {
    		fill(255);
    		rect(b.x, b.y, Block.BLOCK_SIZE, Block.BLOCK_SIZE);
    	}
    	
    	oldX = p.x;
    	oldY = p.y;
    	
    	double c = shPressed ? 0.3 : 1.0;
    	
    	if (aPressed) {
    		p.x -= WALK_SPEED * c;
    	}
    	if (dPressed) {
    		p.x += WALK_SPEED * c;
    	}
    	p.yv -= GRAVITY;
    	p.y -= p.yv;
    	if (p.y > height) {
    		p.y = height;
    		p.yv = 0;
    		p.canJump = true;
    	}
    	
    	for (Block b : blocks) {
    		if (b.isInside(p.x, p.y)) {
    			Direction d = b.getDirection(oldX, oldY);
    			if (d == Direction.LEFT) {
    				p.x = b.x-1;
    				p.xv = 0;
    			} else if (d == Direction.RIGHT) {
    				p.x = b.x + Block.BLOCK_SIZE;
    				p.xv = 0;
    			} else if (d == Direction.TOP) {
    				p.y = b.y-1;
    				p.yv = 0;
    				p.canJump = true;
    			} else if (d == Direction.BOTTOM) {
    				p.y = b.y + Block.BLOCK_SIZE;
    				p.yv = 0;
    			}
    		}
    	}
    	
    	rect(p.x - 25, p.y - 50, 50, 50);
    }
    
    @Override
    public void mouseClicked(MouseEvent event) {
    	if (event.getButton() == RIGHT) {
    		blocks.add(new Block(mouseX, mouseY));
    	}
    }
    
    @Override
    public void keyPressed(KeyEvent event) {
    	switch (event.getKey()) {
    		case 'W':
    		case 'w': {
    			wPressed = true;
    			
    			if (p.canJump) {
    				p.canJump = false;
    				p.yv = JUMP_HEIGHT;
    			}
    			
    			break;
    		}
    		case 'A':
    		case 'a': {
    			aPressed = true;
    			break;
    		}
    		case 'S':
    		case 's': {
    			sPressed = true;
    			break;
    		}
    		case 'D':
    		case 'd': {
    			dPressed = true;
    			break;
    		}
    	}
    	if (keyCode == SHIFT) {
    		shPressed = true;
    	}
    }
    
    @Override
    public void keyReleased(KeyEvent event) {
    	switch (event.getKey()) {
    		case 'W':
    		case 'w': {
    			wPressed = false;
    			break;
    		}
    		case 'A':
    		case 'a': {
    			aPressed = false;
    			break;
    		}
    		case 'S':
    		case 's': {
    			sPressed = false;
    			break;
    		}
    		case 'D':
    		case 'd': {
    			dPressed = false;
    			break;
    		}
    	}
    	if (keyCode == SHIFT) {
    		shPressed = false;
    	}
    }

    
    public static void main (String... args) {
    	MainClass pt = new MainClass();
        PApplet.runSketch(new String[]{"ProcessingTest"}, pt);
    }
}