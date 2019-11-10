package FirstTest;

public class Student implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<=5;i++) {
			System.out.println("--ÄãÊÇÑ§Éú£¡");
			try {
				Thread.sleep(800);
			}catch(InterruptedException e) {}
		}
	}
	
}
