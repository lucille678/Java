package com.epf.persistance.mapper;

import com.epf.core.model.Zombie;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ZombieMapper implements RowMapper<Zombie> {
    @Override
    public Zombie mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Zombie(
                rs.getLong("id"),
                rs.getString("nom"),
                rs.getInt("pv"),
                rs.getInt("attaque"),
                rs.getInt("vitesse")
        );
    }
}

