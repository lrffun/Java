/*
 *	类名：MyMain
 *	主要方法：initCards();ShowInitCards();InitPlayer();TestDealCards();DealCards();StartDealCards();
 *	作用：主类，用于将所有的Data和View展示。
 */

package Main;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Data.CardData;
import Data.MyPlayer;
import View.Card;
import View.MainWindow;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MyMain {
	private Card[] cards = new Card[54];		//定义54张卡牌;
	private MainWindow mainWindow = new MainWindow();		//定义主窗体；
	private MyPlayer[] players = new MyPlayer[4];
	public boolean startOrNot = false;
	
	private void initCards() {			//卡牌初始化
		int i = 0;
		for(String s:CardData.getRandomCardData()) {				//得到卡牌的乱序；
			cards[i] = new Card(mainWindow,s,false);
			i++;
		}
	}
	
	
	private void showInitCards() {			//展示初始卡牌
		for(int i = 453;i >= 400;i--) {
			cards[i-400].setBounds((53-(i-400)+400), 252, 71, 96);
			cards[i-400].showReverse();
			mainWindow.add(cards[i-400]);
		}
		mainWindow.setVisible(true);
	}
	
	private void initPlayers() {			//玩家初始化
		players[0] = new MyPlayer(10,100);
		players[1] = new MyPlayer(100,10);
		players[2] = new MyPlayer(100,700 - 10 -96);
		players[3] = new MyPlayer(900 - 10 - 71,100);
	}
	
//	private void TestDealCards() {			//测试发牌（无动画）
//		int i = 0;
//		for(Card card:cards) {
//			players[i].addCard(card);
//			i++;
//			if(i == 3) {i = 0;}
//		}
//		
//		i = 0;
//		
//		for(Card card:players[0].MyCards) {
//			card.setBounds(10, 100+i, 71, 96);
//			card.showUp();
//			mainWindow.add(card);
//			i+=38;
//		}
//		
//		System.out.println(players[0].getCardsNum());
//		
//	}
	
	private void DealCards() {				//开始发牌
		int PlayPoint = 0; 		//玩家指针
		for(int i = 0;i < 54;i++) {
			switch((PlayPoint++)%4) {
				case 0:{
					cards[i].moveAndDeal(players[0],cards[i].getX(),10,cards[i].getY(),100+players[0].MyCards.size()*30);
				}break;
				case 1:{
			
					cards[i].moveAndDeal(players[1],cards[i].getX(),100+players[1].MyCards.size()*50,cards[i].getY(),10);
				}break;
				case 2:{
					cards[i].moveAndDeal(players[2],cards[i].getX(),900-10-96,cards[i].getY(),100+players[2].MyCards.size()*30);
				}break;
				case 3:{
					cards[i].moveAndDeal(players[3],cards[i].getX(),100+players[3].MyCards.size()*50,cards[i].getY(),700-170);
				}break;
				default:break;
			}
		}
	}
	
	private void StartDealCards() {			//开始发牌
		playMusic();				//播放音乐（线程）
		initCards();				//初始化卡牌；
		showInitCards();			//展示初始化后的卡牌，背面朝上，放在屏幕中央
		initPlayers();				//初始化玩家；
		DealCards();				//开始发牌；
		for(int i = 0;i < 4;i++) {	//发牌完毕，进行排序；
			players[i].MySort(mainWindow,i);
		}
	}
	
	private void playMusic() {
		new Thread(new Runnable() {						//新建一个音乐线程，让音乐在子线程中播放
			@Override
			public void run() {
				while(true)	{		//循环播放
					try {
						File music = new File("music/doudizhu.mp3");				//音乐文件；
						Player player = new Player(new FileInputStream(music));		//调用jl库，传入文件输入流，构建Player参数（再这里曾和我自己构建的类冲突，调试了好久）
						player.play();												//播放音乐。
						System.out.println("播放完");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (JavaLayerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	public static void main(String[] args) {
		MyMain myMain = new MyMain();
//		myMain.mainWindow.Begin.addActionListener(new ActionListener() {			//不知道为什么，用上菜单栏监听之后，点击就会卡死
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				myMain.StartDealCards();
//			}
//		});

		myMain.StartDealCards();							//开始
	
	
	}
}
