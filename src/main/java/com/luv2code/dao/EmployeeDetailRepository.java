package com.luv2code.dao;

import com.luv2code.entity.EmployeeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/*
* by defaultt end point for spring data ret is entity name in lower case with s in the end.
 */

@RepositoryRestResource(path = "members") // to set customised path for spring data rest
public interface EmployeeDetailRepository extends JpaRepository<EmployeeDetail, Integer> {
}
