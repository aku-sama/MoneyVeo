package ru.improvegroup.moneyveo.server;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.improvegroup.moneyveo.app.Config;
import ru.improvegroup.moneyveo.server.entity.Login;
import ru.improvegroup.moneyveo.server.entity.Token;

/**
 * Created by Diana.Raspopova on 4/14/2017.
 */

public class RetrofitService {

    private static final String AUTHORIZATION = "Authorization";
    private static final String VEO = "VEO ";

    private static Retrofit mRetrofit;
    private static Gson mGson;

    private static VeoAPI service;


    private RetrofitService() {
        // no instances
    }

    public static void init() {
        mGson = new GsonBuilder()
                .create();

        TokenManager tokenManager = new TokenManager() {
            @Override
            public String getToken() {
                return Config.getAuthorizationToken();
            }

            @Override
            public boolean hasToken() {
                return Config.getAuthorizationToken() != null;
            }


            @Override
            public String refreshToken() {
                Login login = Config.getLoginPreferences();

                try {
                    Token result = service.authorization(login).execute().body();
                    saveToken(result);
                    return result.getToken();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }


            private void saveToken(Token result) {
                Config.setAuthorizationToken(result);
            }
        };


        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new TokenInterceptor(tokenManager))
                .addInterceptor(logging)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();


        mRetrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(mGson))
                .build();

        service = mRetrofit.create(VeoAPI.class);
    }


    public static VeoAPI getRetrofitService() {
        if (service != null) {
            return service;
        } else {
            throw new IllegalStateException("mRetrofit not initialized");
        }
    }


    private static class TokenInterceptor implements Interceptor {
        private final TokenManager mTokenManager;

        private TokenInterceptor(TokenManager tokenManager) {
            mTokenManager = tokenManager;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();
            Request modifiedRequest = request.newBuilder()
                    .addHeader(AUTHORIZATION, getAuthorizationToken())
                    .build();

            Response response = chain.proceed(modifiedRequest);
            boolean unauthorized = response.code() == 401;

            if (unauthorized && !request.url().toString().contains(Urls.AUTH)) {
                String newToken = mTokenManager.refreshToken();

                if (newToken == null) {
                    return response;
                }

                modifiedRequest = request.newBuilder()
                        .addHeader(AUTHORIZATION, getAuthorizationToken())
                        .build();

                return chain.proceed(modifiedRequest);
            } else {
                return response;
            }
        }

    }

    private static String getAuthorizationToken() {
        return VEO + Config.PROVIDER_TOKEN + ":" + Config.getAuthorizationToken();

    }

    interface TokenManager {
        String getToken();

        boolean hasToken();

        String refreshToken();
    }

}
