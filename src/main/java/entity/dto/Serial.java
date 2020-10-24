package entity.dto;

import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name = "serial")
@Entity
@SelectBeforeUpdate
public class Serial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 5000)
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
    private Set<Season> seasonSet = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "creators", joinColumns = @JoinColumn(name = "serial_id"))
    @Column(name = "creator")
    private Set<String> creatorSet;

    @ElementCollection
    @CollectionTable(name = "screenwriters", joinColumns = @JoinColumn(name = "serial_id"))
    @Column(name = "screenwriter")
    private Set<String> screenwriterSet;

    @ElementCollection
    @CollectionTable(name = "composers", joinColumns = @JoinColumn(name = "serial_id"))
    @Column(name = "composer")
    private Set<String> composerSet;

    @ElementCollection
    @CollectionTable(name = "operators", joinColumns = @JoinColumn(name = "serial_id"))
    @Column(name = "operator")
    private Set<String> operatorList;

    @ElementCollection
    @CollectionTable(name = "producers", joinColumns = @JoinColumn(name = "serial_id"))
    @Column(name = "producer")
    private Set<String> producerSet;

    @ElementCollection
    @CollectionTable(name = "actors", joinColumns = @JoinColumn(name = "serial_id"))
    @Column(name = "actor")
    private Set<String> actorSet;

    @ElementCollection
    @CollectionTable(name = "countries", joinColumns = @JoinColumn(name = "serial_id"))
    @Column(name = "country")
    private Set<String> countrySet;

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

    public Set<Season> getSeasonSet() {
        return seasonSet;
    }

    public void setSeasonSet(Set<Season> seasonList) {
        this.seasonSet = seasonList;
    }

    public Set<String> getCreatorSet() {
        return creatorSet;
    }

    public void setCreatorSet(Set<String> creatorList) {
        this.creatorSet = creatorList;
    }

    public Set<String> getScreenwriterSet() {
        return screenwriterSet;
    }

    public void setScreenwriterSet(Set<String> screenwriterList) {
        this.screenwriterSet = screenwriterList;
    }

    public Set<String> getComposerSet() {
        return composerSet;
    }

    public void setComposerSet(Set<String> composerList) {
        this.composerSet = composerList;
    }

    public Set<String> getOperatorList() {
        return operatorList;
    }

    public void setOperatorList(Set<String> operatorList) {
        this.operatorList = operatorList;
    }

    public Set<String> getProducerSet() {
        return producerSet;
    }

    public void setProducerSet(Set<String> producerList) {
        this.producerSet = producerList;
    }

    public Set<String> getActorSet() {
        return actorSet;
    }

    public void setActorSet(Set<String> actorList) {
        this.actorSet = actorList;
    }

    public Set<String> getCountrySet() {
        return countrySet;
    }

    public void setCountrySet(Set<String> countryList) {
        this.countrySet = countryList;
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
