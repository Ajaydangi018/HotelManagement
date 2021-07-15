
package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.sql.*;
import java.awt.*;

public class Room extends JFrame implements ActionListener{


JTable t1;
JButton b1,b2;
JLabel l1,l2,l3,l4,l5,l6;
ImageIcon i1;
public Room(){
i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/hotel_image1.jpg"));
l1=new JLabel(i1);
l1.setBounds(630,0,450,600);
add(l1);


t1=new JTable();
t1.setBounds(0,50,600,400);
add(t1);


l2=new JLabel("Room Number");
l2.setBounds(20,20,90,20);
add(l2);

l3=new JLabel("Availability");
l3.setBounds(150,20,90,20);
add(l3);

l4=new JLabel("Status");
l4.setBounds(280,20,90,20);
add(l4);

l5=new JLabel("Price");
l5.setBounds(400,20,90,20);
add(l5);

l6=new JLabel("Bed Type");
l6.setBounds(510,20,90,20);
add(l6);

b1=new JButton("Load Data");
b1.setBounds(150,500,100,30);
b1.setBackground(Color.BLACK);
b1.setForeground(Color.WHITE);
b1.addActionListener(this);
add(b1);

b2=new JButton("Back");
b2.setBounds(300,500,100,30);
b2.setBackground(Color.BLACK);
b2.setForeground(Color.WHITE);
b2.addActionListener(this);
add(b2);


getContentPane().setBackground(Color.WHITE);
setLayout(null);
setSize(1100,600);
setLocation(100,100);
setVisible(true);

}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==b1){
try{
Conn c=new Conn();
String str="select * from rooms";
ResultSet rs=c.s.executeQuery(str);

t1.setModel(DbUtils.resultSetToTableModel(rs));

}catch(Exception e){}
 
}else if(ae.getSource()==b2){
new Reception().setVisible(true);
this.setVisible(false);
}
}
public static void main(String[] args)
{
new Room();
}

}
