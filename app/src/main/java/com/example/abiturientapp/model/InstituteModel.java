package com.example.abiturientapp.model;

public class InstituteModel {

    int id;
    String img, tittleEducation, dateEducation, programEducation, color, text;

    public InstituteModel(int id, String img, String tittleEducation, String dateEducation, String programEducation, String color, String text) {
        this.id = id;
        this.img = img;
        this.tittleEducation = tittleEducation;
        this.dateEducation = dateEducation;
        this.programEducation = programEducation;
        this.color = color;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTittleEducation() {
        return tittleEducation;
    }

    public void setTittleEducation(String tittleEducation) {
        this.tittleEducation = tittleEducation;
    }

    public String getDateEducation() {
        return dateEducation;
    }

    public void setDateEducation(String dateEducation) {
        this.dateEducation = dateEducation;
    }

    public String getProgramEducation() {
        return programEducation;
    }

    public void setProgramEducation(String programEducation) {
        this.programEducation = programEducation;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
