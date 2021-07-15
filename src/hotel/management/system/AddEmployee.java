

package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddEmployee extends JFrame implements ActionListener{

JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
ImageIcon i1;
JTextField t1,t2,t3,t4,t5,t6;
JRadioButton r1,r2;
JComboBox c1;
JButton b1;
public AddEmployee(){
l1=new JLabel("ADD  EMPLOYEE  DETAILS");
l1.setBounds(120,10,240,30);
l1.setBackground(Color.BLACK);
l1.setFont(new Font("Tahoma",Font.BOLD, 16));
add(l1);


l2=new JLabel("NAME");
l2.setBounds(60,60,120,30);
l2.setFont(new Font("Tahoma",Font.PLAIN, 14));
add(l2);
t1=new JTextField();
t1.setBounds(200,60,150,30);
add(t1);


l3=new JLabel("AGE");
l3.setBounds(60,110,120,30);
l3.setFont(new Font("Tahoma",Font.PLAIN, 14));
add(l3);
t2=new JTextField();
t2.setBounds(200,110,150,30);
add(t2);



l4=new JLabel("GENDER");
l4.setBounds(60,160,120,30);
l4.setFont(new Font("Tahoma",Font.PLAIN, 14));
add(l4);
r1=new JRadioButton("Male");
r1.setBounds(200,160,60,30);
add(r1);
r2=new JRadioButton("Female");
r2.setBounds(280,160,70,30);
add(r2);



l5=new JLabel("JOB TYPE");
l5.setBounds(60,210,120,30);
l5.setFont(new Font("Tahoma",Font.PLAIN, 14));
add(l5);
String str[]={"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
c1=new JComboBox(str);
c1.setBounds(200,210,150,30);
add(c1);



l6=new JLabel("SALARY");
l6.setBounds(60,260,120,30);
l6.setFont(new Font("Tahoma",Font.PLAIN, 14));
add(l6);
t3=new JTextField();
t3.setBounds(200,260,150,30);
add(t3);



l7=new JLabel("PHONE");
l7.setBounds(60,310,120,30);
l7.setFont(new Font("Tahoma",Font.PLAIN, 14));
add(l7);
t4=new JTextField();
t4.setBounds(200,310,150,30);
add(t4);


l8=new JLabel("AADHAR");
l8.setBounds(60,360,120,30);
l8.setFont(new Font("Tahoma",Font.PLAIN, 14));
add(l8);
t5=new JTextField();
t5.setBounds(200,360,150,30);
add(t5);



l9=new JLabel("EMAIL");
l9.setBounds(60,410,120,30);
l9.setFont(new Font("Tahoma",Font.PLAIN, 14));
add(l9);
t6=new JTextField();
t6.setBounds(200,410,150,30);
add(t6);


b1=new JButton("SUBMIT");
b1.setBounds(200,460,150,30);
b1.setForeground(Color.WHITE);
b1.setBackground(Color.BLACK);
b1.addActionListener(this);
add(b1);

i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/third.jpg"));
l1=new JLabel(i1);
l1.setBounds(400,50,400,500);
add(l1);


setLayout(null);
setSize(1000,600);
setLocation(300,100);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){

String name=t1.getText();
String age=t2.getText();
String salary=t3.getText();
String phone=t4.getText();
String aadhar=t5.getText();
String email=t6.getText();
String gender=null;
if(r1.isSelected()){
gender="Male";
}
else if(r2.isSelected()){
gender="Female";
}
String jobtype=(String)c1.getSelectedItem();
Conn c=new Conn();
String str="insert into employee values('"+name+"','"+age+"','"+gender+"','"+jobtype+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";
try{

c.s.executeUpdate(str);
JOptionPane.showMessageDialog(null,"New Employee Added");
this.setVisible(false);
}catch(Exception e){System.out.print(e);}


}
public static void main(String[] args)
{
new AddEmployee();
}
}
