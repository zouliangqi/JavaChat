import javax.swing.*;
import static javax.swing.JFrame.*; //引入JFrame的静态常量
import java.awt.event.*;
import java.awt.*;
import java.net.*;
import java.util.*;




class MyExtendsJFrame extends JFrame implements ActionListener , Runnable,KeyListener{
	//自定义窗口类，
	//1.继承窗口类，用于设计窗体；
	//2.实现ActionListener，用于响应按钮点击事件
	//3.实现Runnable，重写run方法，用于执行接收线程
	
	 JTextField textSend;
	 JTextField textIP;
	 JTextField textDK;
	 JTextArea textRecv;
	  JButton buttonSend;
	public MyExtendsJFrame(){
		setTitle("聊天软件");
		setBounds(160,100,400,520);		
		setLayout(null);		
		init();   //添加控件的操作封装成一个函数         
		setVisible(true);//放在添加组件后面执行
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	void init(){//添加的控件
	
	   textIP=new JTextField();
       textIP.setBounds(5,350,100,30);
       add(textIP);
       textIP.setText("192.168.4.112");
       
       textDK=new JTextField();
       textDK.setBounds(150,350,100,30);
       textDK.setText("2013");
       add(textDK);
       
       textSend=new JTextField(20);
       textSend.setBounds(5,315,150,30);
      
       add(textSend);
       
       
       
       textRecv=new JTextArea();      
       textRecv.setBounds(5,5,300,400);
       add(textRecv);       
       JScrollPane jsp=new JScrollPane(textRecv);
       jsp.setBounds(13,10,350,140);
       jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       add(jsp);
       
       buttonSend=new JButton("Send");
       buttonSend.setBounds(225,315,100,30);       
       buttonSend.addActionListener(this);//添加关联
       buttonSend.addKeyListener(this);
       add(buttonSend);
	
	}
	public void keyPressed(KeyEvent e) {
        if( e.getKeyCode()==KeyEvent.VK_ENTER)
        {
        	byte data[]=textSend.getText().getBytes();//获取发送文本框字符
            try{
         	    InetAddress address=InetAddress.getByName(textIP.getText());//设置目的IP地址	
         	    int DK=Integer.parseInt(textDK.getText());
         	    DatagramPacket SendPacket=new DatagramPacket(data,data.length,address,DK);
         	    //基于上一步的目标地址，创建UDP数据包，目标端口为2013
         	   
         	    DatagramSocket Post=new DatagramSocket();//创建UDP发送对象
         	    Post.send(SendPacket); //发送数据
         	    textRecv.setText(textRecv.getText()+'\n'+"我："+textSend.getText());  //显示数据	
         	    
         	    
         	}	
         	catch(Exception e1){}
        } 	//判断是否是enter健,如果是则发送
}
	public void keyReleased(KeyEvent e){
		return;
	}
	public void keyTyped(KeyEvent e){return;}
	
	
	public void actionPerformed(ActionEvent e){	//发送按钮响应	
	   byte data[]=("zhu哥哥："+textSend.getText()).getBytes();//获取发送文本框字符
       try{
    	    InetAddress address=InetAddress.getByName(textIP.getText());//设置目的IP地址
    	    int DK=Integer.parseInt(textDK.getText());
    	    DatagramPacket SendPacket=new DatagramPacket(data,data.length,address,DK);
    	    //基于上一步的目标地址，创建UDP数据包，目标端口为2013
    	   
    	    DatagramSocket Post=new DatagramSocket();//创建UDP发送对象
    	    Post.send(SendPacket); //发送数据
    	    textRecv.setText(textRecv.getText()+'\n'+"我："+'\n'+textSend.getText());  //显示数据	
    	    
    	    
    	}	
    	catch(Exception e1){}
    }
    
    
    public void run()//接收线程
  	{
  		byte data[]=new byte[1024];
  		try{  		
  		  DatagramSocket Recv=new DatagramSocket(2013);//创建UDP接收对象
  		  DatagramPacket pack=new DatagramPacket(data,data.length);//创建UDP接收数据包
  		  
  		  while(true)
  		  {
  			Recv.receive(pack); //接收一个数据包 			  		
  			String s=new String(pack.getData(),0,pack.getLength());  //读取数据包		
  			textRecv.setText(textRecv.getText()+'\n'+textIP.getText()+'\n'+s);  //显示数据	
  			
  		  }  		
  		}
  		catch(Exception e1){}		
  	}
	
	
	
	}


class Liao {
    public static void main(String args[]) {
    	 
    	MyExtendsJFrame frame=new MyExtendsJFrame();//创建聊天程序窗口
    	      
    	Thread readData=new Thread(frame);//创建接收线程
    	readData.start();  	//开启线程
       
}
}

