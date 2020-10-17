package entity.dto;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "seria")
@Entity
public class Seria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Integer number;

    @Column
    private String name;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Seria() {
    }
}
