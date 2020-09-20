package com.luv2code.serviceImpl;

import com.luv2code.dao.EmployeeRepository;
import com.luv2code.entity.Employee;
import com.luv2code.requestVO.EmployeeVO;
import com.luv2code.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("employeeSpringDataJPAServiceImpl")
public class EmployeeSpringDataJPAServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int employeeId) {
        Optional<Employee> result = employeeRepository.findById(employeeId);
        Employee employee = null;
        if (result.isPresent())
            employee = result.get();

        return employee;
    }

    @Override
    public void save(EmployeeVO employeeVO) {
        Employee employee = new Employee(employeeVO.getFirstName(), employeeVO.getLastName(), employeeVO.getEmail());
        employeeRepository.save(employee);

    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);

    }
}
