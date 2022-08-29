package com.company.chatterbook.models;

import org.springframework.web.bind.annotation.*;

public class ChatterPost {
    public String text;

    public String getText() {
        return text;
    }

    public ChatterPost(String text) {
        this.text = text;
    }
}
