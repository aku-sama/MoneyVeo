package ru.improvegroup.moneyveo.server;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import ru.improvegroup.moneyveo.app.Config;
import ru.improvegroup.moneyveo.server.entity.BasicResponse;
import ru.improvegroup.moneyveo.server.entity.Login;
import ru.improvegroup.moneyveo.server.entity.Token;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BASIC;

/**
 * Created by Diana.Raspopova on 4/14/2017.
 */

public class ServerMethods {


    /*********************************************
     * CHECK PROVIDER AND GET TOKEN
     ********************************************/

    public static void checkProviderToken(Callback<BasicResponse> cb) {

        Call<BasicResponse> call = RetrofitService.getRetrofitService()
                .checkProviderToken(Config.PROVIDER_TOKEN);

        call.enqueue(cb);
    }

    public static void authorization(Login body, Callback<Token> cb) {

        Call<Token> call = RetrofitService.getRetrofitService()
                .authorization(body);

        call.enqueue(cb);
    }


}
