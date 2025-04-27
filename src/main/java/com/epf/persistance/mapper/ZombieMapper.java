package com.epf.persistance.mapper;

import com.epf.persistance.Zombie;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ZombieMapper implements RowMapper<Zombie> {
    @Override
    public Zombie mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Zombie(
                rs.getLong("id_zombie"),
                rs.getString("nom"),
                rs.getInt("point_de_vie"),
                rs.getBigDecimal("attaque_par_seconde"),
                rs.getInt("degat_attaque"),
                rs.getBigDecimal("vitesse_de_deplacement"),
                rs.getString("chemin_image"),
                rs.getObject("id_map") != null ? rs.getLong("id_map") : null 
        );
    }
}

