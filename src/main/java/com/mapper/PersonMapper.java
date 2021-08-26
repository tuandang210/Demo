package com.mapper;

import com.model.Person;

import java.util.List;

public interface PersonMapper {
    List<Person> selectAllPerson();
    Person selectPersonById(Long personId);
    Person insertPerson(Person person);
}
