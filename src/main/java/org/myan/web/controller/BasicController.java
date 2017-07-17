package org.myan.web.controller;

import org.myan.web.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by myan on 2017/7/17.
 * Intellij IDEA
 */
@Controller
@RequestMapping("/")
public class BasicController {
    @Autowired
    private TestService service;

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        System.out.println(service.getBases().size());
        return "index";
    }
}
