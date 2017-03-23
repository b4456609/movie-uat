package ntou.soselab.movie;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.List;
import java.util.SimpleTimeZone;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://localhost:8080/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    private String name;
    private String phone;
    private UserClient userClient;
    private UserDTO body;
    private String id;

    @Given("^I am a unregister user$")
    public void i_am_a_unregister_user() throws Throwable {

    }

    @Given("^I provide a Ben$")
    public void i_provide_a_Ben() throws Throwable {
        name = "Ben";
    }

    @Given("^I provide a (\\d+)$")
    public void i_provide_a(int arg1) throws Throwable {
        phone = String.valueOf(arg1);
    }

    @When("^I register the account$")
    public void i_register_the_account() throws Throwable {
        this.userClient = retrofit.create(UserClient.class);
        UserDTO userDTO = new UserDTO();
        userDTO.setName(name);
        userDTO.setPhone(phone);
        this.body = userClient.register(userDTO).execute().body();
    }

    @Then("^I got my user id$")
    public void i_got_my_user_id() throws Throwable {
        id = body.getId();
    }

    @Then("^I can check my name is Ben")
    public void i_can_check_my_name_is_Ben() throws Throwable {
        assertThat(body.getName()).isEqualToIgnoringCase("Ben");
    }

    @Then("^I can check my phone number is (\\d+)$")
    public void i_can_check_my_phone_number_is(int arg1) throws Throwable {
        assertThat(body.getName()).isEqualToIgnoringCase(String.valueOf(arg1));
    }

    @Given("^I provide a Marry$")
    public void i_provide_a_Marry() throws Throwable {
        name = "Marry";
    }

    @Then("^I can check my name is Marry$")
    public void i_can_check_my_name_is_Marry() throws Throwable {
        assertThat(body.getName()).isEqualToIgnoringCase("Marry$");
    }
}
