package tony.java.exer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.junit.Test;
//如下程序为了保证相应的流以及socket的关闭(即使在关闭之前出现异常，也一定要保证相应资源的关闭),要求使用
//try-catch-finally进行操作。要求将关闭的信息写在finally里！
public class TestTCP {

	
	//客户端
	@Test
	public void client(){
		//1.创建一个socket
		Socket socket =null;
		//2.发送
		OutputStream os = null;
		Scanner input = null;
		//4.接受来自于服务端的数据
		InputStream is = null;
		try {
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
			os = socket.getOutputStream();
			//3.向服务端发送数据
//		os.write("abc".getBytes());
			System.out.print("Please input: ");
			input = new Scanner(System.in);
			String str = input.next();
			os.write(str.getBytes());
			socket.shutdownOutput();
			is = socket.getInputStream();
			byte[] b = new byte[20];
			int len;
			while((len = is.read(b))!= -1){
				String str1 = new String(b, 0,len);
				System.out.println(str1);
				
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(os != null){
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(input != null){
				input.close();
			}
			if(os != null){
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		//5.关闭流
		
		
		
		
	
		
		
	}
	
	//服务端
	@Test
	public void server(){
		//1.
		ServerSocket ss = null;
		//2.
		Socket s = null;
		//3.接受来自于客户端的信息
		InputStream is = null;
		//4.返回给客户端
		OutputStream os = null;
		try {
			ss = new ServerSocket(9090);
			s = ss.accept();
			is = s.getInputStream();
			byte[] b = new byte[10];
			int len;
			String str = new String();
			while((len = is.read(b))!= -1){
				String str1 = new String(b, 0, len);
				str += str1;
			}
			String strUpper = str.toUpperCase();
			os = s.getOutputStream();
			os.write(strUpper.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(os != null){
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(s != null){
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ss != null){
				try {
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		//关闭
		
		
		
		
		
		
		}
		
		
		
	}
	
	
}
