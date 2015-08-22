/**   
 * @fileName Img.java
 * @package com.sllx.tetris.ui
 * @copyright (c) 2014, sincerebravefight@gmail.com All Rights Reserved. 
 * @description TODO
 * @author sllx  
 * @date 2014-5-21 下午10:53:14
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-21 下午10:53:14
   * Why & What is modified
 * @version V1.0
 */
package com.sllx.tetris.ui;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * @className Img
 * @description TODO
 * @author sllx
 * @date 2014-5-21 下午10:53:14
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-21 下午10:53:14
 * Why & What is modified
 */
public class Img {
	
	/**
	 * @title Img
	 * @description 构造器 TODO    
	 */
	private Img() {}
	
	/**
	 * @fields FRAME : 边框
	 */
	public final static Image FRAME = new ImageIcon("source/box/Frame.png").getImage();
	
	/**
	 * @fields NUMBER : 数字
	 */
	public final static Image NUMBER = new ImageIcon("source/string/num.png").getImage();
	
	/**
	 * @fields IMG : 背景图片
	 */
	public final static Image BACKGROUND = new ImageIcon("source/background/01.jpg").getImage();
	

	/**
	 * @fields IMG : 数据库标题
	 */
	public final static Image DATABASE = new ImageIcon("source/string/database.png").getImage();
	
	/**
	 * @fields IMG : 本地标题
	 */
	public final static Image DISK = new ImageIcon("source/string/disk.png").getImage();

	/**
	 * @fields IMG_ACT : 俄罗斯方块
	 */
	public final static Image ACT = new ImageIcon("source/game/rect.png").getImage();

	/**
	 * @fields IMG : 等级标题
	 */
	public static final Image LEVEL = new ImageIcon("source/string/level.png").getImage();

	/**
	 * @fields SCORE : 得分
	 */
	public final static Image SCORE = new ImageIcon("source/string/score.png").getImage();
	
	/**
	 * @fields IMG_RMLINE : 消行
	 */
	public final static Image RMLINE = new ImageIcon("source/string/rmline.png").getImage();
	
}
