package ntou.soselab.movie;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ntou.soselab.movie.model.Timetable;
import org.joda.time.DateTime;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.List;

public class TimetableTest {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://localhost:8080/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    @Given("^the following show exist:$")
    public void the_following_show_exist(List<Timetable> timetables) throws Throwable {
        timetables.stream()
                .map(item -> {
                    ShowDTO showDTO = new ShowDTO();
                    DateTime dt = new DateTime(2017, 3, 26, item.getStartTimeHour(), item.getStartTimeMinute(), 0, 0);
                    long millis = dt.getMillis();
                    showDTO.setStart(millis);
                    showDTO.setId("");
                    return showDTO;
                });
        throw new PendingException();
    }

    @When("^I view timetable$")
    public void i_view_timetable() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I get (\\d+) show information$")
    public void i_get_show_information(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I view show detail$")
    public void i_view_show_detail() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^The number of result should be (\\d+)$")
    public void the_number_of_result_should_be(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^(\\d+) empty seat should be exist in one item$")
    public void empty_seat_should_be_exist_in_one_item(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
