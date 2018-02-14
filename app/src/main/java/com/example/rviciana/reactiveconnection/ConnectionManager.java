package com.example.rviciana.reactiveconnection;

import android.content.Context;
import android.widget.Toast;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class ConnectionManager {

    private Context context;
    public boolean hasConnection;

    public ConnectionManager(Context context) {
        this.context = context;
    }

    public void initRxNetwork() {
        RxNetwork.stream(context)
                .map(hasConn -> {
                    hasConnection = hasConn;
                    if (!hasConn) {
                        return hasConn;
                    }
                    return true;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(isOnline -> {
                    if (!isOnline) {
                        Toast.makeText(context, "Connection is disabled", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Connection is enabled!", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
