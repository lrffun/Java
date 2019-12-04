package Students;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Student s1 = new Student("s1");
		s1.setAge(20);
		s1.setName("张三");
		s1.setSex("男");
		s1.setXuehao("123456");
		//对象序列化到文件
		ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream(new File("D:/Data/TestData/studentTest.txt")));
		ob.writeObject(s1);
		ob.close();
		//从文件读取并反序列化
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("D:/Data/TestData/studentTest.txt")));
		Student s2 = (Student) in.readObject();
		s2.setInstanceName("s2");
		//打印
		String s = s2.getInformation();
		System.out.println(s);
		
		Set<Student> stus = new HashSet<Student>();
		
		s2.setAge(100);
		
		System.out.println(s1.hashCode());	
		System.out.println(s2.hashCode());
		
		stus.add(s1);
		stus.add(s2);
		//两个都更改后为1，更改任何一个都为2，结论：set判断是依靠hashcode和equils两个判断的
		//先输出正在计算HashCode，后输出正在判断equils，所以先判断HashCode，后判断equils；
		System.out.println(stus.size());
		//比较s2和s1是否相同。
		if(s1.hashCode() ==  s2.hashCode()) {
			System.out.println("hashcode相同");
		}
		if(s1.equals(s2)){
			System.out.println("equals相同");
		}
			
		List<Student> stuList = new ArrayList<Student>();
		stuList.add(s1);
		stuList.add(s2);
		
		Collections.sort(stuList,new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getAge() - o2.getAge();
			}
		
		});
		
		System.out.println(stuList.get(0).getInstanceName()+"\n"+stuList.get(1).getInstanceName());
	}
}
