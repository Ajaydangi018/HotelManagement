
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class CheckOut extends JFrame implements ActionListener {

JLabel l1,l2,l3,l4;
JTextField t1;
Choice c1;
JButton b1,b2,b3;

public CheckOut(){

l1=new JLabel("Check-Out");
l1.setBounds(100,20,150,30);
l1.setForeground(Color.BLUE);
l1.setFont(new Font("Tahoma",Font.PLAIN,20));
add(l1);

l2=new JLabel("Customer ID");
l2.setBounds(30,100,100,30);
add(l2);
c1=new Choice();
try{
Conn c=new Conn();
ResultSet rs=c.s.executeQuery("select * from customer");
while(rs.next()){
c1.add(rs.getString("number"));
}
c1.setBounds(180,100,150,25);
add(c1);


}catch(Exception e){}


l3=new JLabel("Room Number");
l3.setBounds(30,150,100,30);
add(l3);
t1=new JTextField();
t1.setBounds(180,150,150,25);
add(t1);


b1=new JButton("CheckOut");
b1.setBounds(50,220,100,25);
b1.setForeground(Color.WHITE);
b1.setBackground(Color.BLACK);
b1.addActionListener(this);
add(b1);

b2=new JButton("Back");
b2.setBounds(180,220,100,25);
b2.setForeground(Color.WHITE);
b2.setBackground(Color.BLACK);
b2.addActionListener(this);
add(b2);

ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/in.jpg"));
Image i2=i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
b3=new JButton(i3);
b3.setBounds(350,100,20,20);
b3.addActionListener(this);
add(b3);


ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
Image i2=i1.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
l4=new JLabel(i3);
l4.setBounds(400,20,400,250);
add(l4);

getContentPane().setBackground(Color.WHITE);
setLayout(null);
setSize(800,300);
setLocation(300,100);
setVisible(true);

}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==b1){
String id=c1.getSelectedItem();
String room=t1.getText();
try{
Conn c=new Conn();
String s1="delete from customer where number='"+id+"'";
String s2="update rooms set availability='Available' where room_number='"+room+"'";
c.s.executeUpdate(s1);
c.s.executeUpdate(s2);
JOptionPane.showMessageDialog(null,"Checkout Done");
new Reception().setVisible(true);
this.setVisible(false);
}catch(Exception e){System.out.print(e);}
}
else if(ae.getSource()==b2){
new Reception().setVisible(true);
this.setVisible(false);
}
else if(ae.getSource()==b3){
String id=c1.getSelectedItem();
Conn c=new Conn();
try{
ResultSet rs=c.s.executeQuery("select * from customer where number='"+id+"'");
while(rs.next()){
t1.setText(rs.getString("room"));
}
}catch(Exception e){}
}

}
public static void main(String[] args)
{
new CheckOut();
}

}
