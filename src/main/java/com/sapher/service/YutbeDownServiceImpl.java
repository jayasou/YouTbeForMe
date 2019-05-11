package com.sapher.service;

import com.sapher.manageApp.WebCrawler;
import com.sapher.youtubedl.YoutubeDL;
import com.sapher.youtubedl.YoutubeDLException;
import com.sapher.youtubedl.mapper.VideoInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class YutbeDownServiceImpl implements YutbeDownService {

    @Override
    public List<VideoInfo> getVideoList(String url) throws YoutubeDLException, IndexOutOfBoundsException {
        System.out.println("channer : " + url);

        List<VideoInfo> videoInfos = new ArrayList();

        if (url.contains("list")) {
            List<String> urlList = WebCrawler.webCrawling(url);
            for (String URL : urlList) {
                videoInfos.add(YoutubeDL.getVideoInfo(URL));
            }
            return videoInfos;
        }
        return null;
    }
}
