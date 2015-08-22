/**   
 * @fileName ProgressRenderer.java
 * @package com.sllx.tetris.ui.abstractUI
 * @copyright (c) 2014, sincerebravefight@gmail.com All Rights Reserved. 
 * @description TODO
 * @author sllx  
 * @date 2014-5-28 下午6:29:50
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-28 下午6:29:50
   * Why & What is modified
 * @version V1.0
 */
package util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 * @className ProgressRenderer
 * @description TODO
 * @author sllx
 * @date 2014-5-28 下午6:29:50
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-28 下午6:29:50
 * Why & What is modified
 */
public abstract class ProgressRenderer{

	
	/**
	 * @title drawProgress
	 * @description 绘制进度条
	 * @return void
	 * @param img 进度条中间的图片
	 * @param img_width 图片被使用部分的长度
	 * @param x 进度条的x坐标
	 * @param y 进度条的y坐标
	 * @param width 进度条宽度
	 * @param height 进度高度
	 * @param percent 绘制百分比
	 * @param g    
	 */
	public static void drawProgress(Image img, int img_width, int x, int y, int width, int height, double percent, Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
		g.setColor(Color.WHITE);
		g.fillRect(x + 1, y + 1, width - 2, height - 2);
		g.setColor(Color.black);
		g.fillRect(x + 2, y + 2, width - 4, height - 4);
		//int colorBegin = (int)(percent * img_width); TODO 变色
		int colorWidth = (int)(percent * (width - 4)); 
		g.drawImage(img, x + 2, y + 2, x + 2 + colorWidth, y + height -2, 180, 0, 181, height - 4, null);
	}
}
