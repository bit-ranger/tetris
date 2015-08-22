/**   
 * @fileName Box_Button.java
 * @package com.sllx.tetris.config
 * @copyright (c) 2014, sincerebravefight@gmail.com All Rights Reserved. 
 * @description 框架
 * @author sllx  
 * @date 2014-5-9 下午1:48:04
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午1:48:04
   * Why & What is modified
 * @version V1.0
 */
package com.sllx.tetris.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import com.sllx.tetris.config.Config_Window;
import com.sllx.tetris.config.Factory;



/**
 * @className Window
 * @description 框架
 * @author sllx
 * @date 2014-5-9 下午2:53:37
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午2:53:37
   * Why & What is modified
 */
public class Window extends JFrame{
	
	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = -5844184030609276380L;
	
	
	/**
	 * @fields config_Window : 窗口配置对象
	 */
	private  static Config_Window  config_Window = Factory.getConfig().getWindow();
	

	/**
	 * @title Window
	 * @description 构造器 
	 * @param panel    
	 */
	public Window() {
		// TODO Auto-generated constructor stub
		setProperties();
		adaptiveScreen();
		
	}
	
	public void setPanel(Panel panel){
		setContentPane(panel);
		//TODO
		setVisible(true);
	}
	
	/**
	 * @title setProperties
	 * @description 设置属性 
	 * @return void    
	 */
	private void setProperties(){
		setTitle(config_Window.getTitle());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(config_Window.getW(), config_Window.getH());
		setResizable(false);
	}
	
	/**
	 * @title adaptiveScreen
	 * @description 自适应屏幕 
	 * @return void    
	 */
	private void adaptiveScreen(){
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int x = screenSize.width - this.getWidth() >> 1;
		int y = (screenSize.height - this.getHeight() >>1) - config_Window.getWindowUp();
		setLocation(x, y);
	}
}
