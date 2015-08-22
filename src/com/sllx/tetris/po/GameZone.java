/**   
 * @fileName GameZone.java
 * @package com.sllx.tetris.po
 * @copyright (c) 2014, sincerebravefight@gmail.com All Rights Reserved. 
 * @description TODO
 * @author sllx  
 * @date 2014-5-12 下午10:45:55
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-12 下午10:45:55
   * Why & What is modified
 * @version V1.0
 */
package com.sllx.tetris.po;

import java.awt.Point;

import util.ArrayUtil;

/**
 * @className GameZone
 * @description TODO
 * @author sllx
 * @date 2014-5-12 下午10:45:55
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-12 下午10:45:55
 * Why & What is modified
 */
public class GameZone {
	/**
	 * 游戏区最大列号
	 */
	public final static int MAX_COLUMN = 9;
	
	/**
	 * 游戏区最大行号
	 */
	public final static int MAX_ROW = 17;
	
	/**
	 * 二维数组模拟游戏区[列][行]
	 * 游戏区被平均分为10列*18行
	 * 若二维数组中gameZone[c][r]为true,表示第c列第r行有小方格
	 */
	private boolean[][] gameZone = new boolean[MAX_COLUMN+1][MAX_ROW+1];
	
	
	private GameZone(){
		
	}
	

	/**
	 * @title getRow
	 * @description 通过输入行号获取某一行
	 * @return boolean[]
	 * @param rowNum
	 * @return
	 */
	public boolean[] getRow(int rowNum){
		//创建行
		boolean[] row = new boolean[MAX_COLUMN+1];
		//将游戏区每一列的第rowNum个元素放入行对象
		for(int i=0; i<gameZone.length; i++){
			row[i] = gameZone[i][rowNum];
		}
		return row;
	}
	
	
	/**
	 * @title getColumn
	 * @description 通过输入列号获取某一列 
	 * @return boolean[]
	 * @param columnNum
	 * @return    
	 */
	public boolean[] getColumn(int columnNum){
		return gameZone[columnNum];
	}
	
	
	/**
	 * @title add
	 * @description 在游戏区添加一个俄罗斯方块 
	 * @return void
	 * @param position    
	 */
	public void add(Position position){
		//俄罗斯方块由四个小方块组成
		//每个小方块都有自己的列号与行号
		//将小方块在gameZone中表示的位置设置为true,表示将此俄罗斯方块固定到游戏区
		for(Point point : position.getPoints()){
			gameZone[point.x][point.y] = true;
		}
	}
	
	/**
	 * @title removeLine
	 * @description 删除一行,为避免覆盖数据,需从下往上遍历 
	 * @return int    
	 */
	public int removeLine(){
		int rmNum = 0;
		for (int i = MAX_ROW; i >= 0; i--) {
			if(shouldRemove(i)){
				remove(i);
				rmNum ++;
				i ++;//删除成功后,再判断移动下来的这一行是否可以删除
			}
		}
		return rmNum;
	}
	
	
	/**
	 * @title shouldRemove
	 * @description 若该行全部为true则应该删除该行 
	 * @return boolean
	 * @param row
	 * @return    
	 */
	private boolean shouldRemove(int row){
		boolean res = true;
		for(boolean boo : getRow(row)){
			res &= boo;
		}
		return res;
	}
	
	
	/**
	 * @title remove
	 * @description 删除行号为row的行 
	 * @return void
	 * @param row    
	 */
	private void remove(int row){
		//遍历所有的列
		for(int i=0; i<=MAX_COLUMN; i++){
			//对于一个列,将从0到row-1之间的所有数据往下移动一格,覆盖掉第row个数据
			ArrayUtil.innerMoveBackward(getColumn(i), 0, row-1, 1);
		}
	}
	
	public static GameZone newInstance(){
		return new GameZone();
	}
}
