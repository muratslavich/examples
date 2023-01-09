package com.prot.example;

public class Thing {

    private final OtherThing composition;

    public Thing(OtherThing otherThing) {
        composition = otherThing;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "composition=" + composition +
                '}';
    }
}
