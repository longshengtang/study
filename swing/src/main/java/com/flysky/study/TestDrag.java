package com.flysky.study;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestDrag extends JFrame {

	private JPanel contentPane;
	//坐标数组
	public static int[][] seat = {{10,10},{150,10},{10,150},{150,150}};
	//记录坐标对应的组件
	public static Map<String,String> seatPanel = new HashMap<String, String>();
	public static JPanel[] panels = new JPanel[4] ;
	
	//查找最近的区域坐标，返回编号
	public static int getbest(int x, int y){
		int indexbest = 0;
		int modbest = 0;
		int modtmp = 0;
		int indextmp = 0;
		System.out.println("x:"+x + " y:" + y);
		for(int i = 0; i < 4; i++){
			if(i==0){
				modbest = Math.abs(x-seat[i][0]) + Math.abs(y-seat[i][1]);
				System.out.println("modbest:"+modbest );
				indexbest = 0;
			}else{
				modtmp = Math.abs(x-seat[i][0]) + Math.abs(y-seat[i][1]);
				System.out.println("modtmp:"+modtmp );
				indextmp = i;
				if(modtmp < modbest){
					modbest = modtmp;
					indexbest = indextmp;
					System.out.println("modbest:"+modbest + " indexbest:" + indextmp);
				}
			}
		}
		return indexbest;
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {

					TestDrag frame = new TestDrag();

					frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}

	public TestDrag() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(310, 330);

		setLocationRelativeTo(null);

		contentPane = new JPanel();

		contentPane.setLayout(new BorderLayout());

		add(contentPane);

		JPanel panel = new JPanel();

		contentPane.add(panel, BorderLayout.CENTER);

		panel.setBorder(BorderFactory.createLineBorder(Color.orange, 2));

		panel.setLayout(null);
		
		
		panels[0] = new JPanel();

		panels[0].setBackground(Color.BLUE);

		panels[0].setBounds(10, 10, 130, 130);

		panel.add(panels[0]);
		
		seatPanel.put("0", "0");

		panels[1] = new JPanel();

		panels[1].setBackground(Color.LIGHT_GRAY);

		panels[1].setBounds(150, 10, 130, 130);

		panel.add(panels[1]);
		
		seatPanel.put("1", "1");

		panels[2] = new JPanel();

		panels[2].setBackground(Color.MAGENTA);

		panels[2].setBounds(10, 150, 130, 130);

		panel.add(panels[2]);
		
		seatPanel.put("2", "2");

		panels[3] = new JPanel();

		panels[3].setBackground(Color.ORANGE);

		panels[3].setBounds(150, 150, 130, 130);

		panel.add(panels[3]);
		
		seatPanel.put("3", "3");

		MyListener m = new MyListener();

		panels[0].addMouseListener(m);

		panels[0].addMouseMotionListener(m);

		panels[1].addMouseListener(m);

		panels[1].addMouseMotionListener(m);

		panels[2].addMouseListener(m);

		panels[2].addMouseMotionListener(m);

		panels[3].addMouseListener(m);

		panels[3].addMouseMotionListener(m);

	}

	// 写一个类继承鼠标监听器的适配器，这样就可以免掉不用的方法。

	class MyListener extends MouseAdapter {

		// 这两组x和y为鼠标点下时在屏幕的位置和拖动时所在的位置

		int newX, newY, oldX, oldY;

		// 这两个坐标为组件当前的坐标

		int startX, startY;
		
		int endX, endY;

		@Override
		public void mousePressed(MouseEvent e) {

			// 此为得到事件源组件

			Component cp = (Component) e.getSource();

			// 当鼠标点下的时候记录组件当前的坐标与鼠标当前在屏幕的位置

			startX = cp.getX();

			startY = cp.getY();

			oldX = e.getXOnScreen();

			oldY = e.getYOnScreen();

		}

		@Override
		public void mouseDragged(MouseEvent e) {

			Component cp = (Component) e.getSource();

			// 拖动的时候记录新坐标
			newX = e.getXOnScreen();

			newY = e.getYOnScreen();

			// 设置bounds,将点下时记录的组件开始坐标与鼠标拖动的距离相加
			endX = startX + (newX - oldX);
			endY = startY + (newY - oldY);
			cp.setBounds(endX, endY,
					cp.getWidth(), cp.getHeight());

		}
		
		@Override
		public void mouseReleased(MouseEvent e) {

			Component cp = (Component) e.getSource();

			//组件新坐标
			int now = getbest(startX, startY);		
			int best = getbest(endX, endY);		
			System.out.println("now:" + now +" best:" +best);
			System.out.println("seatPanel:"+seatPanel.toString() );
			//拖动指定组件到目标坐标
			cp.setBounds(seat[best][0], seat[best][1],
					cp.getWidth(), cp.getHeight());			
			
			//拖动目标坐标组件 到 指定组件坐标  完成交换
			panels[Integer.parseInt(seatPanel.get(String.valueOf(best)))].setBounds(seat[now][0], seat[now][1],
					cp.getWidth(), cp.getHeight());
			
			//更新坐标组建对应关系
			seatPanel.put("temp",seatPanel.get(String.valueOf(best)));
			seatPanel.put(String.valueOf(best), seatPanel.get(String.valueOf(now)));
			seatPanel.put(String.valueOf(now), seatPanel.get("temp"));
			
			System.out.println("seatPanel:"+seatPanel.toString() );
		}
		

	}
}