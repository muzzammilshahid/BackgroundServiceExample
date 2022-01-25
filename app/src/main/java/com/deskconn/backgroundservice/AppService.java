package com.deskconn.backgroundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import pk.codebase.requests.HttpRequest;

public class AppService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, " MyService Created ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, " MyService Started", Toast.LENGTH_SHORT).show();


        final Handler handler = new Handler();
        final int delay = 5000; // 1000 milliseconds == 1 second

        handler.postDelayed(new Runnable() {
            public void run() {
                HttpRequest request = new HttpRequest();
                request.setOnResponseListener(response -> {

                });

                request.setOnErrorListener(error -> {

                });

                request.get("http://192.168.10.10:5009/api/name");
                System.out.println("myHandler: here!");
                handler.postDelayed(this, delay);
            }
        }, delay);
        return START_STICKY;
    }
}

