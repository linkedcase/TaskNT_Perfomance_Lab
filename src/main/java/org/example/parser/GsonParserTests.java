package org.example.parser;

import com.google.gson.Gson;
import org.example.model.tests.RootTests;

import java.io.FileReader;

public class GsonParserTests {

    public RootTests parse(String fileTests){
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(fileTests)) {
            RootTests rootTests = gson.fromJson(reader, RootTests.class);

            return rootTests;
        } catch (Exception e) {
            System.out.println("Parsing error " + e);
        }
        return null;
    }
}

