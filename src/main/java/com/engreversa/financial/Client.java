package com.engreversa.financial;

public class Client {
    private final int type;
    private final boolean statusPartial;

    public Client(int type, boolean statusPartial) {
        this.type = type;
        this.statusPartial = statusPartial;
    }

    public int getType() {
        return this.type;
    }

    public boolean isStatusPartial() {
        return this.statusPartial;
    }
}
