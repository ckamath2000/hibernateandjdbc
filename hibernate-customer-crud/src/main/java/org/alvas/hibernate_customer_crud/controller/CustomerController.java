package org.alvas.hibernate_customer_crud.controller;

import java.util.List;
import java.util.Scanner;

import org.alvas.hibernate_customer_crud.dao.CustomerDao;
import org.alvas.hibernate_customer_crud.dto.Customer;

public class CustomerController {
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	Customer customer;
	CustomerDao customerDao=new CustomerDao();
	while(true)
	{
		System.out.println("1.Save Customer");
		System.out.println("2.Update Customer by id");
		System.out.println("3.Delete Customer by id");
		System.out.println("4.Select all customers");
		System.out.println("Enter your choice");
		int ch=scanner.nextInt();
		switch(ch)
		{
		case 1:
		{
			customer=new Customer();
		System.out.println("Enter the customerName");
		customer.setName(scanner.next());
		System.out.println("Enter the customerEmail");
		customer.setEmail(scanner.next());
		customerDao.saveCustomer(customer);
		}
		case 2:
		{
			System.out.println("Enter the id");
			int id = scanner.nextInt();
			System.out.println("Enter the customer Name");
			String name = scanner.next();
			Customer customer1 = customerDao.updateById(id, name);
			System.out.println(customer1.getId()+" "+customer1.getName());
		}
		case 3:
		{
			System.out.println("Enter the id");
			int id = scanner.nextInt();
		
			Customer customer1 = customerDao.deleteById(id);
			System.out.println(customer1.getId()+" "+customer1.getName());
		
		}
		case 4:
		{
			
			List<Customer> list=customerDao.getAllData();
			
			list.forEach(a->System.out.println(a.getId()+"\n"+a.getName()+"\n"+a.getEmail()));
		
		}
		}
	}
		
}
}
