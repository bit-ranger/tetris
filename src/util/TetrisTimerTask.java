/**   
 * @fileName TetrisTimer.java
 * @package util
 * @copyright (c) 2014, sincerebravefight@gmail.com All Rights Reserved. 
 * @description TODO
 * @author sllx  
 * @date 2014-5-22 下午10:41:21
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-22 下午10:41:21
   * Why & What is modified
 * @version V1.0
 */
package util;

import java.util.TimerTask;

import com.sllx.tetris.control.GameController;

/**
 * @className TetrisTimer
 * @description 定时器
 * @author sllx
 * @date 2014-5-22 下午10:41:21
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-22 下午10:41:21
 * Why & What is modified
 */
public class TetrisTimerTask extends TimerTask{
	
	private GameController gameController;
	
	
	
	/**
	 * @param gameController the gameController to set
	 */
	public void setGameController(GameController gameController) {
		this.gameController = gameController;
	}



	/* (non-Javadoc)
	 * description 
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		gameController.moveDown();
	}
	
}
