package org.alvas.preparedstatementcustomer.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import customerconnection.CustomerConnection;
public class CustomerDao {
	Connection connection;
public Customer saveMethod(Customer customer)
{
	connection=CustomerConnection.getConnection();
String insert="insert into customer values(?,?,?)";
try
{
	PreparedStatement preparedStatement=connection.prepareStatement(insert);
	 preparedStatement.setInt(1,customer.id);
	 preparedStatement.setString(2,customer.name);
	 preparedStatement.setLong(3,customer.phone);
	
	 preparedStatement.execute();
}
catch(SQLException e)
{
	e.printStackTrace();
}
	return customer;
}

public void getAllData() throws SQLException
{
	connection=CustomerConnection.getConnection();
	String select="select * from customer" ;
	try
	{
		PreparedStatement preparedStatement=connection.prepareStatement(select);
		 ResultSet resultset=preparedStatement.executeQuery();
		 while(resultset.next())
		 {
			 System.out.println(resultset.getInt(1));
			 System.out.println(resultset.getString(2));
			 System.out.println(resultset.getLong(3));
		
			 
		 }
	
}
	catch(SQLException e)
	{
		e.printStackTrace();
	}

}
public Customer updateData(Customer customer)
{
	connection=CustomerConnection.getConnection();
	String insert="update customer set name= ?,phone= ? where id=?" ;
	try
	{
		PreparedStatement preparedStatement=connection.prepareStatement(insert);
		 preparedStatement.setString(1,customer.name);
		 preparedStatement.setLong(2,customer.phone);
		 preparedStatement.setInt(3,customer.id);
		 preparedStatement.execute();
}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return customer;
}
public Customer deleteData(Customer customer)
{
	connection=CustomerConnection.getConnection();
	String delete="delete from customer  where id=?" ;
	try
	{
		PreparedStatement preparedStatement=connection.prepareStatement(delete);
		
		 preparedStatement.setInt(1,customer.id);
		 preparedStatement.execute();
}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return customer;
}
}
