package pay;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.OutputStream;

public class demo2 {


	 public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		while(true)
		{
			Socket socket = new Socket("192.168.43.220",8080);
			
			System.out.println("�������ӳɹ�������������Ҫ��������ݣ�");
			
			Scanner in = new Scanner(System.in);
			
			String f = in.nextLine();
			
			OutputStream out = (OutputStream) socket.getOutputStream();
			
			out.write(f.getBytes());
			
			out.flush();
			
			out.close();
			
			System.out.println("��Ϣ������ɣ�");
			
			socket.close();
		}
		
	}

}
