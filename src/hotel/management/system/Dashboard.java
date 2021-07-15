
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener
{
JMenuBar mb1;
JMenu m1,m2,m3;
JMenuItem t1,t2,t3,t4;
JLabel l1;
ImageIcon I1;
public Dashboard(){
mb1=new JMenuBar();
mb1.setBounds(0,0,1000,30);
add(mb1);

m1=new JMenu("MANAGEMENT");
m1.setBackground(Color.WHITE);
m1.setForeground(Color.RED);
mb1.add(m1);
m2=new JMenu("ADMIN");
m2.setBackground(Color.WHITE);
m2.setForeground(Color.BLUE);
mb1.add(m2);

t1=new JMenuItem("RECEPTION");
t1.addActionListener(this);
m1.add(t1);
t2=new JMenuItem("ADD EMPLOYEE");
t2.addActionListener(this);
m2.add(t2);
t3=new JMenuItem("ADD ROOMS");
t3.addActionListener(this);
m2.add(t3);
t4=new JMenuItem("ADD DRIVERS");
t4.addActionListener(this);
m2.add(t4);

 I1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/third.jpg"));
 l1=new JLabel(I1);
l1.setBounds(0,40,1000,600);
add(l1);

setLayout(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(1000,900);
setLocation(200,0);
setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getActionCommand().equals("RECEPTION")){
new Reception().setVisible(true);
}else if(ae.getActionCommand().equals("ADD EMPLOYEE")){
new AddEmployee().setVisible(true);
}else if(ae.getActionCommand().equals("ADD ROOMS")){
new AddRooms().setVisible(true);
}else if(ae.getActionCommand().equals("ADD DRIVERS")){
new AddDriver().setVisible(true);
}
}
public static void main(String[] args)
{
new Dashboard();
}
}
