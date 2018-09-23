package com.prasad.mvc.servicemanger;



import com.prasad.mvc.pojo.MovieReviews;
import com.prasad.mvc.pojo.MovieTeaser;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by Welcome on 5/18/2016.
 */
public interface MovieDatabaseApi {


//    @GET("movie/popular")
//    Call<MoviesPostersData> getPosters(@Query("api_key") String apiKey);

    @GET("movie/popular")
    Call<ResponseBody> getPosters(@Query("api_key") String apiKey);

    @GET("movie/top_rated")
    Call<ResponseBody> getPostersTopRated(@Query("api_key") String apiKey);

    @GET("movie/reviews")
    Call<MovieReviews> getReviews(@Query("api_key") String apiKey);

    @GET("movie/videos")
    Call<MovieTeaser> getTeasers(@Query("api_key") String apiKey);





}
