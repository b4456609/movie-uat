package ntou.soselab.movie.dto;

public class BookDTO {
    private String id;
    private String showId;
    private int ticket;
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id='" + id + '\'' +
                ", showId='" + showId + '\'' +
                ", ticket=" + ticket +
                ", userId='" + userId + '\'' +
                '}';
    }
}
