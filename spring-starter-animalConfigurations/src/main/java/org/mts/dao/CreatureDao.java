package org.mts.dao;

import org.hibernate.Session;
import org.mts.entity.Creature;
import org.springframework.stereotype.Repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

@Repository
public class CreatureDao extends AbstractHibernateDao<Creature>{

    public CreatureDao() {
        setClazz(Creature.class);
    }

    public List<Creature> getCreatures(Connection connection) throws SQLException {
        PreparedStatement stmt3 = connection.prepareStatement("SELECT * FROM animals.creature");
        List<Creature> creatureList = new ArrayList<>();
        ResultSet resultSet3 = stmt3.executeQuery();
        while (resultSet3.next()) {
            creatureList.add(new Creature(
                    resultSet3.getLong("id"),
                    resultSet3.getString("name"),
                    resultSet3.getInt("type_id"),
                    resultSet3.getShort("age"),
                    resultSet3.getString("secret_info")
            ));
        }
        return creatureList;
    }

}
