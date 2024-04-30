package org.mts.lab2.dao;

import org.mts.dao.AbstractHibernateDao;
import org.mts.lab2.entity.AnimalsHabitats;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalsHabitatsDao extends AbstractHibernateDao<AnimalsHabitats> {
    public AnimalsHabitatsDao() {
        setClazz(AnimalsHabitats.class);
    }

    public List<AnimalsHabitats> getAnimalsHabitats(Connection connection) throws SQLException {
        //AnimalsHabitats
        PreparedStatement stmt2 = connection.prepareStatement("SELECT * FROM animals.animals_habitats");
        List<AnimalsHabitats> animalsHabitatsList = new ArrayList<>();
        ResultSet resultSet2 = stmt2.executeQuery();
        while (resultSet2.next()) {
            animalsHabitatsList.add(new AnimalsHabitats(
                    resultSet2.getLong("id_animal_type"),
                    resultSet2.getLong("id_area")
            ));
        }
        return animalsHabitatsList;
    }
}
