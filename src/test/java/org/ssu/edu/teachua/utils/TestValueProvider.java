package org.ssu.edu.teachua.utils;

import java.io.*;
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
}
