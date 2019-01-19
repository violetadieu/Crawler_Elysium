package com.Searching;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service("SearchService")
public class SearchServiceImpl implements SearchService {

    @Override
    public ArrayList<String> ParseUrl_total(ArrayList<String> AL) {//url 저장
        String URL = "https://search.naver.com/search.naver?sm=top_hty&fbm=0&ie=utf8&query=팀엘리시움";//통합검색
        Document doc = null;
        try {
            doc = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elems = doc.select("a[href]:contains(팀엘리시움)");
        for(Element elem:elems){
            String input=elem.attr("abs:href");
            AL.add(input);
        }
        return AL;
    }

    @Override
    public ArrayList<String> ParseUrl_blog(ArrayList<String> AL) {
        String URL="https://search.naver.com/search.naver?where=post&sm=tab_jum&query=팀엘리시움";//블로그
        Document doc = null;
        try {
            doc = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elems = doc.select("a[href]:contains(팀엘리시움)");
        for(Element elem:elems){
            String input=elem.attr("abs:href");
            AL.add(input);
        }
        return AL;
    }

    @Override
    public ArrayList<String> ParseUrl_website(ArrayList<String> AL) {
        String URL="https://search.naver.com/search.naver?where=webkr&sm=tab_jum&query=팀엘리시움";
        Document doc = null;
        try {
            doc = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elems = doc.select("a[href]:contains(팀엘리시움)");
        for(Element elem:elems){
            String input=elem.attr("abs:href");
            AL.add(input);
        }
        return AL;
    }

    @Override
    public void SendRequest(ArrayList<String>UrlArray) {
        for(int i=0;i<UrlArray.size();i++){
            String url=UrlArray.get(i);
            try {
                Document tmp=Jsoup.connect(url).get();
                //System.out.println(url);
            } catch (IOException e) {
                System.out.println("Connection failed");
                e.printStackTrace();
            }

        }
    }
}
