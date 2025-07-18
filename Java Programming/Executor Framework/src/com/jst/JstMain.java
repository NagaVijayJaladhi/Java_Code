package com.jst;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class JstMain {
	
	public static void main(String[] args) {
		
		Task task = new Task("Jaladhi Soft Technology");
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		Future<String> future = executorService.submit(task);
		
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException ee) {
			System.out.println("Error Occurred while executing the submitted task");
			ee.printStackTrace();
		}
		executorService.shutdown();
	}

}
