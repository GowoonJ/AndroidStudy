package org.gowoon.android_study_hw_0715;

public class RecyclerModel {
    private String title;
    private String aurthor;

    public RecyclerModel(String title, String aurthor){
        this.title = title;
        this.aurthor = aurthor;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(){
        this.title = title;
    }

    public String getAurthor(){
        return aurthor;
    }

    public void setAurthor(String aurthor){
        this.aurthor = aurthor;
    }

}
