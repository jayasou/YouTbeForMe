package com.sapher.service;

import com.sapher.manageApp.DownloadVideo;
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

    @Override
    public String getDownloadPath() {
        String osName = System.getProperty("os.name").toLowerCase();
        String user = System.getProperty("user.name");

        String downloadPath = null;
        if(osName.contains("mac")) {
           downloadPath = "/Users/" + user + "/Downloads/";
        } else {
           downloadPath = "C:\\Users\\" + user + "\\Downloads\\";
        }

        return downloadPath;
    }

    @Override
    public void download(List<String> url, String downloadPath) {
        url.forEach(str -> {
            try {
                DownloadVideo dv = new DownloadVideo(str, downloadPath);
                dv.download(str);
            } catch (YoutubeDLException e) {
                e.printStackTrace();
            }
        });
    }
}
