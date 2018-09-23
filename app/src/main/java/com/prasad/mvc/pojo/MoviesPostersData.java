package com.prasad.mvc.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kishorevarma on 17/03/16.
 */
public class MoviesPostersData  {

    int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    List<Inner> results;

    public List<Inner> getResults() {
        return results;
    }

    public void setResults(List<Inner> results) {
        this.results = results;
    }

    public static class Inner implements Serializable{

        int id;
        String poster_path;
        String overview;
        String release_date;

        String original_title;

        double vote_average;

        double popularity;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }


        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public double getVote_average() {
            return vote_average;
        }

        public void setVote_average(double vote_average) {
            this.vote_average = vote_average;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getPoster_path() {

            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

    }

}




//    {"poster_path":"\/inVq3FRqcYIRl2la8iZikYYxFNR.jpg",
//            "adult":false,
//            "overview":"Based upon Marvel Comicsâ€™ most unconventional anti-hero, DEADPOOL tells the origin story of former " +
//            "Special Forces operative turned mercenary Wade Wilson, who after being subjected to a rogue experiment that leaves" +
//            " him with accelerated healing powers, adopts the alter ego Deadpool. Armed with his new abilities and a dark, " +
//            "twisted sense of humor, Deadpool hunts down the man who nearly destroyed his life.",
//            "release_date":"2016-02-09",
//            "genre_ids":[28,12,35],
//            "id":293660,
//            "original_title":"Deadpool",
//            "original_language":"en",
//            "title":"Deadpool",
//            "backdrop_path":"\/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg",
//            "popularity":37.346151,
//            "vote_count":2079,
//            "video":false,
//            "vote_average":7.2},