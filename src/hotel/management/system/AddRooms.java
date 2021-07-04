

package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener{

JLabel rooms,l1,l2,l3,l4,l5;
JTextField t1,t2;
JComboBox c1,c2,c3;
JButton b1,b2;
AddRooms(){
rooms=new JLabel("ADD ROOMS DETAILS");
rooms.setFont(new Font("Tahoma",Font.BOLD,18));
rooms.setBounds(180,10,200,30);
add(rooms);

l1=new JLabel("Room Number");
l1.setFont(new Font("Tahoma",Font.PLAIN,15));
l1.setBounds(20,100,120,20);
add(l1);
t1=new JTextField();
t1.setBounds(160,100,150,20);
add(t1);



l2=new JLabel("Availability");
l2.setFont(new Font("Tahoma",Font.PLAIN,15));
l2.setBounds(20,150,120,20);
add(l2);
c1=new JComboBox(new String[]{"Available","Ocuppied"});
c1.setBounds(160,150,150,20);
add(c1);


l3=new JLabel("Cleaning Status");
l3.setFont(new Font("Tahoma",Font.PLAIN,15));
l3.setBounds(20,200,120,20);
add(l3);
c2=new JComboBox(new String[]{"Clean","Dirty"});
c2.setBounds(160,200,150,20);
add(c2);




l4=new JLabel("Price");
l4.setFont(new Font("Tahoma",Font.PLAIN,15));
l4.setBounds(20,250,120,20);
add(l4);
t2=new JTextField();
t2.setBounds(160,250,150,20);
add(t2);



l5=new JLabel("Bed Type");
l5.setFont(new Font("Tahoma",Font.PLAIN,15));
l5.setBounds(20,300,120,20);
add(l5);
c3=new JComboBox(new String[]{"Single Bed","Double Bed"});
c3.setBounds(160,300,150,20);
add(c3);

b1=new JButton("ADD");
b1.setBounds(30,400,120,20);
b1.setBackground(Color.BLACK);
b1.setForeground(Color.WHITE);
b1.addActionListener(this);
add(b1);
b2=new JButton("CANCEL");
b2.setBounds(180,400,120,20);
b2.setBackground(Color.BLACK);
b2.setForeground(Color.WHITE);
b2.addActionListener(this);
add(b2);


getContentPane().setBackground(Color.WHITE);


setSize(600,500);
setLocation(300,100);
setLayout(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==b1){

String room=t1.getText();
String available=(String)c1.getSelectedItem();
String status=(String)c2.getSelectedItem();
String price=t2.getText();
String bedtype=(String)c3.getSelectedItem();


Conn c=new Conn();
try
{
String str="insert into rooms values('"+room+"','"+available+"','"+status+"','"+price+"','"+bedtype+"')";
c.s.executeUpdate(str);
JOptionPane.showMessageDialog(null,"New Room Added");
this.setVisible(false);
}catch(Exception e){
System.out.println(e);
}

}
else if(ae.getSource()==b2){
this.setVisible(true);
}

}


public static void main(String[] args)
{
new AddRooms();
}
}
