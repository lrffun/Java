package SecondTest;

public class Push extends Thread{
	public void run() {
		theStack the = new theStack();
		char c;
		for(int i = 0;i < 20;i++) {
			c = (char)(Math.random()*26+'A');
			the.push(c);
			System.out.println("Produced:"+c);
			try {
				Thread.sleep((int)(Math.random()*1000));
			}catch(InterruptedException e) {}
		}
	}
}
