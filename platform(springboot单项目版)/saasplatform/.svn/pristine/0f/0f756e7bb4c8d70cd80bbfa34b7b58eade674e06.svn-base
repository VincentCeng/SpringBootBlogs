package com.saas.commons.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 解析properties文件的工具类
 *  
 * 
 * @项目        hyplatform
 *
 * @日期:       2017年7月24日
 *  
 * @负责人:    Orchid
 */
public class PropertiesUtils {

	private static final Properties global = loadProperties("agreement.properties");
	
	public static String getdefaultTransportCharset()
	{
		return global.getProperty("defaultTransportCharset");
	}
	
	public static String getdefaultSmgpTransportCharset()
	{
		return global.getProperty("defaultSmgpTransportCharset");
	}
	
	public static String getdefaultSgipTransportCharset()
	{
		return global.getProperty("defaultSgipTransportCharset");
	}
	
	public static String getproperties(String key,String defaultValue)
	{
		String ret = global.getProperty(key);
		return  StringUtils.isBlank(ret) ? defaultValue :ret;
	}
	
	private static Properties loadProperties(String resources) {
		// 使用InputStream得到一个资源文件
		InputStream inputstream = PropertiesUtils.class.getClassLoader().getResourceAsStream(resources);
		// new 一个Properties
		Properties properties = new Properties();
		try {
			// 加载配置文件
			properties.load(inputstream);
			return properties;
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				inputstream.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}
	}
}
