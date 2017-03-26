package ntou.soselab.movie;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;


public interface TheaterClient {
    @GET("/theater/timetable")
    Call<List<ShowDTO>> getTimetable(@Query("q") String name);

    @GET("/theater/show/{showId}")
    Call<ShowDTO> getShowDetail(@Path("showId") String showId);

    @POST("/theater/show")
    Call<ShowDTO> addShow(@Body ShowDTO showDTO);

    @POST("/theater/")
    Call<String> addTheater(@Body TheaterDTO theaterDTO);

    @DELETE("/theater/reset")
    Call<Void> reset();
}
