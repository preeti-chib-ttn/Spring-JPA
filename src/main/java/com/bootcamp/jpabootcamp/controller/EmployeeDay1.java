package com.bootcamp.jpabootcamp.controller;


import com.bootcamp.jpabootcamp.entity.Employee;
import com.bootcamp.jpabootcamp.projection.NameProjection;
import com.bootcamp.jpabootcamp.repository.EmployeeRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day1")
@Tag(name = "Day1")
public class EmployeeDay1 {

    // Avoided service layer to be more focused on Spring jpa data functionalities
    @Autowired
    EmployeeRepository employeeRepository;

    // Question 1-a
    @GetMapping("/jpql/get-employee-with-salary-gt-avg-sorted")
    @Operation(summary = "Question 1-a",description = "Display the first name, " +
            "last name of all employees having salary greater than\n" +
            "average salary ordered in ascending by their age and in descending by their salary.")
    List<NameProjection> getEmployeeWithSalaryGtAvg(){
        Sort sort = Sort.by(Sort.Order.asc("age"),Sort.Order.desc("salary"));
        return employeeRepository.findAllWithSalaryGtAvg(sort);
    }


    // Question 1-b
    @PutMapping("/jpql/update-salary-if-less-than-avg")
    @Operation(summary ="Update salary of all employees by a salary passed as a parameter " +
            "whose existing salary is less than the average")
    ResponseEntity<String> updateSalaryIfLtAvg(@RequestParam Double salary){
        Double averageSalary = employeeRepository.findAverageSalary();
        int updatedNumber =employeeRepository.updateSalaryIfLessThanAverage(salary,averageSalary);
        return ResponseEntity.ok("Updated "+ updatedNumber+" salary successfully");
    }


    // Question 1-c
    @DeleteMapping("/jpql/delete-if-salary-minimum")
    @Operation(summary ="Delete all employees with minimum salary.")
    ResponseEntity<String> deleteSalaryIfLtMin(){
        Double minSalary = employeeRepository.findMinSalary();
        int deletedNumber =employeeRepository.deleteAllMinSalaryEmployee(minSalary);
        return ResponseEntity.ok("Deleted "+ deletedNumber+" employees successfully");
    }





}
