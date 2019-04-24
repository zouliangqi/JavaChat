import javax.swing.*;
import static javax.swing.JFrame.*; //����JFrame�ľ�̬����
import java.awt.event.*;
import java.awt.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.border.EmptyBorder;

class AddFriendJFrame extends JFrame implements ActionListener{
    JTextField textip,textport,ip,port;
    JButton Add;
    MyExtendsJFrame jframe;
    int numberfriend;
    String ipaddress,portnumber;

    public AddFriendJFrame(MyExtendsJFrame jf){
        setTitle("��Ӻ���");
        setBounds(300,225,350,300);
        setLayout(null);
        init();
        jframe = jf;
        numberfriend = jf.numberfriend;
    }

    void init(){
        textip = new JTextField();
        textip.setBounds(130, 50, 150, 40);
        add(textip);

        textport = new JTextField();
        textport.setBounds(130, 100, 150, 40);
        add(textport);

        ip = new JTextField();
        ip.setBounds(50, 50, 80, 40);
        ip.setText("IP:");
        ip.setFont(new Font("����",Font.PLAIN,18));
        ip.setHorizontalAlignment(JTextField.CENTER);
        ip.setEditable(false);
        ip.setBackground(getBackground());
        ip.setBorder(new EmptyBorder(0,0,0,0));
        add(ip);

        port = new JTextField();
        port.setBounds(50, 100, 80, 40);
        port.setText("�˿�:");
        port.setFont(new Font("����",Font.PLAIN,18));
        port.setHorizontalAlignment(JTextField.CENTER);
        port.setEditable(false);
        port.setBackground(getBackground());
        port.setBorder(new EmptyBorder(0,0,0,0));
        add(port);

        Add = new JButton("ȷ��");
        Add.setBounds(200, 150, 80, 40);
        Add.addActionListener(this);//��ӹ���
        add(Add);

        setVisible(true);//��������������ִ��
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        ipaddress = textip.getText();
        portnumber = textport.getText();
        if(ipaddress.isEmpty() || portnumber.isEmpty()){
            return;
        }
        int height = numberfriend * 25+45;

        jframe.Friend[numberfriend].setBounds(690, height,120,25);
        jframe.Friend[numberfriend].setBackground(Color.lightGray);
        jframe.Friend[numberfriend].setText(ipaddress);
        jframe.add(jframe.Friend[numberfriend]);




        jframe.repaint();
        hide();
    }
}

class MyExtendsJFrame extends JFrame implements ActionListener , Runnable,KeyListener{
    //�Զ��崰���࣬
    //1.�̳д����࣬������ƴ��壻
    //2.ʵ��ActionListener��������Ӧ��ť����¼�
    //3.ʵ��Runnable����дrun����������ִ�н����߳�

    JTextField textIp,textPort;
    JTextArea textSend,textRecv,textLink;
    JButton j2,j1,j3,j4,j5,buttonSend,buttonkong,buttonFriend;
    JButton[] Friend=new JButton[10];
    JLabel jlabel;
    ImageIcon qq = new ImageIcon(hhh.class.getResource("qq.png"));
    int numberfriend=0;



    public MyExtendsJFrame(){
        setTitle("�������");
        setBounds(160,100,850,470);
        setLayout(null);
        setBackground(Color.gray);
        init();   //��ӿؼ��Ĳ�����װ��һ������
        setVisible(true);//��������������ִ��
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    void init(){//��ӵĿؼ�
        Font font=new Font("����",Font.BOLD,15);
        Font font1=new Font("����",Font.BOLD,17);
        Font font2=new Font("����",Font.BOLD,18);

        buttonFriend=new JButton("��Ӻ��� +");
        buttonFriend.setBounds(690,35,120,25);
        buttonFriend.setBorder(null);
        buttonFriend.setBackground(Color.gray);
        buttonFriend.addActionListener(this);//��ӹ���
        add(buttonFriend);

        JButton jl=new JButton("�����б�");
        jl.setFont(font1);
        jl.setBackground(Color.lightGray);
        jl.setBounds(675, 5,150,25);
        jl.setBorder(null);
        add(jl);

        JButton jl3=new JButton();
        jl3.setFont(font1);
        jl3.setBackground(Color.lightGray);
        jl3.setBounds(680, 400,140,25);
        jl3.setBorder(null);
        add(jl3);

        JButton jl1=new JButton();
        jl1.setBackground(Color.lightGray);
        jl1.setBounds(675, 30,5,395);
        jl1.setBorder(null);
        add(jl1);

        JButton jl2=new JButton();
        jl2.setBackground(Color.lightGray);
        jl2.setBounds(820, 30,5,395);
        jl2.setBorder(null);
        add(jl2);

        textLink=new JTextArea();
        textLink.setBounds(205,5,460,25);
        textLink.setBorder(null);
        textLink.setFont(font1);
        textLink.setBackground(Color.lightGray);
        textLink.setEditable(false);
        add(textLink);

        textSend=new JTextArea();
        textSend.setBounds(205,335,390,90);
        textSend.setBorder(null);
        textSend.setFont(font1);
        textSend.setLineWrap(true);
        textSend.setBackground(Color.lightGray);
        // textSend.setLineWrap(true);
        add(textSend);
        textSend.addKeyListener(this);

        buttonkong=new JButton();
        buttonkong.setBounds(595,335,70,55);
        buttonkong.setBorder(null);
        buttonkong.setBackground(Color.lightGray);
        add(buttonkong);



        textRecv=new JTextArea();
        Color c4=new Color(195,195,195);
        textRecv.setBackground(c4);
        textRecv.setFont(font1);
        textRecv.setEditable(false);
        textRecv.setOpaque(false);
        textRecv.setLineWrap(true);
        add(textRecv);

        JScrollPane jsp=new JScrollPane(textRecv);
        jsp.setBounds(205,35,460,295);
        jsp.setBorder(null);
        jsp.setOpaque(false);
        jsp.getViewport().setOpaque(false);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(jsp);

        jlabel = new JLabel(qq);
        jlabel.setBounds(205,35,460,295);
        add(jlabel);

        buttonSend=new JButton("Send");
        buttonSend.setBounds(595,390,70,35);
        buttonSend.setFont(font);
        buttonSend.setForeground(Color.white);
        buttonSend.setBackground(Color.black);
        buttonSend.addActionListener(this);//��ӹ���
        add(buttonSend);



        j1=new JButton("IP");
        j1.setBounds(5,35,70,30);
        j1.setFont(font2);
        j1.setBorder(null);
        j1.setForeground(Color.white);
        j1.setBackground(Color.GRAY);
        add(j1);

        j2=new JButton("�˿�");
        j2.setBounds(5,65,70,30);
        j2.setBorder(null);
        j2.setFont(font2);
        Color c3=new Color(120,120,120);
        j2.setForeground(Color.white);
        j2.setBackground(c3);
        add(j2);

        j3=new JButton("����");
        j3.setBounds(5,5,190,25);
        j3.setFont(font1);
        j3.setBorder(null);
        j3.setForeground(Color.black);
        j3.setBackground(Color.lightGray);
        add(j3);

//      // Icon i=new ImageIcon(".//ren.png");
        j4=new JButton(new ImageIcon(getClass().getClassLoader().getResource("ren.png")));
        j4.setBounds(5,125,190,300);
        j4.setFont(font1);
        j4.setBorder(null);
        j4.setForeground(Color.white);
        j4.setBackground(Color.gray);
        add(j4);

        j5=new JButton("����");
        j5.setBounds(5,100,190,25);
        j5.setFont(font1);
        j5.setBorder(null);
        Color c2=new Color(160,160,160);
        j5.setForeground(Color.black);
        j5.setBackground(c2);
        add(j5);
        j5.addActionListener(this);


        textIp=new JTextField(20);
        textIp.setBounds(75,35,120,30);
        textIp.setFont(font);
        textIp.setBorder(null);
        Color c=new Color(180,180,180);
        textIp.setBackground(c);
        add(textIp);

        textPort=new JTextField(20);
        textPort.setBounds(75,65,120,30);
        textPort.setFont(font);
        textPort.setBorder(null);
        Color c1=new Color(170,170,170);
        textPort.setBackground(c1);
        add(textPort);




        for(int i=0;i<10;i++){
            Friend[i]=new JButton();
            Friend[i].addActionListener(this);
        }



    }
    public void actionPerformed(ActionEvent e){	//���Ͱ�ť��Ӧ

        if(textSend.getText()==null)
            return;

        if(e.getSource()==buttonFriend){
            numberfriend++;
            AddFriendJFrame addfriend=new AddFriendJFrame(this);

        }
       //
         for(int i=1;i<=numberfriend;i++){
            if(e.getSource()==Friend[i]){
                textIp.setText(Friend[i].getText());
                textPort.setText("2013");
                textRecv.setText(null);
                j5.doClick();
            }
        }

        if(e.getSource()==j5){
            textLink.setText("�����ӵ�"+textIp.getText());
        }

        if(e.getSource()==buttonSend){

            byte data[]=textSend.getText().getBytes();//��ȡ�����ı����ַ�

            try{
                String s=textIp.getText();
                InetAddress address=InetAddress.getByName(s);//����Ŀ��IP��ַ	"192.168.137.1""192.168.4.111"
                int t=Integer.parseInt(textPort.getText());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                textRecv.setText(textRecv.getText()+'\n'+sdf.format(new Date())+'\n'+"��: "+textSend.getText()+'\n');
                textSend.setText(null);
                DatagramPacket SendPacket=new DatagramPacket(data,data.length,address,t);
                //������һ����Ŀ���ַ������UDP���ݰ���Ŀ��˿�Ϊ2013
                DatagramSocket Post=new DatagramSocket();//����UDP���Ͷ���
                Post.send(SendPacket); //��������

            }
            catch(Exception e1){}
        }
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
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                textRecv.setText(textRecv.getText()+'\n'+sdf.format(new Date())+'\n'+"��: "+s);  //��ʾ����

            }
        }
        catch(Exception e1){}
    }

    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if( e.getKeyCode()==KeyEvent.VK_ENTER){
            byte data[]=textSend.getText().getBytes();//��ȡ�����ı����ַ�
            try{
                String s=textIp.getText();
                InetAddress address=InetAddress.getByName(s);//����Ŀ��IP��ַ	"192.168.43.205"
                int t=Integer.parseInt(textPort.getText());
                textRecv.setText(textRecv.getText()+'\n'+"��:"+textSend.getText());
                textSend.setText(null);
                DatagramPacket SendPacket=new DatagramPacket(data,data.length,address,t);
                //������һ����Ŀ���ַ������UDP���ݰ���Ŀ��˿�Ϊ2013

                DatagramSocket Post=new DatagramSocket();//����UDP���Ͷ���
                Post.send(SendPacket); //��������

            }
            catch(Exception e1){}

        }



    }
    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        return;
    }
    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        return;
    }

    static String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(new Date());
    }

}



class hhh {
    public static void main(String args[]) {

        MyExtendsJFrame frame=new MyExtendsJFrame();//����������򴰿�

        Thread readData=new Thread(frame);//���������߳�
        readData.start();  	//�����߳�

    }
}