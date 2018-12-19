package com.mltech.brite.util;

public class JoinExample {
	public static void main(String[] args) throws InterruptedException {
		//任务1
		Thread t = new Thread(new Runnable() {
			public void run() {
				System.out.println("First task started");
				System.out.println("Sleeping for 2 seconds");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("First task completed");
			}
		});
		//任务2
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Second task completed");
			}
		});
		
		
		t.start(); 
		t.join(); 
		t1.start();
		System.out.println("main method run over");
	}
}
