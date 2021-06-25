package hotel.management.system;
import  javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class adddrivers extends JFrame implements ActionListener
{
    Font f1=new Font("verdana",Font.BOLD,40);
    Font f2=new Font("arial",Font.BOLD,18);
    Font f3=new Font("arial",Font.BOLD,12);
    
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2;
    JComboBox c1,c2;
    adddrivers()
    {
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel("");
        l1.setIcon(i3);
        l1.setBounds(430,60,700,500);
        add(l1);
        
        JLabel l2=new JLabel("ADD DRIVERS");
        l2.setForeground(Color.BLACK);
        l2.setFont(f1);
        l2.setBounds(50,30,400,40);
        add(l2);
        
        JLabel l3=new JLabel("Namer");
        l3.setBounds(20,150,150,30);
        l3.setFont(f2);
        add(l3);
        
        t1=new JTextField();
        t1.setBounds(180,150,170,30);
        t1.setFont(f2);
        add(t1);
        
        JLabel l4=new JLabel("Age");
        l4.setBounds(20,200,150,30);
        l4.setFont(f2);
        add(l4);
        
        t2=new JTextField();
        t2.setBounds(180,200,170,30);
        t2.setFont(f2);
        add(t2);
        
        JLabel l5=new JLabel("Gender");
        l5.setBounds(20,250,150,30);
        l5.setFont(f2);
        add(l5);
        
        c1=new JComboBox();
        c1.addItem("Male");
        c1.addItem("Female");
        c1.addItem("Others");
        c1.setFont(f2);
        c1.setBounds(180,250,170,30);
        add(c1);
        
        JLabel l6=new JLabel("Car Company");
        l6.setBounds(20,300,150,30);
        l6.setFont(f2);
        add(l6);
       
        t3=new JTextField();
        t3.setBounds(180,300,170,30);
        t3.setFont(f2);
        add(t3);
        
        JLabel l7=new JLabel("Car Model");
        l7.setBounds(20,350,150,30);
        l7.setFont(f2);
        add(l7);
        
        t4=new JTextField();
        t4.setBounds(180,350,170,30);
        t4.setFont(f2);
        add(t4);
       
       JLabel l8=new JLabel("Available");
        l8.setBounds(20,400,150,30);
        l8.setFont(f2);
        add(l8);
        
        c2=new JComboBox();
        c2.addItem("Available");
        c2.addItem("Not Available");
        c2.setFont(f2);
        c2.setBounds(180,400,170,30);
        add(c2);
        
        JLabel l9=new JLabel("Location");
        l9.setBounds(20,450,150,30);
        l9.setFont(f2);
        add(l9);
        
        
        t5=new JTextField();
        t5.setBounds(180,450,170,30);
        t5.setFont(f2);
        add(t5);
        
       JLabel l10=new JLabel("Phone number");
        l10.setBounds(20,500,150,30);
        l10.setFont(f2);
        add(l10);
        
        t6=new JTextField();
        t6.setBounds(180,500,170,30);
        t6.setFont(f2);
        add(t6);
        
        b1=new JButton("Submit");
        b1.setFont(f2);
        b1.setFocusable(false);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(10,550,200,40);
        add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Cancel");
        b2.setFont(f2);
        b2.setFocusable(false);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(220,550,200,40);
        add(b2);
        b2.addActionListener(this);
        
        setSize(1200,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setLocation(400,200);
        setLayout(null);
    }
    public static void main(String args[])
    {
        new adddrivers().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
     String s=e.getActionCommand();
        if(s.equals("Submit"))
        {
            String Drviernamer=t1.getText();
            String age=t2.getText();
            String gender=c1.getSelectedItem().toString();
            String Carcompany=t3.getText();
            String carmodel=t4.getText();
            String available=c2.getSelectedItem().toString();
            String location=t5.getText();
            String phone=t6.getText();
              try{
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/malhotra ", "java", "java"); // Connection build
            PreparedStatement pst = null; //complex queries
            // Statement st = null; simple (Select * from table where name = "sachin")
            String q = "insert into DRIVERS values (?,?,?,?,?,?,?,?)"; // Sql Query
            pst = con.prepareStatement(q); 
             pst.setString(1, t1.getText());
                pst.setString(2,t2.getText());
                pst.setString(3, c1.getSelectedItem().toString());
                pst.setString(4, t3.getText());
                pst.setString(5, t4.getText());
                pst.setString(6, c2.getSelectedItem().toString());
                pst.setString(7, t5.getText());
                pst.setString(8, t6.getText());
             int a = pst.executeUpdate();//Executing SQL
            JOptionPane.showMessageDialog(null,"DRIVER ADDED SUCESSFULLY","",JOptionPane.OK_OPTION);
            pst.close();
            con.close(); // Close Connection*/
        }
        catch(Exception ex){System.out.println(ex);};
        }
        
        if(s.equals("Cancel"))
        {
            t1.setText(null);
            t2.setText(null);
            dispose();
        }   
    }
}
