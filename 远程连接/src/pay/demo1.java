package pay;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class demo1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
				
			ServerSocket server = new ServerSocket(8080);
			
			System.out.println("���������������ȴ������У�");
		
			while(true)
			{
			Socket socket = server.accept();
			
			System.out.println("���յ��ͻ������󣬿�ʼ��ȡ����");
			
			InputStream in = (InputStream) socket.getInputStream();
			
			byte[] buff = new byte[1024];
			
			int length = 0;
			
			while((length = in.read(buff))!=-1)
			{
				System.err.println(new String(buff,0,length));
			}
			in.close();
			
			//socket.close();
			}
		
	}

}
