package com.employee.crudactivity.restController;
import com.employee.crudactivity.entity.Employee;
import com.employee.crudactivity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController
{
    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService)
    {
        employeeService=theEmployeeService;

    }
    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int EmployeeId)
    {
        Employee theEmployee=employeeService.findById(EmployeeId);
        if(theEmployee==null) {
            throw new RuntimeException("Employee Id not found: -" + EmployeeId);
        }
        return theEmployee;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee)
    {
        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return theEmployee;

    }
    @PutMapping("/employees")
    public Employee UpdateEmployee(@RequestBody Employee theEmployee)
    {
        employeeService.save(theEmployee);
        return theEmployee;

    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId)
    {
        Employee tempEmployee=employeeService.findById(employeeId);
        if(tempEmployee==null)
        {
            throw new RuntimeException("Employee not found with Id:"+employeeId);

        }
        employeeService.deleteById(employeeId);
        return "Deleted employee id:"+employeeId;

    }


}

