package com.bootcamp.jpabootcamp.service;
import com.bootcamp.jpabootcamp.entity.Employee;
import com.bootcamp.jpabootcamp.exception.ResourceNotFoundException;
import com.bootcamp.jpabootcamp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Q3) Perform Create Operation on Entity
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Q4) Perform Update Operation on Entity
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        existingEmployee.setName(employee.getName());
        existingEmployee.setAge(employee.getAge());
        existingEmployee.setLocation(employee.getLocation());

        return employeeRepository.save(existingEmployee);
    }

    // Q5) Perform Delete Operation on Entity
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // Q6) Perform Read Operation on Entity
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Q7) Get the total count of the number of Employees
    public long getEmployeeCount() {
        return employeeRepository.count();
    }

    // Q8) Implement Pagination and Sorting on the bases of Employee Age
    public List<Employee> getAllEmployeesWithPaginationSorting(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("age"));
        return employeeRepository.findAll(pageable).getContent();
    }

    // Q9) Create and use finder to find Employee by Name
    public List<Employee> getEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    // Q10. Find starting with 'A'
    public List<Employee> getEmployeesStartingWithA() {
        return employeeRepository.findByNameStartingWith("A");
    }

    // Q11. Find age Between the age of 28 to 32
    public List<Employee> getEmployeesBetweenAge(int startAge, int endAge) {
        return employeeRepository.findByAgeBetween(startAge, endAge);
    }
}

