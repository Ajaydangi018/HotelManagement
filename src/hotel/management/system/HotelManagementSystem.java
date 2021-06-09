

package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class HotelManagementSystem extends JFrame implements ActionListener
{
ImageIcon i1;
JLabel l1;
JButton b1;

public HotelManagementSystem(){}
public HotelManagementSystem(String s)
{
super(s);
}
public void setComponents(){
 i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/hotel_image3.jpg"));
 l1=new JLabel(i1);
l1.setBounds(0,0,1000,650);
add(l1);
 b1=new JButton("NEXT");
b1.setBounds(810,570,150,30);
b1.setBackground(Color.BLACK);
b1.setForeground(Color.WHITE);
b1.addActionListener(this);
l1.add(b1);
setLayout(null);
}
public void actionPerformed(ActionEvent e)
{
new Login().setVisible(true);
}
public static void main(String[] args) 
{
     HotelManagementSystem hms=new HotelManagementSystem("Desktop Application");
                hms.setComponents();
                 hms.setSize(1000,650);
                 hms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                hms.setVisible(true);
}

}
