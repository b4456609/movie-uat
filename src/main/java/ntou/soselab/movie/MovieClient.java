package ntou.soselab.movie;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

public interface MovieClient {
    @GET("/movie/timetable")
    Call<List<MovieDTO>> getTimetable();

    @GET("/movie/")
    Call<List<MovieDTO>> getMovieDetail(@Query("q") String name);

    @POST("/movie/")
    Call<String> addMovie(@Body MovieDTO movieDTO);
}