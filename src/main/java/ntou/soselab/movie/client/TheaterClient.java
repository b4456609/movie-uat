package ntou.soselab.movie.client;

import ntou.soselab.movie.dto.ShowDTO;
import ntou.soselab.movie.dto.TheaterDTO;
import ntou.soselab.movie.dto.TimeTableDTO;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;


public interface TheaterClient {
    @GET("/theater/timetable")
    Call<List<TimeTableDTO>> getTimetable(@Query("q") String name);

    @GET("/theater/show/{showId}")
    Call<ShowDTO> getShowDetail(@Path("showId") String showId);

    @POST("/theater/show")
    Call<ShowDTO> addShow(@Body ShowDTO showDTO);

    @POST("/theater/")
    Call<TheaterDTO> addTheater(@Body TheaterDTO theaterDTO);

    @DELETE("/theater/reset")
    Call<Void> reset();
}
