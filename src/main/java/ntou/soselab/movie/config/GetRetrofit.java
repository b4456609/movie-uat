package ntou.soselab.movie.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ntou.soselab.movie.config.ZuulURL;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class GetRetrofit {
    public static Retrofit get(){
        ObjectMapper mapper = new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ZuulURL.getURL())
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .build();
        return retrofit;
    }
}
