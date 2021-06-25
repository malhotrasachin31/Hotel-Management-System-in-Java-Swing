package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class updateroomstatus extends JFrame implements ActionListener
{
    Font f1=new Font("sans-serif",Font.BOLD,40);
    Font f2=new Font("sans-serif",Font.BOLD,18);
    JButton b1,b2,b3;
    JTextField t1,t2,t3;
    JComboBox c1;
    updateroomstatus()
    {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/seventh.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 600, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel("");
        l1.setIcon(i3);
        l1.setBounds(483,25,700,500);
        add(l1);
        
        JLabel l2=new JLabel("Update Room Status");
        l2.setBounds(40,20,400,40);
        l2.setFont(f1);
        add(l2);
        
        JLabel l3=new JLabel("ID Number");
        l3.setBounds(20,100,200,30);
        l3.setFont(f2);
        add(l3);
        
        c1=new JComboBox();
        c1.setBounds(250,100,200,30);
         try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/malhotra","java","java");
            ResultSet rs=null;
            Statement pst=null;
            String q="select * from CUSTOMERDETAILS";
            pst=conn.createStatement();
            rs=pst.executeQuery("select ID from CUSTOMERDETAILS");
             while(rs.next())
             {
                 String number=rs.getString("ID");
                 c1.addItem(number);
             }
         }catch(Exception ex){System.out.println(ex);};
         c1.setFont(f2);
        add(c1);
        
        JLabel l4=new JLabel("Room Number");
        l4.setBounds(20,150,200,30);
        l4.setFont(f2);
        add(l4);
        
        t1=new JTextField();
        t1.setForeground(Color.BLACK);
        t1.setFont(f2);
        t1.setBounds(250,150,200,30);
        add(t1);
        
        JLabel l5=new JLabel("Availability");
        l5.setBounds(20,200,200,30);
        l5.setFont(f2);
        add(l5);
        
        t2=new JTextField();
        t2.setForeground(Color.BLACK);
        t2.setFont(f2);
        t2.setBounds(250,200,200,30);
        add(t2);
        
        JLabel l6=new JLabel("Clean status");
        l6.setBounds(20,250,200,30);
        l6.setFont(f2);
        add(l6);
        
        t3=new JTextField();
        t3.setForeground(Color.BLACK);
        t3.setFont(f2);
        t3.setBounds(250,250,200,30);
        add(t3);
        
        b1=new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setFocusable(false);
        b1.setForeground(Color.white);
        b1.setFont(f2);
        b1.setBounds(10,450,150,40);
        add(b1);
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae) 
            {
               		System.out.println("hekki");
                            try{
                                    String s1 = c1.getSelectedItem().toString();
		Class.forName("org.apache.derby.jdbc.ClientDriver");
                                    Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/malhotra","java","java");
                                    ResultSet rs=null;
                                    PreparedStatement pst=null;		
                                    ResultSet rs1 = pst.executeQuery("SELECT * FROM CUSTOMERDETAILS WHERE ID = ?");
                                    pst.setString(1, s1);
                                    int a=pst.executeUpdate();
                                     if(rs.next())
                                             t1.setText(rs.getString("ROOMNUMBER"));
                               
                            }catch(Exception ee){};
                            /*try{
                               Class.forName("org.apache.derby.jdbc.ClientDriver");
                                 Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/malhotra","java","java");
                                ResultSet rs=null;
                                PreparedStatement pst=null;		 
                                ResultSet rs2 = pst.executeQuery("select * from addrooms where roomnumber = "+t1.getText());
                                while(rs2.next()){
                                    
                                    t2.setText(rs2.getString("availabie")); 
                                    t3.setText(rs2.getString("status"));
                                }
                            catch(Exception ee){}*/
            }
        
          
           
          });
        b2=new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setFocusable(false);
        b2.setForeground(Color.white);
        b2.setFont(f2);
        b2.setBounds(170,450,150,40);
        add(b2);
        b2.addActionListener(this);
        
       b3=new JButton("Update");
        b3.setBackground(Color.BLACK);
        b3.setFocusable(false);
        b3.setForeground(Color.white);
        b3.setFont(f2);
        b3.setBounds(330,450,150,40);
        add(b3);
        b3.addActionListener(this);
        
        setSize(1200,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(400,200);
        getContentPane().setBackground(Color.white);
        setResizable(true);
    }
    public static void main(String args[])
    {
     new updateroomstatus().setVisible(true);   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String s=e.getActionCommand();
       
       if(s.equals("Back"))
       {
           new reception().setVisible(true);
           dispose();
       }
       
     
       
    }
}
