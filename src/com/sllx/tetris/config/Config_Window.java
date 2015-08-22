/**   
 * @fileName Config_Window.java
 * @package com.sllx.tetris.config
 * @copyright (c) 2014, sincerebravefight@gmail.com All Rights Reserved. 
 * @description 游戏窗口配置
 * @author sllx  
 * @date 2014-5-9 下午1:48:04
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午1:48:04
   * Why & What is modified
 * @version V1.0
 */
package com.sllx.tetris.config;

import java.util.ArrayList;
import java.util.List;



/**
 * @className Config_Window
 * @description 游戏窗口配置
 * @author sllx
 * @date 2014-5-9 下午1:50:14
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午1:50:14
   * Why & What is modified
 */
public class Config_Window {
	
	/**
	 * @fields title : 标题
	 */
	private String title;
	
	
	/**
	 * @fields w : 宽度
	 * @fields h : 高度
	 * @fields box_padding : box内边距
	 * @fields windowUp : 窗口拔高
	 */
	private int w,h,box_padding,windowUp;
	
	/**
	 * @fields boxes : 窗口内包含的box配置
	 */
	private List<Config_Box> boxes;
	

	/**
	 * @title Config_Window
	 * @description 构造器
	 * @param title
	 * @param w
	 * @param h
	 * @param windowUp
	 * @param box_padding    
	 */
	Config_Window(String title, int w, int h, int windowUp, int box_padding){
		this.title = title;
		this.w = w;
		this.h = h;
		this.windowUp = windowUp;
		this.box_padding = box_padding;
		boxes = new ArrayList<Config_Box>();
	}
	
	

	/**
	 * @title add
	 * @description 添加一个Box配置 
	 * @return void
	 * @param boxConfig    
	 */
	void add(Config_Box boxConfig){
		boxes.add(boxConfig);
	}
	
	
	
	/**
	 * @title getTitle
	 * @description TODO 
	 * @return String
	 * @return    
	 */
	public String getTitle() {
		return title;
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
	
	/**
	 * @return the box_padding
	 */
	public int getBox_padding() {
		return box_padding;
	}

	/**
	 * @return the windowUp
	 */
	public int getWindowUp() {
		return windowUp;
	}
	
	/**
	 * @return the boxes
	 */
	public List<Config_Box> getBoxes() {
		return boxes;
	}
	
}
