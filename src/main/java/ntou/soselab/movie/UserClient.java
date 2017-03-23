package ntou.soselab.movie;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

public interface UserClient {
    @POST("/user/registration")
    Call<UserDTO> register(@Body UserDTO userDTO);
}
