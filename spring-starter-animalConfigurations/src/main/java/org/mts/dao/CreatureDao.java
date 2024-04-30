package org.mts.dao;

import org.hibernate.Session;
import org.mts.entity.Creature;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CreatureDao extends AbstractHibernateDao<Creature>{

    public CreatureDao() {
        setClazz(Creature.class);
    }
}
