package com.example.firstplugin;

import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.PluginRegistry.Registrar;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.Intent;
import android.net.Uri;
import android.Manifest;

/** FirstPlugin */
public class FirstPlugin implements MethodCallHandler {
  /** Plugin registration. */
  private final Registrar mRegistrar;
  private static final int REQUEST_CALL_PHONE_PERMISSION = 123456;

  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "first_plugin");
    FirstPlugin instance = new FirstPlugin(registrar);
    channel.setMethodCallHandler(instance);
  }

  private FirstPlugin(Registrar registrar) {
    this.mRegistrar = registrar;
  }


//  public static void registerWith(Registrar registrar) {
//    final MethodChannel channel = new MethodChannel(registrar.messenger(), "first_plugin");
//    channel.setMethodCallHandler(new FirstPlugin());
//  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    int idActivity = call.argument("idActivity");

    Context context;
    if (mRegistrar.activity() != null) {
      context = (Context) mRegistrar.activity();
    } else {
      context = mRegistrar.context();
    }


    Intent launchIntent = new Intent(Intent.ACTION_MAIN);

    switch (idActivity){
      case 0:
        launchIntent.setClassName("com.hb.dialer.free", "com.hb.dialer.ui.PhoneActivity");
        break;
      case 1:
        launchIntent.setClassName("com.hb.dialer.free", "com.hb.dialer.ui.ShortcutStartActivity$Contacts");
        break;
      case 2:
        launchIntent.setClassName("com.hb.dialer.free", "com.hb.dialer.ui.ShortcutStartActivity$Favorites");
        break;
    }
    context.startActivity(launchIntent);
    //result.success(simId);

  }


}
