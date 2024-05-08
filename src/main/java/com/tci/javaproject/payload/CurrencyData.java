package com.tci.javaproject.payload;

import java.util.List;

public class CurrencyData {
    private String currency;
    private List<EmployeeData> employees;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<EmployeeData> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeData> employees) {
        this.employees = employees;
    }
}
