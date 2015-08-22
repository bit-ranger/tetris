/**   
 * @fileName Box_Button.java
 * @package com.sllx.tetris.config
 * @copyright (c) 2014, sincerebravefight@gmail.com All Rights Reserved. 
 * @description 数据库
 * @author sllx  
 * @date 2014-5-9 下午1:48:04
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午1:48:04
   * Why & What is modified
 * @version V1.0
 */
package com.sllx.tetris.ui;

import java.awt.Graphics;



/**
 * @className Box_DataBase
 * @description 数据库
 * @author sllx
 * @date 2014-5-9 下午2:26:28
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午2:26:28
   * Why & What is modified
 */
class Box_DataBase extends Box{
	
	/**
	 * @title Box_DataBase
	 * @description 构造器 
	 * @param x
	 * @param y
	 * @param w
	 * @param h    
	 */
	public Box_DataBase(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	
	/* (non-Javadoc)
	 * description 绘制
	 * @see com.sllx.tetris.ui.Box#paint(java.awt.Graphics)
	 */
	@Override
	protected void paint(Graphics g){
		this.createWindow(g);
		g.drawImage(Img.DATABASE, x + BORDER + PADDING, y + BORDER + PADDING, null);
	}
}
