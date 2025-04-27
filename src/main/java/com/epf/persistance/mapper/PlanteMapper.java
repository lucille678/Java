package com.epf.persistance.mapper;

import com.epf.persistance.Plante;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanteMapper implements RowMapper<Plante> {
    @Override
    public Plante mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Plante(
                rs.getLong("id_plante"),
                rs.getString("nom"),
                rs.getInt("point_de_vie"),
                rs.getBigDecimal("attaque_par_seconde"), 
                rs.getInt("degat_attaque"),
                rs.getInt("cout"),
                rs.getBigDecimal("soleil_par_seconde"), 
                rs.getString("effet"),
                rs.getString("chemin_image")
        );
    }
}


