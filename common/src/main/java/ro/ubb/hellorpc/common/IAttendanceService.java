package ro.ubb.hellorpc.common;

import ro.ubb.hellorpc.common.Domain.Attendance;
import ro.ubb.hellorpc.common.Domain.Location;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Future;

public interface IAttendanceService  extends Service<Attendance>{

    @Override
    Set<Attendance> findAll();

    @Override
    Integer add(Attendance entity);

    @Override
    Optional<Attendance> delete(Integer id);

    @Override
    Integer update(Attendance entity);
}
