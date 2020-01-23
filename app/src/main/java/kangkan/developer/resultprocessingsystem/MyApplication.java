package kangkan.developer.resultprocessingsystem;

import android.app.Application;

import com.onesignal.OneSignal;

public class MyApplication extends Application {

    private static MyApplication mInstance;
    // SharedPreferences.Editor prefEditor;


    public  MyApplication(){
        mInstance = this;
    }


    @Override
    public  void onCreate() {
        super.onCreate();
        mInstance = this;

        // OneSignal Initialization
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();

    }



    public static  synchronized  MyApplication getmInstance(){

        return mInstance;
    }

}

