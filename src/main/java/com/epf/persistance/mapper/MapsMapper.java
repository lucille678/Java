package com.epf.persistance.mapper;

import com.epf.persistance.Maps;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapsMapper implements RowMapper<Maps> {
    @Override
    public Maps mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Maps(
                rs.getLong("id_map"), // Correction : Utilisation de getLong
                rs.getInt("ligne"),
                rs.getInt("colonne"),
                rs.getString("chemin_image")
        );
    }
}
