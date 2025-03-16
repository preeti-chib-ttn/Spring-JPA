package com.bootcamp.jpabootcamp.repository;

import com.bootcamp.jpabootcamp.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    // Q9) Create and use finder to find Employee by Nam
    List<Employee> findByName(String name);

    // Q10) Create and use finder to find Employees starting with A character
    List<Employee> findByNameStartingWith(String prefix);

    // Q11) Create and use finder to find Employees Between the age of 28 to 32
    List<Employee> findByAgeBetween(int startAge, int endAge);
}
