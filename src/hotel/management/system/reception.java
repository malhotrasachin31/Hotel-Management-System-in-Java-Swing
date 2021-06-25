package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class reception extends JFrame implements ActionListener
{
    Font f1=new Font("Verdana",Font.BOLD,14);
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13;
    reception()
    {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fourth.jpg"));
        Image i2=i1.getImage().getScaledInstance(590, 560, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel("");
        l1.setIcon(i3);
        l1.setBounds(250,0,590,600);
        add(l1);
        
        JButton b1=new JButton("New Customer Form");
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setFocusable(false);
        b1.setFont(f1);
        b1.setBounds(30,40,200,30);
        add(b1);
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e1)
            {
                new newcustomerform().setVisible(true);
                dispose();
            }
        });
        
        JButton b2=new JButton("Room");
         b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setFocusable(false);
         b2.setFont(f1);
        b2.setBounds(30,80,200,30);
        add(b2);
        b2.addActionListener(this);
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e1)
            {
                new roominfo().setVisible(true);
                dispose();
            }
        });
        
        
        JButton b3=new JButton("Department");
         b3.setForeground(Color.white);
        b3.setBackground(Color.black);
        b3.setFocusable(false);
         b3.setFont(f1);
        b3.setBounds(30,120,200,30);
        add(b3);
         b3.addActionListener(this);
         b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e1)
            {
                new companyowner().setVisible(true);
                dispose();
            }
        });
        
        JButton b4=new JButton("All Employee Info");
         b4.setForeground(Color.white);
        b4.setBackground(Color.black);
        b4.setFocusable(false);
        b4.setBounds(30,160,200,30);
         b4.setFont(f1);
        add(b4);
         b4.addActionListener(this);
         b4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e1)
            {
                new employeeinfo().setVisible(true);
                dispose();
            }
        });
        
        JButton b5=new JButton("Customer Info");
        b5.setForeground(Color.white);
        b5.setBackground(Color.black);
         b5.setFont(f1);
        b5.setFocusable(false);
        b5.setBounds(30,200,200,30);
        add(b5);
         b5.addActionListener(this);
         b5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e1)
            {
                new customerinfo().setVisible(true);
                dispose();
            }
        });
        
        JButton b6=new JButton("Manager Info");
         b6.setForeground(Color.white);
         b6.setFont(f1);
         b6.setBackground(Color.black);
        b6.setFocusable(false);
        b6.setBounds(30,240,200,30);
        add(b6);
         b6.addActionListener(this);
         b6.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e1)
            {
                new managerinfo().setVisible(true);
                dispose();
            }
        });
         
        
        JButton b7=new JButton("Check out");
         b7.setForeground(Color.white);
         b7.setFont(f1);
         b7.setBackground(Color.black);
        b7.setFocusable(false);
        b7.setBounds(30,280,200,30);
        add(b7);
         b7.addActionListener(this);
         b7.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e1)
            {
                new checkout().setVisible(true);
                dispose();
            }
        });
         
        
        JButton b9=new JButton("Update Room Status");
         b9.setForeground(Color.white);
         b9.setFont(f1);
         b9.setBackground(Color.black);
        b9.setFocusable(false);
        b9.setBounds(30,320,200,30);
        add(b9);
         b9.addActionListener(this);
         b9.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e1)
            {
                new updateroomstatus().setVisible(true);
                dispose();
            }
        });
        
        JButton b10=new JButton("Pick-up Service");
         b10.setForeground(Color.white);
        b10.setBackground(Color.black);
         b10.setFont(f1);
        b10.setFocusable(false);
        b10.setBounds(30,360,200,30);
        add(b10);
         b10.addActionListener(this);
         b10.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e1)
            {
                new pickupservice().setVisible(true);
                dispose();
            }
        });
         
        
        JButton b11=new JButton("Search Room");
         b11.setForeground(Color.white);
        b11.setBackground(Color.black);
         b11.setFont(f1);
        b11.setFocusable(false);
        b11.setBounds(30,400,200,30);
        add(b11);
         b11.addActionListener(this);
         b11.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e1)
            {
                new searchroom().setVisible(true);
                dispose();
            }
        });
        
        JButton b12=new JButton("Logout");
         b12.setForeground(Color.white);
        b12.setBackground(Color.black);
         b12.setFont(f1);
        b12.setFocusable(false);
        b12.setBounds(30,440,200,30);
        add(b12);
         b12.addActionListener(this); 
         b12.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e1)
            {
                new mainpage().setVisible(false);
                new Login().setVisible(true);
                dispose();
            }
        });
         
        
         JButton b13=new JButton("Back");
         b13.setForeground(Color.white);
        b13.setBackground(Color.black);
         b13.setFont(f1);
        b13.setFocusable(false);
        b13.setBounds(250,250,200,40);
        l1.add(b13);
         b13.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent e1)
             {
                 dispose();
             }
         }); 
         
        setSize(850,600);
        setLocation(550,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(Color.ORANGE);
        setUndecorated(true);
    }
    public static void main(String [] args)
    {
        new reception().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
    }
}
