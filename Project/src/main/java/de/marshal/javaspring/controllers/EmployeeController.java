package de.marshal.javaspring.controllers;

import de.marshal.javaspring.entities.Employee;
import de.marshal.javaspring.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private static final String NOT_PROVIDED = "Not provided";
    private static final int UNDERAGE_THRESHOLD = 18;

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> find(
            @RequestParam(name = "name", required = false)
            String name,
            @RequestParam(name = "prefix", required = false)
            String prefix
    ) {
        if (name != null && prefix != null) {
            return ResponseEntity.badRequest().build();
        }

        List<Employee> employees;

        if (name != null) {
            employees = employeeService.findByName(name);
        } else if (prefix != null) {
            employees = employeeService.findByNameStartingWith(prefix);
        } else {
            employees = employeeService.findAll();
        }

        return ResponseEntity.ok(employees);
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> count() {
        return ResponseEntity.ok(employeeService.count());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(
            @PathVariable("id")
            String id
    ) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }

        Employee employee = employeeService.getById(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<Employee> add(
            @RequestBody
            Employee employeeToAdd
    ) {
        if (employeeToAdd.getName() == null) {
            return ResponseEntity.badRequest().build();
        }

        Employee employee = employeeService.add(
                employeeToAdd.getName(),
                employeeToAdd.getSurname(),
                employeeToAdd.getAge()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @PostMapping("/fillEmptySurname")
    public ResponseEntity<Void> fillEmptySurname() {
        employeeService.fillEmptySurnameWith(NOT_PROVIDED);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/deleteUnderage")
    public ResponseEntity<List<Employee>> deleteUnderage(){
        return ResponseEntity.ok(employeeService.deleteWithAgeLessThan(UNDERAGE_THRESHOLD));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(
            @PathVariable("id")
            String id
    ) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }

        Employee employee = employeeService.delete(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping
    public ResponseEntity<Employee> update(
            @RequestBody
            Employee employeeToUpdate
    ) {
        if (employeeToUpdate.getId() == null || employeeToUpdate.getName() == null) {
            return ResponseEntity.badRequest().build();
        }

        Employee employee = employeeService.update(
                employeeToUpdate.getId(),
                employeeToUpdate.getName(),
                employeeToUpdate.getSurname(),
                employeeToUpdate.getAge()
        );
        return ResponseEntity.ok(employee);
    }
}
