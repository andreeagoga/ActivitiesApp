package ro.ubb.hellorpc.server.service;

import ro.ubb.hellorpc.common.ActivityService;
import ro.ubb.hellorpc.common.Domain.Activity;
import ro.ubb.hellorpc.common.Domain.Location;
import ro.ubb.hellorpc.server.repository.IRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class ActivityServerServiceImpl implements ActivityService {
    private IRepository<Integer, Activity> activityRepository;

    public ActivityServerServiceImpl(IRepository<Integer, Activity> activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public Integer add(Activity entity) {
        return activityRepository.save(entity).isPresent() ? 1 : 0;
    }
    @Override
    public Integer update(Activity entity) {
        return activityRepository.update(entity).isPresent() ? 1 : 0;
    }

    @Override
    public Optional<Activity> delete(Integer id) {
        return this.activityRepository.delete(id);
    }

    @Override
    public Set<Activity> findAll() {
        Iterable<Activity> activities = activityRepository.findAll();
        Set<Activity> collect = StreamSupport.stream(activities.spliterator(), false).collect(Collectors.toSet());
        return collect;
    }

}
