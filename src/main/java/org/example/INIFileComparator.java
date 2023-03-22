package org.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * A class for comparing two INI files and identifying differences in their key-value pairs.
 */
public class INIFileComparator {
    /**
     * Compares two INI files and returns a HashMap containing the differences between the files.
     *
     * @param filePath1 The path of the first INI file to compare.
     * @param filePath2 The path of the second INI file to compare.
     * @return A HashMap<String, List<String>> containing the differences between the files.
     * @throws IOException If there is an error reading the INI files.
     */
    public static HashMap<String, List<String>> compareINIFiles(String filePath1, String filePath2) throws IOException {
        BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
        BufferedReader reader2 = new BufferedReader(new FileReader(filePath2));

        String line1 = reader1.readLine();
        String line2 = reader2.readLine();

        HashMap<String, List<String>> diffMap = new HashMap<>();

        while (line1 != null || line2 != null) {
            if (line1 != null && line1.contains("=")) {
                String[] parts1 = line1.split("=", 2);
                String key1 = parts1[0];
                String value1 = parts1[1];

                String value2 = "";

                while (line2 != null && !line2.contains(key1)) {
                    line2 = reader2.readLine();
                }

                if (line2 != null && line2.contains(key1)) {
                    String[] parts2 = line2.split("=", 2);
                    value2 = parts2[1];
                    line2 = reader2.readLine();
                }

                if (!value1.equals(value2)) {
                    List<String> values = new ArrayList<>();
                    values.add(value1);
                    values.add(value2);
                    diffMap.put(key1, values);
                }
            }

            line1 = reader1.readLine();
        }

        reader1.close();
        reader2.close();

        return diffMap;
    }
}

