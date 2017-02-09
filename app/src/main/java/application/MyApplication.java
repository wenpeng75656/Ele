package application;

import android.app.Application;

import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * Created by asus on 2017/2/9.
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();
    }
}
