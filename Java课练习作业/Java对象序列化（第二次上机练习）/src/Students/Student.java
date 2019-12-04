package Students;

import java.util.Comparator;

public class Student implements java.io.Serializable,Comparator{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String instanceName;
	private String name;
	private String xuehao;
	private String sex;
	private int age;
	
	public Student(String instanceName) {
		this.instanceName = instanceName;
	}
	
	public String getInstanceName() {
		return instanceName;
	}
	
	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}
	
	public String getInformation() {
		return "姓名:"+name+"  学号:"+xuehao+"  性别:"+sex+"  年龄:"+age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getXuehao() {
		return xuehao;
	}


	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + age;
		System.out.println("正在计算"+this.instanceName+"HashCode......");
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((xuehao == null) ? 0 : xuehao.hashCode());
		
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		System.out.println("正在用equils判断"+this.instanceName+"和"+((Student)obj).instanceName+"是否相等");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
//		if (age != other.age)
//			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (xuehao == null) {
			if (other.xuehao != null)
				return false;
		} else if (!xuehao.equals(other.xuehao))
			return false;
		return true;
	}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return ((Student)o1).name.hashCode() - ((Student)o2).instanceName.hashCode();
	}

}
