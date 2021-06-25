package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class managerinfo extends JFrame implements ActionListener
{
    JTable t1;
    JMenuBar mb;
    JButton b1,b2;
    Font f1=new Font("verdana",Font.BOLD,14);
    managerinfo()
    {
        mb=new JMenuBar();
        mb.setLayout(null);
        mb.setBackground(Color.BLACK);
        mb.setForeground(Color.white);
        mb.setBounds(0,0,1200,40);
        add(mb);
        
        JLabel l1=new JLabel("NAME");
        l1.setBounds(10,7,100,20);
        l1.setFont(f1);
        l1.setForeground(Color.WHITE);
        mb.add(l1);
        
           JLabel l2=new JLabel("AGE");
           l2.setBounds(147,7,100,20);
           l2.setFont(f1);
           l2.setForeground(Color.WHITE);
           mb.add(l2);
          
          JLabel l3=new JLabel("GENDER");
        l3.setBounds(300,7,100,20);
        l3.setFont(f1);
        l3.setForeground(Color.WHITE);
        mb.add(l3);
          
          JLabel l4=new JLabel("JOB");
        l4.setBounds(447,7,100,20);
        l4.setFont(f1);
        l4.setForeground(Color.WHITE);
        mb.add(l4);
          
          JLabel l5=new JLabel("SALARY");
        l5.setBounds(596,7,100,20);
        l5.setFont(f1);
        l5.setForeground(Color.WHITE);
        mb.add(l5);
          
          JLabel l6=new JLabel("PHONE NO.");
        l6.setBounds(750,7,100,20);
        l6.setFont(f1);
        l6.setForeground(Color.WHITE);
        mb.add(l6);
          
          JLabel l7=new JLabel("AADHAAR");
        l7.setBounds(900,7,100,20);
        l7.setFont(f1);
        l7.setForeground(Color.WHITE);
        mb.add(l7);
          
          JLabel l8=new JLabel("EMAIL-ID");
        l8.setBounds(1050,7,100,20);
        l8.setFont(f1);
        l8.setForeground(Color.WHITE);
        mb.add(l8);
          
        
        t1=new JTable();
        t1.setBackground(Color.WHITE);
        t1.setBounds(0,40,1200,400);
        add(t1);
        
        b1=new JButton("Load Details");
        b1.setBounds(300,500,200,40);
        b1.setBackground(Color.black);
        b1.setFocusable(false);
        b1.setForeground(Color.white);
        b1.setFont(f1);
        add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Back");
        b2.setBounds(700,500,200,40);
        b2.setBackground(Color.black);
        b2.setFocusable(false);
        b2.setForeground(Color.white);
        b2.setFont(f1);
        add(b2);
        b2.addActionListener(this);
        
        
        setSize(1200,600);
        setLocation(400,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
    }
    public static void main(String [] args)
    {
        new managerinfo().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s=e.getActionCommand();
        
        if(s.equals("Load Details"))
        {
            try{
                //System.out.println("hello");
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/malhotra","java","java");
                PreparedStatement pst=null;
                ResultSet rs=null;
                String q="select * from EMPLOYEEDETAILS where JOB='Hotel Manager' ";
                //System.out.println("hello");
                pst=con.prepareStatement(q);
                rs=pst.executeQuery();
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception ex){System.out.println(ex);};
        }
        if(s.equals("Back"))
        {
          new reception().setVisible(true);
           dispose(); 
        }  
    }
}
