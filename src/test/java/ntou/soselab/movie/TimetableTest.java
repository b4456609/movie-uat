package ntou.soselab.movie;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ntou.soselab.movie.model.Timetable;
import org.joda.time.DateTime;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class TimetableTest {

    private final Show show = new Show();
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(ZuulURL.getURL())
            .addConverterFactory(JacksonConverterFactory.create())
            .build();
    private TheaterClient theaterClient;
    private MovieClient movieClient;
    private List<ShowDTO> body;
    private List<ShowDTO> showDTOS;

    @Given("^the following show exist:$")
    public void the_following_show_exist(List<Timetable> timetables) throws Throwable {
        this.theaterClient = retrofit.create(TheaterClient.class);
        this.movieClient = retrofit.create(MovieClient.class);
        timetables.forEach(item -> {
            //add movie
            MovieDTO movieDTO = new MovieDTO();
            movieDTO.setTitle("La La Land");
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
        body = this.theaterClient.getTimetable().execute().body();
    }

    @Then("^I get (\\d+) show information$")
    public void i_get_show_information(int arg1) throws Throwable {
        assertThat(body.size()).isEqualTo(arg1);
    }

    @When("^I view show detail$")
    public void i_view_show_detail() throws Throwable {
        showDTOS = theaterClient.getTimetable().execute().body();
    }

    @Then("^The number of result should be (\\d+)$")
    public void the_number_of_result_should_be(int arg1) throws Throwable {
        assertThat(showDTOS.size()).isEqualTo(arg1);
    }

    @Then("^(\\d+) empty seat should be exist in one item$")
    public void empty_seat_should_be_exist_in_one_item(int arg1) throws Throwable {
        Optional<ShowDTO> any = showDTOS.stream()
                .filter(i -> i.getEmptySeat() == arg1)
                .findAny();
        assertThat(any.isPresent()).isTrue();
    }
}
