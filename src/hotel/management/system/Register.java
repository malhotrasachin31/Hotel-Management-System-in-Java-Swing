
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Register extends JFrame implements ActionListener
{
    JPanel p1;
    Font f1=new Font("arial",Font.BOLD,26);
    Font f2=new Font("arial",Font.BOLD,18);
    Font f3=new Font("arial",Font.BOLD,12);
    JTextField t1,t2,t3,t4;
   
    
    Register()
    {
        p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,900,50);
        p1.setBackground(Color.BLACK);
        add(p1);
        
        JLabel l3=new JLabel("REGISTRATION FORM");
        l3.setBounds(250,7,300,30);
        l3.setForeground(Color.white);
        l3.setFont(f1);
        p1.add(l3);
        
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
        });
        
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fifth.jpg"));
        Image i8=i7.getImage().getScaledInstance(400, 700, Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        JLabel l2=new JLabel("");
        l2.setIcon(i9);
        l2.setBounds(0,50,450,700);
        add(l2);
        
        JLabel l4=new JLabel("Username");
        l4.setBounds(500,100,100,30);
        l4.setForeground(Color.white);
        l4.setFont(f2);
        add(l4);
        
        JLabel l5=new JLabel("Password");
        l5.setBounds(500,150,100,30);
        l5.setForeground(Color.white);
        l5.setFont(f2);
        add(l5);
        
        JLabel l7=new JLabel("Email-ID");
        l7.setBounds(500,200,100,30);
        l7.setForeground(Color.white);
        l7.setFont(f2);
        add(l7);
        
        JLabel l8=new JLabel("Address");
        l8.setBounds(500,250,100,30);
        l8.setForeground(Color.white);
        l8.setFont(f2);
        add(l8);
        
        
        t1=new JTextField();
        t1.setBounds(650,100,200,30);
        t1.setForeground(Color.black);
        t1.setFont(f2);
        add(t1);
        
        t2=new JTextField();
        t2.setBounds(650,150,200,30);
        t2.setForeground(Color.black);
        t2.setFont(f2);
        add(t2);
        
        t3=new JTextField();
        t3.setBounds(650,200,200,30);
        t3.setForeground(Color.black);
        t3.setFont(f2);
        add(t3);
        
        t4=new JTextField();
        t4.setBounds(650,250,200,30);
        t4.setForeground(Color.black);
        t4.setFont(f2);
        add(t4);
        
        
        
        JLabel l10=new JLabel("If you Have already an acount please to Login Page By clicking here.");
        l10.setBounds(470,550,400,30);
        l10.setForeground(Color.white);
        l10.setForeground(Color.black);
        l10.setFont(f3);
        add(l10);
        l10.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e1)
            {
                new Login().setVisible(true);
                dispose();
            }
        });
        
        JButton b1=new JButton("Submit");
        b1.setBounds(550,490,200,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setFocusable(false);
        b1.setFont(f2);
        add(b1);
        b1.addActionListener(this);
        
        
        setLayout(null);
        getContentPane().setBackground(new Color(7,84,94));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,698);
        setLocation(600,150);
        setUndecorated(true);
    }
    
 public static void main(String [] args)
 {
     new Register().setVisible(true);
 }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        try{
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/malhotra ", "java", "java"); // Connection build
            PreparedStatement pst = null; //complex queries
            // Statement st = null; simple (Select * from table where name = "sachin")
            String q = "insert into REGISTER values (?,?,?,?)"; // Sql Query
            pst = con.prepareStatement(q); 
            pst.setString(1,t1.getText() );
            pst.setString(2, t2.getText());
            pst.setString(3, t3.getText());
            pst.setString(4, t4.getText());
             int a = pst.executeUpdate();//Executing SQL
            JOptionPane.showMessageDialog(null,"ACCOUNT CREATED SUCESSFULLY","MALHOTRA-KITCHEN",JOptionPane.OK_OPTION);
            t1.setText(null);
            t2.setText(null);
            t3.setText(null);
            t4.setText(null);
            pst.close();
            con.close(); // Close Connection*/
        }
        catch(Exception ex){System.out.println(ex);};
    }
}
