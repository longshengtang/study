package com.flysky.study.mybatis.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Download 
{
   public static void main(String[] args)
   {
	   JFrame jf=new JFrame("创建一个顶层窗口用于当做下载界面");
	   jf.setSize(600,400);
	  //设置这个框架窗口的宽度和高度。
	   jf.setLocation(200,200);
	   //设置这个窗口在200,200的位置显示。
	   JPanel jp=new JPanel();
	   //创建一个容器面板对象，用于存放组件。
	   JLabel jl=new JLabel("我是标记类，用于起标记作用");
	   final JTextField jt=new JTextField(30);
	   //创建一个文本域，用来存放一行数据。因为面板的缺省布局管理器是flowLayout,所以它们会按顺序排列。
	   jp.add(jl);
	   //把这个文本域添加到面板上。
	   jp.add(jt);
	   //把这个标签添加到面板上。
	   jf.getContentPane().add(jp,"North");
	   //将面板增加到框架窗口。在swing包中，如果要往框架窗口之中增加组件。必须先获取窗口的内容面板。
	   //然后才能增加。将面板增加到窗口的北边。
	   final JTextArea jta=new JTextArea();
	   //创建一个文本区，
	   jf.getContentPane().add(jta,"Center");
	   //将这个文本区增加到窗口的中间。
	   JButton jb=new JButton("下载");
	   //创建一个下载的按钮。
	   jf.getContentPane().add(jb,"South");
	   //将这个按钮增加到南边。
	   jb.addActionListener(new ActionListener()
			   {

				public void actionPerformed(ActionEvent e) 
				{
					String str=jt.getText();
					//首先构造一个url，可以在文本域当中利用输入的字符串来构造。如果要访问jtextfield,要把它定义为final.
					//通过文本域调用gettext()方法，获取在文本域中输入的文本信息。
					try {
						URL url=new URL(str);
						//构造一个URL对象。
						URLConnection urlcon=url.openConnection();
						//获取一个到URL所引用的远程对象的链接。就是连接到这个url网址。
						String line=System.getProperty("line.separator");
						//获取一个行的分隔符。//当我们增加下一个字符串时，它就会紧跟着上一个字符串显示，而我们要求换行，最好利用与平台无关的，容易移植
						//的方式编写代码。在java虚拟机中，有一个系统属性，可以表示分隔符。line.separator。
						jta.append("host:"+url.getHost());
						//将这个url的相关信息显示到文本区当中。利用gethost方法获取这个url的主机名。
						jta.append(line);
						//添加一个系统分隔符。
						jta.append("port:"+url.getDefaultPort());
						//添加一个端口信息。
						jta.append(line);
						//添加一个系统分隔符。
						jta.append("contenttype:"+urlcon.getContentType());
						//获取一个内容的类型并添加到文本区中。
						jta.append(line);
						//添加一个系统分隔符。
						jta.append("contentlength"+urlcon.getContentLength());
						//获取这个内容的长度并添加到文本区中。
						InputStream is=urlcon.getInputStream();
						FileOutputStream os=new FileOutputStream("1.html");
						//构造一个文件输出流，用来创建一个文件。
						int data;
						//定义一个整形变量。
						while((data=is.read())!=-1)
							//按照一个字节一个字节进行读取，如果读取的数据不等于-1，也就是没有到达数据的结尾。
						{
							os.write(data);
							//将字节数据写入到文件中。
						}
						is.close();
						os.close();
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
				}
		   
			   });
	   jf.addWindowListener(new WindowAdapter()
	   {//创建一个窗口监听器。使用内部类调用windowClosing方法,当点击关闭按钮，窗口退出。
		public void windowClosing(WindowEvent e) 
		{
		System.exit(0);
		}
		   
	   });
	   jf.setVisible(true);
	   //调用setVisible(true)方法将窗口显示出来。
   }
}
