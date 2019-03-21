package com.tistory.centauros.srcdev;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class LinkCheck {

    public static void main(String[] args) {
        String result = "";
        String linkUrl = "https://search1.daumcdn.net/search/statics/common/img/og_search.png";
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(linkUrl).openConnection());
            httpURLConnection.setRequestMethod("HEAD");
            httpURLConnection.connect();
            result = ""+httpURLConnection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(linkUrl + " :: " + result);
    }
}
