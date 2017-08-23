package ahang;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by cwh on 2017/8/23.
 */

public class Foryou extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "1900b216c2", false);
    }
}
