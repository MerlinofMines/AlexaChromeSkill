package com.merlin.alexa.chrome.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/recieve")
public class RecieveController {
    @RequestMapping(method = RequestMethod.GET)
    public String recieve() {
        return "recieve";
    }
}
