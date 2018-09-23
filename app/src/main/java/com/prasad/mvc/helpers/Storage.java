package com.prasad.mvc.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.prasad.mvc.pojo.MoviesPostersData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Welcome on 5/18/2016.
 */
public class Storage {

    SharedPreferences.Editor editor;
    SharedPreferences prefs;

    public Storage(Context context) {
        prefs = context.getSharedPreferences("Movies_Prefs", Context.MODE_PRIVATE);
        editor = prefs.edit();
        editor.commit();
    }

    public List<MoviesPostersData.Inner> getFavMoviesData() {

        List<MoviesPostersData.Inner> moviePosterList = new ArrayList<MoviesPostersData.Inner>();

        Map<String, ?> keys = prefs.getAll();

        for (Map.Entry<String, ?> entry : keys.entrySet()) {

            MoviesPostersData.Inner storedMovieInnerObj = new Gson().fromJson((String) entry.getValue(), MoviesPostersData.Inner.class);
            moviePosterList.add(storedMovieInnerObj);
        }

        return moviePosterList;
    }

    public void setMovieData(int movieId, String movieData) {
        editor.putString(String.valueOf(movieId), movieData);
        editor.commit();
    }

    public String getMovieData(int movieId) {

        return prefs.getString(String.valueOf(movieId), null);

    }

    public void clearMovieData(int movieId) {
        editor.remove(String.valueOf(movieId));
        editor.commit();
    }

}
