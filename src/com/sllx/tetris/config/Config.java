/**   
 * @fileName Config.java
 * @package com.sllx.tetris.config
 * @copyright (c) 2014, sincerebravefight@gmail.com All Rights Reserved. 
 * @description 总配置
 * @author sllx  
 * @date 2014-5-9 下午1:48:04
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午1:48:04
   * Why & What is modified
 * @version V1.0
 */
package com.sllx.tetris.config;


/**
 * @className Config
 * @description 总配置
 * @author sllx
 * @date 2014-5-9 下午1:56:39
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午1:56:39
   * Why & What is modified
 */
public class Config {
	
	/**
	 * @fields window : 子配置--窗口配置
	 */
	private Config_Window window;
	

	/**
	 * @return the window
	 */
	public Config_Window getWindow() {
		return window;
	}

	/**
	 * @param window the window to set
	 */
	void setWindow(Config_Window window) {
		this.window = window;
	}
	

	
	
}
