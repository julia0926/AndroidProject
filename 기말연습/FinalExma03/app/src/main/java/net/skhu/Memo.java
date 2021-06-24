package net.skhu;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Memo {
    String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    public Memo(String title, int id) {
        this.title = title;
        this.id =id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

