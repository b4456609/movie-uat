package ntou.soselab.movie;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ntou.soselab.movie.model.OrderUser;
import ntou.soselab.movie.model.Timetable;
import org.joda.time.DateTime;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by bernie on 2017/3/22.
 */
public class OrderTest {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://localhost:8080/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();
    private UserClient userClient;
    private OrderClient orderClient;
    private TheaterClient theaterClient;
    private MovieClient movieClient;
    private Show show = new Show();
    private ShowDTO showDTO1;
    private UserDTO userBen;
    private Response<BookDTO> bookResponse;
    private Response<PickTicketsResultDTO> body;

    @Before
    public void before() {
        userClient = retrofit.create(UserClient.class);
        orderClient = retrofit.create(OrderClient.class);
        theaterClient = retrofit.create(TheaterClient.class);
        movieClient = retrofit.create(MovieClient.class);
    }

    @Given("^the following the user exist:$")
    public void the_following_the_user_exist(List<OrderUser> orderUserList) throws Throwable {
        orderUserList.forEach(user -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setName(user.getName());
            userDTO.setPhone(user.getPhone());
            try {
                userBen = userClient.register(userDTO).execute().body();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    @Given("^the show exist:$")
    public void the_show_exist(List<Timetable> timetables) throws Throwable {

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

            showDTO1 = show.addShow(movieDTO, null, showDTO);
        });
    }

    @When("^The user book a La La Land ticket$")
    public void the_user_book_a_La_La_Land_ticket() throws Throwable {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setShowId(showDTO1.getId());
        bookDTO.setTicket(1);
        bookDTO.setUserId(userBen.getId());
        bookResponse = orderClient.bookTickets(bookDTO).execute();
    }

    @Then("^Successful book the ticket$")
    public void successful_book_the_ticket() throws Throwable {
        assert bookResponse.code() == 200;
    }

    @Given("^Ben has a order which is not picked up$")
    public void ben_has_a_order_which_is_not_picked_up() throws Throwable {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setShowId(showDTO1.getId());
        bookDTO.setTicket(1);
        bookDTO.setUserId(userBen.getId());
        bookResponse = orderClient.bookTickets(bookDTO).execute();
    }

    @When("^The Ben pick the ticket$")
    public void the_Ben_pick_the_ticket() throws Throwable {
        String id = bookResponse.body().getId();
        body = orderClient.pickUpTickets(id).execute();
    }

    @Then("^Successful pick up the ticket$")
    public void successful_pick_up_the_ticket() throws Throwable {
        assert body.code() == 200;
        assertThat(body.body().isPickUp()).isTrue();
    }
}
