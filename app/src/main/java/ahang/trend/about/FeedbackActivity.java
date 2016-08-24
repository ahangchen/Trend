package ahang.trend.about;

import android.os.Bundle;
import android.view.MenuItem;

import ahang.trend.R;
import ahang.trend.idea.ComposeActivity;

public class FeedbackActivity  extends ComposeActivity {

	@Override
	protected void setupActionBar() {
		super.setupActionBar();
		if(getSupportActionBar() != null) {
			getSupportActionBar().setTitle(R.string.feedback);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feedback);
		setupActionBar();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.compose_ok:
				// save
				break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void save() {

	}
}
