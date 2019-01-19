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
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Home(){
        String FirstMAC=getMacAddress.getAddress();
        System.out.println(FirstMAC);
        while(true) {
            try {
                ArrayList<String>UrlList=new ArrayList<String>();
                searchService.ParseUrl_total(UrlList);
                searchService.ParseUrl_blog(UrlList);
                searchService.ParseUrl_website(UrlList);
                searchService.SendRequest(UrlList);
                Thread.sleep(30000);
                if(!(FirstMAC.equals(getMacAddress.getAddress()))) {
                    FirstMAC=getMacAddress.getAddress();
                    System.out.println(FirstMAC);
                }
            }
            catch (Exception e) {
                return "index";
            }
        }
    }
}
