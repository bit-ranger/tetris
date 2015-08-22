package com.sllx.tetris;

import com.sllx.frost.ioc.context.XmlApplicationContext;


/**
 * @className Main
 * @description 启动
 * @author sllx
 * @date 2014-5-22 下午6:36:02
 * @modifiedBy sllx
 * @ModifiedDate 2014-5-22 下午6:36:02
   * Why & What is modified
 */
class Launch {
	public static void main(String[] args) {
		XmlApplicationContext.loadXml("config/ioc.xml");
	}
}

