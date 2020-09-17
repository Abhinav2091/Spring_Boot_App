package com.luv2code.service;

import com.luv2code.entity.Employee;
import com.luv2code.requestVO.EmployeeVO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface EmployeeService {


    public List<Employee> findAll();

    Employee findById(int employeeId);

    void save(EmployeeVO employeeVO);

    void deleteById(int id);
}
