package ntou.soselab.movie.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by bernie on 2017/3/25.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderResultDTO {

    private String id;
    private boolean pickUp;
    private String showId;
    private int ticket;
    private int timestamp;
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isPickUp() {
        return pickUp;
    }

    public void setPickUp(boolean pickUp) {
        this.pickUp = pickUp;
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

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
