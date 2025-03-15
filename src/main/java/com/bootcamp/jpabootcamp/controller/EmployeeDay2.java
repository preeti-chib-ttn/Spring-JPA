package com.bootcamp.jpabootcamp.controller;


import com.bootcamp.jpabootcamp.projection.NameProjection;
import com.bootcamp.jpabootcamp.repository.EmployeeRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day2")
@Tag(name = "Day - 2")
public class EmployeeDay2 {

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
    @PutMapping("/jpql/update-salary-if-less-than-avg/{salary}")
    @Operation(summary = "Question 1-b", description ="Update salary of all employees by a salary passed as a parameter " +
            "whose existing salary is less than the average")
    ResponseEntity<String> updateSalaryIfLtAvg(@RequestParam Double salary){
        Double averageSalary = employeeRepository.findAverageSalary();
        int updatedNumber =employeeRepository.updateSalaryIfLessThanAverage(salary,averageSalary);
        return ResponseEntity.ok("Updated "+ updatedNumber+" salary successfully");
    }


    // Question 1-c
    @DeleteMapping("/jpql/delete-if-salary-minimum")
    @Operation(summary = "Question 1-c",description ="Delete all employees with minimum salary.")
    ResponseEntity<String> deleteSalaryIfLtMin(){
        Double minSalary = employeeRepository.findMinSalary();
        int deletedNumber =employeeRepository.deleteAllMinSalaryEmployee(minSalary);
        return ResponseEntity.ok("Deleted "+ deletedNumber+" employees successfully");
    }



    // Question 2-a
    @GetMapping("/native/get-employee-last-name-singh")
    @Operation(summary = "Question 2-a",description = "Display the id, firstName, age of all employees where last name ends with \"singh\".")
    List<Map<String,Object>> getEmployeeWithLastNameSingh(){
        List<Object[]> employees= employeeRepository.findEmployeeWhereLastNameSingh();
        return employees.stream().map(obj -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", obj[0]);
            map.put("firstName", obj[1]);
            map.put("age", obj[2]);
            return map;
        }).toList();
    }


    // Question 2-b
    @DeleteMapping("/native/delete-age-less-than/{age}")
    @Operation(summary = "Question 2-b",description ="Delete all employees with age greater " +
            "than `45` (should be passed as a parameter).")
    ResponseEntity<String> deleteIfAgeGreaterThan(@RequestParam Integer age){
        int deletedNumber =employeeRepository.deleteEmployeebyAge(age);
        return ResponseEntity.ok("Deleted "+ deletedNumber+" employees successfully");
    }







}
