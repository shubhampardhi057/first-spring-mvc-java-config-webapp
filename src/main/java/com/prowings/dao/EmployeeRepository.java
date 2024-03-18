package com.prowings.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prowings.entity.Employee;

@Repository
public class EmployeeRepository {
	

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean saveEmployeeToDb(Employee emp)
	{
		boolean result = false;	
		try 
		{
			
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		session.save(emp);
		txn.commit();
		session.close();
		result = true;
		}
		catch (Exception e) 
		{
			System.out.println("Error occured while storing the employee :"+e.getStackTrace());
		}
		
		return result;
	}
	
	public List<Employee> viewAllEmployee()
	{
		Session session = sessionFactory.openSession();
		Transaction txn = null;
		List<Employee> EmpList = null;
		
		try {
			
			txn = session.beginTransaction();
			Query<Employee> query = session.createQuery("from Employee");
			EmpList = query.list();
			txn.commit();
		
		}
		catch (HibernateException e) 
		{
			if(txn != null)
			{
				txn.rollback();
			}
			System.out.println("Exception :"+e.getMessage());
			e.printStackTrace(System.err);
		}
		finally 
		{
			session.close();
			
			return EmpList;
			
		}
		
	}


}
