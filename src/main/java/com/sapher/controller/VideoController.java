package com.sapher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class VideoController {

        @GetMapping("/main")
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