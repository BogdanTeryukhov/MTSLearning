package org.mts.dao;

import org.hibernate.Session;
import org.mts.entity.AnimalType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnimalTypeDao extends AbstractHibernateDao<AnimalType> {
    public AnimalTypeDao() {
        setClazz(AnimalType.class);
    }

    @Override
    public List<AnimalType> findAll() {
        Session session = getCurrentSession();
        session.beginTransaction();
        List<AnimalType> list = session.createQuery("from AnimalType", AnimalType.class).list();
        session.close();
        return list;
    }
}
