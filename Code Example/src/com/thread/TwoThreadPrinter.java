package com.thread;

public class TwoThreadPrinter {
	public static void main(String[] args) {
		NumberPrinter numberPrinter = new NumberPrinter();

		Thread oddThread = new Thread(() -> {
			try {
				numberPrinter.printOdd();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}, "OddThread");

		Thread evenThread = new Thread(() -> {
			try {
				numberPrinter.printEven();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}, "EvenThread");

		oddThread.start();
		evenThread.start();

		try {
			oddThread.join();
			evenThread.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		System.out.println("Printing completed.");
	}
}
