package ro.ubb.hellorpc.server.service;

import ro.ubb.hellorpc.common.Domain.*;
import ro.ubb.hellorpc.common.LocationService;
import ro.ubb.hellorpc.common.Message;
import ro.ubb.hellorpc.common.Service;
import ro.ubb.hellorpc.server.repository.IRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class LocationServiceImpl implements LocationService {
    private IRepository<Integer, Location> locationRepository;


    public LocationServiceImpl(IRepository<Integer, Location> locationRepository) {
        this.locationRepository = locationRepository;
    }


    @Override
    public Set<Location> findAll() {
        Iterable<Location> subscriptions = locationRepository.findAll();
        Set<Location> collect = StreamSupport.stream(subscriptions.spliterator(), false).collect(Collectors.toSet());
        return collect;
    }

    @Override
    public Integer add(Location entity) {

        return locationRepository.save(entity).isPresent() ? 1 : 0;
    }

    @Override
    public Optional<Location> delete(Integer id) {
        return this.locationRepository.delete(id);
    }


    @Override
    public Integer update(Location entity) {
        return locationRepository.update(entity).isPresent() ? 1 : 0;
    }
}
