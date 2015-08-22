/**   
 * @fileName Box_Button.java
 * @package com.sllx.tetris.config
 * @copyright (c) 2014, sincerebravefight@gmail.com All Rights Reserved. 
 * @description 下一个
 * @author sllx  
 * @date 2014-5-9 下午1:48:04
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午1:48:04
   * Why & What is modified
 * @version V1.0
 */
package com.sllx.tetris.ui;

import java.awt.Graphics;
import java.awt.Point;
import com.sllx.tetris.po.Position;



/**
 * @className Box_Next
 * @description 下一个
 * @author sllx
 * @date 2014-5-9 下午2:30:25
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午2:30:25
   * Why & What is modified
 */
class Box_Next extends Box{

	private final static int SIZE_EXPONENT = Position.SIZE_EXPONENT;
	private final static int X_OFFSET = 80;
	private final static int Y_OFFSET = 40;
	
	/**
	 * @title Box_Next
	 * @description 构造器 
	 * @param x
	 * @param y
	 * @param w
	 * @param h    
	 */
	public Box_Next(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	/* (non-Javadoc)
	 * description 绘制
	 * @see com.sllx.tetris.ui.Box#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g){
		this.createWindow(g);
		Point[] points = dto.getNextPosition().getPoints();
		int shapeNum = dto.getNextPosition().currentShapeNumber();
		for (Point point : points) {
			g.drawImage(Img.ACT, 
					x_begin(point.x), 
					y_begin(point.y), 
					x_begin(point.x) + (1<<SIZE_EXPONENT),
					y_begin(point.y) + (1<<SIZE_EXPONENT), 
					(shapeNum+1)<<SIZE_EXPONENT, 
					0, 
					(shapeNum+2)<<SIZE_EXPONENT, 
					32, null);
		}
	}
	
	private int x_begin(int x){
		return this.x + BORDER + (x<<SIZE_EXPONENT) - X_OFFSET;
	}
	
	private int y_begin(int y){
		return this.y + BORDER + (y<<SIZE_EXPONENT) + Y_OFFSET;
	}
}
