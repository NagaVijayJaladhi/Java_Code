package com.jst;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		return "Task Completed ";
	}
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Callable<String> callable = new MyCallable();
		Future<String> future = executorService.submit(callable);
		try {
			String result = future.get();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		executorService.shutdown();
	}

}
