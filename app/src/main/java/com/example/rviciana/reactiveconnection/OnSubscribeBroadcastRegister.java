package com.example.rviciana.reactiveconnection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposables;

public class OnSubscribeBroadcastRegister implements ObservableOnSubscribe<Intent> {

    private final Context context;
    private final IntentFilter intentFilter;

    public OnSubscribeBroadcastRegister(Context context, IntentFilter intentFilter) {
        this.context = context;
        this.intentFilter = intentFilter;
    }

    @Override
    public void subscribe(final ObservableEmitter<Intent> emitter) throws Exception {
        final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                emitter.onNext(intent);
            }
        };

        emitter.setDisposable(Disposables.fromRunnable(() -> {
            if (context != null) {
                context.unregisterReceiver(broadcastReceiver);
            }
        }));

        if (context != null) {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}
