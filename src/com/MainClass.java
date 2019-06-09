package com;

import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class MainClass extends PApplet{

	public static final int WALK_SPEED = 15;
	public static final int GRAVITY = 1;
	public static final int JUMP_HEIGHT = 25;
	
	Player p = new Player();

	boolean wPressed = false;
	boolean aPressed = false;
	boolean sPressed = false;
	boolean dPressed = false;
	
    @Override
    public void settings() {
        fullScreen();
    }

    @Override
    public void setup() {
    	p.x = 0;
    	p.y = 0;
    	p.xv = 0;
    	p.yv = 0;
    }
    
    @Override
    public void draw() {
    	background(0);
    	if (aPressed) {
    		p.x -= WALK_SPEED;
    	}
    	if (dPressed) {
    		p.x += WALK_SPEED;
    	}
    	p.yv -= GRAVITY;
    	p.y -= p.yv;
    	if (p.y > height) {
    		p.y = height;
    		p.yv = 0;
    		p.canJump = true;
    	}
    	rect(p.x, p.y - 50, 50, 50);
    }
    
    @Override
    public void mouseClicked(MouseEvent event) {
    	
    }
    
    @Override
    public void keyPressed(KeyEvent event) {
    	switch (event.getKey()) {
    		case 'w': {
    			wPressed = true;
    			
    			if (p.canJump) {
    				p.canJump = false;
    				p.yv = JUMP_HEIGHT;
    			}
    			
    			break;
    		}
    		case 'a': {
    			aPressed = true;
    			break;
    		}
    		case 's': {
    			sPressed = true;
    			break;
    		}
    		case 'd': {
    			dPressed = true;
    			break;
    		}
    	}
    }
    
    @Override
    public void keyReleased(KeyEvent event) {
    	switch (event.getKey()) {
    		case 'w': {
    			wPressed = false;
    			break;
    		}
    		case 'a': {
    			aPressed = false;
    			break;
    		}
    		case 's': {
    			sPressed = false;
    			break;
    		}
    		case 'd': {
    			dPressed = false;
    			break;
    		}
    	}
    }

    
    public static void main (String... args) {
    	MainClass pt = new MainClass();
        PApplet.runSketch(new String[]{"ProcessingTest"}, pt);
    }
}