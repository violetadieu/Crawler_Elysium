package com.Home;

import com.Searching.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class HomeController {
    @Autowired
    SearchServiceImpl searchService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Home(HttpServletRequest request) throws Exception{

        ArrayList<String>UrlList=searchService.ParseUrl();

        return UrlList.get(1);
    }
}
