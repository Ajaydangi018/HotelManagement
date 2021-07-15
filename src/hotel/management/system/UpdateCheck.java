
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class UpdateCheck extends JFrame implements ActionListener {

JButton b1,b2,b3;
JTextField t1,t2,t3,t4,t5;
Choice c1;
JLabel l1,l2,l3,l4,l5,l6,l7,l8;
public UpdateCheck(){


l1=new JLabel("Check-In Details");
l1.setBounds(150,20,250,30);
l1.setFont(new Font("Tahoma",Font.PLAIN,25));
l1.setForeground(Color.BLUE);
add(l1);

l2=new JLabel("Cutomer ID");
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

l4=new JLabel("Name");
l4.setBounds(30,200,100,30);
add(l4);
t2=new JTextField();
t2.setBounds(180,200,150,25);
add(t2);

l5=new JLabel("Check-In");
l5.setBounds(30,250,100,30);
add(l5);
t3=new JTextField();
t3.setBounds(180,250,150,25);
add(t3);

l6=new JLabel("Amount Paid");
l6.setBounds(30,300,100,30);
add(l6);
t4=new JTextField();
t4.setBounds(180,300,150,25);
add(t4);

l7=new JLabel("Pending Amount");
l7.setBounds(30,350,100,30);
add(l7);
t5=new JTextField();
t5.setBounds(180,350,150,25);
add(t5);

b1=new JButton("Check");
b1.setBounds(20,420,100,25);
b1.setForeground(Color.WHITE);
b1.setBackground(Color.BLACK);
b1.addActionListener(this);
add(b1);

b2=new JButton("Update");
b2.setBounds(150,420,100,25);
b2.setForeground(Color.WHITE);
b2.setBackground(Color.BLACK);
b1.addActionListener(this);
add(b2);

b3=new JButton("Back");
b3.setBounds(280,420,100,25);
b3.setForeground(Color.WHITE);
b3.setBackground(Color.BLACK);
b3.addActionListener(this);
add(b3);

ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/nine.jpg"));
l8=new JLabel(i1);
l8.setBounds(450,20,500,400);
add(l8);



setLayout(null);
setSize(1000,500);
setLocation(300,100);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==b1){
try{
Conn c=new Conn();
String price=null;
String deposit=null;
int pending;
String room=null;
String id=c1.getSelectedItem();
String str="select * from customer where number='"+id+"'";
ResultSet rs=c.s.executeQuery(str);
while(rs.next()){
t1.setText(rs.getString("room"));
t2.setText(rs.getString("name"));
t3.setText(rs.getString("status"));
t4.setText(rs.getString("deposit"));
room=t1.getText();
deposit=t4.getText();
}
ResultSet rs2=c.s.executeQuery("select * from rooms where room_number='"+room+"'");
while(rs2.next()){
price=rs2.getString("price");
pending=Integer.parseInt(price)-Integer.parseInt(deposit);
t5.setText(Integer.toString(pending));
}
}catch(Exception e){}

}
else if(ae.getSource()==b2){}
else if(ae.getSource()==b3){
new Reception().setVisible(true);
this.setVisible(false);
}
}
public static void main(String[] args){

new UpdateCheck();
}

}
