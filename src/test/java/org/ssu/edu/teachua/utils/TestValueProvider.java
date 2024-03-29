package org.ssu.edu.teachua.utils;

import java.io.FileInputStream;
import java.io.IOException;
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

    public String getLeadEmail() {
        return properties.getProperty("leadEmail");
    }

    public String getLeadPassword() {
        return properties.getProperty("leadPassword");
    }

    public String getUserEmail() {
        return properties.getProperty("userEmail");
    }

    public String getUserPassword() {
        return properties.getProperty("userPassword");
    }

    public String getBaseUiUrl() {
        return properties.getProperty("baseUiUrl");
    }

    public String getDbUrl() {
        return properties.getProperty("dbUrl");
    }

    public String getDbUserName() {
        return properties.getProperty("dbUserName");
    }

    public String getUDbUserPassword() {
        return properties.getProperty("dbUserPassword");
    }

    public String getFilePath(String fileName) {
        return Paths.get(Paths.get(System.getProperty("user.dir")).toString(),
                "src", "test", "resources", fileName).toString();
    }
}
