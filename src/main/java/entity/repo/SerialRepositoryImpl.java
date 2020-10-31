package entity.repo;

import core.hibernate.HibernateEntityManagerFactory;
import entity.dto.Season;
import entity.dto.Serial;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Objects;


public class SerialRepositoryImpl implements SerialRepository {

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
        List<Serial> serials = em.createQuery("SELECT s FROM Serial s WHERE s.name = :name", Serial.class)
                .setParameter("name", name)
                .getResultList();

        if (serials.isEmpty()) {
            return null;
        } else {
            return serials.get(0);
        }
    }

    @Override
    public Serial saveSerial(Serial serial) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Serial serialByName = getSerialByName(serial.getName());
        if (Objects.isNull(serialByName)) {
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

    @Override
    public List<Serial> getAll() {
        return em.createQuery("FROM Serial", Serial.class)
                .getResultList();
    }

    @Override
    public Season getSeasonBySerialIdAndSeasonNumber(Long serialId, Integer seasonNumber) {
        List<Season> seasonList = em.createQuery("FROM Season WHERE serial.id = :id AND number = :number", Season.class)
                .setParameter("id", serialId)
                .setParameter("number", seasonNumber)
                .getResultList();

        if (seasonList.isEmpty()) {
            return null;
        } else {
            return seasonList.get(0);
        }
    }

    @Override
    public Season getSeasonBySerialNameAndSeasonNumber(String name, Integer seasonNumber) {
        List<Season> seasonList = em.createQuery("FROM Season WHERE serial.name = :name AND number = :number", Season.class)
                .setParameter("name", name)
                .setParameter("number", seasonNumber)
                .getResultList();

        if (seasonList.isEmpty()) {
            return null;
        } else {
            return seasonList.get(0);
        }
    }
}
