package com.commonproject;

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.microsoft.codepush.react.CodePush;
import com.github.yamill.orientation.OrientationPackage;
import com.rnfingerprint.FingerprintAuthPackage;
import com.reactlibrary.RNSyanImagePickerPackage;
import com.swmansion.gesturehandler.react.RNGestureHandlerPackage;
import com.oblador.vectoricons.VectorIconsPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.react.rnspinkit.RNSpinkitPackage;
import android.content.Intent;
import android.content.res.Configuration;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {

        @Override
        protected String getJSBundleFile() {
        return CodePush.getJSBundleFile();
        }
    
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
            //第一个参数是刚刚申请的key（可以根据环境配置）
            //第三个参数是服务器的URL
            new CodePush("BDMXo3QZ1CpYlCFAhXiBhXmdYcMJ4ksvOXqog", MainApplication.this, BuildConfig.DEBUG,"http://47.93.31.98:3000/"),
            new OrientationPackage(),
            new FingerprintAuthPackage(),
            new RNSyanImagePickerPackage(),
            new RNGestureHandlerPackage(),
            new VectorIconsPackage(),
            new RNSpinkitPackage()
      );
    }

    @Override
    protected String getJSMainModuleName() {
      return "index";
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    Intent intent = new Intent("onConfigurationChanged");
    intent.putExtra("newConfig", newConfig);
    this.sendBroadcast(intent);
  }
}
