package ro.ubb.hellorpc.server.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import ro.ubb.hellorpc.common.Domain.Location;
import ro.ubb.hellorpc.common.Domain.Person;
import ro.ubb.hellorpc.common.PersonService;
import ro.ubb.hellorpc.server.validators.ValidatorException;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class DBRepositoryPerson implements IRepository<Integer, Person>{


    @Autowired
    private JdbcOperations jdbcOperations;


    @Override
    public Optional<Person> findOne(Integer id) {
        Person person = null;
        String sql = "select * from person where id = ?";

        List<Person> persons =jdbcOperations.query(sql, new Object[]{id}, (resultSet, i) ->{

            var firstName = resultSet.getString("firstName");
            var lastName = resultSet.getString("lastName");
            var age = resultSet.getInt("age");
            var technicalLevel = resultSet.getInt("technicalLevel");
            var weight = resultSet.getInt("weight");
            var email = resultSet.getString("email");
            var phoneNumber = resultSet.getString("phoneNumber");
            return new Person(id, firstName, lastName, age, technicalLevel, weight,email, phoneNumber);
        });
        if (!persons.isEmpty())
            person=persons.get(0);
        return Optional.ofNullable(person);
    }

    @Override
    public Iterable<Person> findAll() {
        var sql = "select * from person";

        return jdbcOperations.query(sql, (resultSet,i) ->{
            var id = resultSet.getInt("id");
            var firstName = resultSet.getString("firstName");
            var lastName = resultSet.getString("lastName");
            var age = resultSet.getInt("age");
            var technicalLevel = resultSet.getInt("technicalLevel");
            var weight = resultSet.getInt("weight");
            var email = resultSet.getString("email");
            var phoneNumber = resultSet.getString("phoneNumber");
            return new Person(id, firstName, lastName, age, technicalLevel, weight,email, phoneNumber);
        });
    }


    @Override
    public Optional<Person> save(Person entity) {

        String sql = "insert into person(firstName, lastName, age, technicalLevel, weight,email, phoneNumber ) values (?, ?, ?, ?, ?, ?, ?)";
        jdbcOperations.update(sql, entity.getFirstName(), entity.getLastName(), entity.getAge(), entity.getTechnicalLevel(), entity.getWeight(), entity.getEmail(), entity.getPhoneNumber());
        return Optional.of(entity);
    }


    @Override
    public Optional<Person> delete(Integer id) {
        Optional<Person> person = findOne(id);
        String sql = "delete from Person where id = ?";
        jdbcOperations.update(sql, id);
        return Optional.ofNullable(person.get());
    }



    @Override
    public Optional<Person> update(Person entity) {
        String sql = "insert into person(firstName, lastName, age, technicalLevel, weight,email, phoneNumber) values (?, ?, ?, ?, ?, ?, ?)";
        jdbcOperations.update(sql, entity.getFirstName(), entity.getLastName(), entity.getAge(), entity.getTechnicalLevel(), entity.getWeight(), entity.getEmail(), entity.getPhoneNumber());
        return Optional.ofNullable(entity);

    }

}



