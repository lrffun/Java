package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class test01 {

	public static void main(String[] args) {
			List<A> list = new ArrayList<A>();
			list.add(new A(1));
			list.add(new A(3));
			list.add(new A(2));
			list.add(new A(7));
			list.add(new A(6));
		//	Collections.sort(list);
			for(int i=0;i<list.size();i++){
				System.out.print(list.get(i).a);
			}
			Collections.sort(list,new Comparator<A>(){

				public int compare(A o1, A o2) {
					// TODO Auto-generated method stub
					return o2.a-o1.a;
				}
			});
			System.out.println();
			for(int i=0;i<list.size();i++){
				System.out.print(list.get(i).a);
			}
	}

}
class A{
	int a;
	public A(int a){
		this.a=a;
	}
}