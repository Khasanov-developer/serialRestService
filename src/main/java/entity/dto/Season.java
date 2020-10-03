package entity.dto;

import java.util.List;

public class Season {

    private String number;
    private String startDate;
    private String finishDate;
    private String seriesCount;
    private List<Seria> seriaList;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getSeriesCount() {
        return seriesCount;
    }

    public void setSeriesCount(String seriesCount) {
        this.seriesCount = seriesCount;
    }

    public List<Seria> getSeriaList() {
        return seriaList;
    }

    public void setSeriaList(List<Seria> seriaList) {
        this.seriaList = seriaList;
    }
}
