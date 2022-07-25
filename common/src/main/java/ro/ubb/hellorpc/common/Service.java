package ro.ubb.hellorpc.common;

import ro.ubb.hellorpc.common.Domain.Entity;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Future;

public interface Service <T extends Entity> {
    Set<T> findAll();
    Integer add(T entity);
    Optional<T> delete(Integer id);
    Integer update(T entity);
}
