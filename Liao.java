import javax.swing.*;
import static javax.swing.JFrame.*; //����JFrame�ľ�̬����
import java.awt.event.*;
import java.awt.*;
import java.net.*;
import java.util.*;




class MyExtendsJFrame extends JFrame implements ActionListener , Runnable,KeyListener{
	//�Զ��崰���࣬
	//1.�̳д����࣬������ƴ��壻
	//2.ʵ��ActionListener��������Ӧ��ť����¼�
	//3.ʵ��Runnable����дrun����������ִ�н����߳�
	
	 JTextField textSend;
	 JTextField textIP;
	 JTextField textDK;
	 JTextArea textRecv;
	  JButton buttonSend;
	public MyExtendsJFrame(){
		setTitle("�������");
		setBounds(160,100,400,520);		
		setLayout(null);		
		init();   //��ӿؼ��Ĳ�����װ��һ������         
		setVisible(true);//��������������ִ��
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	void init(){//��ӵĿؼ�
	
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
       buttonSend.addActionListener(this);//��ӹ���
       buttonSend.addKeyListener(this);
       add(buttonSend);
	
	}
	public void keyPressed(KeyEvent e) {
        if( e.getKeyCode()==KeyEvent.VK_ENTER)
        {
        	byte data[]=textSend.getText().getBytes();//��ȡ�����ı����ַ�
            try{
         	    InetAddress address=InetAddress.getByName(textIP.getText());//����Ŀ��IP��ַ	
         	    int DK=Integer.parseInt(textDK.getText());
         	    DatagramPacket SendPacket=new DatagramPacket(data,data.length,address,DK);
         	    //������һ����Ŀ���ַ������UDP���ݰ���Ŀ��˿�Ϊ2013
         	   
         	    DatagramSocket Post=new DatagramSocket();//����UDP���Ͷ���
         	    Post.send(SendPacket); //��������
         	    textRecv.setText(textRecv.getText()+'\n'+"�ң�"+textSend.getText());  //��ʾ����	
         	    
         	    
         	}	
         	catch(Exception e1){}
        } 	//�ж��Ƿ���enter��,���������
}
	public void keyReleased(KeyEvent e){
		return;
	}
	public void keyTyped(KeyEvent e){return;}
	
	
	public void actionPerformed(ActionEvent e){	//���Ͱ�ť��Ӧ	
	   byte data[]=("zhu��磺"+textSend.getText()).getBytes();//��ȡ�����ı����ַ�
       try{
    	    InetAddress address=InetAddress.getByName(textIP.getText());//����Ŀ��IP��ַ
    	    int DK=Integer.parseInt(textDK.getText());
    	    DatagramPacket SendPacket=new DatagramPacket(data,data.length,address,DK);
    	    //������һ����Ŀ���ַ������UDP���ݰ���Ŀ��˿�Ϊ2013
    	   
    	    DatagramSocket Post=new DatagramSocket();//����UDP���Ͷ���
    	    Post.send(SendPacket); //��������
    	    textRecv.setText(textRecv.getText()+'\n'+"�ң�"+'\n'+textSend.getText());  //��ʾ����	
    	    
    	    
    	}	
    	catch(Exception e1){}
    }
    
    
    public void run()//�����߳�
  	{
  		byte data[]=new byte[1024];
  		try{  		
  		  DatagramSocket Recv=new DatagramSocket(2013);//����UDP���ն���
  		  DatagramPacket pack=new DatagramPacket(data,data.length);//����UDP�������ݰ�
  		  
  		  while(true)
  		  {
  			Recv.receive(pack); //����һ�����ݰ� 			  		
  			String s=new String(pack.getData(),0,pack.getLength());  //��ȡ���ݰ�		
  			textRecv.setText(textRecv.getText()+'\n'+textIP.getText()+'\n'+s);  //��ʾ����	
  			
  		  }  		
  		}
  		catch(Exception e1){}		
  	}
	
	
	
	}


class Liao {
    public static void main(String args[]) {
    	 
    	MyExtendsJFrame frame=new MyExtendsJFrame();//����������򴰿�
    	      
    	Thread readData=new Thread(frame);//���������߳�
    	readData.start();  	//�����߳�
       
}
}

