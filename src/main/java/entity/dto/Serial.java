package entity.dto;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Table(name = "serial")
@Entity
public class Serial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 2000)
    private String description;

    @ElementCollection
    @CollectionTable(name = "genres", joinColumns = @JoinColumn(name = "serial_id"))
    @Column(name = "genre")
    private Set<String> genreList;

    @Column(name = "start_year")
    private String startYear;

    @Column(name = "finish_year")
    private String finishYear;

    @Column(name = "seasons_count")
    private Integer seasonsCount;

    @OneToMany(mappedBy = "serial", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Season> seasonList;

    @ElementCollection
    @CollectionTable(name = "creators", joinColumns = @JoinColumn(name = "serial_id"))
    @Column(name = "creator")
    private Set<String> creatorList;

    @ElementCollection
    @CollectionTable(name = "screenwriters", joinColumns = @JoinColumn(name = "serial_id"))
    @Column(name = "screenwriter")
    private Set<String> screenwriterList;

    @ElementCollection
    @CollectionTable(name = "composers", joinColumns = @JoinColumn(name = "serial_id"))
    @Column(name = "composer")
    private Set<String> composerList;

    @ElementCollection
    @CollectionTable(name = "operators", joinColumns = @JoinColumn(name = "serial_id"))
    @Column(name = "operator")
    private Set<String> operatorList;

    @ElementCollection
    @CollectionTable(name = "producers", joinColumns = @JoinColumn(name = "serial_id"))
    @Column(name = "producer")
    private Set<String> producerList;

    @ElementCollection
    @CollectionTable(name = "actors", joinColumns = @JoinColumn(name = "serial_id"))
    @Column(name = "actor")
    private Set<String> actorList;

    @ElementCollection
    @CollectionTable(name = "countries", joinColumns = @JoinColumn(name = "serial_id"))
    @Column(name = "country")
    private Set<String> countryList;

    @Column(name = "premiere_date")
    private Date premiereDate;

    @Column(name = "film_company")
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

    public Set<String> getGenreList() {
        return genreList;
    }

    public void setGenreList(Set<String> genreList) {
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

    public Set<Season> getSeasonList() {
        return seasonList;
    }

    public void setSeasonList(Set<Season> seasonList) {
        this.seasonList = seasonList;
    }

    public Set<String> getCreatorList() {
        return creatorList;
    }

    public void setCreatorList(Set<String> creatorList) {
        this.creatorList = creatorList;
    }

    public Set<String> getScreenwriterList() {
        return screenwriterList;
    }

    public void setScreenwriterList(Set<String> screenwriterList) {
        this.screenwriterList = screenwriterList;
    }

    public Set<String> getComposerList() {
        return composerList;
    }

    public void setComposerList(Set<String> composerList) {
        this.composerList = composerList;
    }

    public Set<String> getOperatorList() {
        return operatorList;
    }

    public void setOperatorList(Set<String> operatorList) {
        this.operatorList = operatorList;
    }

    public Set<String> getProducerList() {
        return producerList;
    }

    public void setProducerList(Set<String> producerList) {
        this.producerList = producerList;
    }

    public Set<String> getActorList() {
        return actorList;
    }

    public void setActorList(Set<String> actorList) {
        this.actorList = actorList;
    }

    public Set<String> getCountryList() {
        return countryList;
    }

    public void setCountryList(Set<String> countryList) {
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
