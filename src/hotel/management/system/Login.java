
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
public class Login extends JFrame 
{
JLabel l1,l2,l3;
JTextField t1;
JPasswordField p1;
JButton b1,b2;
ImageIcon i1,i3;
Image i2;
public Login(String s)
{super(s);}
public Login(){
l1=new JLabel("Username");
l1.setBounds(50,50,100,20);
add(l1);
t1=new JTextField();
t1.setBounds(200,50,100,20);
add(t1);
l2=new JLabel("Password");
l2.setBounds(50,100,100,20);
add(l2);
p1=new JPasswordField();
p1.setBounds(200,100,100,20);
add(p1);
b1=new JButton("Login");
b1.setBackground(Color.BLACK);
b1.setForeground(Color.WHITE);
b1.setBounds(70,150,100,20);
add(b1);
b2=new JButton("Cancel");
b2.setBackground(Color.BLACK);
b2.setForeground(Color.WHITE);
b2.setBounds(200,150,100,20);
add(b2);
//i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/in.jpg"));
//i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
//i3=new ImageIcon(i2);
//l3=new JLabel("IMAGE");
//l3.setBounds(350,10,200,200);
//add(l3);
setLayout(null);
setSize(380,300);
setLocation(220,170);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
public static void main(String[] args)
{
new Login("login");
}
}
