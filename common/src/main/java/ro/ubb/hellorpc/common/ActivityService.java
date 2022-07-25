package ro.ubb.hellorpc.common;

import ro.ubb.hellorpc.common.Domain.Activity;
import ro.ubb.hellorpc.common.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Future;

public interface ActivityService extends Service<Activity> {

    @Override
    Set<Activity> findAll();

    @Override
    Integer add(Activity entity);

    @Override
    Integer update(Activity entity);

    @Override
    Optional<Activity> delete(Integer id);

}
