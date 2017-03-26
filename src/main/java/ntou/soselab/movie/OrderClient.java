package ntou.soselab.movie;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface OrderClient {
    @POST("/order/book")
    Call<BookDTO> bookTickets(@Body BookDTO bookDTO);

    @GET("/order/user/{userId}")
    Call<List<OrderResultDTO>> getUserOrders(@Path("userId") String userId);

    @POST("/order/tickets/{orderId}")
    Call<PickTicketsResultDTO> pickUpTickets(@Path("orderId") String orderId);

    @DELETE("/order/reset")
    Call<Void> reset();
}
