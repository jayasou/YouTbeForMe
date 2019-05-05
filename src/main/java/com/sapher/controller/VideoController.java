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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class VideoController {

    @Inject
    private YutbeDownService service;

//    @ResponseBody
    @RequestMapping("/main")
    public String test(){


        return "/main";
    }

    @RequestMapping("/sample")
    public String sample() {
        return "/sample-page";
    }

    @ResponseBody
    @RequestMapping(value="/getVideoList", produces = "application/json")//, method = RequestMethod.GET)
    public JSONArray list(@RequestParam String param)  throws YoutubeDLException, IndexOutOfBoundsException {


//        String url = "https://www.youtube.com/playlist?list=PLuHgQVnccGMBe0848t2_ZUgFNJdanOA_I";
        String url = param.replaceAll("\"", "");

        System.out.println(param);
        System.out.println("url : " + url);

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

        return jArray;
    }

}