package com.daroz;


import com.daroz.db.utils.DB;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Program {

    public static void main(String[] args) {

        DB.openConnection();
        DB.closeConnection();
    }
}
