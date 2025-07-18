package com.thread;

class NumberPrinter {
	private int counter = 1;
	private final Object lock = new Object();

	public void printOdd() throws InterruptedException {
		synchronized (lock) {
			while (counter <= 100) {
				if (counter % 2 == 1) {
					System.out.println(Thread.currentThread().getName() + ": " + counter++);
					lock.notify();
					lock.wait();
				} else {
					lock.wait();
				}
			}
		}
	}

	public void printEven() throws InterruptedException {
		synchronized (lock) {
			while (counter <= 100) {
				if (counter % 2 == 0) {
					System.out.println(Thread.currentThread().getName() + ": " + counter++);
					lock.notify();
					lock.wait();
				} else {
					lock.wait();
				}
			}
		}
	}
}