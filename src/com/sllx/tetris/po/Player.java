/**   
 * @fileName Player.java
 * @package com.sllx.tetris.po
 * @copyright (c) 2014, sincerebravefight@gmail.com All Rights Reserved. 
 * @description TODO
 * @author sllx  
 * @date 2014-5-16 下午9:08:44
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-16 下午9:08:44
   * Why & What is modified
 * @version V1.0
 */
package com.sllx.tetris.po;


/**
 * @className Player
 * @description TODO
 * @author sllx
 * @date 2014-5-16 下午9:08:44
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-16 下午9:08:44
 * Why & What is modified
 */
public class Player {
	
	/**
	 * @fields name : 姓名
	 */
	private String name;
	
	/**
	 * @fields score : 得分
	 */
	private int score;
	
	/**
	 * @fields level : 等级
	 */
	private int level;
	
	/**
	 * @fields rmline : 消行
	 */
	private int rmline;
	
	/**
	 * @fields experience : 经验值
	 */
	private int experience;
	
	/**
	 * @fields maxExperience : 满经验值
	 */
	public int maxExperience = 20;
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	
	public static Player newInstance(){
		return new Player();
	}
	
	/**
	 * @return the rmline
	 */
	public int getRmline() {
		return rmline;
	}
	
	/**
	 * @param rmline the rmline to set
	 */
	public void setRmline(int rmline) {
		this.rmline = rmline;
	}
	
	/**
	 * @return the experience
	 */
	public int getExperience() {
		return experience;
	}
	
	/**
	 * @param experience the experience to set
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	
	/**
	 * @title expUp
	 * @description 经验上升 
	 * @return void
	 * @param exp    
	 */
	public void expUp(){
		experience += 1;
		//若经验上升至满值,等级上升
		if(experience == maxExperience){
			levelUp();
		}
	}
	
	/**
	 * @title rmlineUp
	 * @description 消行上升 
	 * @return void
	 * @param rm    
	 */
	public void rmlineUp(int rm){
		rmline += rm;
		//积分上升
		score += Math.pow(2, rm) - 1;
	}
	
	/**
	 * @title levelUp
	 * @description 等级上升,经验归0,满经验提升 
	 * @return void    
	 */
	private void levelUp(){
		level += 1;
		experience = 0;
		maxExperience += 10;
	}
}