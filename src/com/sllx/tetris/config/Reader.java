/**   
 * @fileName Reader.java
 * @package com.sllx.tetris.config
 * @copyright (c) 2014, sincerebravefight@gmail.com All Rights Reserved. 
 * @description 配置读取器
 * @author sllx  
 * @date 2014-5-9 下午1:48:04
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午1:48:04
   * Why & What is modified
 * @version V1.0
 */
package com.sllx.tetris.config;


import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


/**
 * @className Reader
 * @description 配置读取器
 * @author sllx
 * @date 2014-5-9 下午2:17:43
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-9 下午2:17:43
   * Why & What is modified
 */
class Reader {
	
	/**
	 * @fields document : 文档对象
	 */
	private static Document document;

	/**
	 * @fields config : 配置对象
	 */
	private static Config config;
	
	
	/**
	 * @title Reader
	 * @description 构造器    
	 */
	Reader(){
		initDocument();
		initConfig();
	}
	
	
	/**
	 * @title initDocument
	 * @description 初始化文档 
	 * @return void    
	 */
	private void initDocument(){
		try {
			document = new SAXReader().read("config/config.xml");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @title initConfig
	 * @description 初始化配置对象
	 * @return void    
	 */
	private void initConfig(){
		config = new Config();
		Element game = document.getRootElement();
		initConfig_Window(game);
	}
	
	
	/**
	 * @title initConfig_Window
	 * @description 初始化窗口配置 
	 * @return void
	 * @param game    
	 */
	private void initConfig_Window(Element game){
		Element window = game.element("window");
		Config_Window cw = new Config_Window(
					window.attributeValue("title"), 
					Integer.parseInt(window.attributeValue("w")), 
					Integer.parseInt(window.attributeValue("h")), 
					Integer.parseInt(window.attributeValue("windowUp")),
					Integer.parseInt(window.attributeValue("box_padding"))
				);
		config.setWindow(cw);
		initConfig_Boxes(window, cw);
	}
	
	
	/**
	 * @title initConfig_Boxes
	 * @description 初始化所有box配置 
	 * @return void
	 * @param window    
	 */
	@SuppressWarnings("unchecked")
	private void initConfig_Boxes(Element window, Config_Window cw){
		List<Element> boxes = window.elements();
		for(Element box : boxes){
			Config_Box cb = initConfig_Box(box);
			cw.add(cb);
		}
	}
	
	

	/**
	 * @title initConfig_Box
	 * @description 初始化一个box配置 
	 * @return Config_Box
	 * @param box
	 * @return    
	 */
	private Config_Box initConfig_Box(Element box){
		return new Config_Box(
				box.attributeValue("className"),
				Integer.parseInt(box.attributeValue("x")),
				Integer.parseInt(box.attributeValue("y")),
				Integer.parseInt(box.attributeValue("w")),
				Integer.parseInt(box.attributeValue("h"))
			);
	}
	
	
	

	/**
	 * @title getConfig
	 * @description 获取配置对象 
	 * @return Config
	 * @return    
	 */
	Config getConfig(){
		return config;
	}
}
