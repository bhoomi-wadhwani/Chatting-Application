package chatting.application;
import javax.swing.* ;
import java.awt.*;
import java.awt.event.* ;
import javax.swing.border.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.io.*;

public class Server implements ActionListener {
    
    JTextField text;
    JPanel a1;
    static Box vertical = Box.createVerticalBox();
    static JFrame f= new JFrame();    
    Server() {
        
        f.setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setBackground(new Color(7, 94, 84));
        p1.setBounds(0,0,450, 70);
        p1.setLayout(null);
        f.add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2= i1.getImage().getScaledInstance(25, 25 , Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2) ;
        JLabel back =new JLabel(i3) ;
        back.setBounds(10,20,25,25);
        p1.add(back);
        
        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                System.exit(0) ;    
            }
        }) ;
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/1.png"));
        Image i5= i4.getImage().getScaledInstance(50, 50 , Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5) ;
        JLabel profile =new JLabel(i6) ;
        profile.setBounds(45,10,50,50);
        p1.add(profile);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT) ;
        ImageIcon i9 =new ImageIcon(i8);
        JLabel vedio =new JLabel(i9);
        vedio.setBounds(280,20,30,30);
        p1.add(vedio);
        
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT) ;
        ImageIcon i12 =new ImageIcon(i11);
        JLabel phone =new JLabel(i12);
        phone.setBounds(330,20,35,30);
        p1.add(phone);
        
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT) ;
        ImageIcon i15 =new ImageIcon(i14);
        JLabel dots =new JLabel(i15);
        dots.setBounds(380,21,10,25);
        p1.add(dots);
        
        JLabel name= new JLabel("Anish");
        name.setBounds(110 , 15, 100, 18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF", Font.BOLD , 18));
        p1.add(name);
        
        JLabel status= new JLabel("Active Now");
        status.setBounds(110 , 35, 100, 18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF", Font.BOLD , 14));
        p1.add(status);
        
        a1= new JPanel();
        a1.setBounds(5, 75, 390,570); //phele wala left is kitna chahiye 2nd is uper se 3rd is panel ka width and 4th is panel ka height
        f.add(a1);
        
        text = new JTextField() ;
        text.setBounds(5,650,280,40);
        text.setFont(new Font("SAN_SERIF" , Font.PLAIN, 16));
        f.add(text);
        
        JButton send= new JButton("Send");
        send.setBounds(288,650,107, 40);
        send.setBackground(new Color(7,94,84));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        send.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        f.add(send);
        
        f.setSize(400,700) ;
        f.setLocation(150,20);
        f.setUndecorated(true); //to remove the default header 
        f.getContentPane().setBackground(Color.WHITE);
                
        f.setVisible(true);        
    }
    
    public void actionPerformed(ActionEvent ae){
        String out= text.getText();
        JPanel p2=formatLabel(out);
        
        a1.setLayout(new BorderLayout());
        
        JPanel right=new JPanel(new BorderLayout());
        right.add(p2, BorderLayout.LINE_END);
        vertical.add(right);
        vertical.add(Box.createVerticalStrut(15));
        
        
        a1.add(vertical, BorderLayout.PAGE_START);
        text.setText("");
        f.repaint();
        f.invalidate();
        f.validate();
    }
    
    public static JPanel formatLabel(String out){
        JPanel panel= new JPanel();
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel output= new JLabel("<html><p style=\"width: 150px\">"+ out +"</p></html>");
        output.setFont(new Font("Tahoma",Font.PLAIN, 16));
        output.setBackground(new Color(37,211,102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15,15,15,50));
        
        
        panel.add(output);
        
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
        
        JLabel time=new JLabel();
        time.setText(sdf.format(cal.getTime()));
        
        panel.add(time); 
        
        
        return panel;
    }
    
    public static void main(String args[]) {
        new Server();
        
        try{
            ServerSocket skt=new ServerSocket(6001);
            while(true) {
                Socket s= skt.accept();
                DataInputStream din= new DataInputStream(s.getInputStream());
                DataOutputStream dout= new DataOutputStream(s.getOutputStream());
                
                while(true){
                    String msg=din.readUTF();
                    JPanel panel=formatLabel(msg);
                    
                    JPanel left = new JPanel(new BorderLayout());
                    left.add(panel, BorderLayout.LINE_START);
                    vertical.add(left);
                    f.validate();
                }
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
        
    
}
