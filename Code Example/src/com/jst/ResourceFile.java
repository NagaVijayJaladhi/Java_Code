package com.jst;

import java.io.File;
import java.net.URL;

public class ResourceFile {

    public static void main(String[] args) {
        String filename = "my_resource_file.txt";

        ClassLoader classLoader = ResourceFile.class.getClassLoader();
        URL resourceUrl = classLoader.getResource(filename);

        if (resourceUrl != null) {
            File file = new File(resourceUrl.getFile());
            String fileName = file.getName();
            System.out.println("File name: " + fileName);
        } else {
            System.out.println("Resource file not found: " + filename);
        }
    }
}
