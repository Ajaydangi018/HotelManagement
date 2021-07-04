

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener{

JTable t1;
JButton b1,b2;
JLabel l1,l2,l3,l4,l5,l6,l7,l8;

public EmployeeInfo(){

t1=new JTable();
t1.setBounds(0,50,1100,400);
add(t1);

l1=new JLabel("Name");
l1.setBounds(50,20,70,20);
add(l1);

l2=new JLabel("Age");
l2.setBounds(180,20,70,20);
add(l2);

l3=new JLabel("Gender");
l3.setBounds(310,20,70,20);
add(l3);

l4=new JLabel("Job Type");
l4.setBounds(450,20,70,20);
add(l4);

l5=new JLabel("Salary");
l5.setBounds(590,20,70,20);
add(l5);

l6=new JLabel("Phone");
l6.setBounds(730,20,70,20);
add(l6);

l7=new JLabel("Aadhar");
l7.setBounds(870,20,70,20);
add(l7);

l8=new JLabel("Mail");
l8.setBounds(1010,20,70,20);
add(l8);





b1=new JButton("Load Data");
b1.setBounds(350,500,100,30);
b1.setBackground(Color.BLACK);
b1.setForeground(Color.WHITE);
b1.addActionListener(this);
add(b1);

b2=new JButton("Back");
b2.setBounds(530,500,100,30);
b2.setBackground(Color.BLACK);
b2.setForeground(Color.WHITE);
b2.addActionListener(this);
add(b2);
setSize(1100,600);
setLocation(100,100);
getContentPane().setBackground(Color.WHITE);
setLayout(null);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){

if(ae.getSource()==b1){
try{
Conn c=new Conn();
String str="select * from employee";
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
new EmployeeInfo();
}

}
