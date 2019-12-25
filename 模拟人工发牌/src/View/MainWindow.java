/*
 * ������MainWindow���̳�JFrame��
 * ��Ҫ������MainWindow()��setJmenu()��init() ��
 * ���ã����ڳ�ʼ�����壻
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
		start = new JMenu("��ʼ��Ϸ");
		Begin = new JMenuItem("��ʼ����");
		start.add(Begin);
		mb.add(start);
	}
	
	private void init() {
		this.setTitle("ģ���˹�����-----���������ݣ������");			//���ô������
		this.setSize(900,700);											//���ô����С
		setJmenu();
		this.setJMenuBar(mb);
		setLocationRelativeTo(getOwner()); 								//���ô������
		container = this.getContentPane();
		container.setLayout(null);										//����Ϊ��
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//���ùر�Style
		container.setBackground(new Color(2, 132, 60));						//������ɫΪ��ɫ
		this.setVisible(true);
	}
}
