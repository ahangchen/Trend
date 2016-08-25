package ahang.trend.setting;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.SwitchPreferenceCompat;

import ahang.trend.R;

/**
 * Created by cwh on 16-8-25
 */


public class SettingsFragment extends PreferenceFragmentCompat {

	@VisibleForTesting
	protected SharedPreferences.OnSharedPreferenceChangeListener mListener;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Preferences.sync(getPreferenceManager());
	}

	@Override
	public void onCreatePreferences(Bundle bundle, String s) {
		addPreferencesFromResource(R.xml.pref_v7);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
			@Override
			public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
				Preferences.sync(getPreferenceManager(), key);
			}
		};
	}

	@Override
	public void onResume() {
		super.onResume();
		getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(mListener);
	}

	@Override
	public void onPause() {
		getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(mListener);
		super.onPause();
	}
}