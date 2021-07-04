

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddDriver extends JFrame implements ActionListener
{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
JTextField t1,t2,t3,t4,t5;
JComboBox c1,c2;
JButton b1,b2;

public AddDriver(){
 
l1=new JLabel("ADD NEW DRIVER");
l1.setBounds(180,10,200,30);
l1.setFont(new Font("Tahoma",Font.BOLD,18));
add(l1);

l2=new JLabel("Name");
l2.setBounds(20,100,120,20);
l2.setFont(new Font("Tahoma",Font.PLAIN,15));
add(l2);
t1=new JTextField();
t1.setBounds(160,100,150,20);
add(t1);

l3=new JLabel("Age");
l3.setBounds(20,150,120,20);
l3.setFont(new Font("Tahoma",Font.PLAIN,15));
add(l3);
t2=new JTextField();
t2.setBounds(160,150,150,20);
add(t2);


l4=new JLabel("Gender");
l4.setBounds(20,200,120,20);
l4.setFont(new Font("Tahoma",Font.PLAIN,15));
add(l4);
c1=new JComboBox(new String[]{"Male","Female"});
c1.setBounds(160,200,150,20);
add(c1);


l5=new JLabel("Car Model");
l5.setBounds(20,250,120,20);
l5.setFont(new Font("Tahoma",Font.PLAIN,15));
add(l5);
t3=new JTextField();
t3.setBounds(160,250,150,20);
add(t3);



l8=new JLabel("Car Company");
l8.setBounds(20,300,120,20);
l8.setFont(new Font("Tahoma",Font.PLAIN,15));
add(l8);
t4=new JTextField();
t4.setBounds(160,300,150,20);
add(t4);


l6=new JLabel("Availability");
l6.setBounds(20,350,120,20);
l6.setFont(new Font("Tahoma",Font.PLAIN,15));
add(l6);
c2=new JComboBox(new String[]{"Available","Busy"});
c2.setBounds(160,350,150,20);
add(c2);


l7=new JLabel("Location");
l7.setBounds(20,400,120,20);
l7.setFont(new Font("Tahoma",Font.PLAIN,15));
add(l7);
t5=new JTextField();
t5.setBounds(160,400,150,20);
add(t5);


b1=new JButton("ADD");
b1.setBounds(50,470,120,20);
b1.setBackground(Color.BLACK);
b1.setForeground(Color.WHITE);
b1.addActionListener(this);
add(b1);
b2=new JButton("CANCEL");
b2.setBounds(190,470,120,20);
b2.setBackground(Color.BLACK);
b2.setForeground(Color.WHITE);
b2.addActionListener(this);
add(b2);

//ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/hotel_image4.jpg"));
//Image i2=i1.getImage().getScaledInstance(500,400, Image.SCALE_DEFAULT);
//ImageIcon i3=new ImageIcon(i2);
//l9=new JLabel(i3);
//l9.setBounds(400,100,120,50);
//add(l9);

setLayout(null);
setSize(1000,600);
setLocation(300,100);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
getContentPane().setBackground(Color.WHITE);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==b1){

String name=t1.getText();
String age=t2.getText();
String gender=(String)c1.getSelectedItem();
String carmodel=t3.getText();
String carcompany=t4.getText();
String availability=(String)c2.getSelectedItem();
String location=t5.getText();


Conn c=new Conn();
try{

String str="insert into driver values('"+name+"','"+age+"','"+gender+"','"+carmodel+"','"+carcompany+"','"+availability+"','"+location+"')";
c.s.executeUpdate(str);
JOptionPane.showMessageDialog(null,"Driver Added Successfully");
this.setVisible(false);
}catch(Exception e){
System.out.println(e);
}

}else if(ae.getSource()==b2){
this.setVisible(false);
}

}
public static void main(String[] args) 
{
        new AddDriver();
                 
}

}

