package ntou.soselab.movie;


import ntou.soselab.movie.client.MovieClient;
import ntou.soselab.movie.client.TheaterClient;
import ntou.soselab.movie.config.GetRetrofit;
import ntou.soselab.movie.dto.MovieDTO;
import ntou.soselab.movie.dto.ShowDTO;
import ntou.soselab.movie.dto.TheaterDTO;
import org.json.JSONObject;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

public class Show {
    private TheaterClient theaterClient;
    private MovieClient movieClient;

    public Show() {
        Retrofit retrofit = GetRetrofit.get();
        theaterClient = retrofit.create(TheaterClient.class);
        movieClient = retrofit.create(MovieClient.class);
    }

    /**
     * add show
     *
     * @param movieDTO
     * @param theaterDTO nullable default capacity is 40.
     * @param showDTO
     */
    public ShowDTO addShow(MovieDTO movieDTO, TheaterDTO theaterDTO, ShowDTO showDTO) {
        try {
            Response<MovieDTO> execute = movieClient.addMovie(movieDTO).execute();
            assert execute.code() == 200;
            MovieDTO result = execute.body();
            System.out.println(result);
            String movieId = result.getId();

            assert movieId != null;

            //add theater
            TheaterDTO theaterDTO1;
            if (theaterDTO == null) {
                theaterDTO1 = new TheaterDTO();
                theaterDTO1.setCapacity(40);
            } else {
                theaterDTO1 = theaterDTO;
            }

            Response<TheaterDTO> execute1 = theaterClient.addTheater(theaterDTO1).execute();
            assert execute1.code() == 200;

            TheaterDTO theaterResponse = execute1.body();
            System.out.println(theaterResponse);
            String theaterId = theaterResponse.getId();

            assert theaterId != null;


            showDTO.setMovieId(movieId);
            showDTO.setTheaterId(theaterId);

            Response<ShowDTO> execute2 = theaterClient.addShow(showDTO).execute();
            System.out.println(execute2.body());
            assert execute2.code() == 200;
            return execute2.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
