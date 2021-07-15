

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;
public class PickUp extends JFrame implements ActionListener {

JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
Choice c1;
JTable t1;
JButton b1,b2;

public PickUp(){

l1=new JLabel("PickUp Service");
l1.setFont(new Font("Tahoma",Font.PLAIN,20));
l1.setBounds(300,20,200,30);
add(l1);

l2=new JLabel("Type of Car");
l2.setBounds(50,100,150,30);
add(l2);
c1=new Choice();
try{
Conn c=new Conn();
String str="select * from driver";
ResultSet rs=c.s.executeQuery(str);
while(rs.next()){
c1.add(rs.getString("carmodel"));
}
}catch(Exception e){}
c1.setBounds(250,100,150,25);
add(c1);


l3=new JLabel("Driver Name");
l3.setBounds(30,170,100,30);
add(l3);

l4=new JLabel("Age");
l4.setBounds(190,170,100,30);
add(l4);

l5=new JLabel("Gender");
l5.setBounds(340,170,100,30);
add(l5);

l6=new JLabel("Car Model");
l6.setBounds(460,170,100,30);
add(l6);

l7=new JLabel("Car Company");
l7.setBounds(600,170,100,30);
add(l7);

l8=new JLabel("Availability");
l8.setBounds(750,170,100,30);
add(l8);

l9=new JLabel("Location");
l9.setBounds(890,170,100,30);
add(l9);


t1=new JTable();
t1.setBounds(0,200,1000,300);
add(t1);

b1=new JButton("Show");
b1.setBounds(350,520,100,25);
b1.setBackground(Color.BLACK);
b1.setForeground(Color.WHITE);
b1.addActionListener(this);
add(b1);

b2=new JButton("Back");
b2.setBounds(510,520,100,25);
b2.setBackground(Color.BLACK);
b2.setForeground(Color.WHITE);
b2.addActionListener(this);
add(b2);


setLayout(null);
setSize(1000,600);
setLocation(300,100);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==b1){
try{
Conn c=new Conn();
String str="select * from driver where carmodel='"+c1.getSelectedItem()+"'";
ResultSet rs;
{
rs=c.s.executeQuery(str);
t1.setModel(DbUtils.resultSetToTableModel(rs));
}
}catch(Exception e){}
}
else if(ae.getSource()==b2){
new Reception().setVisible(true);
this.setVisible(false);
}

}
public static void main(String[] args){

new PickUp();
}

}
