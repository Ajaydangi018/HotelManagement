
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class AddCustomer extends JFrame implements ActionListener {


JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
JTextField t1,t2,t3,t4,t5;
JComboBox c1;//swing package ka hai
Choice c2;//awt package ka hai
JRadioButton r1,r2;
JButton b1,b2;

public AddCustomer(){

l1=new JLabel("New Customer Form");
l1.setBounds(150,20,200,30);
l1.setFont(new Font("Tahoma",Font.PLAIN,18));
l1.setForeground(Color.BLUE);
add(l1);

l2=new JLabel("ID");
l2.setBounds(30,80,150,20);
add(l2);
c1=new JComboBox(new String[]{"Passport","Voter ID","Driving Licence","Aadhar"});
c1.setBounds(200,80,150,20);
c1.setBackground(Color.WHITE);
add(c1);


l3=new JLabel("ID Number");
l3.setBounds(30,120,150,20);
add(l3);
t1=new JTextField();
t1.setBounds(200,120,150,20);
add(t1);


l4=new JLabel("Name");
l4.setBounds(30,160,150,20);
add(l4);
t2=new JTextField();
t2.setBounds(200,160,150,20);
add(t2);

l5=new JLabel("Gender");
l5.setBounds(30,200,150,20);
add(l5);
r1=new JRadioButton("Male");
r1.setBounds(200,200,70,20);
r1.setBackground(Color.WHITE);
add(r1);
r2=new JRadioButton("Female");
r2.setBounds(280,200,70,20);
r2.setBackground(Color.WHITE);
add(r2);


l6=new JLabel("Country");
l6.setBounds(30,240,150,20);
add(l6);
t3=new JTextField();
t3.setBounds(200,240,150,20);
add(t3);

l7=new JLabel("Allocated Room Number");
l7.setBounds(30,280,150,20);
add(l7);
c2=new Choice();
try{
Conn c=new Conn();
String str="Select * from rooms where availability='Available'";
ResultSet rs=c.s.executeQuery(str);
while(rs.next()){
c2.add(rs.getString("room_number"));
}
}catch(Exception e){}
c2.setBounds(200,280,150,20);
add(c2);

l8=new JLabel("Checked In");
l8.setBounds(30,320,150,20);
add(l8);
t4=new JTextField();
t4.setBounds(200,320,150,20);
add(t4);

l9=new JLabel("Deposit Amount");
l9.setBounds(30,360,150,20);
add(l9);
t5=new JTextField();
t5.setBounds(200,360,150,20);
add(t5);


b1=new JButton("Add Customer");
b1.setBounds(50,420,130,25);
b1.setBackground(Color.BLACK);
b1.setForeground(Color.WHITE);
b1.addActionListener(this);
add(b1);

b2=new JButton("Back");
b2.setBounds(220,420,130,25);
b2.setBackground(Color.BLACK);
b2.setForeground(Color.WHITE);
b2.addActionListener(this);
add(b2);

ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/fifth.png"));
Image i2=i1.getImage().getScaledInstance(300,400, Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel l10=new JLabel(i3);
l10.setBounds(400,20,400,400);
add(l10);


getContentPane().setBackground(Color.WHITE);
setLayout(null);
setSize(900,500);
setLocation(200,100);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==b1){
String id=(String)c1.getSelectedItem();
String number=t1.getText();
String name=t2.getText();
String gender=null;
if(r1.isSelected()){
gender="Male";
}
else if(r2.isSelected()){
gender="Female";
}
String country=t3.getText();
String room=c2.getSelectedItem();
String status=t4.getText();
String deposit=t5.getText();

String str="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposit+"')";
String str2="update rooms set availability='Ocuppied' where room_number='"+room+"'";
String str3="update rooms set status='Clean' where room_number='"+room+"'";
try{
Conn c=new Conn();
c.s.executeUpdate(str);
c.s.executeUpdate(str2);
c.s.executeUpdate(str3);

JOptionPane.showMessageDialog(null,"New Customer Added");
new Reception().setVisible(true);
this.setVisible(false);

}catch(Exception e){}
}
else if(ae.getSource()==b2){
new Reception().setVisible(true);
this.setVisible(false);
}
}
public static void main(String[] args)
{
new AddCustomer();
}
}
