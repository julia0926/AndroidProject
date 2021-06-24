package net.skhu;

public class Memo {
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Memo(String name, String number) {
        this.name = name;
        this.number = number;
    }

    String name;
    String number;



}

