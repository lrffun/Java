package FirstTest;

public class Righthand extends Thread{
	public void run(){
		for(int i = 0;i <= 5;i++) {
			System.out.println("������ʦ������");
			try {
				sleep(400);
			}catch(InterruptedException e) {}
		}
	}
	
}
