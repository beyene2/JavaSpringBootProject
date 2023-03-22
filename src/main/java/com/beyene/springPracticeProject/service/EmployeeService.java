package com.beyene.springPracticeProject.service;

import com.beyene.springPracticeProject.model.Employee;
import com.beyene.springPracticeProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    public EmployeeRepository employeeRepository;
    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> addEmployees(List<Employee> employee) {
        return employeeRepository.saveAll(employee);
    }
    public List<Employee> readEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> readEmployee(int id){
        return employeeRepository.findById(id);
    }

    public Optional<List<Employee>> readEmployeeByGender(String gender){
        return employeeRepository.findByGender(gender);
    }

    public Employee editEmployee(Employee employee, int id) {
        if(employeeRepository.findById(id).isPresent()){
            Employee emp = new Employee();
            emp.setEmpid(id);
            emp.setFullname(employee.getFullname());
            emp.setAge(employee.getAge());
            emp.setSalary(employee.getSalary());
            emp.setGender(employee.getGender());
            return employeeRepository.save(emp);
        }else
            return null;

    }

    public Boolean deleteEmployee(int id) {
        if(employeeRepository.findById(id).isPresent()){
            employeeRepository.deleteById(id);
            return true;
        }else
            return false;
    }
}
