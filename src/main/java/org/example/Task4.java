package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Task4 {
    public static void main(String[] args) throws IOException {
        String file;

        if (args.length > 0) {
            file = args[0];
        } else {
            System.out.println("You not input arguments for method main in Task4");
            return;
        }

        System.out.println(file);
        BufferedReader reader = null;
        ArrayList<String> list = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException var4) {
            System.out.println("Error: " + var4);
        }

        if (reader != null) {
            reader.close();
        }

        System.out.println(getCountOfMoves(list));
    }

    public static Integer getCountOfMoves(List<String> list) {
        ArrayList<Integer> listOfNumbers = new ArrayList<>();
        int sum = 0;

        int number;
        for (Iterator<String> var3 = list.iterator(); var3.hasNext(); sum += number) {
            String item = var3.next();
            number = Integer.parseInt(item);
            listOfNumbers.add(number);
        }

        int averageValue = sum / list.size();
        int countOfMoves = 0;

        int delta;
        for (Iterator<Integer> var10 = listOfNumbers.iterator(); var10.hasNext(); countOfMoves += Math.abs(delta)) {
            Integer item = var10.next();
            delta = item - averageValue;
        }
        return countOfMoves;
    }
}
