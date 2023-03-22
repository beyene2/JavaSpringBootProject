package com.beyene.springPracticeProject.repository;

import com.beyene.springPracticeProject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<List<Employee>> findByGender(String gender);
}
