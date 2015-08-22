/**   
 * @fileName Box_Button.java
 * @package com.sllx.tetris.config
 * @copyright (c) 2014, sincerebravefight@gmail.com All Rights Reserved. 
 * @description 分数
 * @author sllx  
 * @date 2014-5-9 下午1:48:04
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午1:48:04
   * Why & What is modified
 * @version V1.0
 */
package com.sllx.tetris.ui;

import java.awt.Graphics;

import util.NumberRenderer;
import util.ProgressRenderer;
import util.StringValueRenderer;

import com.sllx.tetris.po.Player;



/**
 * @className Box_Point
 * @description 分数
 * @author sllx
 * @date 2014-5-9 下午2:30:55
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午2:30:55
   * Why & What is modified
 */
class Box_Point extends Box{

	
	
	private final static int IMG_SCORE_H = Img.SCORE.getHeight(null);
	
	private final static int IMG_RMLINE_H = Img.RMLINE.getHeight(null);
	
	private final static int IMG_ACT_H = Img.ACT.getHeight(null);
	
	private int x_left;
	
	private int x_right;
	
	private int y_up;
	
	private int x_num;
	
	/**
	 * @fields MAX_NUM_LENGTH : 数字最大位数
	 */
	private static final int MAX_NUM_LENGTH = 5;
	
	/**
	 * @title Box_Point
	 * @description 构造器 
	 * @param x
	 * @param y
	 * @param w
	 * @param h    
	 */
	public Box_Point(int x, int y, int w, int h) {
		super(x, y, w, h);
		initFields();
	}
	
	private void initFields(){
		this.x_left = this.x + BORDER + PADDING;
		this.x_right = this.x + this.w - BORDER - PADDING;
		this.x_num = x_right - NumberRenderer.NUM_W * MAX_NUM_LENGTH;
		this.y_up = this.y + BORDER + PADDING;
	}
	
	/* (non-Javadoc)
	 * description 绘制
	 * @see com.sllx.tetris.ui.Box#paint(java.awt.Graphics)
	 */
	@Override
	protected void paint(Graphics g){
		this.createWindow(g);
		Player player = this.dto.getPlayer();
		//绘制得分
		int rowY = y_up;
		StringValueRenderer.draw_String_Value(rowY, Img.SCORE, x_left, player.getScore(), x_num, MAX_NUM_LENGTH, g);
		//绘制消行
		rowY += IMG_SCORE_H + PADDING;
		StringValueRenderer.draw_String_Value(rowY, Img.RMLINE, x_left, player.getRmline(), x_num, MAX_NUM_LENGTH, g);
		//绘制进度条
		rowY += IMG_RMLINE_H + PADDING;
		int num = player.getExperience();
		int maxNum = player.maxExperience;
		double percent = (double)(num % maxNum) / maxNum;
		ProgressRenderer.drawProgress(Img.ACT, 250, x_left, rowY, x_right - x_left, IMG_ACT_H + 4, percent, g);
	}
}
