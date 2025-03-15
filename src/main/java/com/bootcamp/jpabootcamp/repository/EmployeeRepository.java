package com.bootcamp.jpabootcamp.repository;

import com.bootcamp.jpabootcamp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
