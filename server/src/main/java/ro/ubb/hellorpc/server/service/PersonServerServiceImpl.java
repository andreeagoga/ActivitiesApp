package ro.ubb.hellorpc.server.service;

import ro.ubb.hellorpc.common.Domain.Location;
import ro.ubb.hellorpc.common.Domain.Person;
import ro.ubb.hellorpc.common.LocationService;
import ro.ubb.hellorpc.common.PersonService;
import ro.ubb.hellorpc.server.repository.IRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;



public class PersonServerServiceImpl implements PersonService {
    private IRepository<Integer, Person> personIRepository;


    public PersonServerServiceImpl(IRepository<Integer, Person> personIRepository) {
        this.personIRepository = personIRepository;
    }


    @Override
    public Set<Person> findAll() {
        Iterable<Person> subscriptions = personIRepository.findAll();
        Set<Person> collect = StreamSupport.stream(subscriptions.spliterator(), false).collect(Collectors.toSet());
        return collect;
    }

    @Override
    public Integer add(Person entity) {
        return personIRepository.save(entity).isPresent() ? 1 : 0;
    }

    @Override
    public Optional<Person> delete(Integer id) {
        return this.personIRepository.delete(id);
    }

    @Override
    public Integer update(Person entity) {
        return personIRepository.update(entity).isPresent() ? 1 : 0;
    }
}
//public class PersonServerServiceImpl implements PersonService {
//    private ExecutorService executorService;
//    private IRepository<Integer, Person> personRepository;
//
//    public PersonServerServiceImpl(ExecutorService executorService, IRepository<Integer, Person> personRepository) {
//        this.executorService = executorService;
//        this.personRepository = personRepository;
//    }
//
//    @Override
//    public Future<List> findAll() {
//        Iterable<Person> subscriptions = personRepository.findAll();
//        Set<Person> collect = StreamSupport.stream(subscriptions.spliterator(), false).collect(Collectors.toSet());
//        return executorService.submit(() -> Arrays.asList(collect.toArray()));
//    }
//
//    @Override
//    public Future<Integer> add(Person person) {
//        return executorService.submit(() -> {
//            return personRepository.save(person).isPresent() ? 1 : 0;
//        });
//    }
//
//    @Override
//    public Future<Optional<Person>> delete(Integer id) {
//        return executorService.submit(() -> {
//            return personRepository.delete(id);
//        });
//    }
//
//    @Override
//    public Future<Integer> update(Person person) {
//        return executorService.submit(() -> {
//            return personRepository.update(person).isPresent() ? 1 : 0;
//        });
//    }
//}
