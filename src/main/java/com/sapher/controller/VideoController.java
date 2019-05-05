package com.sapher.controller;


import com.sapher.service.YutbeDownService;
import com.sapher.youtubedl.YoutubeDLException;
import com.sapher.youtubedl.mapper.VideoInfo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class VideoController {

    @Inject
    private YutbeDownService service;

//    @ResponseBody
    @RequestMapping("/main")
    public String test(){


        return "/main";
    }

    @ResponseBody
    @RequestMapping(value="/getVideoList", produces = "application/json")//, method = RequestMethod.GET)
    public JSONArray list(HttpServletResponse response)  throws YoutubeDLException, IndexOutOfBoundsException {


        String url = "https://www.youtube.com/playlist?list=PLuHgQVnccGMBe0848t2_ZUgFNJdanOA_I";
        List<VideoInfo> urlList = service.youtubeDownload(url);


        ModelAndView mav = new ModelAndView("/main");
        mav.addObject("urlList", urlList);

        JSONArray jArray = new JSONArray();
        int size = urlList.size();
        for(int i=0; i<size; i++) {
//            System.out.println(urlList.get(i).title);
            VideoInfo tmp = urlList.get(i);

            JSONObject jobject = new JSONObject();
            jobject.put("title", tmp.title);
            jobject.put("format", tmp.format);
            jobject.put("duration", tmp.duration);

            jArray.add(jobject);

        }
        System.out.println("jArray -------------------");
        System.out.println(jArray);
        response.setHeader("Accept", "application/json");

        return jArray;
    }

}