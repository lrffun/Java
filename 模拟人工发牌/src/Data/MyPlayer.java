/*
 * ������MyPlayer
 * ��Ҫ���ԣ�MyCards���Ƽ��ϣ�MyX,X���ꣻMyY,Y���ꣻ
 * ��Ҫ������MyPlayer{}���췽����addCard();remove(Card card);getCardsNum();MySort(MainWindow mainwindow,int playerNum)
 */
package Data;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import View.Card;
import View.MainWindow;

public class MyPlayer {			//�����
	public List<Card> MyCards = new ArrayList<>();
	public int MyX;		//��ҳ�ʼλ��X����
	public int MyY;		//��ҳ�ʼλ��Y����
	
	public MyPlayer(int MyX,int MyY) {			//��ʼ����ҵ�X�����Y����
		this.MyX = MyX;
		this.MyY = MyY;
	}

	public void addCard(Card card) {			//���Ƶ��������
		MyCards.add(card);
	}
	
	public void removeCard(Card card) {			//���ƣ���ʱ�ò�����
		MyCards.remove(card);
	}
	
	public int getCardsNum() {					//�õ���ҵ�ǰ���еĿ�������
		return MyCards.size();
	}
	
	public void MySort(MainWindow mainWindow,int playerNum) {						//����
		Collections.sort(MyCards,new Comparator<Card>() {
			@Override
			public int compare(Card o1, Card o2) {
				// TODO Auto-generated method stub
				int type1 = o1.type;
				int type2 = o2.type;
				int num1 = o1.num;
				int num2 = o2.num;
				if(o1.BossOrNot) {			//�ж��Ƿ�Ϊ��С��
					num1+=100;
				}
				if(o2.BossOrNot) {
					num2+=100;
				}
				int num_cha = num2 - num1;				
				if(num_cha == 0) {						//�жϴ�С�Ƿ���ͬ����С��ͬ�Ļ������ջ�ɫ����
					return type1-type2;
				}else {									//��С����ͬ�����յ�������
					return num_cha;
				}
			}
			
		});	
		new Thread(new Runnable() {						//�����򶯻������߳���������ĸ����ͬʱ��
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0;i < MyCards.size();i++) {				//������ɺ������ƶ�һ�¿���λ��
					switch(playerNum) {								///�ж��ƶ������ĸ�������еĿ���
						case 0:{
							MyCards.get(i).moveAndDeal(MyCards.get(i).getX(),10,MyCards.get(i).getY(),100+i*30);
							mainWindow.container.setComponentZOrder(MyCards.get(i), 0);				//�ú���ĸ���ǰ���
						}break;
						case 1:{
							MyCards.get(i).moveAndDeal(MyCards.get(i).getX(),100+i*50,MyCards.get(i).getY(),10);
							mainWindow.container.setComponentZOrder(MyCards.get(i), 0);
						}break;
						case 2:{
							MyCards.get(i).moveAndDeal(MyCards.get(i).getX(),900-10-96,MyCards.get(i).getY(),100+i*30);
							mainWindow.container.setComponentZOrder(MyCards.get(i), 0);
						}break;
						case 3:{
							MyCards.get(i).moveAndDeal(MyCards.get(i).getX(),100+i*50,MyCards.get(i).getY(),700-170);
							mainWindow.container.setComponentZOrder(MyCards.get(i), 0);
						}break;
						default:break;
					}
				}
			}
			
		}).start();

	}
}
