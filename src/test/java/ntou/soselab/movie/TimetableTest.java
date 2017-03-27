package ntou.soselab.movie;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ntou.soselab.movie.client.MovieClient;
import ntou.soselab.movie.client.TheaterClient;
import ntou.soselab.movie.config.GetRetrofit;
import ntou.soselab.movie.dto.MovieDTO;
import ntou.soselab.movie.dto.ShowDTO;
import ntou.soselab.movie.dto.TimeTableDTO;
import ntou.soselab.movie.model.Timetable;
import org.joda.time.DateTime;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class TimetableTest {

    private final Show show = new Show();
    private Retrofit retrofit = GetRetrofit.get();
    private TheaterClient theaterClient;
    private MovieClient movieClient;
    private List<TimeTableDTO> body;
    private List<TimeTableDTO> showDTOS;

    @Before
    public void before() throws IOException {
        this.theaterClient = retrofit.create(TheaterClient.class);
        this.movieClient = retrofit.create(MovieClient.class);
        movieClient.reset().execute();
        theaterClient.reset().execute();
    }

    @Given("^the following show exist:$")
    public void the_following_show_exist(List<Timetable> timetables) throws Throwable {
        timetables.forEach(item -> {
            //add movie
            MovieDTO movieDTO = new MovieDTO();
            movieDTO.setTitle(item.getMovie());
            movieDTO.setActors("Ryan Gosling, Emma Stone, Amiée Conn, Terry Walters");
            movieDTO.setDirector("Damien Chazelle");
            movieDTO.setGenre("Comedy, Drama, Musical");
            movieDTO.setPlot("A jazz pianist falls for an aspiring actress in Los Angeles.");
            movieDTO.setRunTime("128 min");
            movieDTO.setRated("PG-13");
            movieDTO.setYear("2016");

            //add show
            ShowDTO showDTO = new ShowDTO();
            DateTime dt = new DateTime(2017, 3, 26,
                    item.getStartTimeHour(), item.getStartTimeMinute(), 0, 0);
            long millis = dt.getMillis();
            showDTO.setStart(millis);
            showDTO.setEnd(dt.plus((1000 * 60 * 60 * 2)).getMillis());
            showDTO.setEmptySeat(item.getEmptySeat());

            show.addShow(movieDTO, null, showDTO);
        });
    }

    @When("^I view timetable$")
    public void i_view_timetable() throws Throwable {
        Response<List<TimeTableDTO>> execute = this.theaterClient.getTimetable(null).execute();
        assertThat(execute.code()).isEqualTo(200);
        body = execute.body();
        System.out.println(body);
    }

    @Then("^I get (\\d+) show information$")
    public void i_get_show_information(int arg1) throws Throwable {
        assertThat(body.size()).isEqualTo(arg1);
    }

    @When("^I view show, (.*), detail$")
    public void iViewShowMovieDetail(String a) throws Throwable {
        Response<List<TimeTableDTO>> execute = theaterClient.getTimetable(a).execute();
        assert execute.code() == 200;
        showDTOS = execute.body();
    }

//    @When("^I view show, Moonlight, detail$")
//    public void iViewMoonlightDetail() throws Throwable {
//        Response<List<TimeTableDTO>> execute = theaterClient.getTimetable("Moonlight").execute();
//        assert execute.code() == 200;
//        showDTOS = execute.body();
//    }

    @Then("^The number of result should be (\\d+)$")
    public void the_number_of_result_should_be(int arg1) throws Throwable {
        System.out.println(showDTOS);
        assertThat(showDTOS.size()).isEqualTo(arg1);
    }

    @Then("^(\\d+) empty seat should be exist in one item$")
    public void empty_seat_should_be_exist_in_one_item(int arg1) throws Throwable {
        Optional<TimeTableDTO> any = showDTOS.stream()
                .filter(i -> i.getEmptySeat() == arg1)
                .findAny();
        assertThat(any.isPresent()).isTrue();
    }
}
