package com.example.spiiceapp;

public class OnboardingItem  {

    private int image;
    private String textView;
    private String description;

    public String getTextView(){

        return textView;
    }
    public void setTextView(String textView)
    {
        this.textView = textView;
    }

    public int getImage()
    {
        return image;
    }

    public void setImage(int image)
    {
        this.image = image;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
