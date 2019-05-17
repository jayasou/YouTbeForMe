package com.sapher.controller;

import com.sapher.service.YutbeDownService;
import com.sapher.youtubedl.YoutubeDLException;
import com.sapher.youtubedl.mapper.VideoInfo;
import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Inject
    private YutbeDownService service;

    @RequestMapping(value="/getVideoList", produces = "application/json")//, method = RequestMethod.GET)
    public List<VideoInfo> list(@RequestParam String url)  throws YoutubeDLException, IndexOutOfBoundsException {

//        String URL = "https://www.youtube.com/playlist?list=PLuHgQVnccGMBe0848t2_ZUgFNJdanOA_I";

        List<VideoInfo> urlList = service.getVideoList(url);

        return urlList;
    }

    @RequestMapping(value="/download", produces = "application/json")
    public String download(@RequestParam List<String> videoID) {

        String downloadPath = service.getDownloadPath();

        service.download(videoID, downloadPath);


        return "Complete";
    }
}
