package com.ashwin.java.springbootpostgresql.dao;

import com.ashwin.java.springbootpostgresql.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Qualifier("postgres-person-dao")
public class PostgresPersonDaoImpl implements PersonDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostgresPersonDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        final String sql = "INSERT INTO person (id, name) VALUES (?, ?);";
        return jdbcTemplate.update(sql, id, person.getName());
    }

    @Override
    public List<Person> selectAllPeople() {
        final String sql = "SELECT id, name FROM person;";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Person(id, name);
        });
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        final String sql = "SELECT id, name FROM person WHERE id = '" + id + "' LIMIT 1;";
        Person person = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            UUID uuid = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Person(uuid, name);
        });
        return Optional.ofNullable(person);
    }

    @Override
    public int deletePersonById(UUID id) {
        final String sql = "DELETE FROM person WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        final String sql = "UPDATE person SET id = ?, name = ? WHERE id = ?";
        final Object[] params = {person.getId(), person.getName(), id};
        return jdbcTemplate.update(sql, params);
    }
}
