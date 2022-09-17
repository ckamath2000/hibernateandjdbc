package customerconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class CustomerConnection {
public static Connection getConnection()
{ String url="jdbc:mysql://localhost:3306/Customerapp-jdbc";
String username="root";
String password="root";
try
{
	Connection connection=DriverManager.getConnection(url,username,password);
	return connection;
}
catch(Exception e)
{
	e.printStackTrace();
}
return null;
}
}
