package Socket;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class mySocket {

	 public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		while(true)
		{
			Socket socket = new Socket("127.0.0.1",8080);
			
			System.out.println("建立连接成功！！请输入你要传输的数据：");
			
			Scanner in = new Scanner(System.in);
			
			String f = in.nextLine();
			
			OutputStream out = (OutputStream) socket.getOutputStream();
			
			out.write(f.getBytes());
			
			out.flush();
			
			out.close();
			
			System.out.println("消息发送完成！");
			
			socket.close();
		}
		
	}

}