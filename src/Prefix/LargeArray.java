package Prefix;

import java.io.*;
import java.util.*;

public class LargeArray {
    public static int[] loadArray() {
        try (BufferedReader reader = new BufferedReader(new FileReader("large_array.txt"))) {
            String line = reader.readLine().trim(); // Read the entire line and trim spaces

            // Remove square brackets [ and ]
            line = line.substring(1, line.length() - 1);

            // Split the numbers by comma and trim spaces
            String[] numStrings = line.split(",");

            // Convert to int array
            int[] loadedArray = new int[numStrings.length];
            for (int i = 0; i < numStrings.length; i++) {
                loadedArray[i] = Integer.parseInt(numStrings[i].trim());
            }

            // Print first 10 numbers to confirm loading worked
            System.out.println("Loaded first 10 elements: " + Arrays.toString(Arrays.copyOf(loadedArray, 10)));

            return loadedArray;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new int[0]; // Return empty array if loading fails
    }
}
