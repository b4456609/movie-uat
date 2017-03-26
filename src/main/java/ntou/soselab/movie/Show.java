package ntou.soselab.movie;


import org.json.JSONObject;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

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
            Response<String> execute = movieClient.addMovie(movieDTO).execute();
            assert execute.code() == 200;
            String result = execute.body();
            JSONObject jsonObject = new JSONObject(result);
            String movieId = jsonObject.getString("id");

            assert movieId != null;

            //add theater
            TheaterDTO theaterDTO1;
            if (theaterDTO == null) {
                theaterDTO1 = new TheaterDTO();
                theaterDTO1.setCapacity(40);
            } else {
                theaterDTO1 = theaterDTO;
            }

            Response<String> execute1 = theaterClient.addTheater(theaterDTO1).execute();
            assert execute1.code() == 200;

            String theaterResponse = execute1.body();
            JSONObject theaterResponseObject = new JSONObject(theaterResponse);
            String theaterId = theaterResponseObject.getString("id");

            assert theaterId != null;


            showDTO.setMovieId(movieId);
            showDTO.setTheaterId(theaterId);

            Response<ShowDTO> execute2 = theaterClient.addShow(showDTO).execute();
            assert execute2.code() == 200;
            return execute2.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
