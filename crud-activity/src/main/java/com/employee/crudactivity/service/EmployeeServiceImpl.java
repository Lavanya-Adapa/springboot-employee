package com.employee.crudactivity.service;
import com.employee.crudactivity.dao.EmployeeDAO;
import com.employee.crudactivity.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService
{

    private EmployeeDAO employeeDAO;
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO)
    {
        employeeDAO=theEmployeeDAO;
    }
    @Transactional
    public List<Employee> findAll()
    {
        return employeeDAO.findAll();
    }
    @Transactional
    public Employee findById(int theId)
    {
        return employeeDAO.findById(theId);

    }
    @Transactional
    public void save(Employee theEmployee)
    {
        employeeDAO.save(theEmployee);
    }
    @Transactional
    public void deleteById(int theId)
    {
        employeeDAO.deleteById(theId);

    }
}

