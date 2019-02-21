package com.Home.f20;

import java.util.Scanner;

class a {

    a(){  //클래스 a에 대한 생성자  및  오버로딩
        System.out.println("nothing");
    }
    a(int a){
        System.out.println("int");
    }
    a(Double b){
        System.out.println("double");
    }
    static int num = 1;
    int num1 = 2;
    public static void math(int a, int b) {

        System.out.println(a+b);
    }
    public static void math(int a, Double b ) {
        System.out.println(a+b);
    }
    public  void math() {
        System.out.println("하..");
    }
    public String math_1(int a){
        return "ㅎ2";
    }
    public double math_1(double b){
        return b;
    }

}
public class asd {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        a a_1 = new a(10);
        a.math(3,5);
        a.math(3,4);     // 이거랑 칸이 같을경우
        a_1.math();

        System.out.println(a_1.num1);
        System.out.println(a_1.math_1(n));
        System.out.println(a_1.math_1(1.2)); //??
    }

}