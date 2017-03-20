package ntou.soselab.movie;


import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface MovieClient {
    @GET("/timetable")
    List<MovieDTO> getTimetable();

    @GET("/")
    List<MovieDTO> groupList(@Query("q") String sort);
}