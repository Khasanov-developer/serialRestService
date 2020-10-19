package entity.repo;

import core.hibernate.HibernateEntityManagerFactory;
import entity.dto.Serial;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


public class SerialRepositoryImpl implements SerialRepository{

    private final EntityManager em;

    public SerialRepositoryImpl() {
        em = HibernateEntityManagerFactory.getEntityManager();
    }

    @Override
    public Serial getSerialById(Long id) {
        return em.find(Serial.class, id);
    }

    @Override
    public Serial getSerialByName(String name) {
        TypedQuery<Serial> q = em.createQuery("SELECT s FROM Serial s WHERE s.name = :name", Serial.class);
        q.setParameter("name", name);
        return q.getSingleResult();
    }

    @Override
    public Serial saveSerial(Serial serial) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        if (serial.getId() == null) {
            em.persist(serial);
        } else {
            serial = em.merge(serial);
        }
        transaction.commit();
        return serial;
    }

    @Override
    public void deleteSerial(Serial serial) {
        if (serial != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            if (em.contains(serial)) {
                em.remove(serial);
            } else {
                em.merge(serial);
            }
            transaction.commit();
        }
    }
}
