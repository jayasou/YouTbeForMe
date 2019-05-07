package com.sapher.controller;


import com.sapher.service.YutbeDownService;
import com.sapher.youtubedl.YoutubeDLException;
import com.sapher.youtubedl.mapper.VideoInfo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class VideoController {



//    @ResponseBody
    @GetMapping("/youtubedl/main")
    public String test(){

        return "/youtubedl/main";
    }

    @GetMapping(value = "/template/index")
    public String getIndex() {

        return "/template/index";
    }

    @GetMapping(value = "/template/generic")
    public String getGeneric() {

        return "/template/generic";
    }
    @GetMapping(value = "/template/elements")
    public String getElements() {

        return "/template/elements";
    }

}