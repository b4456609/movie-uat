package ntou.soselab.movie.model;

/**
 * Created by bernie on 2017/3/22.
 */
public class Timetable {
    private int startTimeMinute;
    private int startTimeHour;
    private String theater;
    private String emptySeat;
    private String movie;

    public Timetable() {
    }

    public int getStartTimeMinute() {
        return startTimeMinute;
    }

    public void setStartTimeMinute(int startTimeMinute) {
        this.startTimeMinute = startTimeMinute;
    }

    public int getStartTimeHour() {
        return startTimeHour;
    }

    public void setStartTimeHour(int startTimeHour) {
        this.startTimeHour = startTimeHour;
    }

    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    public String getEmptySeat() {
        return emptySeat;
    }

    public void setEmptySeat(String emptySeat) {
        this.emptySeat = emptySeat;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }
}
