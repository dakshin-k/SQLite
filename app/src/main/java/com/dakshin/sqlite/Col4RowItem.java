package com.dakshin.sqlite;

public class Col4RowItem {
    private String one,two,three,four;
    public Col4RowItem(String a,String b, String c, String d) {
        one=a;
        two=b;
        three=c;
        four=d;
    }
    public Col4RowItem(String[] names) {
        one=names[0];
        two=names[1];
        three=names[2];
        four=names[3];
    }
    public String getFour() {
        return four;
    }

    public String getOne() {
        return one;
    }

    public String getThree() {
        return three;
    }

    public String getTwo() {
        return two;
    }
}
