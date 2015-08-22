/**   
 * @fileName Box_Button.java
 * @package com.sllx.tetris.config
 * @copyright (c) 2014, sincerebravefight@gmail.com All Rights Reserved. 
 * @description 等级
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


/**
 * @className Box_Level
 * @description 等级
 * @author sllx
 * @date 2014-5-9 下午2:29:28
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午2:29:28
   * Why & What is modified
 */
class Box_Level extends Box{

	
	/**
	 * @fields MAX_NUM_LENGTH : 数字最大位数
	 */
	private static final int MAX_NUM_LENGTH = 5;
	
	/**
	 * @fields Y_OFFSET : Y轴偏移量
	 */
	private static final int Y_OFFSET = 70;
	
	/**
	 * @title Box_Level
	 * @description 构造器 
	 * @param x
	 * @param y
	 * @param w
	 * @param h    
	 */
	public Box_Level(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	
	/* (non-Javadoc)
	 * description 绘制
	 * @see com.sllx.tetris.ui.Box#paint(java.awt.Graphics)
	 */
	@Override
	protected void paint(Graphics g){
		this.createWindow(g);
		g.drawImage(Img.LEVEL, x + BORDER + PADDING, y + BORDER + PADDING, null);
		Integer score = dto.getPlayer().getLevel();
		NumberRenderer.drawNumber(score, x + BORDER, y + BORDER + Y_OFFSET, MAX_NUM_LENGTH, g);
	}
	
}
