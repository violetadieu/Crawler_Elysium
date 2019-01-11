package com.Home;

import com.Searching.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;

@Controller
public class HomeController {
    @Autowired
    SearchServiceImpl searchService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Home(){

        ArrayList<String>UrlList=searchService.ParseUrl();

        searchService.SendRequest(UrlList);

        return "index";
    }
}
