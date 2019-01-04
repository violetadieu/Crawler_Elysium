package com.Home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Home(HttpServletRequest request) throws Exception{
        String URL = "https://search.naver.com/search.naver?sm=top_hty&fbm=0&ie=utf8&query=팀엘리시움";
        Document doc = Jsoup.connect(URL).get();
        Elements elem = doc.select("a:contains(팀엘리시움)[href]");
        String str = elem.text();
        System.out.println(str);
        return "redirect:" + request.getScheme()+"://search.naver.com/search.naver?sm=top_hty&fbm=0&ie=utf8&query=팀엘리시움";
    }
}
