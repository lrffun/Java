package FirstTest;

public class Lefthand extends Thread{
	public void run() {
		for(int i=0;i<=5;i++) {
			System.out.println("����ѧ����");
			try {
				sleep(800);
			}catch(InterruptedException e) {}
		}
	}
}
