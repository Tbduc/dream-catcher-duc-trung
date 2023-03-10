package com.codecool.elproyectegrande1.dto;

import com.codecool.elproyectegrande1.entity.DreamStatus;

import java.util.List;

public class NewDreamDto {

    private String dreamTitle;
    private String dreamDescription;
    private DreamStatus dreamStatus;
    private List<String> hashtags;

    public NewDreamDto() {
    }

    public NewDreamDto(String dreamTitle, String dreamDescription, List<String> hashtags) {
        this.dreamTitle = dreamTitle;
        this.dreamDescription = dreamDescription;
        this.dreamStatus = DreamStatus.PRESENTING;
        this.hashtags = hashtags;
    }

    public String getDreamTitle() {
        return dreamTitle;
    }

    public void setDreamTitle(String dreamTitle) {
        this.dreamTitle = dreamTitle;
    }

    public String getDreamDescription() {
        return dreamDescription;
    }

    public void setDreamDescription(String dreamDescription) {
        this.dreamDescription = dreamDescription;
    }

    public DreamStatus getDreamStatus() {
        return dreamStatus;
    }

    public void setDreamStatus(DreamStatus dreamStatus) {
        this.dreamStatus = dreamStatus;
    }

    public List<String> getHashtags() {
        return hashtags;
    }
}

