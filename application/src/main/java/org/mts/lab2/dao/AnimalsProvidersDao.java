package org.mts.lab2.dao;

import org.mts.dao.AbstractHibernateDao;
import org.mts.lab2.entity.AnimalsHabitats;
import org.mts.lab2.entity.AnimalsProviders;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalsProvidersDao extends AbstractHibernateDao<AnimalsHabitats> {
    public AnimalsProvidersDao() {
        setClazz(AnimalsHabitats.class);
    }

    public List<AnimalsProviders> getAnimalsProviders(Connection connection) throws SQLException {
        PreparedStatement stmt6 = connection.prepareStatement("SELECT * FROM animals.animals_providers");
        List<AnimalsProviders> animalsProvidersList = new ArrayList<>();
        ResultSet resultSet6 = stmt6.executeQuery();
        while (resultSet6.next()) {
            animalsProvidersList.add(new AnimalsProviders(
                    resultSet6.getLong("id_animal_type"),
                    resultSet6.getLong("id_provider")
            ));
        }
        return animalsProvidersList;
    }
}
