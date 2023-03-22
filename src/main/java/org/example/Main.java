package org.example;

import java.io.IOException;
import java.util.HashMap;

import static org.example.INIFileComparator.compareINIFiles;
import static org.example.JsonFile.readJsonFile;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
       // System.out.println(compareINIFiles(System.getProperty("user.dir") + "\\fil1.ini", System.getProperty("user.dir") + "\\fil2.ini"));
        System.out.println(readJsonFile(System.getProperty("user.dir") + "\\file.json"));

    }


}