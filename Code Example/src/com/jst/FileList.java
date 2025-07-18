package com.jst;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileList {

	public static void main(String[] args) {
		String ppt = "D:/JST Videos/PPT Abbrivations";
		String video = "D:\\JST Videos\\Videos";
		String image = "D:\\JST Videos\\TN Images";
		String finalv = "D:\\JST Videos\\Final Videos";

		List<String> pptList = new ArrayList<>();
		List<String> videoList = new ArrayList<>();
		List<String> imageList = new ArrayList<>();
		List<String> finalList = new ArrayList<>();

		File pptFolder = new File(ppt);
		File videoFolder = new File(video);
		File imageFolder = new File(image);
		File finalFolder = new File(finalv);

		// Get PPT File Names
		if (pptFolder.isDirectory()) {
			File[] files = pptFolder.listFiles();
			if (files != null) {
				for (File file : files) {
					if (file.isFile()) {
						int value = file.getName().length();
						pptList.add(file.getName().substring(0, value - 5));
					}
				}
			}
		} else {
			System.out.println("The specified path is not a directory.");
		}

		// Get Video File Names
		if (videoFolder.isDirectory()) {
			File[] files = videoFolder.listFiles();
			if (files != null) {
				for (File file : files) {
					if (file.isFile()) {
						int value = file.getName().length();
						videoList.add(file.getName().substring(0, value - 4));
					}
				}
			}
		} else {
			System.out.println("The specified path is not a directory.");
		}

		// Get Image File Names
		if (imageFolder.isDirectory()) {
			File[] files = imageFolder.listFiles();
			if (files != null) {
				for (File file : files) {
					if (file.isFile()) {
						int value = file.getName().length();
						imageList.add(file.getName().substring(0, value - 4));
					}
				}
			}
		} else {
			System.out.println("The specified path is not a directory.");
		}

		// Get Final Video File Names
		if (finalFolder.isDirectory()) {
			File[] files = finalFolder.listFiles();
			if (files != null) {
				for (File file : files) {
					if (file.isFile()) {
						int value = file.getName().length();
						finalList.add(file.getName().substring(0, value - 4));
					}
				}
			}
		} else {
			System.out.println("The specified path is not a directory.");
		}

		System.out.println("PPT Files List : " + pptList);
		System.out.println("Video Files List : " + videoList);
		System.out.println("Image Files List : " + imageList);
		System.out.println("Final Video Files List : " + finalList);
		
		
		List<String> pptVideo = pptList.stream().filter(ele -> !videoList.contains(ele)).collect(Collectors.toList());
		System.out.println("Display Finding Difference List 1 & 2 : " + pptVideo);

		List<String> videoImage = videoList.stream().filter(ele -> !imageList.contains(ele)).collect(Collectors.toList());
		System.out.println("Display Finding Difference List 2 & 3 : " + videoImage);
		
		List<String> imageFinal = imageList.stream().filter(ele -> !finalList.contains(ele)).collect(Collectors.toList());
		System.out.println("Display Finding Difference List 3 & 4 : " + imageFinal);
	}

}
