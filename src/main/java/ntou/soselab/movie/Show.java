package ntou.soselab.movie;


import org.json.JSONObject;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

public class Show {
    private TheaterClient theaterClient;
    private MovieClient movieClient;

    public Show() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://localhost:8080/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
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
            String result = movieClient.addMovie(movieDTO).execute().body();
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

            String theaterResponse = theaterClient.addTheater(theaterDTO1).execute().body();
            JSONObject theaterResponseObject = new JSONObject(theaterResponse);
            String theaterId = theaterResponseObject.getString("id");

            assert theaterId != null;


            showDTO.setMovieId(movieId);
            showDTO.setTheaterId(theaterId);

            return theaterClient.addShow(showDTO).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
