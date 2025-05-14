package com.example.ctpseducation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ctpseducation.entity.Employee;
import com.example.ctpseducation.service.EmployeeSerivce;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeSerivce employeeSerivce;

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeSerivce.createEmployee(employee);
    }

    @GetMapping("/fetch/all")
    public List<Employee> getAllEmployees() {
        return employeeSerivce.getAllEmployees();
    }

    @GetMapping("/fetch/{id}")
    public Employee getEmployeeById(@PathVariable("id") String id) {
        return employeeSerivce.getEmployeeById(id);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        // Usando o mesmo método do serviço para incluir e alterar
        return employeeSerivce.createEmployee(employee);
    }

    @DeleteMapping("/delete")
    public void deleteEmployee(@PathVariable("id") String id) {
        employeeSerivce.deleteEmployee(id);
    }
}
