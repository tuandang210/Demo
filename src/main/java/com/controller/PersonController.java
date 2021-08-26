package com.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Person;
import com.model.PersonDto;
import com.service.IPersonService;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@CrossOrigin
public class PersonController {
    @Autowired
    private IPersonService personService;

    @GetMapping("/people")
    public ModelAndView showList() {
        Iterable<Person> people = personService.selectAllPerson();
        return new ModelAndView("/index", "people", people);
    }

    @GetMapping("/people/{id}")
    public ModelAndView showDetailPerson (@PathVariable Long id){
        Person person = personService.selectPersonById(id);
        if (person == null) {
            return new ModelAndView("/error");
        }
        return new ModelAndView("/detail", "person", person);
    }
}
