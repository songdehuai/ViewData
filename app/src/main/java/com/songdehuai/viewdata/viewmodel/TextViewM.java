package com.songdehuai.viewdata.viewmodel;

/**
 * TextView实体类
 * Created by songd on 2017/4/10.
 */

public class TextViewM {

    private String TEXT;
    private String TEXT_COLOR;
    private String TEXT_SIZE;
    private String BG_COLOR;
    private String TEXT_ALIGN;

    public void setTEXT(String TEXT) {
        this.TEXT = TEXT;
    }

    public void setTEXT_COLOR(String TEXT_COLOR) {
        this.TEXT_COLOR = TEXT_COLOR;
    }

    public void setTEXT_SIZE(String TEXT_SIZE) {
        this.TEXT_SIZE = TEXT_SIZE;
    }

    public void setBG_COLOR(String BG_COLOR) {
        this.BG_COLOR = BG_COLOR;
    }

    public void setTEXT_ALIGN(String TEXT_ALIGN) {
        this.TEXT_ALIGN = TEXT_ALIGN;
    }

    public String getTEXT() {
        return TEXT;
    }

    public String getTEXT_COLOR() {
        return TEXT_COLOR;
    }

    public String getTEXT_SIZE() {
        return TEXT_SIZE;
    }

    public String getBG_COLOR() {
        return BG_COLOR;
    }

    public String getTEXT_ALIGN() {
        return TEXT_ALIGN;
    }
}
