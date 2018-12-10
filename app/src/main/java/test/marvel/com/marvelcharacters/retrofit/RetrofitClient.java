package test.marvel.com.marvelcharacters.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;
    static final String BASE_URL = "https://gateway.marvel.com:443/";


    public static Retrofit getClient() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public static RetrofitService getMarvelService() {

        return getClient().create(RetrofitService.class);

    }

}
