package com.example.mma;

public class Equation {
    private String type;
    private String form;

    public Equation() {
    }

    public Equation(String type, String form) {
        this.type = type;
        this.form = form;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }
}
