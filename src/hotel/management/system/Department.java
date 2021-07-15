

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;
public class Department extends JFrame implements ActionListener {

JLabel l1,l2,l3;
JTable t1;
JButton b1,b2;

public Department(){

l1=new JLabel("Department");
l1.setBounds(120,10,150,30);
add(l1);

l2=new JLabel("Budget");
l2.setBounds(450,10,150,30);
add(l2);


t1=new JTable();
t1.setBounds(0,50,700,300);
add(t1);

b1=new JButton("Show");
b1.setBounds(180,520,100,25);
b1.setBackground(Color.BLACK);
b1.setForeground(Color.WHITE);
b1.addActionListener(this);
add(b1);

b2=new JButton("Back");
b2.setBounds(400,520,100,25);
b2.setBackground(Color.BLACK);
b2.setForeground(Color.WHITE);
b2.addActionListener(this);
add(b2);

getContentPane().setBackground(Color.WHITE);
setLayout(null);
setSize(700,600);
setLocation(300,100);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==b1){
try{
Conn c=new Conn();
String str="select * from department";
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

new Department();
}

}
