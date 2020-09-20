/**
 * JPA Implementation class.
 */

package com.luv2code.daoImpl;

import com.luv2code.dao.EmployeeDao;
import com.luv2code.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@Qualifier("employeeDaoJPAImpl")
public class EmployeeDaoJPAImpl implements EmployeeDao {

    //Inject Entity Manager.
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        //create a query
        Query query = entityManager.createQuery("from Employee");

        //execute query and get result list
        List<Employee> employee = query.getResultList();

        return employee;
    }

    @Override
    public Employee findById(int employeeId) {
        //get the employee
        Employee employee = entityManager.find(Employee.class, employeeId);

        return employee;
    }

    @Override
    public void save(Employee employee) {
        //save or update the employee

        Employee employe = entityManager.merge(employee);

    }

    @Override
    @Transactional
    public void deleteById(int id) {
        //create query to delete the row by id
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();

    }
}
