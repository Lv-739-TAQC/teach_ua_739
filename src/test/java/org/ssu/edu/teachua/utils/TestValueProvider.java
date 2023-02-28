package org.ssu.edu.teachua.utils;

import java.io.*;
import java.nio.file.Paths;
import java.util.Properties;

public class TestValueProvider {
    private final Properties properties;

    public TestValueProvider() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/data.properties");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        properties = new Properties();
        properties.load(inputStreamReader);
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
}
