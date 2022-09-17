package org.alvas.preparedstatementcustomer.crud;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerApp {
public static void main(String args[])
{Scanner scanner =new Scanner(System.in);
CustomerDao dao=new CustomerDao();

Customer customer =new Customer();

boolean flag=true;
while(flag)
{
	System.out.println("1.Insert customer");
System.out.println("2.update customer");
System.out.println("3.get all customer details");
System.out.println("4. delete customer");
System.out.println("5. exit");
System.out.println("Enter choice");
int ch=scanner.nextInt();
	switch(ch)
	{
	
	case 1:
	System.out.println("Enter the id of customer");
	customer.id=scanner.nextInt();
	System.out.println("Enter the name of customer");
	customer.name=scanner.next();
	System.out.println("Enter the phone of customer");
	customer.phone=scanner.nextLong();
	
	
	
Customer customer1=dao.saveMethod(customer);
if(customer1!=null)
{
	System.out.println("......Data Stored.....");
}
else
{
	System.out.println("......Please Check Your Data.....");
}
break;
	case 2:
	System.out.println("Enter the id of customer");
	customer.id=scanner.nextInt();
	System.out.println("Enter the name of customer");
	customer.name=scanner.next();
	System.out.println("Enter the phone of customer");
	customer.phone=scanner.nextLong();
	
	
Customer customer2=dao.updateData(customer);
if(customer2!=null)
{
	System.out.println("......Data Updated.....");
}
else
{
	System.out.println("......Please Check Your Data.....");
}
break;
	case 3:
		try
		{
	dao.getAllData();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		break;
	case 4:		System.out.println("Enter the id of customer");
	customer.id=scanner.nextInt();
	
	
	
Customer employee2=dao.deleteData(customer);
if(employee2!=null)
{
	System.out.println("......Data deleted.....");
}
else
{
	System.out.println("......Please Check Your id.....");
}
break;
	case 5: flag=false;
	break;
	default:System.out.println("Invalid option");
	
}
}
}
}
