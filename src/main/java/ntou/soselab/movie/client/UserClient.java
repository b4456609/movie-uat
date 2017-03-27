package ntou.soselab.movie.client;


import ntou.soselab.movie.dto.UserDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;

public interface UserClient {
    @POST("/user/registration")
    Call<UserDTO> register(@Body UserDTO userDTO);

    @DELETE("/user/reset")
    Call<Void> reset();
}
