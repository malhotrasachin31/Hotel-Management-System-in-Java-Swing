package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener
{
    JPanel p1;
    JButton b1,b2;
    JTextField t1;
    JPasswordField p;
     Font f1=new Font("arial",Font.BOLD,20);
    Font f2=new Font("arial",Font.BOLD,18);
    Font f3=new Font("arial",Font.BOLD,12);
    Login()
    {
        p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,700,50);
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
        });
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/second.jpg"));
        Image i5=i4.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel l2=new JLabel("second");
        l2.setBounds(10,90,250,250);
        l2.setIcon(i6);
        add(l2);
        
        JLabel l3=new JLabel("Username");
        l3.setBounds(300,90,100,30);
        l3.setFont(f1);
        add(l3);
        
        JLabel l4=new JLabel("Password");
        l4.setBounds(300,140,100,30);
        l4.setFont(f1);
        add(l4);
        
        t1=new JTextField();
        t1.setBounds(420,90,250,30);
        t1.setFont(f2);
        add(t1);
        
        p=new JPasswordField();
        p.setBounds(420,140,250,30);
        p.setFont(f2);
        add(p);
        
        b1=new JButton("Login");
        b1.setBounds(420,200,100,30);
        b1.setFocusable(false);
        b1.setForeground(Color.white);
        b1.setBackground(Color.BLACK);
        b1.setFont(f1);
        add(b1);
        b1.addActionListener(this);
        
        
        
        JLabel l5=new JLabel("For Sign-up Please Click Here");
        l5.setBounds(440,250,300,20);
        l5.setForeground(Color.red);
        l5.setFont(f3);
        add(l5);
        l5.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent me)
            {
                new Register().setVisible(true);
                dispose();
            }
        });
        
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,400);
        setLocation(600,300);
        setUndecorated(true);
    }    
public static void main(String [] args)
    {
         new Login().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String s=e.getActionCommand();
        if(s.equals("Login"))
        {
        String user=t1.getText();
           String pass=p.getText();
                   try{
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/malhotra ", "java", "java"); // Connection build
                PreparedStatement pst = null; 
                ResultSet rs;
                String check="Select * from REGISTER where USERNAME=?";
                pst=con.prepareStatement(check);
                pst.setString(1, user);
                rs=pst.executeQuery();
                
                if(rs.next()){
                    String password=rs.getString("PASSWORD");
                    if(pass.equals(password)){
                        new  mainpage().setVisible(true);
                        dispose();
                        p.setText("");  
                    } else{
                        JOptionPane.showMessageDialog(null,"INVALID USRENAME or PASSWORD","",JOptionPane.OK_OPTION);
                    }
                 
                   // yaha takk 
                    
                }
                   
               
           }catch(Exception ex){System.out.println("");};
    }
        if(s.equals("Cancel"))
        {
            dispose();
        }
    }
}
