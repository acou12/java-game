package com;

import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class MainClass extends PApplet{

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
    }
    
    @Override
    public void draw() {
    	background(0);
    	if (wPressed) {
    		p.y-=p.speed;
    	}
    	if (aPressed) {
    		p.x-=p.speed;
    	}
    	if (sPressed) {
    		p.y+=p.speed;
    	}
    	if (dPressed) {
    		p.x+=p.speed;
    	}
    	rect(p.x, p.y, 50, 50);
    }
    
    @Override
    public void mouseClicked(MouseEvent event) {
    	
    }
    
    @Override
    public void keyPressed(KeyEvent event) {
    	switch (event.getKey()) {
    		case 'w': {
    			wPressed = true;
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