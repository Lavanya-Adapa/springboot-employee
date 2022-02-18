package com.employee.crudactivity.dao;
import com.employee.crudactivity.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO
{
    private EntityManager entityManager;
    public EmployeeDAOImpl(EntityManager theEntityManager)
    {
        entityManager=theEntityManager;
    }

    @Transactional
    public List<Employee> findAll()
    {
        Session currentsession=entityManager.unwrap(Session.class);
        Query<Employee> theQuery=currentsession.createQuery("from Employee",Employee.class);
        List<Employee> employees=theQuery.getResultList();
        return employees;

    }
    public Employee findById(int theId)
    {
        Session currentsession=entityManager.unwrap(Session.class);
        Employee theemployee=currentsession.get(Employee.class,theId);
        return theemployee;
    }
    public  void save(Employee theEmployee)
    {
        Session currentsession=entityManager.unwrap(Session.class);
        currentsession.saveOrUpdate(theEmployee);

    }
    public void deleteById(int theId)
    {
        Session currentsession=entityManager.unwrap(Session.class);
        Query theQuery=currentsession.createQuery("delete from Employee where id= :EmployeeId");
        theQuery.setParameter("EmployeeId",theId);
        theQuery.executeUpdate();


    }
}

