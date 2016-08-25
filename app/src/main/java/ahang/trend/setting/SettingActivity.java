package ahang.trend.setting;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import ahang.trend.R;

public class SettingActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		setupActionBar();
	}
	private void setupActionBar() {
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null) {
			// Show the Up button in the action bar.
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				onBackPressed();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
