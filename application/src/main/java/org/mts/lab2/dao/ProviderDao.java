package org.mts.lab2.dao;

import org.mts.dao.AbstractHibernateDao;
import org.mts.lab2.entity.Provider;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProviderDao extends AbstractHibernateDao<Provider> {
    public ProviderDao() {
        setClazz(Provider.class);
    }

    public List<Provider> getProviders(Connection connection) throws SQLException {
        PreparedStatement stmt5 = connection.prepareStatement("SELECT * FROM animals.provider");
        List<Provider> providerList = new ArrayList<>();
        ResultSet resultSet5 = stmt5.executeQuery();
        while (resultSet5.next()) {
            providerList.add(new Provider(
                    resultSet5.getLong("id"),
                    resultSet5.getString("name"),
                    resultSet5.getString("phone")
            ));
        }
        return providerList;
    }
}
