package de.marshal.javaspring.services;

import de.marshal.javaspring.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    List<Employee> findByName(String name);

    List<Employee> findByNameStartingWith(String prefix);

    List<Employee> deleteWithAgeLessThan(int value);

    Employee getById(String id);

    Employee add(String name, String surname, int age);

    Employee update(String id, String name, String surname, int age);

    Employee delete(String id);

    int count();

    void fillEmptySurnameWith(String value);
}
