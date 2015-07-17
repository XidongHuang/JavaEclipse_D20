package tony.java;

//import java.net.InetAddress;
import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * 网络通信的第一个要素: IP地址，通过IP地址，唯一的定位互联网
 * InetAddress:位于java.net包下
 * 1. InetAddress 用来代表IP地址。一个InetAddress的对象就代表着IP地址
 * 2. 如何创建InetAddress的对象: getByName(String host)
 * 3. getHostName():获取IP地址对应的域名
 *    getHostAddress():获取IP地址
 */
public class TestInetAddress {
	public static void main(String[] args) throws UnknownHostException {
		//创建一个InetAddress对象：getByName()
		InetAddress inet = InetAddress.getByName("www.Subaru.ca");
//		inet = InetAddress.getByName("66.135.120.72");
		System.out.println(inet);
		
		//两个方法
		System.out.println(inet.getHostName());
		System.out.println(inet.getHostAddress());
		//获取本机的IP: getLocalHost()
		InetAddress inet1  = InetAddress.getLocalHost();
		System.out.println(inet1);
		System.out.println(inet1.getHostAddress());
		System.out.println(inet1.getHostName());
	}
}
