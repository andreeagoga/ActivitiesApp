package ro.ubb.hellorpc.server.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import ro.ubb.hellorpc.common.Domain.Activity;
import ro.ubb.hellorpc.common.Domain.Attendance;
import ro.ubb.hellorpc.common.Domain.Attendance;
import ro.ubb.hellorpc.common.Domain.Location;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class DBRepositoryAttendance  implements IRepository<Integer, Attendance>{
    @Autowired
    private JdbcOperations jdbcOperations;


    /*@Override
    public Optional<Attendance> findOne(Integer id) {

        if (id == null) {
            throw new IllegalArgumentException("Id can't be null");
        }
        Optional<Attendance> result = Optional.empty();

        var sql = "select * from attendance where id = ?";
        try (var connection = DriverManager.getConnection(url, user, password);
             var preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, id);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                var personId = resultSet.getInt("personId");
                var activityId = resultSet.getInt("activityId");

                Attendance attendance = new Attendance(id, personId, activityId);
                result = Optional.ofNullable(attendance);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return Optional.empty();
        }

        return result;
    }

    @Override
    public Iterable<Attendance> findAll() {
        Set<Attendance> attendances = new HashSet<>();
        var sql = "select * from attendance";

        // id, personId, activityId;
        try (var connection = DriverManager.getConnection(url, user, password);
             var preparedStatement = connection.prepareStatement(sql);
             var resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                var id = resultSet.getInt("id");
                var personId = resultSet.getInt("personId");
                var activityId = resultSet.getInt("activityId");
                Attendance attendance = new Attendance(id, personId, activityId);

                attendances.add(attendance);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return attendances;
    }

    @Override
    public Optional<Attendance> save(Attendance entity)  {
        if (entity == null) {
            throw new IllegalArgumentException("Entity can't be null");
        }
        Optional<Attendance> existingAttendance = findOne(entity.getId());
        if(existingAttendance.isPresent()){
            return existingAttendance;
        }
        var sql = "insert into attendance(personId, activityId) values (?, ?)";
        try (var connection = DriverManager.getConnection(url, user, password);
             var preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, entity.getPersonID());
            preparedStatement.setInt(2,  entity.getActivityID());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return Optional.of(entity);
        }
        return existingAttendance;
    }

    @Override
    public Optional<Attendance> delete(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Id can't be null");
        }
        Optional<Attendance> attendanceToDelete = findOne(id);

        if(!attendanceToDelete.isPresent()){
            return Optional.empty();
        }
        var sql = "delete from Attendance where id = ?";
        try (var connection = DriverManager.getConnection(url, user, password);
             var preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1,  id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Attendance> update(Attendance entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity can't be null");
        }

        Optional<Attendance> attendanceToUpdate = findOne(entity.getId());

        if(!attendanceToUpdate.isPresent()){
            return attendanceToUpdate;
        }

        var sql = "update Attendance set personId = ?, activityId = ? where id = ?";
        try (var connection = DriverManager.getConnection(url, user, password);
             var preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, ((Attendance)entity).getPersonID());
            preparedStatement.setInt(2, ((Attendance)entity).getActivityID());
            preparedStatement.setInt(3, ((Attendance)entity).getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }
    */

    @Override
    public Optional<Attendance> findOne(Integer id) {
        Attendance attendance = null;
        String sql = "select * from attendance where id = ?";

        List<Attendance> attendances =jdbcOperations.query(sql, new Object[]{id}, (resultSet, i) ->{

            var personId = resultSet.getInt("personId");
            var activityId = resultSet.getInt("activityId");

            return new Attendance(id, personId, activityId);
        });
        if (!attendances.isEmpty())
            attendance=attendances.get(0);
        return Optional.ofNullable(attendance);
    }

/*    @Override
    public Iterable<Attendance> findAll() {
        var sql = "select * from attendance";

        return jdbcOperations.query(sql, (resultSet,i) ->{
            var id = resultSet.getInt("id");
            var personId = resultSet.getInt("personId");
            var activityId = resultSet.getInt("activityId");
            return new Attendance(id, personId, activityId);
        });
    }*/

    @Override
    public Iterable<Attendance> findAll() {
        String sql = "select * from attendance";
        return jdbcOperations.query(sql, (rs, i) -> {
            var id = rs.getInt("id");
            var personId = rs.getInt("personId");
            var activityId = rs.getInt("activityId");
            return new Attendance(id, personId, activityId);
        });
    }


    @Override
    public Optional<Attendance> save(Attendance entity) {

        var sql = "insert into attendance(personId, activityId) values (?, ?)";
        jdbcOperations.update(sql, entity.getPersonID(), entity.getActivityID());
        return Optional.of(entity);
    }


    @Override
    public Optional<Attendance> delete(Integer id) {
        Optional<Attendance> attendance = findOne(id);
        String sql = "delete from Attendance where id = ?";
        jdbcOperations.update(sql, id);
        return Optional.ofNullable(attendance.get());
    }



    @Override
    public Optional<Attendance> update(Attendance entity) {
        var sql = "update Attendance set personId = ?, activityId = ? where id = ?";
        jdbcOperations.update(sql, entity.getPersonID(), entity.getActivityID(), entity.getId());
        return Optional.ofNullable(entity);

    }

}
