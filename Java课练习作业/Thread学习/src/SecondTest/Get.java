package SecondTest;

public class Get extends Thread{
	
	public void run() {
		char c;
		theStack the = new theStack();
		for(int i = 0;i < 20;i++)
		{
			c = the.pop();
			System.out.println("Consuned:"+c);
			try {
				Thread.sleep((int)(Math.random()*1500));
			}catch(InterruptedException e) {}
		}
	}
}
