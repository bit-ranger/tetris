/**
 * 
 */
package com.sllx.tetris.po;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author sllx
 *
 */
public class Position {
	
	private final static List<Point[]> shapes;
	
	static{
		shapes = new ArrayList<Point[]>();
		shapes.add(new Point[]{new Point(4,0),new Point(3,0),new Point(4,1),new Point(5,1)});//Z
		shapes.add(new Point[]{new Point(4,0),new Point(5,0),new Point(4,1),new Point(3,1)});//反Z
		shapes.add(new Point[]{new Point(4,0),new Point(5,0),new Point(4,1),new Point(5,1)});//方
		shapes.add(new Point[]{new Point(4,0),new Point(3,1),new Point(4,1),new Point(5,1)});//三角
		shapes.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(6,0)});//长条
		shapes.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(3,1)});//L
		shapes.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(5,1)});//反L
	}
	
	/**
	 * @fields SIZE_EXPONENT : 2的幂表示宽度
	 */
	public static final int SIZE_EXPONENT = 5;
	
	/**
	 * @fields MIN_X : 最小列号
	 */
	private final static int MIN_X = 0;
	
	/**
	 * @fields MAX_X : 最大列号
	 */
	private final static int MAX_X = 9;
	
	/**
	 * @fields MIN_Y : 最小行号
	 */
	private final static int MIN_Y = 0;
	
	/**
	 * @fields MAX_Y : 最大列号
	 */
	private final static int MAX_Y = 17;
	
	private int currentShapeNumber;
	
	/**
	 * @fields points : 当前俄罗斯方块所具有的形状
	 * 俄罗斯方块由4个小方格组成,Point[]用来存放这四个小方格的位置,point.x表示小方格的列号,point.y表示小方格的行号
	 */
	private Point[] points;
	
	
	/**
	 * @title Position
	 * @description 构造器 初始化一个俄罗斯方块对象,并初始化形状    
	 */
	private Position() {
		//TODO 随机初始化形状
		init(new Random().nextInt(6));
	}
	
	
	
	/**
	 * @title init
	 * @description 初始化当前形状，随参数不同而改变 取值范围0～6
	 * @return void
	 * @param i    
	 */
	private void init(int shapeNumber){
		Point[] shape = shapes.get(shapeNumber);
		points = new Point[shape.length];
		for (int i = 0; i < points.length; i++) {
			points[i] = new Point(shape[i].x, shape[i].y);
		}
		currentShapeNumber = shapeNumber;
	}
	
	
	/**
	 * @return the 当前俄罗斯方块的位置
	 */
	public Point[] getPoints() {
		return points;
	}
	
	
	/**
	 * 移动
	 * @title move
	 * @description 移动 
	 * @return void
	 * @param moveX
	 * @param moveY    
	 */
	public boolean move(int moveX, int moveY, GameZone gameZone){
		//判断能否移动
		boolean canMove = canMove(moveX, moveY, gameZone);
		if(canMove){
			shift(moveX, moveY);
		}
		return canMove;
	}
	
	/**
	 * 能移动
	 * @param moveX
	 * @param moveY
	 * @return
	 */
	private boolean canMove(int moveX, int moveY, GameZone gameZone){
		//对一个由多个点组成的小方块,只要任意一个点移动后越界,就让其不能移动
		for(Point point : points){
			int newX = point.x + moveX;
			int newY = point.y + moveY;
			//如果移动后产生的新坐标判定为越界，则不能移动
			if(isOutOfBounds(newX, newY, gameZone)){
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * 数据偏移
	 * @param moveX
	 * @param moveY
	 */
	private void shift(int moveX, int moveY){
		for (int i = 0; i < points.length; i++) {
			points[i].x +=  moveX;
			points[i].y +=  moveY;
		}
	}
	
	
	/**
	 * @title transform
	 * @description 变形 
	 * @return boolean    
	 */
	public boolean transform(GameZone gameZone){
		boolean canRevolve = canRevolve(gameZone);
		if(canRevolve){
			revolve();
		}
		return canRevolve;
	}
	
	
	/**
	 * @title canRevolve
	 * @description 能旋转 
	 * @return boolean
	 * @return    
	 */
	private boolean canRevolve(GameZone gameZone) {
		//TODO 如果为正方块，不能旋转
		if(currentShapeNumber == 2) return false;
		for (int i = 1; i < points.length; i++) {//第0个为中心点，不需要旋转,所以遍历从1开始
			//
			int newX = points[0].y + points[0].x - points[i].y;
			int newY = points[0].y - points[0].x + points[i].x;
			if(isOutOfBounds(newX, newY, gameZone)){
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * @title revolve
	 * @description 旋转 
	 * @return void    
	 */
	private void revolve(){
		for (int i = 1; i < points.length; i++) {//第0个为中心点，不需要旋转,所以遍历从1开始
			int newX = points[0].y + points[0].x - points[i].y;
			int newY = points[0].y - points[0].x + points[i].x;
			points[i].x = newX;
			points[i].y = newY;
		}
	}

	
	/**
	 * 判定是否越界
	 * @title isNotOutOfBounds
	 * @description 若坐标超过游戏区边界，或坐标表示的位置在gameZone中为true(表示此位置已有小方块),则判定为越界
	 * @return boolean
	 * @return    
	 */
	private boolean isOutOfBounds(int x, int y, GameZone gameZone){
		return x<MIN_X || x>MAX_X || y<MIN_Y || y>MAX_Y || gameZone.getColumn(x)[y];
	}
	
	
	/**
	 * @title newInstance
	 * @description 获取一个实例 
	 * @return Position
	 * @return    
	 */
	public static Position newInstance(){
		return new Position();
	}
	
	
	public int currentShapeNumber(){
		return currentShapeNumber;
	}
}
