package de.marshal.javaspring.services;

import de.marshal.javaspring.entities.Employee;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Service
@ConditionalOnProperty("app.service.employee.stub_enabled")
public class StubEmployeeService implements EmployeeService {
    private List<Employee> employees = new CopyOnWriteArrayList<>(List.of(
            new Employee("E1", "S1", 17),
            new Employee("E2", "S2", 18),
            new Employee("E3", "S3", 19)
    ));

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employees);
    }

    @Override
    public List<Employee> findByName(String name) {
        return employees.stream().filter(e -> e.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> findByNameStartingWith(String prefix) {
        return employees.stream().filter(e -> e.getName().startsWith(prefix)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> deleteWithAgeLessThan(int value) {
        List<Employee> employeesToDelete = employees.stream().filter(e -> e.getAge() < value).collect(Collectors.toList());

        employees.removeAll(employeesToDelete);

        return employeesToDelete;
    }

    @Override
    public Employee getById(String id) {
        return employees.stream()
                .filter(e -> Objects.equals(id, e.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Employee add(String name, String surname, int age) {
        Employee employee = new Employee(name, surname, age);
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee update(String id, String name, String surname, int age) {
        Employee employeeToUpdate = getById(id);

        if (employeeToUpdate != null) {
            employeeToUpdate.setName(name);
            employeeToUpdate.setSurname(surname);
            employeeToUpdate.setAge(age);
        }

        return employeeToUpdate;
    }

    @Override
    public Employee delete(String id) {
        Employee employeeToDelete = getById(id);
        employees.remove(employeeToDelete);
        return employeeToDelete;
    }

    @Override
    public int count() {
        return  employees.size();
    }

    @Override
    public void fillEmptySurnameWith(String value) {
        employees.stream()
                .filter(e -> e.getSurname() == null || e.getSurname().isBlank())
                .forEach(e -> e.setSurname(value));
    }
}
