package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class checkout extends JFrame implements ActionListener
{
    Font f1=new Font("arial",Font.BOLD,30);
    Font f2=new Font("arial",Font.BOLD,16);
    JTextField t1;
    JComboBox c1;
    JButton b1,b2;
    checkout()
    {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
        Image i2=i1.getImage().getScaledInstance(400, 350, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel("");
        l1.setIcon(i3);
        l1.setBounds(280,20,400,310);
        add(l1);
        
        JLabel l2=new JLabel("CHECK OUT");
        l2.setBounds(20,10,300,40);
        l2.setFont(f1);
        add(l2);
        
        JLabel l3=new JLabel("CUSTOMER ID");
        l3.setBounds(10,70,300,40);
        l3.setFont(f2);
        add(l3);
        
        //c1 
        c1=new JComboBox();
        c1.setBounds(170,70,100,30);
        c1.setFont(f2);
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
        add(c1);
        
        JLabel l4=new JLabel("ROOM NUMBER");
         l4.setBounds(10,130,300,40);
        l4.setFont(f2);
        add(l4);
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
        Image i5=i4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel l5=new JLabel("");
        l5.setIcon(i6);
        l5.setBounds(140,75,20,20);
        add(l5);
        l5.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent me)
            {
                  String id = c1.getSelectedItem().toString();
                try{
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/malhotra","java","java");
                    ResultSet rs=null;
                    PreparedStatement pst=null;
                    String q="select * from customerdetails where id = ?";
                    pst=conn.prepareStatement(q);
                    pst.setString(1, id);
                    rs = pst.executeQuery();
                    if(rs.next())
                        t1.setText(rs.getString("roomnumber"));
                    
         }catch(Exception ex){System.out.println(ex);};
                    
            }
        });
        
        t1=new JTextField();
        t1.setBounds(170,135,100,30);
        t1.setFont(f2);
        add(t1);
        
        b1=new JButton("Check Out");
        b1.setBounds(40,250,100,30);
        b1.setFocusable(false);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        b1.addActionListener(this);
                
        b2=new JButton("Back");
        b2.setBounds(160,250,100,30);
        b2.setFocusable(false);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        b2.addActionListener(this);
        
        setSize(700,400);
        setLocation(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setResizable(false);
    }
    public static void main(String args[])
    {
        new checkout().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String s=e.getActionCommand();
       
       if(s.equals("Back"))
       {
           new reception().setVisible(true);
           dispose();
       }
       if(s.equals("Check Out"))
       {
           String room = t1.getText();
           try{
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/malhotra","java","java");
                    ResultSet rs=null;
                    PreparedStatement pst=null;
                    
                    String q = "update addrooms set status = 'Available' , condition = 'Dirty' where roomnumber = ?";
                    pst = conn.prepareCall(q);
                    pst.setString(1, room);
                    pst.executeUpdate();
                    
                    q="delete from customerdetails where roomnumber = ?";
                    pst=conn.prepareStatement(q);
                    pst.setString(1, room);
                    pst.executeUpdate();
                    
                    
                    JOptionPane.showMessageDialog(this, "Customer Checked Out");
         }catch(Exception ex){System.out.println(ex);};
       }
    }
}
