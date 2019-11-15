package ServeSocket;
	import java.io.IOException;
	import java.io.InputStream;
	import java.net.ServerSocket;
	import java.net.Socket;
	
public class myServeSocket {



		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			
					
				ServerSocket server = new ServerSocket(8080);  //开个8080端口
				
				System.out.println("服务器已启动，等待连接中！");
			
				new Thread() {                                  //新建一个线程等待客户端连接
					public void run() {
						while(true) {
							Socket socket;
							try {
							socket = server.accept();			
							
							System.out.println("接收到客户端请求，开始读取数据");
														
							InputStream in;                    //新建输入流读取客户端的输入
					
							in = (InputStream) socket.getInputStream();
				
							byte[] buff = new byte[1024];
							
							int length = 0;
							
							while((length = in.read(buff))!=-1)     //利用错误打印（没有缓存）
							{
								System.err.println(new String(buff,0,length));
							}
							in.close();
							}catch(IOException e) {}
							
						}
					}
				}.start();
				new Thread() {
					public void run() {        //新建一个线程，令服务器在运行期间做其他事
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