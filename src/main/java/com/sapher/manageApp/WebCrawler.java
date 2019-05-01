package com.sapher.manageApp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebCrawler {


    public List<String> webCrawling(String channelUrl) {
//        String url = "https://www.youtube.com/playlist?list=PLuHgQVnccGMAp9YSO2J5VBWLJewTPn_0_";

        Document doc = null;
        try {
            doc = Jsoup.connect(channelUrl).get();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
            return null;
        }

        String query = "table .pl-video .pl-video-thumbnail .yt-uix-sessionlink";
        Elements elements = doc.select(query);

        List<String> videoList = new ArrayList<>();
        for(Element element : elements) {
            videoList.add("https://www.youtube.com" +
                    element.attr("href").split("&")[0]);
        }

        videoList.stream().forEach(System.out::println);

        return videoList;
    }
}
