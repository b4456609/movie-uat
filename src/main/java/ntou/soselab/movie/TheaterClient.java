package ntou.soselab.movie;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface TheaterClient {
    @GET("/theater/show/{showId}")
    Call<ShowDTO> getShowDetail(@Path("showId") String showId);

    @POST("/theater/show")
    Call<Void> addShow(@Body ShowDTO showDTO);
}