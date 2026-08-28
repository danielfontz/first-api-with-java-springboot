package com.danielsapi.Daniel.s.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class EmployeeController {
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository){
        this.repository = repository;
    }

    @GetMapping("/employee")
    public List<Employee> GetAll(){
        return repository.findAll();
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee newEmployee){
        return repository.save(newEmployee);
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployeeId(@PathVariable long id){
        return repository.findById(id);
    }

    @PutMapping("/employee/{id}")
    public Employee updateOrCreateEmployee(@RequestBody Employee newEmployee, @PathVariable long id){
        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> repository.save(newEmployee));
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployeeID(@PathVariable long id){
        repository.deleteById(id);
    }

}
