package com.jst;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ListFiles {
    public static void main(String[] args) {
        //String folderPath = "D:/JST Videos/PPT Abbrivations";
        //String folderPath = "D:\\JST Videos\\Videos";
        //String folderPath = "D:\\JST Videos\\TN Images";
        String folderPath = "D:\\JST Videos\\Final Videos";
        File folder = new File(folderPath);

        if (folder.isDirectory()) {
            // Method 1: Using listFiles()
            File[] files = folder.listFiles();
            if (files != null) {
                System.out.println("Files in Folder using listFiles Method :");
                for (File file : files) {
                    if (file.isFile()) {
                        //System.out.println(file.getName());
                    }
                }
            }

            // Method 2: Using Files.list (Java 8 and above)
            System.out.println("\nFiles in Folder using Files.list Method :");
            try (Stream<Path> stream = Files.list(Paths.get(folderPath))) {
                stream.filter(Files::isRegularFile)
                      .map(Path::getFileName)
                      .forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("The specified path is not a directory.");
        }
    }
}
