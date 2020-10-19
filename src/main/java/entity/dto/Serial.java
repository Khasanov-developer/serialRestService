package entity.dto;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Table(name = "serial")
@Entity
public class Serial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column
    private String description;

    @ElementCollection
    @CollectionTable(name = "genres", joinColumns = @JoinColumn(name = "serial_id"))
    @Column(name = "genre")
    private List<String> genreList;

    @Column(name = "start_year")
    private String startYear;

    @Column(name = "finish_year")
    private String finishYear;

    @Column(name ="seasons_count")
    private Integer seasonsCount;

    @OneToMany(mappedBy = "serial", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Season> seasonList;

    @ElementCollection
    @CollectionTable(name = "creators", joinColumns = @JoinColumn(name = "serial_id"))
    @Column(name ="creator")
    private List<String> creatorList;

    @ElementCollection
    @CollectionTable(name = "screenwriters", joinColumns = @JoinColumn(name = "serial_id"))
    @Column(name ="screenwriter")
    private List<String> screenwriterList;

    @ElementCollection
    @CollectionTable(name = "composers", joinColumns = @JoinColumn(name = "serial_id"))
    @Column(name ="composer")
    private List<String> composerList;

    @ElementCollection
    @CollectionTable(name = "operators", joinColumns = @JoinColumn(name = "serial_id"))
    @Column(name ="operator")
    private List<String> operatorList;

    @ElementCollection
    @CollectionTable(name = "producers", joinColumns = @JoinColumn(name = "serial_id"))
    @Column(name ="producer")
    private List<String> producerList;

    @ElementCollection
    @CollectionTable(name = "actors", joinColumns = @JoinColumn(name = "serial_id"))
    @Column(name ="actor")
    private List<String> actorList;

    @ElementCollection
    @CollectionTable(name = "countries", joinColumns = @JoinColumn(name = "serial_id"))
    @Column(name ="country")
    private List<String> countryList;

    @Column(name ="premiere_date")
    private Date premiereDate;

    @Column(name ="film_company")
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

    public Integer getSeasonsCount() {
        return seasonsCount;
    }

    public void setSeasonsCount(Integer seasonsCount) {
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

    public Date getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(Date premiereDate) {
        this.premiereDate = premiereDate;
    }

    public String getFilmCompany() {
        return filmCompany;
    }

    public void setFilmCompany(String filmCompany) {
        this.filmCompany = filmCompany;
    }

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public Serial() {
    }
}
