import entity.dto.Season;
import entity.dto.Seria;
import entity.dto.Serial;
import entity.repo.SerialRepository;
import entity.repo.SerialRepositoryImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class TestMain {

    public static void main(String[] args) throws ParseException {

        SerialRepository repository = new SerialRepositoryImpl();
        Serial serial = new Serial();
        serial.setName("Тест");
        repository.saveSerial(serial);

        Serial serialByName = repository.getSerialByName("Тест");
        System.out.println(serialByName.getName());

        repository.deleteSerial(serial);

//        Serial serial = new Serial();
//        serial.setName("Во все тяжкие 2");
//
//        List<Season> seasonList = new ArrayList();
//        Season season = new Season();
//        season.setNumber(1);
//        season.setSeriesCount(2);
//
//        String strDate = "20.01.2008";
//        Date date = new SimpleDateFormat("dd.MM.yyyy").parse(strDate);
//        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//
//        season.setStartDate(sqlDate);
//
//        List<Seria> seriaList = new ArrayList();
//
//        Seria seria = new Seria();
//        seria.setName("первый эпизод 1");
//        seria.setNumber(12);
//        seria.setDate(sqlDate);
//
//        seriaList.add(seria);
//
//        season.setSeriaList(seriaList);
//
//        seasonList.add(season);
//
//        serial.setSeasonList(seasonList);
//
//        repository.saveSerial(serial);
    }
}
