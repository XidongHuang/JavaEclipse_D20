package tony.java;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;

import org.junit.Test;
//UDP网络编程
public class TestUDP {

	//发送端
	@Test
	public void send(){
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
			byte[] b = "I am going to be sent".getBytes();
			//创建一个数据报:每一个数据报不能大于64k,都记录着数据信息，发送端的IP,端口号，以及要发送到的接收端的IP，端口号
			DatagramPacket dp = new DatagramPacket(b, 0, b.length, InetAddress.getByName("127.0.0.1"), 9090);
			
			ds.send(dp);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		if(ds != null){
			ds.close();
		}
		}
	}
	
	//接收端
	@Test
	public void receive(){
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(9090);
			byte[] b = new byte[1024];
			DatagramPacket pack = new DatagramPacket(b, 0, b.length);
			ds.receive(pack);
			
			String str = new String(pack.getData(), 0, pack.getLength());
			
			System.out.println(str);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		if(ds != null){
			ds.close();
		}
		
		}
		
	}
	
	
}
