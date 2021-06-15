

package hotel.management.system;


import java.sql.*;

public class Conn  
{
Connection c;
Statement s;
public Conn()
{
try
{

   Class.forName("com.mysql.jdbc.Driver");
   c= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","root");
   s=c.createStatement();

}
catch(Exception e)
{
System.out.println(e.getMessage());
}
}
public static void main(String[] args)
{
Conn c=new Conn();
}
}




