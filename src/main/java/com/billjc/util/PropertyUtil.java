package com.billjc.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

	public static String getValue(String filename, String key) {
		Properties prop = new Properties();// 属性集合对象
		InputStream fis;
		try {
			fis = PropertyUtil.class.getClassLoader().getResourceAsStream(filename);
			prop.load(fis);// 将属性文件流装载到Properties对象中
		} catch (Exception e1) {
			e1.printStackTrace();
		} // 属性文件流

		return prop.getProperty(key);
	}

}
