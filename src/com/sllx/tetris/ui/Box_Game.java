/**   
 * @fileName Box_Button.java
 * @package com.sllx.tetris.config
 * @copyright (c) 2014, sincerebravefight@gmail.com All Rights Reserved. 
 * @description 游戏
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
import com.sllx.tetris.po.GameZone;
import com.sllx.tetris.po.Position;



/**
 * @className Box_Game
 * @description 游戏
 * @author sllx
 * @date 2014-5-9 下午2:28:44
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午2:28:44
   * Why & What is modified
 */
class Box_Game extends Box{

	/**
	 * @title Box_Game
	 * @description 构造器 
	 * @param x
	 * @param y
	 * @param w
	 * @param h    
	 */
	public Box_Game(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	private final static int SIZE_EXPONENT = Position.SIZE_EXPONENT;
	
	
	/* (non-Javadoc)
	 * description 绘制
	 * @see com.sllx.tetris.ui.Box#paint(java.awt.Graphics)
	 */
	@Override
	protected void paint(Graphics g){
		this.createWindow(g);
		drawGameZone(g);
		drawPosition(g);
	}
	
	
	/**
	 * @title drawGameZone
	 * @description 绘制游戏区 
	 * @return void
	 * @param g    
	 */
	private void drawGameZone(Graphics g){
		GameZone gameZone = dto.getGameZone();
		//遍历游戏区域中的列
		for (int c=0; c <= GameZone.MAX_COLUMN; c++) {
			//获得一个列
			boolean[] column = gameZone.getColumn(c);
			//遍历该列中所有行
			for(int r=0; r<=GameZone.MAX_ROW; r++){
				//若该列中的某行为true,绘制小方格
				if(column[r]){
					drawSquare(c, r, 0, g);
				}
			}
		}
	}
	
	
	/**
	 * @title drawPosition
	 * @description 绘制俄罗斯方块 
	 * @return void
	 * @param g    
	 */
	private void drawPosition(Graphics g){
		Position position = dto.getPosition();
		//遍历4个小方格
		for(Point point : position.getPoints()){
			drawSquare(point.x, point.y, position.currentShapeNumber()+1, g);
		}
	}
	
	
	/**
	 * @title drawSquare
	 * @description 绘制小方格 
	 * @return void
	 * @param colunm
	 * @param row
	 * @param indexOfImg
	 * @param g    
	 */
	private void drawSquare(int colunm, int row, int indexOfImg, Graphics g){
		//小方格左上角X坐标
		int x_ofSquare = calculate_X_ByColumn(colunm);
		//小方格左下角Y坐标
		int y_ofSquare = calculate_Y_ByRow(row);
		//小方格宽度
		int size = 1 << SIZE_EXPONENT;
		//图片起点X坐标
		int x_ofImg = indexOfImg << SIZE_EXPONENT;
		g.drawImage(Img.ACT, 
				x_ofSquare, y_ofSquare, 
				x_ofSquare + size, y_ofSquare + size, 
				x_ofImg, 0, 
				x_ofImg + size, size, 
				null);
	}
	
	
	/**
	 * @title calculate_X_ByColumn
	 * @description 根据列号计算小方格左上角X坐标 
	 * @return int
	 * @param column
	 * @return    
	 */
	private int calculate_X_ByColumn(int column){
		return x + BORDER + (column << SIZE_EXPONENT);
	}
	
	
	/**
	 * @title calculate_Y_ByRow
	 * @description 根据行号计算小方格左上角Y坐标  
	 * @return int
	 * @param row
	 * @return    
	 */
	private int calculate_Y_ByRow(int row){
		return y + BORDER + (row << SIZE_EXPONENT);
	}
}
