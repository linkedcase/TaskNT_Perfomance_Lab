package org.example.model.tests;

import java.util.ArrayList;

public class Value {
    public int id;
    public String title;
    public String value;
    public ArrayList<Value> values;

    public Value(int id, String title, String value) {
        this.id = id;
        this.title = title;
        this.value = value;
//        this.values = values;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }

    public ArrayList<Value> getValues() {
        return values;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setValues(ArrayList<Value> values) {
        this.values = values;
    }
}
