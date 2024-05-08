package com.tci.javaproject.controller;

import com.tci.javaproject.entity.Employee;
import com.tci.javaproject.payload.BonusResponse;
import com.tci.javaproject.service.EmployeeService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tci/")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("employee-bonus")
    public List<Employee> saveEmployeeList(@RequestBody List<Employee> employees){
        return employeeService.saveEmployees(employees);
    }

    @GetMapping("employee-bonus")
    public BonusResponse getEligibleEmployeesForBonus(@RequestParam("date") @DateTimeFormat(pattern = "MMM-dd-yyyy") String date) {
        return employeeService.findEligibleEmployeesForBonus(date);
    }

}
