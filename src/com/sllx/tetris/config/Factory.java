/**   
 * @fileName Factory.java
 * @package com.sllx.tetris.config
 * @copyright (c) 2014, sincerebravefight@gmail.com All Rights Reserved. 
 * @description 配置工厂
 * @author sllx  
 * @date 2014-5-9 下午1:48:04
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午1:48:04
   * Why & What is modified
 * @version V1.0
 */
package com.sllx.tetris.config;


/**
 * @className Factory
 * @description 配置工厂
 * @author sllx
 * @date 2014-5-9 下午2:16:30
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午2:16:30
   * Why & What is modified
 */
public class Factory {
	
	/**
	 * @fields config : 总配置对象
	 */
	private static Config config;
	
	static{
		config = new Reader().getConfig();
	}
	
	
	/**
	 * @return the config
	 */
	public static Config getConfig(){
		return config;
	}
}
