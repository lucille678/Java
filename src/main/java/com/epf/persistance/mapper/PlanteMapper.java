package com.epf.persistance.mapper;

import com.epf.core.model.Plante;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanteMapper implements RowMapper<Plante> {
    @Override
    public Plante mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Plante(
                rs.getLong("id"),
                rs.getString("nom"),
                rs.getInt("point_de_vie"),
                rs.getInt("attaque_par_seconde"),
                rs.getInt("degat_attaque"),
                rs.getInt("cout"),
                rs.getInt("soleil_par_seconde"),
                rs.getString("effet"),
                rs.getString("chemin_image")
        );
    }
}


