package ro.ubb.hellorpc.common;

import ro.ubb.hellorpc.common.Domain.Location;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Future;

public interface LocationService extends Service<Location> {

    @Override
    Set<Location> findAll();

    @Override
    Integer add(Location entity);

    @Override
    Optional<Location> delete(Integer id);

    @Override
    Integer update(Location entity);
}
