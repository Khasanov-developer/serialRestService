package presentation.rest;

import entity.dto.Season;
import entity.dto.Serial;
import entity.repo.SerialRepository;

import java.util.Objects;
import java.util.Set;

import static spark.Spark.get;

public class SerialRestController {

    private SerialRepository repository;
    private static String path = "/serial";
    private static final String MESSAGE_404 = "Not found!";
    private static final int CODE_404 = 404;

    public SerialRestController(SerialRepository repository) {
        this.repository = repository;

        get(path + "/all", (req, res) -> {
            res.type("application/json");
            return repository.getAll();
        }, JsonUtil.json());


        get(path + "/name/:name", (req, res) -> {
            res.type("application/json");
            Serial serialByName = repository.getSerialByName(req.params(":name").replace("_", " "));

            if (Objects.nonNull(serialByName)) return serialByName;
            return new Message(MESSAGE_404, CODE_404);
        }, JsonUtil.json());


        get(path + "/id/:id", (req, res) -> {
            res.type("application/json");
            Serial serialById = repository.getSerialById(Long.parseLong(req.params(":id")));

            if (Objects.nonNull(serialById)) return serialById;
            return new Message(MESSAGE_404, CODE_404);
        }, JsonUtil.json());


        get(path + "/id/:id/season/all", (req, res) -> {
            res.type("application/json");
            Set<Season> seasonSet = repository.getSerialById(Long.parseLong(req.params(":id")))
                    .getSeasonSet();

            if (!seasonSet.isEmpty()) return seasonSet;
            return new Message(MESSAGE_404, CODE_404);
        }, JsonUtil.json());


        get(path + "/name/:name/season/all", (req, res) -> {
            res.type("application/json");
            Set<Season> seasonSet = repository.getSerialByName(req.params(":name").replace("_", " "))
                    .getSeasonSet();

            if (!seasonSet.isEmpty()) return seasonSet;
            return new Message(MESSAGE_404, CODE_404);
        }, JsonUtil.json());


        get(path + "/id/:id/season/number/:number", (req, res) -> {
            res.type("application/json");
            Season seasonBySerialIdAndSeasonNumber = repository.getSeasonBySerialIdAndSeasonNumber(Long.parseLong(req.params(":id")),
                    Integer.parseInt(req.params(":number")));

            if (Objects.nonNull(seasonBySerialIdAndSeasonNumber)) return seasonBySerialIdAndSeasonNumber;
            return new Message(MESSAGE_404, CODE_404);
        }, JsonUtil.json());


        get(path + "/name/:name/season/number/:number", (req, res) -> {
            res.type("application/json");
            Season seasonBySerialNameAndSeasonNumber = repository.getSeasonBySerialNameAndSeasonNumber(req.params(":name").replace("_", " "),
                    Integer.parseInt(req.params(":number")));

            if (Objects.nonNull(seasonBySerialNameAndSeasonNumber)) return seasonBySerialNameAndSeasonNumber;
            return new Message(MESSAGE_404, CODE_404);
        }, JsonUtil.json());
    }
}
