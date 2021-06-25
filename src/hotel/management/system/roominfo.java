package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class roominfo extends JFrame implements ActionListener
{
    JMenuBar mb;
    JTable t1;
    JButton b1,b2;
    Font f1=new Font("verdana",Font.BOLD,14);
    roominfo()
    {
       super("ROOM INFORMATION"); 
      
       mb=new JMenuBar();
       mb.setLayout(null);
       mb.setBackground(Color.BLACK);
       mb.setForeground(Color.WHITE);
       mb.setBounds(0,0,1200,40);
       add(mb);
       
       JLabel l1=new JLabel("ROOM NO");
        l1.setBounds(10,7,100,20);
        l1.setFont(f1);
        l1.setForeground(Color.WHITE);
        mb.add(l1);
        
           JLabel l2=new JLabel("AVAILABLE");
           l2.setBounds(137,7,100,20);
           l2.setFont(f1);
           l2.setForeground(Color.WHITE);
           mb.add(l2);
          
          JLabel l3=new JLabel("STATUS");
        l3.setBounds(270,7,100,20);
        l3.setFont(f1);
        l3.setForeground(Color.WHITE);
        mb.add(l3);
          
          JLabel l4=new JLabel("PRICE");
        l4.setBounds(390,7,100,20);
        l4.setFont(f1);
        l4.setForeground(Color.WHITE);
        mb.add(l4);
          
          JLabel l5=new JLabel("TYPE");
        l5.setBounds(496,7,100,20);
        l5.setFont(f1);
        l5.setForeground(Color.WHITE);
        mb.add(l5);
          
       
       t1=new JTable();
       t1.setBounds(0,40,600,450);
       t1.setBackground(Color.WHITE);
       add(t1);
       
       b1=new JButton("Load Details");
        b1.setBounds(50,500,200,40);
        b1.setBackground(Color.black);
        b1.setFocusable(false);
        b1.setForeground(Color.white);
        b1.setFont(f1);
        add(b1);
        b1.addActionListener(this);
       
       b2=new JButton("Back");
        b2.setBounds(350,500,200,40);
        b2.setBackground(Color.black);
        b2.setFocusable(false);
        b2.setForeground(Color.white);
        b2.setFont(f1);
        add(b2);
        b2.addActionListener(this);
       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/twelve.jpg"));
        Image i2=i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l=new JLabel("");
        l.setIcon(i3);
        l.setBounds(600,40,600,600);
        add(l);
        
       setSize(1200,600);
       setLocation(400,200);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setResizable(false);
       getContentPane().setBackground(Color.white);
       setLayout(null);
    }
    public static void main(String [] args)
    {
        new roominfo().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String s=e.getActionCommand();
     if(s.equals("Load Details"))
     {
         try{
             Class.forName("org.apache.derby.jdbc.ClientDriver");
             Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/malhotra","java","java");
             PreparedStatement pst=null;
             ResultSet rs=null;
             String q="select * from ADDROOMS ";
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
