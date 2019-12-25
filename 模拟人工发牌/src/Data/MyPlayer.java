/*
 * 类名：MyPlayer
 * 主要属性：MyCards卡牌集合；MyX,X坐标；MyY,Y坐标；
 * 主要方法：MyPlayer{}构造方法；addCard();remove(Card card);getCardsNum();MySort(MainWindow mainwindow,int playerNum)
 */
package Data;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import View.Card;
import View.MainWindow;

public class MyPlayer {			//玩家类
	public List<Card> MyCards = new ArrayList<>();
	public int MyX;		//玩家初始位置X坐标
	public int MyY;		//玩家初始位置Y坐标
	
	public MyPlayer(int MyX,int MyY) {			//初始化玩家的X坐标和Y坐标
		this.MyX = MyX;
		this.MyY = MyY;
	}

	public void addCard(Card card) {			//发牌到玩家手里
		MyCards.add(card);
	}
	
	public void removeCard(Card card) {			//出牌（暂时用不到）
		MyCards.remove(card);
	}
	
	public int getCardsNum() {					//得到玩家当前手中的卡牌数量
		return MyCards.size();
	}
	
	public void MySort(MainWindow mainWindow,int playerNum) {						//排序
		Collections.sort(MyCards,new Comparator<Card>() {
			@Override
			public int compare(Card o1, Card o2) {
				// TODO Auto-generated method stub
				int type1 = o1.type;
				int type2 = o2.type;
				int num1 = o1.num;
				int num2 = o2.num;
				if(o1.BossOrNot) {			//判断是否为大小王
					num1+=100;
				}
				if(o2.BossOrNot) {
					num2+=100;
				}
				int num_cha = num2 - num1;				
				if(num_cha == 0) {						//判断大小是否相同，大小相同的话，按照花色排序
					return type1-type2;
				}else {									//大小不相同，按照点数排序
					return num_cha;
				}
			}
			
		});	
		new Thread(new Runnable() {						//将排序动画放在线程里，可以让四个玩家同时排
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0;i < MyCards.size();i++) {				//排序完成后，重新移动一下卡牌位置
					switch(playerNum) {								///判断移动的是哪个玩家手中的卡牌
						case 0:{
							MyCards.get(i).moveAndDeal(MyCards.get(i).getX(),10,MyCards.get(i).getY(),100+i*30);
							mainWindow.container.setComponentZOrder(MyCards.get(i), 0);				//让后面的覆盖前面的
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
