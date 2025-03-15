package com.bootcamp.jpabootcamp.controller;

import com.bootcamp.jpabootcamp.entity.Employee;
import com.bootcamp.jpabootcamp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day-1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Create employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    // Update employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    // Delete employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employees Deleted with id "+id);
    }

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get employee count
    @GetMapping("/count")
    public ResponseEntity<String> getEmployeeCount() {
        return ResponseEntity.ok("Total Employees are: "+employeeService.getEmployeeCount());
    }

    // Pagination and sorting
    @GetMapping("/page")
    public List<Employee> getEmployeesWithPaginationAndSorting(
            @RequestParam int page,
            @RequestParam int size) {
        return employeeService.getAllEmployeesWithPaginationSorting(page, size);
    }

    // Find by name
    @GetMapping("/name/{name}")
    public List<Employee> getEmployeeByName(@PathVariable String name) {
        return employeeService.getEmployeeByName(name);
    }

    // Find by name starting with 'A'
    @GetMapping("/name-starting-with-a")
    public List<Employee> getEmployeesStartingWithA() {
        return employeeService.getEmployeesStartingWithA();
    }

    // Find by age between 28 to 32
    @GetMapping("/age-between")
    public List<Employee> getEmployeesBetweenAge(
            @RequestParam int startAge,
            @RequestParam int endAge) {
        return employeeService.getEmployeesBetweenAge(startAge, endAge);
    }
}
