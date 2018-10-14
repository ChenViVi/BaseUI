package com.iwritebug.baseui.model;

/**
 * Created by vivi on 2016/8/10.
 */
public class BottomTab {
    private String title;
    private int imageIdEnable;
    private int imageIdInDisable;
    private int colorIdEnable;
    private int colorIdDisable;

    public BottomTab(String title, int imageIdInDisable, int imageIdEnable, int colorIdDisable, int colorIdEnable) {
        this.title = title;
        this.imageIdInDisable = imageIdInDisable;
        this.imageIdEnable = imageIdEnable;
        this.colorIdDisable = colorIdDisable;
        this.colorIdEnable = colorIdEnable;
    }

    public String getTitle() {
        return title;
    }

    public int getImageIdEnable() {
        return imageIdEnable;
    }

    public int getImageIdInDisable() {
        return imageIdInDisable;
    }

    public int getColorIdEnable() {
        return colorIdEnable;
    }

    public int getColorIdDisable() {
        return colorIdDisable;
    }
}
