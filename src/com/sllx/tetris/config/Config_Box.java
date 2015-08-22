/**   
 * @fileName Config_Box.java
 * @package com.sllx.tetris.config
 * @copyright (c) 2014, sincerebravefight@gmail.com All Rights Reserved. 
 * @description 展示功能区域的窗口配置
 * @author sllx  
 * @date 2014-5-9 下午1:48:04
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午1:48:04
   * Why & What is modified
 * @version V1.0
 */
package com.sllx.tetris.config;


/**
 * @className Config_Box
 * @description  展示功能区域的窗口配置
 * @author sllx
 * @date 2014-5-9 下午1:47:30
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午1:47:30
   * Why & What is modified
 */
public class Config_Box {
	
	/**
	 * @fields x : 左上角x坐标
	 * @fields x : 左上角y坐标
	 * @fields w : 宽度
	 * @fields h : 高度
	 */
	private int x, y, w, h;
	
	
	/**
	 * @fields className : 绘制窗口的类全名
	 */
	private String className;
	
	
	/**
	 * @title Config_Box
	 * @description 构造器
	 * @param className
	 * @param x
	 * @param y
	 * @param w
	 * @param h    
	 */
	Config_Box(String className, int x, int y, int w, int h){
		this.className = className;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return the w
	 */
	public int getW() {
		return w;
	}

	/**
	 * @return the h
	 */
	public int getH() {
		return h;
	}
}
