package SecondTest;

public class theStack {
	char c = 'A';
	
	public void push(char c) {
		this.c = c;
	}
	
	public char pop() {
		return c;
	}
	
	public static void main(String[] args) {
		Thread push = new Push();
		Thread get = new Get();
		push.start();
		get.start();
	}
}
