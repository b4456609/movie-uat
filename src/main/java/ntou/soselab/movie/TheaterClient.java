package ntou.soselab.movie;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;


public interface TheaterClient {
    @GET("/theater/timetable")
    Call<List<ShowDTO>> getTimetable();

    @GET("/theater/show/{showId}")
    Call<ShowDTO> getShowDetail(@Path("showId") String showId);

    @POST("/theater/show")
    Call<ShowDTO> addShow(@Body ShowDTO showDTO);

    @POST("/theater/")
    Call<String> addTheater(@Body TheaterDTO theaterDTO);
}
