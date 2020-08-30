package com.ashwin.java.springbootpostgresql.service;

import com.ashwin.java.springbootpostgresql.dao.PersonDao;
import com.ashwin.java.springbootpostgresql.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgres-person-dao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return this.personDao.insertPerson(person);
    }

    public int addPeople(List<Person> people) {
        return this.personDao.insertPeople(people);
    }

    public List<Person> getAllPeople() {
        return this.personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id) {
        return this.personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id) {
        return this.personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person person) {
        return this.personDao.updatePersonById(id, person);
    }
}
