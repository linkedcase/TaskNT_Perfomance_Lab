package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.model.tests.RootTests;
import org.example.model.tests.Test;
import org.example.model.values.RootValues;
import org.example.model.values.Value;
import org.example.parser.GsonParserTests;
import org.example.parser.GsonParserValues;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Task3 {
    public static void main(String[] args) {
        String fileTests;// = "tests.json";
        String fileValues;// = "values.json";

        if (args.length > 0) {
            fileTests = args[0];
            fileValues = args[1];
        } else {
            System.out.println("You not input arguments for method main in Task3");
            return;
        }

        GsonParserTests parserTests = new GsonParserTests();
        GsonParserValues parserValues = new GsonParserValues();

        RootTests rootTests = parserTests.parse(fileTests);
        RootValues rootValues = parserValues.parse(fileValues);

        ArrayList<Test> tests = rootTests.getTests();
        ArrayList<Value> values = rootValues.getValues();

        for (Test test : tests) {
            for (Value value : values) {
                if (test.id == value.id) {
                    test.value = value.value;
                }
            }
        }

        for (Test test : tests) {
            if (test.values != null) {
                for (org.example.model.tests.Value testSecond : test.values) {
                    for (Value value : values) {
                        if (testSecond.id == value.id) {
                            testSecond.value = value.value;
                        }
                    }
                }
            }
        }

        for (Test test : tests) {
            if (test.values != null) {
                for (org.example.model.tests.Value testSecond : test.values) {
                    if (testSecond.values != null) {
                        for (org.example.model.tests.Value testThird : testSecond.values) {
                            for (Value value : values) {
                                if (testThird.id == value.id) {
                                    testThird.value = value.value;
                                }

                                if (testThird.values != null) {
                                    for (org.example.model.tests.Value testFourth : testThird.values) {
                                        for (Value valueSecond : values) {
                                            if (testFourth.id == valueSecond.id) {
                                                testFourth.value = valueSecond.value;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        String path = "C:\\Users\\win10pro\\Documents\\report.json";

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(tests);
            out.write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(tests);
    }
}