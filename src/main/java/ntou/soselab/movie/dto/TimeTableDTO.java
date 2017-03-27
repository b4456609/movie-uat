package ntou.soselab.movie.dto;

/**
 * Created by bernie on 2017/3/27.
 */
public class TimeTableDTO {
    private String theaterId;
    private String movieName;
    private String runTime;
    private long start;
    private int emptySeat;

    public TimeTableDTO() {
    }

    public int getEmptySeat() {
        return emptySeat;
    }

    public void setEmptySeat(int emptySeat) {
        this.emptySeat = emptySeat;
    }

    public String getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "TimeTableDTO{" +
                "theaterId='" + theaterId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", runTime='" + runTime + '\'' +
                ", start=" + start +
                ", emptySeat=" + emptySeat +
                '}';
    }
}
