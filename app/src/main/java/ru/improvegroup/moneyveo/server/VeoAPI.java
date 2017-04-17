package ru.improvegroup.moneyveo.server;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import ru.improvegroup.moneyveo.server.entity.BasicResponse;
import ru.improvegroup.moneyveo.server.entity.Login;
import ru.improvegroup.moneyveo.server.entity.Token;

/**
 * Created by Diana.Raspopova on 4/14/2017.
 */

public interface VeoAPI {


    /*********************************************
     * CHECK PROVIDER AND GET TOKEN
     ********************************************/

    @POST(Urls.AUTH)
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    Call<Token> authorization(@Body Login login);


    @GET(Urls.AUTH_PROVIDE)
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    Call<BasicResponse> checkProviderToken(@Query("ProviderToken") String providerToken);

}
