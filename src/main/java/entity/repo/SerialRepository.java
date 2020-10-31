package entity.repo;

import entity.dto.Season;
import entity.dto.Serial;

import java.util.List;

public interface SerialRepository {

    Serial getSerialById(Long id);

    Serial getSerialByName(String name);

    Serial saveSerial(Serial serial);

    void deleteSerial(Serial serial);

    List<Serial> getAll();

    Season getSeasonBySerialIdAndSeasonNumber(Long serialId, Integer seasonNumber);

    Season getSeasonBySerialNameAndSeasonNumber(String name, Integer seasonNumber);
}
