package com.beyene.springPracticeProject.controller;

import com.beyene.springPracticeProject.exceptions.EmployeeNotFoundException;
import com.beyene.springPracticeProject.model.Employee;
import com.beyene.springPracticeProject.repository.EmployeeRepository;
import com.beyene.springPracticeProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1")//this path is applied/assigned to all methods
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/employee")//updated way of mapping
    //old method used to be like below
    //@RequestMapping(name="/employee", method=RequestMethod.Post, if post not defined, get will be assigned by default)
    public ResponseEntity<Object> insertEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
    }
    @PostMapping("/employees")
    public ResponseEntity<Object> insertEmployees(@RequestBody List<Employee> employee){
        return new ResponseEntity<>(employeeService.addEmployees(employee), HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<Object> getEmployees(){
        return new ResponseEntity<>(employeeService.readEmployees(),HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Object> getEmployee(@PathVariable int id){
        if(employeeService.readEmployee(id).isPresent())
        return new ResponseEntity<>(employeeService.readEmployee(id),HttpStatus.OK);
        else throw new EmployeeNotFoundException();
    }

    @GetMapping("/employeeByGender")
    public ResponseEntity<Object> getEmployeeByGender(@RequestParam String gender){
        return new ResponseEntity<>(employeeService.readEmployeeByGender(gender),HttpStatus.OK);
    }
    @PutMapping("/employees/{id}")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable int id){
        return new ResponseEntity<>(employeeService.editEmployee(employee,id),HttpStatus.OK);
    }
    @DeleteMapping("/employees")
    public ResponseEntity<Object> deleteEmployee(@RequestParam int id){
        if(employeeService.readEmployee(id).isPresent())
        return new ResponseEntity<>(employeeService.deleteEmployee(id),HttpStatus.OK);
        else throw new EmployeeNotFoundException();
    }
}
