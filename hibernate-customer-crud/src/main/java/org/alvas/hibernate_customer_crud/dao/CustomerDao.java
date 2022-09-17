package org.alvas.hibernate_customer_crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.alvas.hibernate_customer_crud.dto.Customer;

public class CustomerDao {

EntityManagerFactory entityManagerFactory;
EntityManager entityManager;
EntityTransaction entityTransaction;
/*Save Customer */
public Customer saveCustomer(Customer customer)
{	 entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	entityManager=entityManagerFactory.createEntityManager();
	entityTransaction=entityManager.getTransaction();
	if(customer!=null)
	{entityTransaction.begin();
entityManager.persist(customer);
entityTransaction.commit();
System.out.println("......Data Stored.........");
	}
	else
	{
		System.out.println(".....please set the data in customer object......");
	}

return customer;

}
public Customer updateById(int id,String name)
{
	 entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
		Customer customer =entityManager.find(Customer.class,id);
		customer.setName(name);
		if(customer!=null)
		{entityTransaction.begin();
	entityManager.persist(customer);
	entityTransaction.commit();
	System.out.println("......Data updated.........");
		}
		else
		{
			System.out.println(".....please set the data in customer object......");
		}

	return customer;
}
public Customer deleteById(int id) {
	entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	entityManager=entityManagerFactory.createEntityManager();
	entityTransaction=entityManager.getTransaction();
	Customer customer = entityManager.find(Customer.class,id);
	if(customer!=null) {
		entityTransaction.begin();
		entityManager.remove(customer);
		entityTransaction.commit();
		System.out.println(".........Data Deleted...................");
	}else{
		System.out.println("..........Please set the data in customer object ...................");
	}
	return customer;
}
public List<Customer> getAllData()
{
	entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
     entityManager=entityManagerFactory.createEntityManager();
	
String query="SELECT c FROM Customer c";
Query query2=entityManager.createQuery(query);
List<Customer> list=query2.getResultList();
return list;

}
}
