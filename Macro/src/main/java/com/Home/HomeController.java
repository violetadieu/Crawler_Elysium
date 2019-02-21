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
        String FirstMAC=getMacAddress.getAddress();//프로그램 시작 시 mac 주소 저장
        System.out.println(FirstMAC);
        String[] TargetList={"팀엘리시움","폼+체커","POM+CHECKER"};//검색어목록
        ArrayList<String>UrlList=new ArrayList<String>();
        for(int i=0;i<TargetList.length;i++) {
            searchService.ParseUrl_total(UrlList,TargetList[i]);//통합검색
            searchService.ParseUrl_blog(UrlList,TargetList[i]);//블로그검색
            searchService.ParseUrl_website(UrlList,TargetList[i]);//웹사이트검색 및 url 주소 저장
        }
        while(true) {
            try {
                searchService.SendRequest(UrlList);//요청 전송
                Thread.sleep(150*1000);//비정상적인 트래픽 전송을 막기위한 지연
                if(!(FirstMAC.equals(getMacAddress.getAddress()))) {//linkliar로 mac주소 바뀐 경우
                    FirstMAC=getMacAddress.getAddress();//현재의 mac주소
                    System.out.println(FirstMAC);
                }
            }
            catch (Exception e) {
                return "index";
            }
        }
    }
}
