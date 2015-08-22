/**
 * 
 */
package com.sllx.tetris.control;

import com.sllx.tetris.service.Service;
import com.sllx.tetris.ui.Panel;

/**
 * @author sllx
 *
 */
public class GameController {
	private Panel panel;
	private Service service;
	
	
	
	/**
	 * @param panel the panel to set
	 */
	public void setPanel(Panel panel) {
		this.panel = panel;
		if(service==null) return;						//panel注入后，与service共享dto对象
		panel.setDto(service.getDto());
	}



	/**
	 * @param service the service to set
	 */
	public void setService(Service service) {
		this.service = service;
		if(panel==null)	return;				//service注入后，与panel共享dto对象
		panel.setDto(service.getDto());
	}

	
	 /**
	 * @title moveDown
	 * @description 下移 
	 * @return void    
	 */
	public void moveDown(){
		service.moveDown();
		panel.repaint();
	}
	
	 /**
	 * @title moveLeft
	 * @description 左移 
	 * @return void    
	 */
	void moveLeft(){
		service.moveLeft();
		panel.repaint();
	}
	
	 /**
	 * @title moveRight
	 * @description 右移 
	 * @return void    
	 */
	void moveRight(){
		service.moveRight();
		panel.repaint();
	}
	
	
	/**
	 * @title transform
	 * @description 变形 
	 * @return void    
	 */
	 void transform(){
		service.transform();
		panel.repaint();
	}

}
