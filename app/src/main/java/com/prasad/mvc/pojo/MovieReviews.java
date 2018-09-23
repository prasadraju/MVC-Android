package com.prasad.mvc.pojo;

import java.util.List;

/**
 * Created by Welcome on 4/24/2016.
 */
public class MovieReviews {


   List<Inner> results;

    public List<Inner> getResults() {
        return results;
    }

    public void setResults(List<Inner> results) {
        this.results = results;
    }

    public static class Inner{


        private String id;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        private String author;
        private String  content;


        public void setId(String key) {
            this.id = id;
        }

        public String getId() {
            return id;
        }


    }


}
