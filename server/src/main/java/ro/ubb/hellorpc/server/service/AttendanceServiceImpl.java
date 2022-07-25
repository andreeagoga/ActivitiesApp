package ro.ubb.hellorpc.server.service;

import ro.ubb.hellorpc.common.Domain.Attendance;
import ro.ubb.hellorpc.common.Domain.Location;
import ro.ubb.hellorpc.common.IAttendanceService;
import ro.ubb.hellorpc.server.repository.IRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class AttendanceServiceImpl implements IAttendanceService {

    private IRepository<Integer, Attendance> attendanceRepository;

    public AttendanceServiceImpl(IRepository<Integer, Attendance> attendanceRepository) {

        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public Set<Attendance> findAll() {
        Iterable<Attendance> subscriptions = attendanceRepository.findAll();
        Set<Attendance> collect = StreamSupport.stream(subscriptions.spliterator(), false).collect(Collectors.toSet());
        return collect;
    }

    @Override
    public Integer add(Attendance entity) {

        return attendanceRepository.save(entity).isPresent() ? 1 : 0;
    }

    @Override
    public Optional<Attendance> delete(Integer id) {
        return this.attendanceRepository.delete(id);
    }


    @Override
    public Integer update(Attendance entity) {
        return attendanceRepository.update(entity).isPresent() ? 1 : 0;
    }
}
