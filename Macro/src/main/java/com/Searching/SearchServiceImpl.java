package com.Searching;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;

public class SearchServiceImpl implements SearchService {

    @Override
    public ArrayList<String> ParseUrl() {//url 저장
        ArrayList<String> stringArrayList=new ArrayList<String>();
        String URL = "https://search.naver.com/search.naver?sm=top_hty&fbm=0&ie=utf8&query=팀엘리시움";
        Document doc = null;
        try {
            doc = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elems = doc.select("a[href]:contains(팀엘리시움)");
        for(Element elem:elems){
            String input=elem.attr("abs:href");
            stringArrayList.add(input);
        }
        return stringArrayList;
    }

    @Override
    public void SendRequest() {

    }
}
