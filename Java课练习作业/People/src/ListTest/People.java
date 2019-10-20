/*�������ƣ�People
 * ���󣺸�ϰ���ϵ��ô�
 * ���ߣ������
 * �༶�����������ݣ�11801��
 */
package ListTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class People {
	String name = "";
	int age;
	double stature;
	double weight;
	double vision;
	
	public People(String name,int age,double stature,double weight,double vision)
	{
		this.name = name;
		this.age = age;
		this.stature = stature;
		this.weight = weight;
		this.vision = vision;
	}
	
	public String toMyString()
	{
		return name+"  "+age+"  "+stature+"  "+weight+"  "+vision;
	}
	
	public static void main(String[] args) {
		ArrayList<People> people = new ArrayList<People>();
		List<People> list = new ArrayList<People>(20);
		people.add(new People("����",20,170,50,4.0));
		people.add(new People("����",21,165,54,5.0));
		people.add(new People("����",19,187,51,6.0));
		people.add(new People("����",10,198,48,5.1));
		people.add(new People("����",85,114,65,5.2));
		people.add(new People("����",31,120,66,4.3));
		people.add(new People("��ʮ��",13,163,83,2.0));
		Collections.sort(people,new Comparator<People>() {

			@Override
			public int compare(People o1, People o2) {
				// TODO Auto-generated method stub
				return o2.age - o1.age;
			}});
		System.out.println("����������:");
		for(People p:people)
		{
			System.out.println(p.toMyString());	
		}
		
		
		Collections.sort(people,new Comparator<People>() {		//���������

			@Override
			public int compare(People o1, People o2) {
				// TODO Auto-generated method stub
				return Double.compare(o1.stature, o2.stature);
			}
			
		});
		System.out.println("\n\n\n���������");
		for(People p:people)
		{
			System.out.println(p.toMyString());	
		}
		
		Collections.sort(people,new Comparator<People>() {		//����������

			@Override
			public int compare(People o1, People o2) {
				// TODO Auto-generated method stub
				return Double.compare(o1.weight,o2.weight);
			}
			
		});
		System.out.println("\n\n\n����������:");
		for(People p:people)
		{
			System.out.println("-"+p.toMyString());
		}
		
		Collections.sort(people,new Comparator<People>() {		//����������

			@Override
			public int compare(People o1, People o2) {
				// TODO Auto-generated method stub
				return Double.compare(o1.vision,o2.vision);
			}
			
		});
		System.out.println("\n\n\n����������:");
		for(People p:people)
		{
			System.out.println("-"+p.toMyString());
		}
	}
	
}
