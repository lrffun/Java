package Main;

//�������Ŀ���Ǽ��㺯��f(x) =2x^2 + x + 3;��һ�������ڵĶ����֡�
//											�����������ߣ����������ݣ�   �����

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float 	a = 0,				//��������
				b = 0,				//��������			
				c = 0,				//�ָ�γ�
				d = 0,				//�м����
				result = 0;			//������
		int 	n = 0;				//�ָ����
		
		System.out.println("�������Ŀ���Ǽ��㺯��f(x) = 3x^2 + 2x + 3;��һ�������ڵĶ����֡�");
		
		Scanner in = new Scanner(System.in);
				
		System.out.println("�������������b");
		b = in.nextFloat();
		
		System.out.println("�������������a");
		a = in.nextFloat();
		
		System.out.println("������ָ�Ķ���n");
		n = in.nextInt();
		
		c = (a - b)/n;
		
		for (float i = 0; i < a - b;i+=c)
		{
			d = 3 * (b + i) * (b + i) + 2 * (b + i) + 3;
			result = d * c + result;
		}
		
		System.out.println("����f(x) = 3x^2 + 2x + 3;��" + a + "����" + b + "�Ľ��Ϊ" + result);
	}

}
