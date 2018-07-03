package com.testfan.pool;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSynchronized {
	


	//全局变量，多线程同时操作，会出现脏读，写问题
	private static int a=0;
	
	private static void threadTest() { 
		Lock lock = new ReentrantLock();
	    for (int i = 0; i < 10; i++) {  
	        new Thread() {  
	            public void run() {
	            	synchronized ("") { 
	                a++;  
	                try {  
	                    Thread.sleep(1);  
	                } catch (InterruptedException e) {  
	                    e.printStackTrace();  
	                }
	                System.out.println("plus:" + Thread.currentThread().getName() + ": " + a);  
	             }
	            }
	        }.start();  
	    }  
	} 
	
	public static void main(String[] args) {
		threadTest();
	
	}
	

}
