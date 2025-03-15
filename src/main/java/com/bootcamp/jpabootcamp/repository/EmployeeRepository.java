package com.bootcamp.jpabootcamp.repository;

import com.bootcamp.jpabootcamp.entity.Employee;
import com.bootcamp.jpabootcamp.projection.NameProjection;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {



    /*1) Display the first name, last name of all employees having salary greater than
     average salary ordered in ascending by their age and in descending by their salary.
     * */
    @Query(" FROM Employee WHERE salary " +
            "> (SELECT AVG(salary) from Employee)")
    List<NameProjection> findAllWithSalaryGtAvg(Sort orders);


    @Query("SELECT AVG(salary) from Employee")
    Double findAverageSalary();

    /*
    * 2) Update salary of all employees by a salary passed as a parameter
    *  whose existing salary is less than the average salary.
     */
    @Transactional
    @Modifying
    @Query("UPDATE Employee  SET salary = :newSalary " +
            "WHERE salary < :avgSalary")
    int updateSalaryIfLessThanAverage(@Param("newSalary") Double salary, @Param("avgSalary") Double avgSalary);

    @Query("SELECT MIN(salary) FROM Employee")
    Double findMinSalary();

    /* Delete all employees with minimum salary. */
    @Transactional
    @Modifying
    @Query("DELETE Employee WHERE salary= :minSalary")
    int deleteAllMinSalaryEmployee(@Param("minSalary") Double minSalary);
}
