package hotel.management.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.proteanit.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class department extends JFrame implements ActionListener
{
     JMenuBar mb;
    JButton b1,b2;
    JTable t1;
     Font f1=new Font("sans-serif",Font.BOLD,16);
    department()
    {
        mb=new JMenuBar();
        mb.setBackground(Color.BLACK);
        mb.setLayout(null);
        mb.setBounds(0,0,1200,30);
        add(mb);
        
         t1=new JTable();
        t1.setBackground(Color.white);
        t1.setBounds(0,40,1200,650);
        t1.setFont(f1);
        add(t1);
        
        b1=new JButton("Load Details");
        b1.setBackground(Color.BLACK);
        b1.setFocusable(false);
        b1.setForeground(Color.white);
        b1.setFont(f1);
        b1.setBounds(300,700,200,40);
        add(b1);
        b1.addActionListener(this);
        
        JLabel l1=new JLabel("DEPARTMENT");
        l1.setBounds(100,7,400,20);
        l1.setFont(f1);
        l1.setForeground(Color.WHITE);
        mb.add(l1);
        
           JLabel l2=new JLabel("BUDGET PER DEPARTMENT");
           l2.setBounds(647,7,400,20);
           l2.setFont(f1);
           l2.setForeground(Color.WHITE);
           mb.add(l2);
        
        b2=new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setFocusable(false);
        b2.setForeground(Color.white);
        b2.setFont(f1);
        b2.setBounds(600,700,200,40);
        add(b2);
        b2.addActionListener(this);
        
        
        setSize(1200,800);
        setLocation(400,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setResizable(false);
    }
 public static void main(String args[])
 {
     new department().setVisible(true);
 }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s=e.getActionCommand();
       if(s.equals("Back"))
       {
           new reception().setVisible(true);
           dispose();
       }
       if(s.equals("Load Details"))
       {
           try{
               
           Class.forName("org.apache.derby.jdbc.ClientDriver");
           Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/malhotra","java","java");
           PreparedStatement pst=null;
         
           ResultSet rs=null;
           String q="select * from DEPARTMENT";
           pst=con.prepareStatement(q);
           rs=pst.executeQuery();
           t1.setModel(DbUtils.resultSetToTableModel(rs));
           }catch(Exception ex){
           System.out.println(ex);
           };
    }
    }
}
