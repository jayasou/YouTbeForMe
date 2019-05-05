package com.sapher.controller;


import com.sapher.service.YutbeDownService;
import com.sapher.youtubedl.YoutubeDLException;
import com.sapher.youtubedl.mapper.VideoInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.inject.Inject;
import java.util.List;

@Controller
public class VideoController {

    @Inject
    private YutbeDownService service;

//    @ResponseBody
    @RequestMapping("/main")
    public ModelAndView test() throws YoutubeDLException, IndexOutOfBoundsException {

        String url = "https://www.youtube.com/playlist?list=PLuHgQVnccGMBe0848t2_ZUgFNJdanOA_I";
        List<VideoInfo> urlList = service.youtubeDownload(url);


        ModelAndView mav = new ModelAndView("/main");
        mav.addObject("urlList", urlList);

//        urlList.forEach((videoInfo -> System.out.println(videoInfo.title)));

        int size = urlList.size();
        for(int i=0; i<size; i++) {
            System.out.println(urlList.get(i).title);
        }

        /*if(urlList != null ) {
            System.out.println(url);
            urlList.forEach(System.out::println);
        }*/


//        return service.youtubeDownload(url);
        return mav;
    }

}