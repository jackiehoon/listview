package com.oz.edu.listview;

/**
 * Created by pc-2 on 2017-08-09.
 */

public class ChatVO {
    private int imgID;
    private String name;
    private String msg;
    private String time;

    public ChatVO(){

    }

    public ChatVO(int imgID, String name, String msg, String time) {
        this.imgID = imgID;
        this.name = name;
        this.msg = msg;
        this.time = time;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
