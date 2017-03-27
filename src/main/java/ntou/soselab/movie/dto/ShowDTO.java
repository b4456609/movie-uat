package ntou.soselab.movie.dto;


public class ShowDTO {
    private String id;
    private String theaterId;
    private String movieId;
    private long start;
    private long end;
    private int emptySeat;

    public ShowDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public int getEmptySeat() {
        return emptySeat;
    }

    public void setEmptySeat(int emptySeat) {
        this.emptySeat = emptySeat;
    }

    @Override
    public String toString() {
        return "ShowDTO{" +
                "id='" + id + '\'' +
                ", theaterId='" + theaterId + '\'' +
                ", movieId='" + movieId + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", emptySeat=" + emptySeat +
                '}';
    }
}
