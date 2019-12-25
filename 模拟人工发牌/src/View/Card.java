/*
 * ������Card
 * ��Ҫ���ԣ�mainWindow;image;type;num;BossOrNot;upOrNot;
 * ��Ҫ������Card();showUp();showReverse();moveAndDeal(MyPlayer myPlayer,int Xfrom,int Xto,int Yfrom, int Yto);moveAndDeal(int Xfrom,int Xto,int Yfrom, int Yto) 
 * ���ã������࣬����չʾ�����Լ����Ƶ��ƶ�������
 */
package View;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Data.MyPlayer;

public class Card extends JLabel{
	MainWindow mainWindow;
	String image;			//ͼƬ����
	public int type;				//�������ͣ�÷�������ң����飬���ң�
	public int num;				//���Ƶ�����
	public boolean	BossOrNot;		//�Ƿ�Ϊ��С����
	boolean upOrNot;		//����Or����
	
	public Card(MainWindow mainWindow,String image,boolean upOrNot) {			//��ʼ������
		this.mainWindow = mainWindow;
		this.image = image;
		this.type = Integer.valueOf(image.substring(0,1));					//�õ���������
		this.num = Integer.valueOf(image.substring(2,image.length()));		//�õ����Ƶ���
		this.BossOrNot = (image.equals("5-1")||image.equals("5-2"));		//�õ��Ƿ�Ϊ��С��
		this.upOrNot = upOrNot;
		this.setSize(71,96);
		this.setVisible(true);
	}
	
	public void showUp() {	//չʾ����
		this.setIcon(new ImageIcon("images/" + image +".gif"));
		this.upOrNot = true;
	}
	
	public void showReverse() {		//չʾ����
		this.setIcon(new ImageIcon("images/rear.gif"));
		this.upOrNot = false;
	}
	
	public void moveAndDeal(MyPlayer myPlayer,int Xfrom,int Xto,int Yfrom, int Yto) {			//��ǰ�����ƶ�����,��������ң�X,Y�������ʼλ�ú���ֹλ��
		myPlayer.MyCards.add(this);									//��ӵ��������
		double k = (1.0)*(Yfrom - Yto)/(Xfrom - Xto);				//��б�ʣ�����һ�κ�����
		double b = Yto - k*Xto;						//��ؾ�
		if(Xfrom <= Xto) {							//�ж������ƻ���������
			for (int x = Xfrom;x <= Xto;x+=3) {
				int y = (int)(k*x+b);				//��x���Ӧ��y������
				this.setLocation(x, y);				//�ƶ�����
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Sleep����");
				}
			}
		}else {
			for(int x = Xfrom;x >= Xto;x-=3) {
				int y = (int)(k*x+b);
				this.setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Sleep����");
				}
			}
		}
		this.setLocation(Xto, Yto);				//���յ�ȷ��һ�¿��Ƶ�λ��
		this.showUp();							//�����Ʒ�����
		this.upOrNot = true;					
	}
	
	public void moveAndDeal(int Xfrom,int Xto,int Yfrom, int Yto) {			//���ؿ����ƶ������������������ϴ��
		double k = (1.0)*(Yfrom - Yto)/(Xfrom - Xto);				//��б��
		double b = Yto - k*Xto;						//��ؾ�
		if(Xfrom <= Xto) {							//�ж������ƻ���������
			for (int x = Xfrom;x <= Xto;x+=3) {
				int y = (int)(k*x+b);
				this.setLocation(x, y);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Sleep����");
				}
			}
		}else {
			for(int x = Xfrom;x >= Xto;x-=3) {
				int y = (int)(k*x+b);
				this.setLocation(x, y);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Sleep����");
				}
			}
		}
		this.setLocation(Xto, Yto);
		this.showUp();
		this.upOrNot = true;
	}
}
