package ro.ubb.hellorpc.server.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import ro.ubb.hellorpc.common.Domain.Location;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class DBRepositoryLocation implements IRepository<Integer, Location> {


    @Autowired
    private JdbcOperations jdbcOperations;


    @Override
    public Optional<Location> findOne(Integer id) {
        Location location = null;
        String sql = "select * from location where id = ?";

        List<Location> locations =jdbcOperations.query(sql, new Object[]{id}, (resultSet, i) ->{

            var locationName = resultSet.getString("locationname");
            var altitude = resultSet.getInt("altitude");
            var typeOfHike = resultSet.getString("typeofhike");
            var coordinates = resultSet.getString("coordinates");
            var city = resultSet.getString("city");
            return new Location(id, locationName, altitude, typeOfHike, coordinates, city);
        });
        if (!locations.isEmpty())
            location=locations.get(0);
        return Optional.ofNullable(location);
    }

    @Override
    public Iterable<Location> findAll() {
        var sql = "select * from location";

        return jdbcOperations.query(sql, (resultSet,i) ->{
            var id = resultSet.getInt("id");
            var locationName = resultSet.getString("locationname");
            var altitude = resultSet.getInt("altitude");
            var typeOfHike = resultSet.getString("typeofhike");
            var coordinates = resultSet.getString("coordinates");
            var city = resultSet.getString("city");
            return new Location(id, locationName, altitude, typeOfHike, coordinates, city);
        });
    }


    @Override
    public Optional<Location> save(Location entity) {

        String sql = "insert into location(locationName, altitude, typeOfHike, coordinates, city) values (?, ?, ?, ?, ?)";
        jdbcOperations.update(sql, entity.getName(), entity.getAltitude(), entity.getTypeOfHike(), entity.getCoordinates(), entity.getCity());
        return Optional.of(entity);
    }


    @Override
    public Optional<Location> delete(Integer id) {
       Optional<Location> location = findOne(id);
        String sql = "delete from Location where id = ?";
        jdbcOperations.update(sql, id);
        return Optional.ofNullable(location.get());
    }



    @Override
    public Optional<Location> update(Location entity) {

        String sql = "update Location set locationName = ?, altitude = ?, typeOfHike = ?, coordinates = ?, city = ? where id = ?";
        jdbcOperations.update(sql,  entity.getName(), entity.getAltitude(), entity.getTypeOfHike(), entity.getCoordinates(), entity.getCity(), entity.getId());
        return Optional.ofNullable(entity);

    }



}
