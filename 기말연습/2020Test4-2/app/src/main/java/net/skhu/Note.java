package net.skhu;

import java.io.Serializable;

public class Note implements Serializable {
    String text;

    public Note(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

