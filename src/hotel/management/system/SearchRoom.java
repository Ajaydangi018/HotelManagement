

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;
public class SearchRoom extends JFrame implements ActionListener {

JLabel l1,l2,l3,l4,l5,l6,l7;
JCheckBox c2;
JComboBox c1;
JTable t1;
JButton b1,b2;

public SearchRoom(){

l1=new JLabel("Search For Room");
l1.setFont(new Font("Tahoma",Font.PLAIN,20));
l1.setBounds(300,20,200,30);
add(l1);

l2=new JLabel("Room Bed Type");
l2.setBounds(50,100,150,30);
add(l2);
c1=new JComboBox(new String[]{"Single Bed","Double Bed"});
c1.setBounds(160,100,150,25);
add(c1);

c2=new JCheckBox("Only Display Available");
c2.setBounds(600,100,150,30);
add(c2);


l3=new JLabel("Room Number");
l3.setBounds(50,170,100,30);
add(l3);

l4=new JLabel("Availability");
l4.setBounds(250,170,100,30);
add(l4);

l5=new JLabel("Cleaning Status");
l5.setBounds(450,170,100,30);
add(l5);

l6=new JLabel("Price");
l6.setBounds(670,170,100,30);
add(l6);

l7=new JLabel("Bed Type");
l7.setBounds(850,170,100,30);
add(l7);


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
String str="select * from rooms where bed_type='"+c1.getSelectedItem()+"'";
String str2="select * from rooms where availability='Available' AND bed_type='"+c1.getSelectedItem()+"'";
ResultSet rs;
if(c2.isSelected()){
rs=c.s.executeQuery(str2);
t1.setModel(DbUtils.resultSetToTableModel(rs));
}else{
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

new SearchRoom();
}

}
