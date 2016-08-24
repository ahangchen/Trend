package ahang.trend.idea;

import android.os.Bundle;
import android.view.MenuItem;

import ahang.trend.R;

public class ComposeIdeaActivity extends ComposeActivity {

	@Override
	protected void setupActionBar() {
		super.setupActionBar();
		if(getSupportActionBar() != null) {
			getSupportActionBar().setTitle(R.string.action_compose_idea);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compose_note);
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
