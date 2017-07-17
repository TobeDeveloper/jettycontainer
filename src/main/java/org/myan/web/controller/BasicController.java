package org.myan.web.controller;

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

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "index";
    }
}
