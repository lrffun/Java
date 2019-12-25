/*
 *	������MyMain
 *	��Ҫ������initCards();ShowInitCards();InitPlayer();TestDealCards();DealCards();StartDealCards();
 *	���ã����࣬���ڽ����е�Data��Viewչʾ��
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
	private Card[] cards = new Card[54];		//����54�ſ���;
	private MainWindow mainWindow = new MainWindow();		//���������壻
	private MyPlayer[] players = new MyPlayer[4];
	public boolean startOrNot = false;
	
	private void initCards() {			//���Ƴ�ʼ��
		int i = 0;
		for(String s:CardData.getRandomCardData()) {				//�õ����Ƶ�����
			cards[i] = new Card(mainWindow,s,false);
			i++;
		}
	}
	
	
	private void showInitCards() {			//չʾ��ʼ����
		for(int i = 453;i >= 400;i--) {
			cards[i-400].setBounds((53-(i-400)+400), 252, 71, 96);
			cards[i-400].showReverse();
			mainWindow.add(cards[i-400]);
		}
		mainWindow.setVisible(true);
	}
	
	private void initPlayers() {			//��ҳ�ʼ��
		players[0] = new MyPlayer(10,100);
		players[1] = new MyPlayer(100,10);
		players[2] = new MyPlayer(100,700 - 10 -96);
		players[3] = new MyPlayer(900 - 10 - 71,100);
	}
	
//	private void TestDealCards() {			//���Է��ƣ��޶�����
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
	
	private void DealCards() {				//��ʼ����
		int PlayPoint = 0; 		//���ָ��
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
	
	private void StartDealCards() {			//��ʼ����
		playMusic();				//�������֣��̣߳�
		initCards();				//��ʼ�����ƣ�
		showInitCards();			//չʾ��ʼ����Ŀ��ƣ����泯�ϣ�������Ļ����
		initPlayers();				//��ʼ����ң�
		DealCards();				//��ʼ���ƣ�
		for(int i = 0;i < 4;i++) {	//������ϣ���������
			players[i].MySort(mainWindow,i);
		}
	}
	
	private void playMusic() {
		new Thread(new Runnable() {						//�½�һ�������̣߳������������߳��в���
			@Override
			public void run() {
				while(true)	{		//ѭ������
					try {
						File music = new File("music/doudizhu.mp3");				//�����ļ���
						Player player = new Player(new FileInputStream(music));		//����jl�⣬�����ļ�������������Player�������������������Լ����������ͻ�������˺þã�
						player.play();												//�������֡�
						System.out.println("������");
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
//		myMain.mainWindow.Begin.addActionListener(new ActionListener() {			//��֪��Ϊʲô�����ϲ˵�������֮�󣬵���ͻῨ��
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				myMain.StartDealCards();
//			}
//		});

		myMain.StartDealCards();							//��ʼ
	
	
	}
}
