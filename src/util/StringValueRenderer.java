/**   
 * @fileName StringValueRenderer.java
 * @package com.sllx.tetris.ui
 * @copyright (c) 2014, sincerebravefight@gmail.com All Rights Reserved. 
 * @description TODO
 * @author sllx  
 * @date 2014-5-28 下午6:40:12
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-28 下午6:40:12
   * Why & What is modified
 * @version V1.0
 */
package util;

import java.awt.Graphics;
import java.awt.Image;

/**
 * @className StringValueRenderer
 * @description TODO
 * @author sllx
 * @date 2014-5-28 下午6:40:12
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-28 下午6:40:12
 * Why & What is modified
 */
public abstract class StringValueRenderer{

	
	/**
	 * @title draw_String_Value
	 * @description 绘制文字与值 
	 * @return void
	 * @param rowY 行y坐标
	 * @param img 文字图片
	 * @param x_img 文字图片的x坐标
	 * @param num 需要显示的数字
	 * @param x_num 数字最左边的x坐标(右对齐,包含左边填充内容)
	 * @param maxNumLength 数字的最大长度
	 * @param g   画笔 
	 */
	public static void draw_String_Value(int rowY, Image img, int x_img, int num, int x_num, int maxNumLength,Graphics g){
		g.drawImage(img, x_img, rowY, null);
		NumberRenderer.drawNumber(num, x_num, rowY, maxNumLength, g);
	}
	
}
