package entity.dto;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Table(name = "season")
@Entity
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Integer number;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "finish_date")
    private Date finishDate;

    @Column(name = "series_count")
    private Integer seriesCount;

    @ManyToOne
    @JoinColumn(name = "serial_id")
    private Serial serial;

    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Seria> seriaList;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Integer getSeriesCount() {
        return seriesCount;
    }

    public void setSeriesCount(Integer seriesCount) {
        this.seriesCount = seriesCount;
    }

    public Set<Seria> getSeriaList() {
        return seriaList;
    }

    public void setSeriaList(Set<Seria> seriaList) {
        this.seriaList = seriaList;
    }

    public Season() {
    }

    public Long getId() {
        return id;
    }
}
