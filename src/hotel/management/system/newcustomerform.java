package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import net.proteanit.sql.*;

public class newcustomerform extends JFrame implements ActionListener
{
    Font f1=new Font("verdana",Font.BOLD,40);
    Font f2=new Font("arial",Font.BOLD,18);
    Font f3=new Font("arial",Font.BOLD,12);
    JTextField t1,t2,t3,t4,t5;
    JRadioButton r1,r2;
    JComboBox c2;
    JButton b1,b2;
    JTextField t6;
    newcustomerform()
    {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/seventh.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel("");
        l1.setIcon(i3);
        l1.setBounds(500,0,700,700);
        add(l1);
        
        JLabel l=new JLabel("ADD CUSTOMER");
        l.setBounds(70,10,400,40);
        l.setForeground(new Color(7,96,94));
        l.setFont(f1);
        add(l);
        
        JLabel l2=new JLabel("ID Number");
        l2.setBounds(40,70,100,30);
        l2.setFont(f2);
        add(l2);
        
        t6=new JTextField();
        t6.setBounds(250,70,200,30);
        t6.setForeground(Color.BLACK);
        t6.setFont(f2);
        add(t6);
        
        JLabel l3=new JLabel("Phone Number");
        l3.setBounds(40,130,200,30);
        l3.setFont(f2);
        add(l3);
        
        t1=new JTextField();
        t1.setForeground(Color.BLACK);
        t1.setFont(f2);
        t1.setBounds(250,130,200,30);
        add(t1);
        
        JLabel l4=new JLabel("Name");
        l4.setBounds(40,190,100,30);
        l4.setFont(f2);
        add(l4);
        
        t2=new JTextField();
        t2.setForeground(Color.BLACK);
        t2.setFont(f2);
        t2.setBounds(250,190,200,30);
        add(t2);
        
        JLabel l5=new JLabel("Gender");
        l5.setBounds(40,250,100,30);
        l5.setFont(f2);
        add(l5);
        
        r1=new JRadioButton("Male");
        r1.setBackground(Color.WHITE);
        r1.setFont(f2);
        r1.setFocusable(false);
        r1.setBounds(250,250,90,30);
        add(r1);
        
        r2=new JRadioButton("Female");
        r2.setBackground(Color.WHITE);
        r2.setFont(f2);
        r2.setFocusable(false);
        r2.setBounds(350,250,90,30);
        add(r2);
        
        JLabel l6=new JLabel("Country");
        l6.setBounds(40,310,100,30);
        l6.setFont(f2);
        add(l6);
        
        t3=new JTextField();
        t3.setForeground(Color.BLACK);
        t3.setFont(f2);
        t3.setBounds(250,310,200,30);
        add(t3);
        
        JLabel l7=new JLabel("Allocated room no.");
        l7.setBounds(40,370,200,30);
        l7.setFont(f2);
        add(l7);
        
        c2=new JComboBox();
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/malhotra","java","java");
            ResultSet rs=null;
            Statement pst=null;
            String q="select * from ADDROOMS ";
            pst=conn.createStatement();
            rs=pst.executeQuery("select ROOMNUMBER from ADDROOMS  ");
             while(rs.next())
             {
                 String number=rs.getString("ROOMNUMBER");
                 c2.addItem(number);
             
             }
            
        }catch(Exception ex){System.out.println(ex);};
        c2.setBounds(250,370,200,30);
        c2.setFont(f2);
        add(c2);
        
        JLabel l8=new JLabel("Checked In");
        l8.setBounds(40,430,100,30);
        l8.setFont(f2);
        add(l8);
        
        t4=new JTextField();
        t4.setForeground(Color.BLACK);
        t4.setFont(f2);
        t4.setBounds(250,430,200,30);
        add(t4);
        
        JLabel l9=new JLabel("Deposit");
        l9.setBounds(40,490,100,30);
        l9.setFont(f2);
        add(l9);
        
        t5=new JTextField();
        t5.setForeground(Color.BLACK);
        t5.setFont(f2);
        t5.setBounds(250,490,200,30);
        add(t5);
        
        b1=new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setFocusable(false);
        b1.setForeground(Color.white);
        b1.setFont(f2);
        b1.setBounds(30,600,150,40);
        add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setFocusable(false);
        b2.setForeground(Color.white);
        b2.setFont(f2);
        b2.setBounds(300,600,150,40);
        add(b2);
        b2.addActionListener(this);
        
        setSize(1200,700);
        setLocation(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
    }
    public static void main(String [] args)
    {
        new newcustomerform().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
     String str=e.getActionCommand();
        String id=t6.getText();
        String phone=t1.getText();
        String name=t2.getText();
        if(r1.isSelected())
        {
            String gender="Male";
        }
        else if(r2.isSelected())
        {
            String gender="Female";
        }
        
        String country=t3.getText();
        String allocatedroom=c2.getSelectedItem().toString();
        String checkedin=t4.getText();
        String deposit=t5.getText();
        
     if(str.equals("Submit"))
     {
         
         
         try{
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/malhotra","java","java");
         PreparedStatement pst=null;
         String s="insert into CUSTOMERDETAILS values(?,?,?,?,?,?,?,?)";
        String s1="update ADDROOMS set STATUS = 'OCCUPIED' where ROOMNUMBER= ? ";
         pst = conn.prepareStatement(s); 
             pst.setString(1, t6.getText());
            pst.setString(2,t1.getText());
            pst.setString(3, t2.getText());
            if(r1.isSelected())
            {
                pst.setString(4, r1.getText());
            }
            else if(!r1.isSelected())
            {
                pst.setString(4, r2.getText());
            }
            
            pst.setString(5,t3.getText());
            pst.setString(6, c2.getSelectedItem().toString());
            pst.setString(7, t4.getText());
            pst.setString(8, t5.getText());
            
             int a = pst.executeUpdate();//Executing SQL
             
             pst=conn.prepareStatement(s1);
             pst.setString(1, allocatedroom);
              pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"CUSTOMER ADDED SUCCESSFULLY");
            pst.close();
            conn.close(); // Close Connection*/
         }catch(Exception ex)
         {
           System.out.println(ex) ; 
         };
      }
     if(str.equals("Back"))
     {
         new reception().setVisible(true);
         dispose();
     }
    }
}
