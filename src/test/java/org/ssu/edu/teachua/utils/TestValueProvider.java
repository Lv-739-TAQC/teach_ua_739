package org.ssu.edu.teachua.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class TestValueProvider {

    private final static String PROPERTIES_PATH = "src/test/resources/data.properties";
    private final Properties properties;

    public TestValueProvider() {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(PROPERTIES_PATH);
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getAdminEmail() {
        return properties.getProperty("adminEmail");
    }

    public String getAdminPassword() {
        return properties.getProperty("adminPassword");
    }

    public String getBaseUiUrl() {
        return properties.getProperty("baseUiUrl");
    }

    public String getFilePath(String fileName) {
        return Paths.get(Paths.get(System.getProperty("user.dir")).toString(),
                "src", "test", "resources", fileName).toString();
    }

    public String getStringFromFile(String filePath) {
        try {
            Path fileName = Path.of(filePath);
            return Files.readString(fileName);
        } catch (IOException e) {
            System.out.println("File not found: " + e);
        }
        return filePath;
    }

}
