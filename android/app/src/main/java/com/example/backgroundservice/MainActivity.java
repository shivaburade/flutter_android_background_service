package com.example.backgroundservice;

import android.content.Intent;

import androidx.annotation.NonNull;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {

    @Override
    public void configureFlutterEngine(@NonNull @org.jetbrains.annotations.NotNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), "backgroundservice").setMethodCallHandler(
                ((call, result) -> {

                    if(call.method.equals("start")){
                        //start Service.
                        Intent i = new Intent(getApplicationContext() ,testservice.class);
                        startService(i);
                    }

                    result.success(1);

                })
        );
    }
}
