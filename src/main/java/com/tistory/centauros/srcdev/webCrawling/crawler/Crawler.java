package com.tistory.centauros.srcdev.webCrawling.crawler;

import lombok.Data;

/**
 * Created by Rene on 2019-01-10.
 * auth : Rene
 */
@Data
public class Crawler {

    String url = null;
    String htmlSource = null;
    TestWebDriver testWebDriver;


    public Crawler() {
        this.url = "https://www.daum.net";
    }

    public Crawler(String url) {
        this.url = url;
    }

    public String getHtmlSource() {
        testWebDriver = new TestWebDriver();
        return testWebDriver.getHtmlSource(this.url);
    }

    public String getHtmlSource(boolean isProxy) {
        testWebDriver = new TestWebDriver();
        return testWebDriver.getHtmlSource(this.url, isProxy);
    }
}
