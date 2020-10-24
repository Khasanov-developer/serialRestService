package presentation.rest;

import entity.repo.SerialRepository;
import static spark.Spark.*;

public class SerialRestController {

    private SerialRepository repository;
    private static String path = "/serial";

    public SerialRestController(SerialRepository repository) {
        this.repository = repository;
        get(path, (request, response) -> repository.getSerialByName(""), JsonUtil.json());
    }

}
