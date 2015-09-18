package com.example.gtkesh.smartsignservice;

/**
 * Created by gtkesh on 9/15/15.
 */
public class SmartSignClient {

    public static final String API_ENDPOINT = "http://smartsign.imtc.gatech.edu/videos?keywords=";
    public String keyword = "";

    public SmartSignClient(String word){
        this.keyword = word;
    }

    // to be implemented
    public String getYoutubeVideoId(String keyword){
        String videoId = "";


        return videoId;
    }

    // to be implemented
    public String getJSON(String http){
        String json = "";

        return json;
    }
}
