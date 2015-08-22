/**   
 * @fileName Box_Button.java
 * @package com.sllx.tetris.config
 * @copyright (c) 2014, sincerebravefight@gmail.com All Rights Reserved. 
 * @description 核心业务
 * @author sllx  
 * @date 2014-5-9 下午1:48:04
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午1:48:04
   * Why & What is modified
 * @version V1.0
 */
package com.sllx.tetris.service;


import com.sllx.tetris.dto.DTO;
import com.sllx.tetris.po.GameZone;
import com.sllx.tetris.po.Player;
import com.sllx.tetris.po.Position;


/**
 * @className Service
 * @description 核心业务
 * @author sllx
 * @date 2014-5-9 下午2:57:39
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午2:57:39
   * Why & What is modified
 */
public class Service {
	
	/**
	 * @fields dto : 数据传输对象
	 */
	private DTO dto;
	
	/**
	 * @return 返回当前dto对象
	 */
	public DTO getDto() {
		//TODO
		if(dto==null){
			query();
		}
		return dto;
	}

	/**
	 * @title query
	 * @description 返回查询结果,效果为生成新的dto对象,dto内容将被重置 
	 * @return DTO
	 * @return    
	 */
	private DTO query(){
		dto = DTO.newInstance();
		dto.setGameZone(GameZone.newInstance());
		dto.setPosition(Position.newInstance());
		dto.setNextPosition(Position.newInstance());
		dto.setPlayer(Player.newInstance());
		return dto;
	}
	
	
	/**
	 * @title moveDown
	 * @description 向下移动 
	 * @return void    
	 */
	public void moveDown(){
		boolean moved = move(0, 1);
		if(!moved){
			Player player = dto.getPlayer();
			//如果向下移动失败，固定到游戏区
			fixToGameZone();
			//经验上升
			player.expUp();
			//TODO 判断是否消行,
			int rm = removeLine();
			//TODO 若消行,积分上升
			if(rm>0){
				player.rmlineUp(rm);
			}
			//刷新一个方块
			refreshBox();
			//TODO,当方块为最顶层一个时，与gameZone中的方块重叠，移动判定失败，
		}
	}
	
	
	/**
	 * @title moveLeft
	 * @description 左移 
	 * @return void    
	 */
	public void moveLeft(){
		move(-1, 0);
	}
	
	
	/**
	 * @title moveRight
	 * @description 右移 
	 * @return void    
	 */
	public void moveRight(){
		move(1, 0);
	}
	
	/**
	 * 移动
	 * @param moveX
	 * @param moveY
	 */
	private boolean move(int moveX, int moveY){
		return	dto.getPosition().move(moveX, moveY, dto.getGameZone());
	}
	
	/**
	 * @title transform
	 * @description 变形 
	 * @return boolean    
	 */
	public void transform(){
		 dto.getPosition().transform(dto.getGameZone());
	}
	
	
	
	/**
	 * @title fixToGameZone
	 * @description 将俄罗斯方块固定到游戏区 
	 * @return void    
	 */
	private void fixToGameZone(){
		dto.getGameZone().add(dto.getPosition());
	}
	
	/**
	 * @title refreshBox
	 * @description 刷新一个方块 
	 * @return void    
	 */
	private void refreshBox(){
		//TODO 考虑更优实现
		//刷新一个方块,实际为，将下一个方块变为当前，创建一个新的方块作为下一个
		dto.setPosition(dto.getNextPosition());
		dto.setNextPosition(Position.newInstance());
	}
	
	/**
	 * @title removeLine
	 * @description 消行 
	 * @return int
	 * @return    
	 */
	private int removeLine(){
		return dto.getGameZone().removeLine();
	}
}
