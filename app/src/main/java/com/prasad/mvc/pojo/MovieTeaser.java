package com.prasad.mvc.pojo;

import java.util.List;

/**
 * Created by Welcome on 4/24/2016.
 */
public class MovieTeaser {


   List<Inner> results;

    public List<Inner> getResults() {
        return results;
    }

    public void setResults(List<Inner> results) {
        this.results = results;
    }

    public static class Inner{


        private String key;
        private String  name;

        public void setkey(String key) {
            this.key = key;
        }

        public String getkey() {
            return key;
        }


    }

//    public String key;
//    public String name;
//
////    public JSONArray results;
//
//    public String getKey() {
//        return key;
//    }
//
//    public void setKey(String key) {
//        this.key = key;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

//    public JSONArray getResults() {
//        return results;
//    }
//
//    public void setResults(JSONArray results) {
//        this.results = results;
//    }
}
