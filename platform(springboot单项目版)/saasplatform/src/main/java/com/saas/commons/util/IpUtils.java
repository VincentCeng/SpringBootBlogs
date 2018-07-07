package com.saas.commons.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * ip方面的工具
 * 
 * @ClassName: IpUtils
 * @Description: (这里用一句话描述这个类的作用)
 * @author Orchid
 * @date 2018年4月20日 下午4:29:07
 *
 */
public class IpUtils {

	//正式服
	private final static String IP = "10.141.186.75";
	//测试服
	private final static String TEXT_IP = "10.141.60.63";
	
	/**
	 * 判断服务器的IP地址正确性
	 * TRUE是测试服
	 * false是正式服
	 * @Title: checkIp 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @throws
	 */
	public static boolean checkIp() {
		try {
			Enumeration<NetworkInterface> allNetInterfaces; // 定义网络接口枚举类
			allNetInterfaces = NetworkInterface.getNetworkInterfaces(); // 获得网络接口
			InetAddress ip = null; // 声明一个InetAddress类型ip地址
			while (allNetInterfaces.hasMoreElements()) // 遍历所有的网络接口
			{
				NetworkInterface netInterface = allNetInterfaces.nextElement();
				Enumeration<InetAddress> addresses = netInterface.getInetAddresses(); // 同样再定义网络地址枚举类
				while (addresses.hasMoreElements()) {
					ip = addresses.nextElement();
					if (ip != null && (ip instanceof Inet4Address)) // InetAddress类包括Inet4Address和Inet6Address
					{
						if ("eth0".equals(netInterface.getName())) {
							String val = ip.getHostAddress();
							System.out.println(val);
							if (val.equals(TEXT_IP)) {
								return true;
							} else {
								return false;
							}
						}
					}
				}
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
}
