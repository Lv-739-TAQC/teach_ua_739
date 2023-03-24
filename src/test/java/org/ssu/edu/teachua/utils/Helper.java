package org.ssu.edu.teachua.utils;

import io.qameta.allure.Step;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

public class Helper {
    @Step("Check file size")
    public static int checkFileSize(String fileURL) {
        long actualFileSize = 0;
        try {
            URL url = new URL(fileURL);
            InputStream is = url.openStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = is.read(b)) != -1) {
                baos.write(b, 0, length);
            }
            is.close();
            byte[] actualImageData = baos.toByteArray();
            actualFileSize = actualImageData.length;
        } catch (Exception e) {
            e.printStackTrace();
        }
        double actualFileSizeInKB = actualFileSize / 1024.0;
        return (int) Math.round(actualFileSizeInKB);

    }

}
