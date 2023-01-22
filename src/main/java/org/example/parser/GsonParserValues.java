package org.example.parser;

import com.google.gson.Gson;
import org.example.model.values.RootValues;

import java.io.FileReader;

public class GsonParserValues {

    public RootValues parse(String fileValues){
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(fileValues)){
            RootValues rootValues = gson.fromJson(reader, RootValues.class);

            return rootValues;
        } catch (Exception e){
            System.out.println("Parsing error " + e);
        }
        return null;
    }
}
