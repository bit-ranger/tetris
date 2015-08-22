/**   
 * @fileName Box_Button.java
 * @package com.sllx.tetris.config
 * @copyright (c) 2014, sincerebravefight@gmail.com All Rights Reserved. 
 * @description 面板
 * @author sllx  
 * @date 2014-5-9 下午1:48:04
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午1:48:04
   * Why & What is modified
 * @version V1.0
 */
package com.sllx.tetris.ui;

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import com.sllx.tetris.config.Config_Box;
import com.sllx.tetris.config.Config;
import com.sllx.tetris.config.Factory;
import com.sllx.tetris.dto.DTO;



/**
 * @className Panel
 * @description 面板
 * @author sllx
 * @date 2014-5-9 下午2:42:44
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午2:42:44
   * Why & What is modified
 */
public class Panel extends JPanel{
	
	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = -2547427354063335724L;
	
	
	/**
	 * @fields boxes : 功能区域的集合
	 */
	private List<Box> boxes;
	

	/**
	 * @param dto the dto to set
	 */
	public void setDto(DTO dto) {
		for(Box box : boxes){
			box.dto = dto;
		}
	}

	
	/**
	 * @title Panel
	 * @description 构造器     
	 */
	public Panel() {
		Config config = Factory.getConfig();
		List<Config_Box> config_Boxes = config.getWindow().getBoxes();
		initBoxes(config_Boxes);
	}
	
	/**
	 * @title setPlayerController
	 * @description 插入玩家控制器 
	 * @return void
	 * @param keyListener    
	 */
	public void setPlayerController(KeyListener keyListener){
		addKeyListener(keyListener);
	}
	
	/**
	 * @title initBoxes
	 * @description 初始化所有功能区域
	 * @return void
	 * @param config_Boxes    
	 */
	private void initBoxes(List<Config_Box> config_Boxes){
		boxes = new ArrayList<>(config_Boxes.size());
		for(Config_Box boxConfig : config_Boxes){
			Box box = initBox(boxConfig);
			boxes.add(box);
		}
	}
	
	/**
	 * @title initBox
	 * @description 初始化一个功能区域 
	 * @return Box
	 * @param config_Box
	 * @return    
	 */
	private Box initBox(Config_Box config_Box){
		try {
			Class<?> cla = Class.forName(config_Box.getClassName());
			Constructor<?> cons = cla.getConstructor(int.class,int.class,int.class,int.class);
			Box box = (Box) cons.newInstance(
				config_Box.getX(),
				config_Box.getY(),
				config_Box.getW(),
				config_Box.getH()
			);
			return box;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return new Box(0, 0, 0, 0) {
			@Override
			public void paint(Graphics g) {}
		}; 
	}
	
	
	/* (non-Javadoc)
	 * description 绘制组件
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i=0; i<boxes.size(); boxes.get(i++).paint(g));
		requestFocus();
	}
	
}
