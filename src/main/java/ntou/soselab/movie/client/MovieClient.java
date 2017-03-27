package ntou.soselab.movie.client;


import ntou.soselab.movie.dto.MovieDTO;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface MovieClient {
    @GET("/movie/find")
    Call<List<MovieDTO>> getMovieDetail(@Query("q") String name);

    @POST("/movie/")
    Call<MovieDTO> addMovie(@Body MovieDTO movieDTO);

    @DELETE("/movie/reset")
    Call<Void> reset();
}