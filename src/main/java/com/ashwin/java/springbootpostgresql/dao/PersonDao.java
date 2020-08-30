package com.ashwin.java.springbootpostgresql.dao;

import com.ashwin.java.springbootpostgresql.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    default int insertPeople(List<Person> people) {
        for (Person person : people) {
            insertPerson(person);
        }
        return 1;
    }

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);
}
