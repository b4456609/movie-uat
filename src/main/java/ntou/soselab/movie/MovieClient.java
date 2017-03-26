package ntou.soselab.movie;


import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface MovieClient {
    @GET("/movie/find")
    Call<List<MovieDTO>> getMovieDetail(@Query("q") String name);

    @POST("/movie/")
    Call<String> addMovie(@Body MovieDTO movieDTO);

    @DELETE("/movie/reset")
    Call<Void> reset();
}