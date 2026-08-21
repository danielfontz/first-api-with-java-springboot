package com.danielsapi.Daniel.s.Api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@RestController("/employee")
public class EmployeeController

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
