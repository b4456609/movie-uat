package ntou.soselab.movie;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieDetail {
    ObjectMapper mapper = new ObjectMapper();

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://localhost:8080/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    private MovieClient movieClient;
    private List<MovieDTO> timetable;
    private String query;
    private List<MovieDTO> movies;

    @Before
    public void before() {
        movieClient = retrofit.create(MovieClient.class);
    }

    @Given("^the following movies exist:$")
    public void the_following_movies_exist(List<List<String>> movies) throws Throwable {
        movies.forEach(movie -> {
            MovieDTO movieDTO = new MovieDTO();
            movieDTO.setTitle(movie.get(0));
            movieClient.addMovie(movieDTO);
        });
        System.out.println(movies);
    }

    @Given("^I am a guest$")
    public void i_am_a_guest() throws Throwable {

    }

    @When("^I view all movies detail$")
    public void i_view_all_movies_detail() throws Throwable {
        timetable = movieClient.getTimetable().execute().body();
    }

    @Then("^I get (\\d+) movies detail$")
    public void i_get_movies_detail(int arg1) throws Throwable {
       assertThat(timetable.size()).isEqualTo(arg1);
    }

    @Given("^I provide a La La Land$")
    public void i_provide_a_La_La_Land() throws Throwable {
        query = "La La Land";
    }

    @When("^I view La La Land detail$")
    public void i_view_La_La_Land_detail() throws Throwable {
        movies = movieClient.getMovieDetail(query).execute().body();
    }

    @Then("^The movie should be exist$")
    public void the_movie_should_be_exist() throws Throwable {
        assertThat(movies.get(0).getTitle()).contains(query);
    }

    @Given("^I provide a Moonlight$")
    public void i_provide_a_Moonlight() throws Throwable {
        query = "Moonlight";
    }

    @When("^I view Moonlight detail$")
    public void i_view_Moonlight_detail() throws Throwable {
        movies = movieClient.getMovieDetail(query).execute().body();
    }

    @Given("^I provide a Zootopia$")
    public void i_provide_a_Zootopia() throws Throwable {
        query = "Zootopia";
    }

    @When("^I view Zootopia detail$")
    public void i_view_Zootopia_detail() throws Throwable {
        movies = movieClient.getMovieDetail(query).execute().body();
    }

}
