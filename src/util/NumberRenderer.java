/**   
 * @fileName NumberRenderer.java
 * @package com.sllx.tetris.ui
 * @copyright (c) 2014, sincerebravefight@gmail.com All Rights Reserved. 
 * @description TODO
 * @author sllx  
 * @date 2014-5-28 下午6:38:11
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-28 下午6:38:11
   * Why & What is modified
 * @version V1.0
 */
package util;

import java.awt.Graphics;
import java.awt.Image;

import com.sllx.tetris.ui.Img;

/**
 * @className NumberRenderer
 * @description TODO
 * @author sllx
 * @date 2014-5-28 下午6:38:11
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-28 下午6:38:11
 * Why & What is modified
 */
public abstract class NumberRenderer{
	
	
	/**
	 * @fields NUM : 数字图片
	 */
	private static final Image NUM = Img.NUMBER;
	
	/**
	 * @fields NUM_W : 每个数字宽度
	 */
	public static final int NUM_W = NUM.getWidth(null)/10;
	
	/**
	 * @fields NUM_H : 数字高度
	 */
	private static final int NUM_H = NUM.getHeight(null);
	

	/**
	 * @title drawLevel
	 * @description 绘制等级数字 
	 * @return void
	 * @param g    
	 */
	public static void drawNumber(Integer number, int x, int y, int max_num_length,Graphics g){
		char[] numArray = number.toString().toCharArray();
		//为了右对齐,先计算出需要在左侧空出的宽度
		int block = (max_num_length - numArray.length) * NUM_W;
		for(int i=0; i<numArray.length; i++){
			int num = numArray[i] - '0';
			int begin_x = calculateX(i, block, x);
			g.drawImage(NUM, begin_x, y, begin_x + NUM_W, y + NUM_H, num * NUM_W, 0, num * NUM_W + NUM_W, NUM_H, null);
		}
	}
	
	/**
	 * @title calculateX
	 * @description 计算起点X 
	 * @return int
	 * @param index
	 * @param numLength
	 * @return    
	 */
	private static int calculateX(int index, int block, int x){
		int begin = x + block + index * NUM_W;
		return begin;
	}
}
