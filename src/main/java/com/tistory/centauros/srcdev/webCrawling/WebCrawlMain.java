package com.tistory.centauros.srcdev.webCrawling;

import com.tistory.centauros.srcdev.webCrawling.crawler.Crawler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.stream.Collectors;

/**
 * Created by Rene on 2019-01-10.
 * auth : Rene
 */
public class WebCrawlMain {


    public static void main(String[] args) {
        Log logger = LogFactory.getLog("stdLogger");

        String url = "http://shopping.daum.net/search/%ED%8C%A8%EB%94%A9/view_type:list&image_filter_cnt:200";
//        String url = "http://shopping.daum.net/search/ski/image_filter_cnt:200";
        String paramTag = "";


        //1. crawler service에서 해당 page의 html text 획득
        Crawler crawler = new Crawler(url);
        String resultHtml = crawler.getHtmlSource(false);
//        System.out.println(crawler.getHtmlSource());
        logger.debug(resultHtml);

        Document doc = Jsoup.parse(resultHtml);
        Elements elements = doc.getElementsByClass("wrap_prod_top");

        // 썸네일 이미지 추출
        elements.stream().forEach(element -> getItemInfo(element));

        // title 추출
        // 카테고리 추출
        // 가격 추출



        //elements.stream().forEach(element -> System.out.println(element.attr("title")));

        //2. parser와 paramTag를 이용해서 원하는 data 획득
        //3. result 구성
    }

    private static String getItemInfo(Element element) {
        getThumbImg(element);
        getTitle(element);
        getCategory(element);
        getPrice(element);
        return new String();
    }

    private static String getThumbImg(Element element) {
        String result;
        System.out.println(element.select("img.thumb_img").attr("src"));

        return new String();
    }

    private static String getTitle(Element element) {
        System.out.println(element.select("a.link_g._GC_").text());
        return new String();
    }

    private static String getCategory(Element element) {
        System.out.println(element.select("a.link_path._GC_").eachText().stream().collect(Collectors.joining(" > ")));
        return new String();
    }

    private static String getPrice(Element element) {
        System.out.println(element.select("span.num_price").eachText());
        return new String();
    }


}




