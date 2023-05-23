package com.mps.think.setup.utils;

import java.util.Timer;
import java.util.TimerTask;

public class ApiScheduler {
	public static void triggerCustomerInactive(){
        Timer timer = new Timer();
        String date = "2023-03-24";
        String time = "12:41:00";
        String dateTime = date + " " + time;
        TimerTask task = new TimerTask() {
            public void run() {
            	System.out.println("the code for testing api");
            }
        };
        timer.schedule(task, java.sql.Timestamp.valueOf(dateTime));
	}
	 public static void main(String[] args) {
		 ApiScheduler.triggerCustomerInactive();
	    }
}
