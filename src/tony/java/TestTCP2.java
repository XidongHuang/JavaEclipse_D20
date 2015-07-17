package tony.java;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;
//
//TCP编程例二:
//客户端给服务端发送信息，服务端将信息打印到控制台上，同时发送"已收到信息"给客户端
public class TestTCP2 {

	//客户端
	@Test
	public void client(){
		Socket socket = null;
		OutputStream os = null;
		InputStream is = null;
		try {
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 8989);
			os = socket.getOutputStream();
			
			os.write("I am client".getBytes());
			//shutdownOutput():执行此方法，显式地告诉服务器发送完毕！
			socket.shutdownOutput();
			is = socket.getInputStream();
			byte [] b = new byte[20];
			int len;
			while((len = is.read(b))!=-1){
				String str = new String(b, 0,len);
				System.out.print(str);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
			
			
			if(socket != null){
				
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
	}
	
	
	
	
	//服务端
	@Test
	public void server(){
		ServerSocket ss = null;
		Socket s =  null;
		InputStream is = null;
		OutputStream os = null;
		try {
			ss = new ServerSocket(8989);
			s = ss.accept();
			is = s.getInputStream();
			byte[] b = new byte[20];
			int len;
			while((len = is.read(b))!= -1){
				String str = new String(b, 0,len);
				System.out.println(str);
				
			}
			os = s.getOutputStream();
			os.write("I have recepted your information".getBytes());
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
			
		}
		
		
		
		
		
		
	}
	
}
