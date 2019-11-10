package FirstTest;

public class FirstTest {
	static Lefthand left;
	static Righthand right;
	static Teacher teacher = new Teacher();
	static Student student = new Student();
	public static void main(String[] args) {
		Thread tea = new Thread(teacher);
		Thread stu = new Thread(student);
		left = new Lefthand();
		right = new Righthand();
		left.start();
		right.start();
		tea.setPriority(2);
		stu.setPriority(1);	
		tea.start();
		stu.start();


	}
}
