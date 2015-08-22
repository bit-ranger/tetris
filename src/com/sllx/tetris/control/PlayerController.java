/**
 * 
 */
package com.sllx.tetris.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author sllx
 *
 */
public class PlayerController extends KeyAdapter{
	private GameController gameController;
	
	
	/**
	 * @param gameController the gameController to set
	 */
	public void setGameController(GameController gameController) {
		this.gameController = gameController;
	}


	@Override
	public void keyPressed(KeyEvent keyevent) {
		//TODO
		switch (keyevent.getKeyCode()) {
		
		case KeyEvent.VK_W:
			gameController.transform();
			break;
		case KeyEvent.VK_UP:
			gameController.transform();
			break;
			
		case KeyEvent.VK_S:
			gameController.moveDown();
			break;
		case KeyEvent.VK_DOWN:
			gameController.moveDown();
			break;
			
		case KeyEvent.VK_A:
			gameController.moveLeft();
			break;
		case KeyEvent.VK_LEFT:
			gameController.moveLeft();
			break;
			
		case KeyEvent.VK_D:
			gameController.moveRight();
			break;
		case KeyEvent.VK_RIGHT:
			gameController.moveRight();
			break;
			
		default:
			break;
		}
	}
	
}
