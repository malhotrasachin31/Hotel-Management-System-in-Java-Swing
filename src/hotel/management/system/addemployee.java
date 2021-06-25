package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class addemployee extends JFrame implements ActionListener
{
    
    Font f1=new Font("verdana",Font.BOLD,40);
    Font f2=new Font("arial",Font.BOLD,18);
    Font f3=new Font("arial",Font.BOLD,12);
    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JComboBox c1;
    
    addemployee()
    {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel("");
        l1.setIcon(i3);
        l1.setBounds(440,110,530,530);
        add(l1);
        
        JLabel l2=new JLabel("ADD EMPLOYEE DETAILS");
        l2.setFont(f1);
        l2.setBounds(410,40,600,40);
        l2.setForeground(Color.BLACK);
        add(l2);
        
        JLabel l3=new JLabel("Name");
        l3.setForeground(Color.BLACK);
        l3.setFont(f2);
        l3.setBounds(40,50,100,30);
        add(l3);
        
        t1=new JTextField();
        t1.setForeground(Color.BLACK);
        t1.setFont(f2);
        t1.setBounds(150,50,200,30);
        add(t1);
        
        JLabel l4=new JLabel("Age");
        l4.setForeground(Color.BLACK);
        l4.setFont(f2);
        l4.setBounds(40,100,200,30);
        add(l4);
        
        t2=new JTextField();
        t2.setForeground(Color.BLACK);
        t2.setFont(f2);
        t2.setBounds(150,100,200,30);
        add(t2);
        
        JLabel l5=new JLabel("Gender");
        l5.setForeground(Color.BLACK);
        l5.setFont(f2);
        l5.setBounds(40,150,200,30);
        add(l5);
        
        r1=new JRadioButton("Male");
        r1.setBackground(Color.WHITE);
        r1.setFont(f2);
        r1.setFocusable(false);
        r1.setBounds(150,150,90,30);
        add(r1);
        
        r2=new JRadioButton("Female");
        r2.setBackground(Color.WHITE);
        r2.setFont(f2);
        r2.setFocusable(false);
        r2.setBounds(250,150,90,30);
        add(r2);
        
        JLabel l6=new JLabel("Job");
        l6.setForeground(Color.BLACK);
        l6.setFont(f2);
        l6.setBounds(40,200,100,30);
        add(l6);
        
        c1=new JComboBox();
        c1.setFont(f2);
        c1.setBounds(150,200,200,30);
        c1.addItem("Musician");
        c1.addItem("Hotel Manager");
        c1.addItem("Room Service");
        c1.addItem("JuniorChef");
        c1.addItem("Senior Chef");
        c1.addItem("Receptionist");
        c1.addItem("Gardener");
        c1.addItem("Security Guard");
        c1.addItem("Velle Parking Man");
        add(c1);
        
        JLabel l7=new JLabel("Salary");
        l7.setForeground(Color.BLACK);
        l7.setFont(f2);
        l7.setBounds(40,250,200,30);
        add(l7);
        
        t3=new JTextField();
        t3.setForeground(Color.BLACK);
        t3.setFont(f2);
        t3.setBounds(150,250,200,30);
        add(t3);
        
        JLabel l8=new JLabel("Phone");
        l8.setForeground(Color.BLACK);
        l8.setFont(f2);
        l8.setBounds(40,300,200,30);
        add(l8);
        
        t4=new JTextField();
        t4.setForeground(Color.BLACK);
        t4.setFont(f2);
        t4.setBounds(150,300,200,30);
        add(t4);
        
        JLabel l9=new JLabel("AADHAAR");
        l9.setForeground(Color.BLACK);
        l9.setFont(f2);
        l9.setBounds(40,350,200,30);
        add(l9);
        
        t5=new JTextField();
        t5.setForeground(Color.BLACK);
        t5.setFont(f2);
        t5.setBounds(150,350,200,30);
        add(t5);
        
        JLabel l10=new JLabel("Email-ID");
        l10.setForeground(Color.BLACK);
        l10.setFont(f2);
        l10.setBounds(40,400,200,30);
        add(l10);
        
        t6=new JTextField();
        t6.setForeground(Color.BLACK);
        t6.setFont(f2);
        t6.setBounds(150,400,200,30);
        add(t6);
        
        JButton b1=new JButton("Submit");
        b1.setForeground(Color.BLACK);
        b1.setFont(f2);
        b1.setFocusable(false);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(30,490,150,40);
        add(b1);  
        b1.addActionListener(this);
        
         JButton b2=new JButton("Cancel");
        b2.setForeground(Color.BLACK);
        b2.setFont(f2);
        b2.setFocusable(false);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(200,490,150,40);
        add(b2);  
        b2.addActionListener(this);
        
        
        setSize(1000,700);
        setLocation(500,100);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
    }
 public static void main(String args[]) 
 {
     new addemployee().setVisible(true);
 }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String name=t1.getText();
        String age=t2.getText();
        String salary=t3.getText();
        String phone=t4.getText();
        String aadhar=t5.getText();
        String email=t6.getText();
        
        if(r1.isSelected())
        {
            String gender="Male";
        }
        else if(r2.isSelected())
        {
            String gender="Female";
        }
        
        String job=c1.getSelectedItem().toString();
            String s=e.getActionCommand();
        if(s.equals("Submit"))
            {
         try{
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/malhotra ", "java", "java"); // Connection build
            PreparedStatement pst = null; //complex queries
            // Statement st = null; simple (Select * from table where name = "sachin")
            String q = "insert into EMPLOYEEDETAILS values (?,?,?,?,?,?,?,?)"; // Sql Query
            pst = con.prepareStatement(q); 
             pst.setString(1, t1.getText());
            pst.setString(2,t2.getText());
            if(r1.isSelected())
            {
                pst.setString(3, r1.getText());
            }
            else if(!r1.isSelected())
            {
                pst.setString(3, r2.getText());
            }
            
            pst.setString(4, c1.getSelectedItem().toString());
            pst.setString(5, t3.getText());
            pst.setString(6, t4.getText());
            pst.setString(7, t5.getText());
            pst.setString(8, t6.getText());
             int a = pst.executeUpdate();//Executing SQL
            JOptionPane.showMessageDialog(null,"EMPLOYEE ADDED SUCESSFULLY","",JOptionPane.OK_OPTION);
            pst.close();
            con.close(); // Close Connection*/
        }
        catch(Exception ex){System.out.println(ex);};
        }
        if(s.equals("Cancel"))
        {
            dispose();
        }
         
    }
    
    
        
        ;
        
        
    
}
