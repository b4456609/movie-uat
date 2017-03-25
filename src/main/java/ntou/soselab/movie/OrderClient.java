package ntou.soselab.movie;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface OrderClient {
    @POST("/order/book")
    Call<BookDTO> bookTickets(@Body BookDTO bookDTO);

    @GET("/order/user/{userId}")
    Call<List<OrderResultDTO>> getUserOrders(@Path("userId") String userId);

    @POST("/order/tickets/{orderId}")
    Call<PickTicketsResultDTO> pickUpTickets(@Path("orderId") String orderId);
}
