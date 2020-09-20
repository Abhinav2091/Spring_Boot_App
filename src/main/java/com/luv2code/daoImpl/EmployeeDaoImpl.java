/**
 * Hibernate Implementation class.
 */

package com.luv2code.daoImpl;

import com.luv2code.dao.EmployeeDao;
import com.luv2code.entity.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Qualifier("employeeDaoImpl")
public class EmployeeDaoImpl implements EmployeeDao {

    //Inject Entity Manager.
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        //get the current hibernate session
        Session session = entityManager.unwrap(Session.class);

        //create a query
        Query<Employee> query = session.createQuery("from Employee", Employee.class);

        //execute query
        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int id) {
        //get the current hibernate session
        Session session = entityManager.unwrap(Session.class);

        //get the employee
        Employee employee = session.get(Employee.class, id);

        return employee;
    }

    @Override
    public void save(Employee employee) {

        //get the current hibernate session
        Session session = entityManager.unwrap(Session.class);

        //save employee
        session.saveOrUpdate(employee);

    }

    @Override
    public void deleteById(int id) {

        //get the current hibernate session
        Session session = entityManager.unwrap(Session.class);

        //create a query
        Query<Employee> query = session.createQuery("delete from Employee where id:=id", Employee.class);

        //set the id
        query.setParameter("id", id);

        //execute query
        query.executeUpdate();

    }
}
