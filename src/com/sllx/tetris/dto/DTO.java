package com.sllx.tetris.dto;


import com.sllx.tetris.po.GameZone;
import com.sllx.tetris.po.Player;
import com.sllx.tetris.po.Position;


/**
 * @className DTO
 * @description 数据传输对象
 * @author sllx
 * @date 2014-5-16 下午9:14:25
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-16 下午9:14:25
   * Why & What is modified
 */
public class DTO {
	
	
	private Position position ;
	
	private Position nextPosition;

	private GameZone gameZone;

	private Player player;
	
	private DTO(){
		
	}
	
	
	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @return the gameZone
	 */
	public GameZone getGameZone() {
		return gameZone;
	}
	
	
	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * @param gameZone the gameZone to set
	 */
	public void setGameZone(GameZone gameZone) {
		this.gameZone = gameZone;
	}
	
	/**
	 * @title newInstance
	 * @description 获取实例
	 * @return DTO
	 * @return    
	 */
	public static DTO newInstance(){
		return new DTO();
	}


	/**
	 * @return the nextPosition
	 */
	public Position getNextPosition() {
		return nextPosition;
	}


	/**
	 * @param nextPosition the nextPosition to set
	 */
	public void setNextPosition(Position nextPosition) {
		this.nextPosition = nextPosition;
	}


	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}


	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}
	
	
	
}
