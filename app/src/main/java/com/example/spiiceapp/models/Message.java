package com.example.spiiceapp.models;

public class Message {

    private String name;
    private String imageUrl;
    private String messageIntro;

    public Message( String name, String imageUrl, String messageIntro){
        this.name = name;
        this.imageUrl = imageUrl;
        this.messageIntro = messageIntro;
    }
    public Message(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMessageIntro() {
        return messageIntro;
    }

    public void setMessageIntro(String messageIntro) {
        this.messageIntro = messageIntro;
    }
}
