import entity.dto.Season;
import entity.dto.Seria;
import entity.dto.Serial;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestMain {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the ServiceRegistry from hibernate.cfg.xml
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();

            // Create a metadata sources using the specified service registry.
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

    public static void main(String[] args) throws ParseException {
        SessionFactory factory = getSessionFactory();

        Session session = factory.getCurrentSession();



        Serial serial = new Serial();
        serial.setName("Во все тяжкие");

        List<Season> seasonList = new ArrayList();
        Season season = new Season();
        season.setNumber(1);
        season.setSeriesCount(2);

        String strDate = "20.01.2008";
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse(strDate);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        season.setStartDate(sqlDate);

        List<Seria> seriaList = new ArrayList();

        Seria seria = new Seria();
        seria.setName("первый эпизод");
        seria.setNumber(1);
        seria.setDate(sqlDate);

        seriaList.add(seria);

        season.setSeriaList(seriaList);

        seasonList.add(season);

        serial.setSeasonList(seasonList);

        Transaction transaction = session.beginTransaction();

        session.save(serial);

        transaction.commit();

        session.close();
    }
}
