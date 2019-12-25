/*
 * 类名：MainWindow（继承JFrame）
 * 主要方法：MainWindow()；setJmenu()；init() ；
 * 作用：用于初始化窗体；
 */
package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Main.MyMain;

public class MainWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Container container = null;
	private JMenuBar mb; 
	public JMenu start;
	public JMenuItem Begin;
	
	public MainWindow() {
		init();
	}
	
	private void setJmenu() {
		mb = new JMenuBar();
		start = new JMenu("开始游戏");
		Begin = new JMenuItem("开始发牌");
		start.add(Begin);
		mb.add(start);
	}
	
	private void init() {
		this.setTitle("模拟人工发牌-----软工（大数据）郎瑞峰");			//设置窗体标题
		this.setSize(900,700);											//设置窗体大小
		setJmenu();
		this.setJMenuBar(mb);
		setLocationRelativeTo(getOwner()); 								//设置窗体居中
		container = this.getContentPane();
		container.setLayout(null);										//布局为空
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//设置关闭Style
		container.setBackground(new Color(2, 132, 60));						//背景颜色为绿色
		this.setVisible(true);
	}
}
