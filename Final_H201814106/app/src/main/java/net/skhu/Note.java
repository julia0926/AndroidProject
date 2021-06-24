package net.skhu;

import java.io.Serializable;

public class Note implements Serializable {

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Note(String header, String body) {
        this.header = header;
        this.body = body;
    }

    String header,body;

}
