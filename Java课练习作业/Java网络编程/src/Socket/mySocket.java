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
			Socket socket = new Socket("127.0.0.1",8080);					//���ӵ������
			
			System.out.println("�������ӳɹ�������������Ҫ��������ݣ�");
			
			Scanner in = new Scanner(System.in);
			
			String f = in.nextLine();											//����һ�λ�
			
			OutputStream out = (OutputStream) socket.getOutputStream();				//�������������������
				
			out.write(f.getBytes());
			
			out.flush();
			
			out.close();
			
			System.out.println("��Ϣ������ɣ�");
			
			socket.close();
		}
		
	}

}