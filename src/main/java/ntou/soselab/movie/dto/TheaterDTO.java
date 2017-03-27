package ntou.soselab.movie.dto;


public class TheaterDTO {
    private String id;
    private int capacity;

    public TheaterDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "TheaterDTO{" +
                "id='" + id + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
