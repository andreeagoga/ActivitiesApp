package ro.ubb.hellorpc.common;

import ro.ubb.hellorpc.common.Domain.Location;
import ro.ubb.hellorpc.common.Domain.Person;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Future;

public interface PersonService extends Service<Person> {


    @Override
    Set<Person> findAll();

    @Override
    Integer add(Person entity);

    @Override
    Optional<Person> delete(Integer id);

    @Override
    Integer update(Person entity);

//    String GET_ALL = "getAllPerson";
//    Future<List> findAll();
//
//    String ADD = "addPerson";
//    Future<Integer> add(Person person);
//
//    String DELETE = "deletePerson";
//    Future<Optional<Person>> delete(Integer id);
//
//
//    String UPDATE = "updatePerson";
//    Future<Integer> update(Person person);
}