/**   
 * @fileName TimerTaskLauncher.java
 * @package util
 * @copyright (c) 2014, sincerebravefight@gmail.com All Rights Reserved. 
 * @description TODO
 * @author sllx  
 * @date 2014-5-28 下午7:19:15
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-28 下午7:19:15
   * Why & What is modified
 * @version V1.0
 */
package util;

import java.util.Timer;


/**
 * @className TimerTaskLauncher
 * @description TODO
 * @author sllx
 * @date 2014-5-28 下午7:19:15
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-28 下午7:19:15
 * Why & What is modified
 */
public class TimerTaskLauncher {
	
	public void setTetrisTimerTask(TetrisTimerTask tetrisTimerTask){
		new Timer().schedule(tetrisTimerTask, 2000, 1000);
	}
}
