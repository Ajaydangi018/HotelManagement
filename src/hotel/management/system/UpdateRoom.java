

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class UpdateRoom extends JFrame implements ActionListener {

JLabel l1,l2,l3,l4,l5,l6;
Choice c1;
JTextField t1,t2,t3;
JButton b1,b2,b3;
public UpdateRoom(){

l1=new JLabel("Update Room Status");
l1.setBounds(150,20,250,30);
l1.setForeground(Color.BLUE);
l1.setFont(new Font("Tahoma",Font.PLAIN,25));
add(l1);

l2=new JLabel("Guest ID");
l2.setBounds(30,100,100,30);
add(l2);
c1=new Choice();
try{
Conn c=new Conn();
ResultSet rs=c.s.executeQuery("select * from customer");
while(rs.next()){
c1.add(rs.getString("number"));
}
}catch(Exception e){}
c1.setBounds(180,100,150,25);
add(c1);

l3=new JLabel("Room Number");
l3.setBounds(30,150,100,30);
add(l3);
t1=new JTextField();
t1.setBounds(180,150,150,25);
add(t1);


l4=new JLabel("Availability");
l4.setBounds(30,200,100,30);
add(l4);
t2=new JTextField();
t2.setBounds(180,200,150,25);
add(t2);


l5=new JLabel("Cleaning Status");
l5.setBounds(30,250,100,30);
add(l5);
t3=new JTextField();
t3.setBounds(180,250,150,25);
add(t3);


b1=new JButton("Check");
b1.setBackground(Color.BLACK);
b1.setForeground(Color.WHITE);
b1.setBounds(20,320,100,25);
b1.addActionListener(this);
add(b1);

b2=new JButton("Update");
b2.setBackground(Color.BLACK);
b2.setForeground(Color.WHITE);
b2.addActionListener(this);
b2.setBounds(150,320,100,25);
add(b2);

b3=new JButton("Back");
b3.setBackground(Color.BLACK);
b3.setForeground(Color.WHITE);
b3.setBounds(280,320,100,25);
b3.addActionListener(this);
add(b3);

ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eight.jpg"));
Image i2=i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
l6=new JLabel(i3);
l6.setBounds(450,20,500,400);
add(l6);

setLayout(null);
setSize(1000,500);
setLocation(300,100);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==b1){
String room=null;
String s1=c1.getSelectedItem();
try{
Conn c=new Conn();
ResultSet rs=c.s.executeQuery("select * from customer where number='"+s1+"'");
while(rs.next()){
t1.setText(rs.getString("room"));
room=rs.getString("room");
}
ResultSet rs2=c.s.executeQuery("select * from rooms where room_number='"+room+"'");
while(rs2.next()){
t2.setText(rs2.getString("availability"));
t3.setText(rs2.getString("status"));
}
}catch(Exception e){}

}else if(ae.getSource()==b2){
try{
Conn c=new Conn();
String room=t1.getText();
String availability=t2.getText();
String status=t3.getText();
String str="update rooms set availability='"+availability+"',status='"+status+"'where room_number='"+room+"'";
c.s.executeUpdate(str);
JOptionPane.showMessageDialog(null,"Room Updated Successfully");
new Reception().setVisible(true);
this.setVisible(false);
}catch(Exception e){}

}else if(ae.getSource()==b3){
new Reception().setVisible(true);
this.setVisible(false);
}
}
public static void main(String[] args){
new UpdateRoom();
}


}
