package org.mts.lab2.dao;

import org.mts.dao.AbstractHibernateDao;
import org.mts.lab2.entity.Habitat;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HabitatDao extends AbstractHibernateDao<Habitat>{
    public HabitatDao() {
        setClazz(Habitat.class);
    }

    public List<Habitat> getHabitats(Connection connection) throws SQLException {
        PreparedStatement stmt4 = connection.prepareStatement("SELECT * FROM animals.habitat");
        List<Habitat> habitatList = new ArrayList<>();
        ResultSet resultSet4 = stmt4.executeQuery();
        while (resultSet4.next()) {
            habitatList.add(new Habitat(
                    resultSet4.getLong("id"),
                    resultSet4.getString("area")
            ));
        }
        return habitatList;
    }
}
