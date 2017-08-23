package ahang.trd.util;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

/**
 * Created by cwh on 2017/8/22.
 */

public class TelUtil {

    public static void call(String telnum, Context context) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
                + telnum));
        try {
            context.startActivity(intent);
        } catch (SecurityException se) {
            Log.e("For you", "call permission refused");
        }
    }
}
