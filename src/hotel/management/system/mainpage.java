package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mainpage extends JFrame implements ActionListener
{
    JPanel p1;
    Font f1=new Font("arial",Font.BOLD,70);
    Font f2=new Font("arial",Font.BOLD,24);
    Font f3=new Font("arial",Font.BOLD,18);
    
    JMenuBar mb;
    JMenu m,m1;
    JMenuItem mi1,mi2,mi3,mi4;
    
    mainpage()
    {
        p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(9,86,97));
        p1.setBounds(0,0,1925,50);
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/3.png"));
        Image i2=i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel("");
        l1.setBounds(20,10,30,30);
        l1.setIcon(i3);
        p1.add(l1);
        l1.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent me)
            {
                System.exit(0);
            }
        });
        
        JLabel l2=new JLabel("HOTEL MANAGEMENT SYSTEM");
        l2.setBounds(750,10,400,30);
        l2.setForeground(Color.white);
        l2.setFont(f2);
        p1.add(l2);
        
        mb=new JMenuBar();
        mb.setBounds(0,50,1925,40);
        mb.setBackground(Color.BLACK);
        add(mb);
        
        m=new JMenu("Hotel Management ");
        m.setBounds(50,55,200,30);
        m.setFont(f3);
        m.setForeground(Color.WHITE);
        mb.add(m);
        
        mi1=new JMenuItem("Reception");
        mi1.setForeground(Color.white);
        mi1.setBackground(Color.BLACK);
        mi1.setFont(f3);
        m.add(mi1);
        mi1.addActionListener(this);
        
        m1=new JMenu("Service Panel ");
        m1.setBounds(300,55,200,30);
        m1.setFont(f3);
        m1.setForeground(Color.WHITE);
        mb.add(m1);
        
        mi2=new JMenuItem("Add Employee");
        mi2.setForeground(Color.white);
        mi2.setBackground(Color.BLACK);
        mi2.setFont(f3);
        m1.add(mi2);
        mi2.addActionListener(this);
        
        mi3=new JMenuItem("Add Rooms");
        mi3.setForeground(Color.white);
        mi3.setBackground(Color.BLACK);
        mi3.setFont(f3);
        m1.add(mi3);
        mi3.addActionListener(this);
        
        mi4=new JMenuItem("Add Drivers");
        mi4.setForeground(Color.white);
        mi4.setBackground(Color.BLACK);
        mi4.setFont(f3);
        m1.add(mi4);
        mi4.addActionListener(this);
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/third.jpg"));
        Image i5=i4.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel l4=new JLabel("");
        l4.setLayout(null);
        l4.setIcon(i6);
        l4.setBounds(0,85,1925,1080);
        add(l4);
        
        JLabel l5=new JLabel("TAJ HOTEL WELCOMES YOU");
        l5.setFont(f1);
        l5.setBounds(500,90,1000,60);
        l5.setForeground(Color.WHITE);
        l4.add(l5);
        
        setLayout(null);
        setSize(1925,1090);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
    }
    public static void main(String[] args)
    {
        new mainpage().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String s=e.getActionCommand();
     if(s.equals("Reception"))
     {
         new reception().setVisible(true);
     }
     if(s.equals("Add Employee"))
     {
         new addemployee().setVisible(true);
     }
     if(s.equals("Add Drivers"))
     {
         new adddrivers().setVisible(true);
     }
     if(s.equals("Add Rooms"))
     {
         new addrooms().setVisible(true);
     }
    }
}
