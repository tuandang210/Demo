package com.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.Person;
import com.model.PersonDto;
import com.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class Test {
    @Autowired
    private IPersonService personService;

    @PostMapping(value = "/people2")
    public ResponseEntity<String> showListAll() {
        List<Person> people = personService.selectAllPerson();
//        PersonDto personDto = new PersonDto("OK", people);
        Gson gson = new GsonBuilder().create();
//        Person person = gson.fromJson(String.valueOf(people), Person.class);

        String listPerson = gson.toJson(people);
        listPerson = "{\"Result\":\"OK\",\"Records\":"+listPerson+"}";
        return new ResponseEntity<>(listPerson, HttpStatus.OK);
    }
}
