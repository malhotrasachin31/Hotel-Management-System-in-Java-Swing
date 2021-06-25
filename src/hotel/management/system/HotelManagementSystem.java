package hotel.management.system;

//import classes for project// 

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener
{
        Font f1=new Font("arial",Font.PLAIN,65);
        Font f2=new Font("arial",Font.PLAIN,18);
        JPanel p1;
       HotelManagementSystem()
       {
           
           super("HOTEL MANAGEMENT SYSTEM");
        /*p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,700,30);
        p1.setBackground(Color.BLACK);
        add(p1);
        
        JLabel l6=new JLabel("LOGIN-FORM");
        l6.setBounds(300,7,300,30);
        l6.setForeground(Color.CYAN);
        l6.setFont(f1);
        p1.add(l6);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/3.png"));
        Image i2=i1.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel("first");
        l1.setBounds(10,7,30,30);
        l1.setIcon(i3);
        p1.add(l1);
          
        l1.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e1)
            {
                  System.exit(0);
            }
        });*/
           
           ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpg"));
           Image i2=i1.getImage();
           ImageIcon i3=new ImageIcon(i2);
           JLabel l1=new JLabel("first-Image");
           l1.setIcon(i3);
           l1.setLayout(null);
           l1.setBounds(0,0,1100,400);
           add(l1);
           
           JLabel l2=new JLabel("HOTEL MANAGEMENT SYSTEM");
           l2.setBounds(100,450,1000,70);
           l2.setForeground(Color.YELLOW);
           l2.setFont(f1);
           l1.add(l2);
           
           JButton b1=new JButton("NEXT");
           b1.setFocusable(false);
           b1.setBounds(1150,470,100,40);
           b1.setForeground(Color.WHITE);
           b1.setFont(f2);
           b1.setBackground(Color.green);
           l1.add(b1);
           b1.addActionListener(this);
           
          setSize(1380,600);
          setVisible(true);
          setLayout(null);
          getContentPane().setBackground(Color.red);
          setLocation(350,200);  
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
           while(true)
           {
                 l2.setVisible(false);
               try{
                   Thread.sleep(300);
               }catch(Exception e1){
               
               };
                 l2.setVisible(true);
               try{
                   Thread.sleep(300);
               }catch(Exception e2)
               {
                   
               };
           }
           
         
              
       }
    public static void main(String[] args) 
    {
        new HotelManagementSystem().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        new Login().setVisible(true);
        dispose();
    }

   
    
}
