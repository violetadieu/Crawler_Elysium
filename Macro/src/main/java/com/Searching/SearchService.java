package com.Searching;

import java.util.ArrayList;

public interface SearchService {
    public ArrayList<String> ParseUrl_total();//요청을 보낼 url 파싱(통합검색)

    public ArrayList<String> ParseUrl_blog();//url 파싱(블로그)

    public ArrayList<String> ParseUrl_website();//url 파싱(웹사이트)

    public void SendRequest(ArrayList<String>UrlArray);//파싱한 url에 요청을 보냄

}
