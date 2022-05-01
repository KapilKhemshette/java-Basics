package com.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
	public static int counter=0;
	static Lock lock=new ReentrantLock();
	public static void main(String[] args) {
		Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {
				lock.lock();
				try {
					for(int i=1;i<=1000;i++) {
						ReentrantLockDemo.counter++;}
					}
					finally {
						lock.unlock();
						}				
				
			
			}});
		Thread t2=new Thread(new Runnable() {

			@Override
			public void run() {
				lock.lock();
				try{for(int i=1;i<=1000;i++) {
					ReentrantLockDemo.counter++;
				}}finally {
				lock.unlock();}
				
			}
				
				
			});
		t1.start();
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("the value of counter:"+counter);
	}

}
