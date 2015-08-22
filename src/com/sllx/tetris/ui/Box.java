/**   
 * @fileName Box_Button.java
 * @package com.sllx.tetris.config
 * @copyright (c) 2014, sincerebravefight@gmail.com All Rights Reserved. 
 * @description 所有功能区域的基类
 * @author sllx  
 * @date 2014-5-9 下午1:48:04
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午1:48:04
   * Why & What is modified
 * @version V1.0
 */
package com.sllx.tetris.ui;

import java.awt.Graphics;
import java.awt.Image;
import com.sllx.tetris.config.Factory;
import com.sllx.tetris.dto.DTO;



/**
 * @className Box
 * @description 所有功能区域的基类
 * @author sllx
 * @date 2014-5-9 下午2:31:49
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午2:31:49
   * Why & What is modified
 */
abstract class Box {
	
	/**
	 * @fields x : 左上角x坐标
	 * @fields y : 左上角y坐标
	 * @fields w : 宽度
	 * @fields h : 高度
	 */
	protected int x, y, w, h;
	
	
	/**
	 * @title Box
	 * @description 构造器 
	 * @param x
	 * @param y
	 * @param w
	 * @param h    
	 */
	protected Box(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	
	/**
	 * @fields PADDING : 内边距
	 */
	protected final static int PADDING = Factory.getConfig().getWindow().getBox_padding();
	
	/**
	 * @fields BORDER : 边框宽度
	 */
	protected final static int BORDER = 7;
	
	
	/**
	 * @fields IMG_FRAME : 边框图片
	 */
	private final static Image IMG_FRAME = Img.FRAME;
	
	
	/**
	 * @fields IMG_FRAME_W : 边框图片宽度
	 */
	private final static int IMG_FRAME_W = IMG_FRAME.getWidth(null);
	
	
	/**
	 * @fields IMG_FRAME_H : 边框图片高度
	 */
	private final static int IMG_FRAME_H = IMG_FRAME.getHeight(null);
	
	protected DTO dto;
	

	/**
	 * @title createWindow
	 * @description 绘制
	 * @return void
	 * @param g    
	 */
	protected void createWindow(Graphics g){
		//左上
		g.drawImage(IMG_FRAME, x, y, x+BORDER, y+BORDER, 0, 0, BORDER, BORDER, null);
		//中上
		g.drawImage(IMG_FRAME, x+BORDER, y, x+w-BORDER, y+BORDER, BORDER, 0, IMG_FRAME_W-BORDER, BORDER, null);
		//右上
		g.drawImage(IMG_FRAME, x+w-BORDER, y, x+w, y+BORDER, IMG_FRAME_W-BORDER, 0, IMG_FRAME_W, BORDER, null);
		//左中
		g.drawImage(IMG_FRAME, x, y+BORDER, x+BORDER, y+h-BORDER, 0, BORDER, BORDER, IMG_FRAME_H-BORDER, null);
		//中
		g.drawImage(IMG_FRAME, x+BORDER, y+BORDER, x+w-BORDER, y+h-BORDER, BORDER, BORDER, IMG_FRAME_W-BORDER, IMG_FRAME_H-BORDER, null);
		//右中
		g.drawImage(IMG_FRAME, x+w-BORDER, y+BORDER, x+w, y+h-BORDER, IMG_FRAME_W-BORDER, BORDER, IMG_FRAME_W, IMG_FRAME_H-BORDER, null);
		//左下
		g.drawImage(IMG_FRAME, x, y+h-BORDER, x+BORDER, y+h, 0, IMG_FRAME_H-BORDER, BORDER, IMG_FRAME_H, null);
		//中下
		g.drawImage(IMG_FRAME, x+BORDER, y+h-BORDER, x+w-BORDER, y+h, BORDER, IMG_FRAME_H-BORDER, IMG_FRAME_W-BORDER, IMG_FRAME_H, null);
		//右下
		g.drawImage(IMG_FRAME, x+w-BORDER, y+h-BORDER, x+w, y+h, IMG_FRAME_W-BORDER, IMG_FRAME_H-BORDER, IMG_FRAME_W, IMG_FRAME_H, null);
	}
	
	/**
	 * @title paint
	 * @description 抽象方法 
	 * @return void
	 * @param g    
	 */
	protected abstract void paint(Graphics g);
	
	
	
}
