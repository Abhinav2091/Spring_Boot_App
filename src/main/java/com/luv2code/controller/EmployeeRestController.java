package com.luv2code.controller;


import com.luv2code.requestVO.EmployeeVO;
import com.luv2code.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employee")
    public ResponseEntity<Object> getEmployeeList() {
        return new ResponseEntity<Object>(employeeService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<Object> addEmployee(@RequestBody EmployeeVO employeeVO) {
        employeeService.save(employeeVO);
        return new ResponseEntity<Object>("SUCCESS", HttpStatus.OK);
    }

    @GetMapping (value = "/{id}/employee")
    public ResponseEntity<Object> getEmployee(@PathVariable(value ="id",required = true)int id) {
        return new ResponseEntity<Object>(employeeService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}/employee")
    public ResponseEntity<Object> DeleteEmployee(@PathVariable(value ="id",required = true)int id) {
        employeeService.deleteById(id);
        return new ResponseEntity<Object>("SUCCESS", HttpStatus.OK);
    }

}
