package ro.ubb.hellorpc.server.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import ro.ubb.hellorpc.common.Domain.Activity;
import ro.ubb.hellorpc.common.Domain.ValidatorException;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class DBRepositoryActivity implements IRepository<Integer, Activity>{

    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public Optional<Activity> findOne(Integer id) {
        Activity activity = null;
        String sql = "SELECT * FROM activity where id = ?";
        List<Activity> activityList = jdbcOperations.query(sql, new Object[]{id}, (rs, i) -> {
            Integer seatsAvailable = rs.getInt("seatsavailable");
            String dateFree = rs.getString("datefree");
            String guideName = rs.getString("guidename");
            Integer locationID = rs.getInt("locationid");
            return new Activity(id, seatsAvailable, dateFree, guideName, locationID);
        });
        if(!activityList.isEmpty())
            activity = activityList.get(0);
        return Optional.ofNullable(activity);
    }

    @Override
    public Iterable<Activity> findAll() {
        String sql = "select * from activity";
        return jdbcOperations.query(sql, (rs, i) -> {
            Integer id = rs.getInt("id");
            Integer seatsAvailable = rs.getInt("seatsavailable");
            String dateFree = rs.getString("datefree");
            String guideName = rs.getString("guidename");
            Integer locationID = rs.getInt("locationid");
            return new Activity(id, seatsAvailable, dateFree, guideName, locationID);
        });
    }

    @Override
    public Optional<Activity> save(Activity entity) throws ValidatorException {
        String sql = "insert into activity(seatsAvailable, dateFree, guideName, locationID) values (?, ?, ?, ?)";
        jdbcOperations.update(sql, entity.getSeatsAvailable(), entity.getDate(), entity.getGuideName(), entity.getLocationID());
        return Optional.of(entity);
    }

    @Override
    public Optional<Activity> delete(Integer id) throws ValidatorException {
        Optional<Activity> activityToDelete = findOne(id);
        String sql = "delete from activity where id = ?";
        jdbcOperations.update(sql, id);
        return Optional.ofNullable(activityToDelete.get());
    }

    @Override
    public Optional<Activity> update(Activity entity) throws ValidatorException {
        String sql = "update activity set seatsAvailable = ?, dateFree = ?, guideName = ?, locationID = ? where id = ?";
        jdbcOperations.update(sql, entity.getSeatsAvailable(), entity.getDate(), entity.getGuideName(), entity.getLocationID());
        return Optional.of(entity);
    }
}

