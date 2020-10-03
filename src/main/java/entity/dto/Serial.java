package entity.dto;

import java.util.List;

public class Serial {
    private String name;
    private String description;
    private List<String> genreList;
    private String startYear;
    private String finishYear;
    private String seasonsCount;
    private List<Season> seasonList;
    private List<String> creatorList;
    private List<String> screenwriterList;
    private List<String> composerList;
    private List<String> operatorList;
    private List<String> producerList;
    private List<String> actorList;
    private List<String> countryList;
    private String premiereDate;
    private String filmCompany;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<String> genreList) {
        this.genreList = genreList;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getFinishYear() {
        return finishYear;
    }

    public void setFinishYear(String finishYear) {
        this.finishYear = finishYear;
    }

    public String getSeasonsCount() {
        return seasonsCount;
    }

    public void setSeasonsCount(String seasonsCount) {
        this.seasonsCount = seasonsCount;
    }

    public List<Season> getSeasonList() {
        return seasonList;
    }

    public void setSeasonList(List<Season> seasonList) {
        this.seasonList = seasonList;
    }

    public List<String> getCreatorList() {
        return creatorList;
    }

    public void setCreatorList(List<String> creatorList) {
        this.creatorList = creatorList;
    }

    public List<String> getScreenwriterList() {
        return screenwriterList;
    }

    public void setScreenwriterList(List<String> screenwriterList) {
        this.screenwriterList = screenwriterList;
    }

    public List<String> getComposerList() {
        return composerList;
    }

    public void setComposerList(List<String> composerList) {
        this.composerList = composerList;
    }

    public List<String> getOperatorList() {
        return operatorList;
    }

    public void setOperatorList(List<String> operatorList) {
        this.operatorList = operatorList;
    }

    public List<String> getProducerList() {
        return producerList;
    }

    public void setProducerList(List<String> producerList) {
        this.producerList = producerList;
    }

    public List<String> getActorList() {
        return actorList;
    }

    public void setActorList(List<String> actorList) {
        this.actorList = actorList;
    }

    public List<String> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<String> countryList) {
        this.countryList = countryList;
    }

    public String getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(String premiereDate) {
        this.premiereDate = premiereDate;
    }

    public String getFilmCompany() {
        return filmCompany;
    }

    public void setFilmCompany(String filmCompany) {
        this.filmCompany = filmCompany;
    }
}
