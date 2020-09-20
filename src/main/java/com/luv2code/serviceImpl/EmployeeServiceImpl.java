package com.luv2code.serviceImpl;

import com.luv2code.dao.EmployeeDao;
import com.luv2code.dao.EmployeeRepository;
import com.luv2code.entity.Employee;
import com.luv2code.requestVO.EmployeeVO;
import com.luv2code.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("employeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    //@Qualifier("employeeDaoImpl")//for simple hibernate
    @Qualifier("employeeDaoJPAImpl")//for JPA
    private EmployeeDao employeeDao;


    @Override
    @Transactional //handle transaction no need to manually start or commit.
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int employeeId) {
        return employeeDao.findById(employeeId);
    }

    @Override
    @Transactional
    public void save(EmployeeVO employeeVO) {
        employeeDao.save(new Employee(employeeVO.getFirstName(), employeeVO.getFirstName(), employeeVO.getEmail()));

    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDao.deleteById(id);

    }
}
