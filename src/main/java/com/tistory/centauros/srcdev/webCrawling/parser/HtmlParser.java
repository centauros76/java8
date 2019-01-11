package com.tistory.centauros.srcdev.webCrawling.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;

/**
 * Created by Rene on 2019-01-11.
 * auth : Rene
 */
public class HtmlParser {

    final String sourceHtml;
    Document doc;

    public HtmlParser(String sourceHtml) {
        this.sourceHtml = sourceHtml;
        doc = Jsoup.parse(sourceHtml);
    }

    public List<String> getElements(String tag, List<String> param) {
        List<String> result = null;
        doc.getElementsByClass("title_g");


        return result;
    }


}
