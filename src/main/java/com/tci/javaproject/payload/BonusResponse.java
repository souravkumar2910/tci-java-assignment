package com.tci.javaproject.payload;

import java.util.List;

public class BonusResponse {
    private String errorMessage;
    private List<CurrencyData> data;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<CurrencyData> getData() {
        return data;
    }

    public void setData(List<CurrencyData> data) {
        this.data = data;
    }
}
