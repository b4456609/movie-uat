package ntou.soselab.movie;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class MovieDetail {

    @Given("^the following movies exist:$")
    public void the_following_movies_exist(List<List<String>> movies) throws Throwable {
        System.out.println(movies);

    }

    @Given("^I am a guest$")
    public void i_am_a_guest() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I view all movies detail$")
    public void i_view_all_movies_detail() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I get (\\d+) movies detail$")
    public void i_get_movies_detail(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I provide a La La Land$")
    public void i_provide_a_La_La_Land() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I view a specific movies detail$")
    public void i_view_a_specific_movies_detail() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^The movie name should be exist$")
    public void the_movie_name_should_be_exist() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I provide a Moonlight$")
    public void i_provide_a_Moonlight() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I provide a Zootopia$")
    public void i_provide_a_Zootopia() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^the following show exist:$")
    public void the_following_show_exist(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
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

    @Given("^the following the user exist:$")
    public void the_following_the_user_exist(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        throw new PendingException();
    }

    @Given("^the show exist:$")
    public void the_show_exist(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        throw new PendingException();
    }

    @When("^The user book a La La Land ticket$")
    public void the_user_book_a_La_La_Land_ticket() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Successful book the ticket$")
    public void successful_book_the_ticket() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^Ben is a user$")
    public void ben_is_a_user() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^Ben has a order which is not picked up$")
    public void ben_has_a_order_which_is_not_picked_up() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^The Ben pick the ticket$")
    public void the_Ben_pick_the_ticket() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Successful pick up the ticket$")
    public void successful_pick_up_the_ticket() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I am a unregister user$")
    public void i_am_a_unregister_user() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I provide a Ben$")
    public void i_provide_a_Ben() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I provide a (\\d+)$")
    public void i_provide_a(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I register the account$")
    public void i_register_the_account() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I got my user id$")
    public void i_got_my_user_id() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I can check my name is Ben$")
    public void i_can_check_my_name_is_Ben() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I can check my phone number is (\\d+)$")
    public void i_can_check_my_phone_number_is(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I provide a Marry$")
    public void i_provide_a_Marry() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I can check my name is Marry$")
    public void i_can_check_my_name_is_Marry() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


}
