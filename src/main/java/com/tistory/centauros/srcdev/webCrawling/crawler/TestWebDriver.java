package com.tistory.centauros.srcdev.webCrawling.crawler;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.concurrent.TimeUnit;

/**
 * Created by Rene on 2019-01-10.
 * auth : Rene
 */
public class TestWebDriver {

    WebDriver webDriver;
    ChromeOptions chromeOptions;

    private void init(boolean isProxy) {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "chromedriver");

        chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        chromeOptions.addArguments("window-size=1920x1080");
        chromeOptions.addArguments("disable-dev-shm-usage");
        chromeOptions.addArguments("no-sandbox");
        chromeOptions.addArguments("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.117 Safari/537.36");
        chromeOptions.addArguments("lang=ko_KR");
        chromeOptions.addArguments("disable-application-cache");

        if(isProxy) {
            String PROXY = "proxy-common.daumcdn.net:8160";
            org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
            proxy.setHttpProxy(PROXY).setFtpProxy(PROXY).setSslProxy(PROXY);
            chromeOptions.setCapability(CapabilityType.PROXY, proxy);
        }

        webDriver = new ChromeDriver(chromeOptions);
    }

    public String getHtmlSource(String url) {
        return getHtmlSource(url, false);
    }

    public String getHtmlSource(String url, boolean isProxy) {

        //1. webDriver 생성
        init(isProxy);

        //2. webDriver이용해서 targetPage loading

//        webDriver.manage().window().maximize();
        webDriver.get(url.trim());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //3. page source 추출
        String result = null;
        try {
            result = webDriver.getPageSource();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            webDriver.quit();
        }

        return result;
    }

}
