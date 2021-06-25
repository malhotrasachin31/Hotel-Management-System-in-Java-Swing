package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class addrooms extends JFrame implements ActionListener
{
    JTextField t1,t2;
    JComboBox c1,c2,c3;
    Font f1=new Font("verdana",Font.BOLD,40);
    Font f2=new Font("arial",Font.BOLD,18);
    Font f3=new Font("arial",Font.BOLD,12);
    JButton b1,b2;
    
    addrooms()
    {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/twelve.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel("");
        l1.setBounds(360,28,600,500);
        l1.setIcon(i3);
        add(l1);
        
        JLabel l2=new JLabel("ADD ROOMS");
        l2.setForeground(Color.BLACK);
        l2.setFont(f1);
        l2.setBounds(35,30,300,40);
        add(l2);
        
        JLabel l3=new JLabel("Room Number");
        l3.setBounds(20,150,150,30);
        l3.setFont(f2);
        add(l3);
        
        t1=new JTextField();
        t1.setBounds(180,150,170,30);
        t1.setFont(f2);
        add(t1);
        
        JLabel l4=new JLabel("Available");
        l4.setBounds(20,200,150,30);
        l4.setFont(f2);
        add(l4);
        
        c1=new JComboBox();
        c1.addItem("Available");
        c1.addItem("Occupied");
        c1.setFont(f2);
        c1.setBounds(180,200,170,30);
        add(c1);
        
        JLabel l5=new JLabel("Cleaning Status");
        l5.setBounds(20,250,150,30);
        l5.setFont(f2);
        add(l5);
        
        c2=new JComboBox();
        c2.addItem("Cleaned");
        c2.addItem("Dirty");
        c2.setFont(f2);
        c2.setBounds(180,250,170,30);
        add(c2);
        
        JLabel l6=new JLabel("Price");
        l6.setBounds(20,300,150,30);
        l6.setFont(f2);
        add(l6);
        
        t2=new JTextField();
        t2.setBounds(180,300,170,30);
        t2.setFont(f2);
        add(t2);
        
        JLabel l7=new JLabel("Bed Type");
        l7.setBounds(20,350,150,30);
        l7.setFont(f2);
        add(l7);
        
        c3=new JComboBox();
        c3.addItem("Single Bed");
        c3.addItem("Double Bed");
        c3.setFont(f2);
        c3.setBounds(180,350,170,30);
        add(c3);
        
        b1=new JButton("Submit");
        b1.setFont(f2);
        b1.setFocusable(false);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(20,450,100,30);
        add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Cancel");
        b2.setFont(f2);
        b2.setFocusable(false);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(200,450,100,30);
        add(b2);
        b2.addActionListener(this);
        
        setSize(1000,600);
        setLocation(500,200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
    }
    public static void main(String [] args)
    {
        new addrooms().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String s=e.getActionCommand();
        if(s.equals("Submit"))
        {
            String roomnumber=t1.getText();
            String available=c1.getSelectedItem().toString();
            String cleaningstatus=c2.getSelectedItem().toString();
            String price=t2.getText();
            String bedtype=c3.getSelectedItem().toString();
            
              try{
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/malhotra ", "java", "java"); // Connection build
            PreparedStatement pst = null; //complex queries
            // Statement st = null; simple (Select * from table where name = "sachin")
            String q = "insert into ADDROOMS values (?,?,?,?,?)"; // Sql Query
            pst = con.prepareStatement(q); 
             pst.setString(1, t1.getText());
                pst.setString(2,c1.getSelectedItem().toString());
                pst.setString(3, c2.getSelectedItem().toString());
                pst.setString(4, t2.getText());
                pst.setString(5, c3.getSelectedItem().toString());
             int a = pst.executeUpdate();//Executing SQL
            JOptionPane.showMessageDialog(null,"EMPLOYEE ADDED SUCESSFULLY","",JOptionPane.OK_OPTION);
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
