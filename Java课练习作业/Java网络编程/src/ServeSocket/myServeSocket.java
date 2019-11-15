package ServeSocket;
	import java.io.IOException;
	import java.io.InputStream;
	import java.net.ServerSocket;
	import java.net.Socket;
	
public class myServeSocket {



		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			
					
				ServerSocket server = new ServerSocket(8080);
				
				System.out.println("服务器已启动，等待连接中！");
			
				new Thread() {
					public void run() {
						while(true) {
							Socket socket;
							try {
							socket = server.accept();			
							
							System.out.println("接收到客户端请求，开始读取数据");
														
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
						System.out.println("我服务器正在做别的事！");
						System.out.println("倒计时:"+i);
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
