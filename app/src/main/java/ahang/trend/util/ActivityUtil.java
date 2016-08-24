package ahang.trend.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;

import ahang.trend.R;

/**
 * Created by cwh on 16-2-3
 */
public class ActivityUtil {
	public static void to(Context context, Class<?> toClass) {
		Intent intent = new Intent();
		intent.setClass(context, toClass);
		context.startActivity(intent);
	}

	public static void animTo (Activity activity, Class<?> toClass, int enterAnim, int exitAnim) {
		Intent intent = new Intent();
		intent.setClass(activity, toClass);
		activity.startActivity(intent);
		activity.overridePendingTransition(enterAnim, exitAnim);
	}

	public static void slideToLeft(Activity activity, Class<?> toClass) {
		Intent intent = new Intent();
		intent.setClass(activity, toClass);
		activity.startActivity(intent);
		activity.overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
	}

	public static void slideToLeftWith(Activity activity, Class<?> toClass, String key, Serializable obj) {
		Intent intent = new Intent();
		intent.setClass(activity, toClass);
		Bundle bundle = new Bundle();
		bundle.putSerializable(key, obj);
		intent.putExtras(bundle);
		activity.startActivity(intent);
		activity.overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
	}


	public static void toWith(Context context, Class<?> toClass, String key, Serializable obj) {
		Intent intent = new Intent();
		intent.setClass(context, toClass);
		Bundle bundle = new Bundle();
		bundle.putSerializable(key, obj);
		intent.putExtras(bundle);
//        int id =((IdObj)bundle.getSerializable("  ")).getId();
		context.startActivity(intent);
	}

	public static void toWithFor(Activity activity, Class<?> toClass, String key, Serializable obj, int requestCode) {
		Intent intent = new Intent();
		intent.setClass(activity, toClass);
		Bundle bundle = new Bundle();
		bundle.putSerializable(key, obj);
		intent.putExtras(bundle);
//        int id =((IdObj)bundle.getSerializable("  ")).getId();
		activity.startActivityForResult(intent, requestCode);
	}

	public static void sysGallery(Context context, int resultCode) {
		Intent i = new Intent(
				Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		((Activity) context).startActivityForResult(i, resultCode);
	}

	public static View getRootView(Activity context) {
		return ((ViewGroup) context.findViewById(android.R.id.content)).getChildAt(0);
	}

	public static Intent getBundleIntent(Bundle bundle) {
		Intent intent = new Intent();
		intent.putExtras(bundle);
		return intent;
	}

	public static Bundle getSingleObjectBundle(String key, Serializable obj) {
		Bundle bundle = new Bundle();
		bundle.putSerializable(key, obj);
		return bundle;
	}

	public static void setActivityResult(Context context, int requestCode, String key, Serializable obj) {
		Intent intent = getBundleIntent(getSingleObjectBundle(key, obj));
		((Activity) context).setResult(requestCode, intent);
	}
}
