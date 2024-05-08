package com.tci.javaproject.service;

import com.tci.javaproject.entity.Employee;
import com.tci.javaproject.payload.BonusResponse;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {

    List<Employee> saveEmployees(List<Employee> employeeList);

    BonusResponse findEligibleEmployeesForBonus(String dateString);
}
