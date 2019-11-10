package FirstTest;

public class Teacher implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0;i <= 5;i++) {
			System.out.println("--我是老师！！！");
			try {
				Thread.sleep(400);
			}catch(InterruptedException e) {}
		}
	}

}
