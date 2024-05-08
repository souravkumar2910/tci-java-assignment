package com.tci.javaproject.service;

import com.tci.javaproject.entity.Employee;
import com.tci.javaproject.exceptions.RecordNotFoundException;
import com.tci.javaproject.payload.BonusResponse;
import com.tci.javaproject.payload.CurrencyData;
import com.tci.javaproject.payload.EmployeeData;
import com.tci.javaproject.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> saveEmployees(List<Employee> employeeList) {
        return employeeRepository.saveAll(employeeList);
    }

    @Override
    public BonusResponse findEligibleEmployeesForBonus(String dateString) {

        List<Employee> allEmployees = employeeRepository.findAll();
        LocalDate parsedDate = parseDateFromString(dateString);

        // Filter eligible employees
        List<Employee> eligibleEmployees = allEmployees.stream()
                .filter(employee -> isActiveOnDate(employee, parsedDate))
                .collect(Collectors.toList());

        if (eligibleEmployees.isEmpty()) {
            throw new RecordNotFoundException("No eligible employees found for the given date: " + dateString);
        }

        // Group eligible employees by currency
        Map<String, List<Employee>> employeesByCurrency = eligibleEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getCurrency));

        // Format response
        BonusResponse response = new BonusResponse();
        response.setErrorMessage("");
        response.setData(employeesByCurrency.entrySet().stream()
                .map(entry -> {
                    CurrencyData currencyData = new CurrencyData();
                    currencyData.setCurrency(entry.getKey());
                    currencyData.setEmployees(entry.getValue().stream()
                            .map(employee -> {
                                EmployeeData employeeData = new EmployeeData();
                                employeeData.setEmpName(employee.getEmpName());
                                employeeData.setAmount(employee.getAmount());
                                return employeeData;
                            })
                            .collect(Collectors.toList()));
                    return currencyData;
                })
                .collect(Collectors.toList()));

        return response;
    }

    private LocalDate parseDateFromString(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy", Locale.ENGLISH);
        return LocalDate.parse(dateString, formatter);
    }

    private boolean isActiveOnDate(Employee employee, LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy", Locale.ENGLISH);

        LocalDate joiningDate = LocalDate.parse(employee.getJoiningDate(), formatter);
        LocalDate exitDate = LocalDate.parse(employee.getExitDate(), formatter);

        return date.isEqual(joiningDate) || (date.isAfter(joiningDate) && date.isBefore(exitDate));
    }


}
