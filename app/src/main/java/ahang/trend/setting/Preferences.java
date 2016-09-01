package ahang.trend.setting;

import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceManager;

import java.util.Map;

public class Preferences {

	public static void sync(PreferenceManager preferenceManager) {
		Map<String, ?> map = preferenceManager.getSharedPreferences().getAll();
		for (String key : map.keySet()) {
			sync(preferenceManager, key);
		}
	}

	public static void sync(PreferenceManager preferenceManager, String key) {
		Preference pref = preferenceManager.findPreference(key);
		if (pref instanceof ListPreference) {
			ListPreference listPref = (ListPreference) pref;
			pref.setSummary(listPref.getEntry());
		} else if (pref instanceof EditTextPreference) {
			EditTextPreference editPref = (EditTextPreference) pref;
			pref.setSummary(editPref.getText());
		}
	}

}