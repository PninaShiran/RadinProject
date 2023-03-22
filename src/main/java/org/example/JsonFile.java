package org.example;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class JsonFile {
    /**
     * Reads a JSON file and returns a List of HashMaps.
     * Each HashMap contains key-value pairs where the keys are the field names and the values are the field values.
     *
     * @param filePath The path of the JSON file to read.
     * @return A List of HashMaps containing the data from the JSON file.
     */
    public static List<HashMap<String, String>> readJsonFile(String filePath) {
        List<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            JSONArray jsonArray = (JSONArray) obj;

            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                HashMap<String, String> dataMap = new HashMap<String, String>();

                for (Object key : jsonObject.keySet()) {
                    Object value = jsonObject.get(key);
                    if (!(value instanceof JSONObject) && !(value instanceof JSONArray)) {
                        dataMap.put(key.toString(), value.toString());
                    }
                }
                dataList.add(dataMap);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }

}
