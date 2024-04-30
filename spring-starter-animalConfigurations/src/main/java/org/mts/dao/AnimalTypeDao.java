package org.mts.dao;

import org.hibernate.Session;
import org.mts.entity.AnimalType;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalTypeDao extends AbstractHibernateDao<AnimalType> {
    public AnimalTypeDao() {
        setClazz(AnimalType.class);
    }


    public List<AnimalType> getAnimalTypes(Connection connection) throws SQLException {
        PreparedStatement stmt1 = connection.prepareStatement("SELECT * FROM animals.animal_type");
        List<AnimalType> animalTypeList = new ArrayList<>();
        ResultSet resultSet1 = stmt1.executeQuery();
        while (resultSet1.next()) {
            animalTypeList.add(new AnimalType(
                    resultSet1.getLong("id"),
                    resultSet1.getBoolean("is_wild"),
                    resultSet1.getString("type")
            ));
        }
        return animalTypeList;
    }
}
