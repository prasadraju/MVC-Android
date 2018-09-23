package com.prasad.mvc.servicemanger;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by prasad on 6/30/18.
 */

public class ApiClient {


    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit==null) {
//            Gson gson =
//                    new GsonBuilder().registerTypeAdapter(classType, new MyDeserializer(classType)).create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.THEMOVIEDB_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
