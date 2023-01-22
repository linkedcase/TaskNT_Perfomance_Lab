package org.example.model.tests;



import java.util.ArrayList;

public class Test {
    public int id;
    public String title;
    public String value;
    public ArrayList<Value> values;

    public int getId(){return id;}

    public String getTitle(){return title;}

    public String getValue(){return value;}

    public ArrayList<Value> getValues(){return values;}

    public Test(String value){ this.value = value;}

    public void setValues(ArrayList<Value> values) {
        this.values = values;
    }
}
