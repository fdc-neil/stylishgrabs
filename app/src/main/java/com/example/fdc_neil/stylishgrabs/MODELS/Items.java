package com.example.fdc_neil.stylishgrabs.MODELS;

public class Items {

    private Integer image;
    private String imageTitle;

    public Items(){

    }

    public Items(Integer image, String imageTitle) {
        this.image = image;
        this.imageTitle = imageTitle;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

}
