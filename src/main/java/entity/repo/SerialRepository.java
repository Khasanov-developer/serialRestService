package entity.repo;

import entity.dto.Serial;

public interface SerialRepository {

    Serial getSerialById(Long id);

    Serial getSerialByName(String name);

    Serial saveSerial(Serial serial);

    void deleteSerial(Serial serial);

}
