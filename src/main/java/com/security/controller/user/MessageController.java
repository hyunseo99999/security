package com.security.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageController {

    @GetMapping(value="/messages")
    public String messages() throws Exception {
        return "messages";
    }

    @RequestMapping(value = "/api/messages")
    @ResponseBody
    public String apiMessages() throws Exception {
        return "messages ok";
    }
}
