package de.marshal.javaspring.employeeweb.service;

import de.marshal.javaspring.employeeweb.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getEmployees();

    Optional<Employee> findEmployeeByIdAndName(String id, String name);

    void add(Employee employee);

    boolean updateEmployee(Employee employee);

    Employee updateEmployeeSurnameAndAge(String id, String surname, int age);

    void deleteEmployee(String id);
}