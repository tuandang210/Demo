package com.model;

import java.util.List;

public class PersonDto {
    private String Result;
    private List<Person> Records;

    public PersonDto() {
    }

    public PersonDto(String result, List<Person> records) {
        Result = result;
        Records = records;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public List<Person> getRecords() {
        return Records;
    }

    public void setRecords(List<Person> records) {
        Records = records;
    }
}
