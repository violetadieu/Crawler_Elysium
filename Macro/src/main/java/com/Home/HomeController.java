package com.Home;

import com.MacAddress.GetMacAddressImpl;
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
    @Autowired
    GetMacAddressImpl getMacAddress;
    int number=1;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Home(){
        String FirstMAC=getMacAddress.getAddress();
        while(true) {
            try {
                ArrayList<String>UrlList=new ArrayList<String>();
                searchService.ParseUrl_total(UrlList);
                searchService.ParseUrl_blog(UrlList);
                searchService.ParseUrl_website(UrlList);
                System.out.println(number);
                System.out.println(FirstMAC);
                if(FirstMAC!=getMacAddress.getAddress()) {
                    FirstMAC=getMacAddress.getAddress();
                    searchService.SendRequest(UrlList);
                }
                number++;
            }
            catch (Exception e) {
                return "index";
            }
        }
    }
}
