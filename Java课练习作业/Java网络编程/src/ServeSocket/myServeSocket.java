package ServeSocket;
	import java.io.IOException;
	import java.io.InputStream;
	import java.net.ServerSocket;
	import java.net.Socket;
	
public class myServeSocket {



		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			
					
				ServerSocket server = new ServerSocket(8080);
				
				System.out.println("���������������ȴ������У�");
			
				new Thread() {
					public void run() {
						while(true) {
							Socket socket;
							try {
							socket = server.accept();			
							
							System.out.println("���յ��ͻ������󣬿�ʼ��ȡ����");
														
							InputStream in;
					
							in = (InputStream) socket.getInputStream();
				
							byte[] buff = new byte[1024];
							
							int length = 0;
							
							while((length = in.read(buff))!=-1)
							{
								System.err.println(new String(buff,0,length));
							}
							in.close();
							}catch(IOException e) {}
							
						}
					}
				}.start();
				new Thread() {
					public void run() {
						for(int i = 100;i > 0;i--) {
						System.out.println("�ҷ���������������£�");
						System.out.println("����ʱ:"+i);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
					}
				}.start();

		}
}
