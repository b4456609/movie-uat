package ntou.soselab.movie;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ntou.soselab.movie.client.MovieClient;
import ntou.soselab.movie.config.GetRetrofit;
import ntou.soselab.movie.dto.MovieDTO;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieDetail {
    private Retrofit retrofit = GetRetrofit.get();

    private MovieClient movieClient;
    private List<MovieDTO> timetable;
    private String laQuery;
    private String moonQuery;
    private String zooQuery;
    private List<MovieDTO> laMovies;
    private List<MovieDTO> moonMovies;
    private List<MovieDTO> zooMovies;

    @Before
    public void before() throws IOException {
        movieClient = retrofit.create(MovieClient.class);
//        Response<Void> execute = movieClient.reset().execute();
//        assert execute.code() == 200;
    }

    @Given("^the following movies exist:$")
    public void the_following_movies_exist(List<List<String>> movies) throws Throwable {
        movies.forEach(movie -> {
            MovieDTO movieDTO = new MovieDTO();
            movieDTO.setTitle(movie.get(0));
            try {
                Response<MovieDTO> execute = movieClient.addMovie(movieDTO).execute();
                assert execute.code() == 200;
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Given("^I am a guest$")
    public void i_am_a_guest() throws Throwable {

    }

    @When("^I view all movies detail$")
    public void i_view_all_movies_detail() throws Throwable {
        Response<List<MovieDTO>> execute = movieClient.getMovieDetail(null).execute();
        assert execute.code() == 200;
        timetable = execute.body();
    }

    @Then("^I get (\\d+) movies detail$")
    public void i_get_movies_detail(int arg1) throws Throwable {
       assertThat(timetable.size()).isEqualTo(arg1);
    }

    @Given("^I provide a La La Land$")
    public void i_provide_a_La_La_Land() throws Throwable {
        laQuery = "La La Land";
    }

    @When("^I view La La Land detail$")
    public void i_view_La_La_Land_detail() throws Throwable {
        laMovies = movieClient.getMovieDetail(laQuery).execute().body();
    }

    @Then("The La La Land should be exist")
    public void The_LaLaLand_should_be_exist(){
        assertThat(laMovies.get(0).getTitle()).isEqualToIgnoringCase(laQuery);
    }

    @Given("^I provide a Moonlight$")
    public void i_provide_a_Moonlight() throws Throwable {
        moonQuery = "Moonlight";
    }

    @Then("The Moonlight should be exist")
    public void The_Moonlight_should_be_exist(){
        assertThat(moonMovies.get(0).getTitle()).isEqualToIgnoringCase(moonQuery);
    }

    @When("^I view Moonlight detail$")
    public void i_view_Moonlight_detail() throws Throwable {
        Response<List<MovieDTO>> execute = movieClient.getMovieDetail(moonQuery).execute();
        assert execute.code() == 200;
        moonMovies = execute.body();
    }

    @Given("^I provide a Zootopia$")
    public void i_provide_a_Zootopia() throws Throwable {
        zooQuery = "Zootopia";
    }

    @When("^I view Zootopia detail$")
    public void i_view_Zootopia_detail() throws Throwable {
        Response<List<MovieDTO>> execute = movieClient.getMovieDetail(zooQuery).execute();
        assert execute.code() == 200;
        zooMovies = execute.body();
    }

    @Then("^The Zootopia should be exist$")
    public void The_Zootopia_should_be_exist(){
        assertThat(zooMovies.get(0).getTitle()).isEqualToIgnoringCase(zooQuery);
    }
}
