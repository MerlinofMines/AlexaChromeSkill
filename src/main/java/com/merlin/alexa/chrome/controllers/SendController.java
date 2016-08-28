package com.merlin.alexa.chrome.controllers;

import com.merlin.alexa.chrome.websockets.SocketManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Aaron on 8/27/2016.
 */
@Controller
@RequestMapping("/send")
public class SendController {

    @RequestMapping(method = RequestMethod.GET)
    public String send(@RequestParam("socket")String socket, @RequestParam("message") String message) {
        System.out.println("Received send request for socket: " + socket);
        System.out.println("Message was: " + message);

        SocketManager.getInstance().sendMessage(socket, message);

        return "send";
    }
}
