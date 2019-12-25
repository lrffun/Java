/*
 * 类名：Card
 * 主要属性：mainWindow;image;type;num;BossOrNot;upOrNot;
 * 主要方法：Card();showUp();showReverse();moveAndDeal(MyPlayer myPlayer,int Xfrom,int Xto,int Yfrom, int Yto);moveAndDeal(int Xfrom,int Xto,int Yfrom, int Yto) 
 * 作用：卡牌类，用于展示卡牌以及卡牌的移动动画。
 */
package View;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Data.MyPlayer;

public class Card extends JLabel{
	MainWindow mainWindow;
	String image;			//图片名字
	public int type;				//卡牌类型（梅花，红桃，方块，黑桃）
	public int num;				//卡牌点数；
	public boolean	BossOrNot;		//是否为大小王；
	boolean upOrNot;		//正面Or反面
	
	public Card(MainWindow mainWindow,String image,boolean upOrNot) {			//初始化卡牌
		this.mainWindow = mainWindow;
		this.image = image;
		this.type = Integer.valueOf(image.substring(0,1));					//得到卡牌类型
		this.num = Integer.valueOf(image.substring(2,image.length()));		//得到卡牌点数
		this.BossOrNot = (image.equals("5-1")||image.equals("5-2"));		//得到是否为大小王
		this.upOrNot = upOrNot;
		this.setSize(71,96);
		this.setVisible(true);
	}
	
	public void showUp() {	//展示正面
		this.setIcon(new ImageIcon("images/" + image +".gif"));
		this.upOrNot = true;
	}
	
	public void showReverse() {		//展示背面
		this.setIcon(new ImageIcon("images/rear.gif"));
		this.upOrNot = false;
	}
	
	public void moveAndDeal(MyPlayer myPlayer,int Xfrom,int Xto,int Yfrom, int Yto) {			//当前卡牌移动动画,参数：玩家，X,Y坐标的起始位置和终止位置
		myPlayer.MyCards.add(this);									//添加到玩家手中
		double k = (1.0)*(Yfrom - Yto)/(Xfrom - Xto);				//求斜率（根据一次函数）
		double b = Yto - k*Xto;						//求截距
		if(Xfrom <= Xto) {							//判断向左移还是向右移
			for (int x = Xfrom;x <= Xto;x+=3) {
				int y = (int)(k*x+b);				//求x点对应的y点坐标
				this.setLocation(x, y);				//移动卡牌
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Sleep错误");
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
					System.out.println("Sleep错误");
				}
			}
		}
		this.setLocation(Xto, Yto);				//最终得确定一下卡牌的位置
		this.showUp();							//将卡牌反过来
		this.upOrNot = true;					
	}
	
	public void moveAndDeal(int Xfrom,int Xto,int Yfrom, int Yto) {			//重载卡牌移动动画，用于玩家自我洗牌
		double k = (1.0)*(Yfrom - Yto)/(Xfrom - Xto);				//求斜率
		double b = Yto - k*Xto;						//求截距
		if(Xfrom <= Xto) {							//判断向左移还是向右移
			for (int x = Xfrom;x <= Xto;x+=3) {
				int y = (int)(k*x+b);
				this.setLocation(x, y);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Sleep错误");
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
					System.out.println("Sleep错误");
				}
			}
		}
		this.setLocation(Xto, Yto);
		this.showUp();
		this.upOrNot = true;
	}
}
