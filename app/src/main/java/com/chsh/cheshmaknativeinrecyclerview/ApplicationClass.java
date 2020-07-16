package com.chsh.cheshmaknativeinrecyclerview;

import android.app.Application;
import android.util.Log;

import me.cheshmak.android.sdk.core.Cheshmak;
import me.cheshmak.android.sdk.core.network.CheshmakCallback;
import me.cheshmak.cheshmakplussdk.core.CheshmakPlus;

public class ApplicationClass extends Application {


    @Override
    public void onCreate() {

        super.onCreate();


        Cheshmak.with(ApplicationClass.this);
        CheshmakPlus.with(ApplicationClass.this);
        Cheshmak.initTracker("APP_KEY", new CheshmakCallback() { //APP_KEY from your panel
            @Override
            public void onCheshmakIdReceived(String cheshmakID) {
                Log.e("----------", "CheshmakID = " + cheshmakID);
            }
        });
        CheshmakPlus.setTestMode(true);
    }


}
