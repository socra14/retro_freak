package com.socra.socra.retro_freak.clases;

import android.app.Application;
import android.os.SystemClock;

public class config extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        SystemClock.sleep(2000);
    }
}
