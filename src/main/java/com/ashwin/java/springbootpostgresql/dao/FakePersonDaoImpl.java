package com.ashwin.java.springbootpostgresql.dao;

import com.ashwin.java.springbootpostgresql.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Qualifier("fake-person-dao")
public class FakePersonDaoImpl implements PersonDao {
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        if (DB.add(new Person(id, person.getName()))) {
            return 1;
        }
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> optPerson = selectPersonById(id);
        if (optPerson.isEmpty()) {
            return 0;
        }
        if (DB.remove(optPerson.get())) {
            return 1;
        }
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonById(id).map(p -> {
            int index = DB.indexOf(p);
            if (index >= 0) {
                DB.set(index, person);
                return 1;
            }
            return 0;
        }).orElse(
                0
        );
    }
}

