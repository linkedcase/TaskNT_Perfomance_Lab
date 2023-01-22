package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    // Circle coordinates and radius
    static float x_circle;
    static float y_circle;
    static int radius;

    // Points coordinates
    static float x_point;
    static float y_point;

    public static void main(String[] args) {
        String file_1;
        String file_2;

        if (args.length > 0) {
            file_1 = args[0];
            file_2 = args[1];
        } else {
            System.out.println("You not input arguments for method main in Task4");
            return;
        }

        BufferedReader test1 = null;
        BufferedReader test2 = null;

        List<String> coordinatesAndRadius = new ArrayList<>();
        List<String> points = new ArrayList<>();

        try {
            test1 = new BufferedReader(new FileReader(file_1));
            String lineTest1;
            while ((lineTest1 = test1.readLine()) != null) {
                coordinatesAndRadius.add(lineTest1);
            }

            test2 = new BufferedReader(new FileReader(file_2));
            String lineTest2;
            while ((lineTest2 = test2.readLine()) != null) {
                points.add(lineTest2);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                assert test1 != null;
                test1.close();
                assert test2 != null;
                test2.close();
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }

        getCoordinatesOfCircleInFloat(coordinatesAndRadius);

        for (String point : points) {
            char[] strToArray = point.toCharArray();
            x_point = Float.parseFloat(String.valueOf(strToArray[0]));
            y_point = Float.parseFloat(String.valueOf(strToArray[1]));

            int distance = getDistance();

            if (distance > radius) {
                System.out.print("2 /");
            } else if (distance < radius) {
                System.out.print("1 /");
            } else System.out.print("0 /");
        }
    }

    public static Integer getDistance() {
        float x = x_point - x_circle;
        float y = y_point - y_circle;
        float targetX = x * x;
        float targetY = y * y;
        float result = (float) Math.sqrt((targetX + targetY));

        return (int) result;
    }

    public static void getCoordinatesOfCircleInFloat(List<String> list) {
        char[] strToArray = list.get(0).toCharArray();
        x_circle = Float.parseFloat(String.valueOf(strToArray[0]));
        y_circle = Float.parseFloat(String.valueOf(strToArray[1]));
        radius = Integer.parseInt(list.get(1));
    }
}
