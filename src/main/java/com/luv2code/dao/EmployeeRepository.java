/**
 * SPRING DATA JPA Implementation class.
 *
 * important URL
 * https://spring.io/projects/spring-data-jpa
 * https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html
 */

package com.luv2code.dao;

import com.luv2code.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
