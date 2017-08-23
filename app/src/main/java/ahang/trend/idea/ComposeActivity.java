package ahang.trend.idea;

import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import ahang.trend.R;

/**
 * Created by cwh on 16-8-24.
 */
public abstract class ComposeActivity extends AppCompatActivity {
	protected void setupActionBar() {
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null) {
			// Show the Up button in the action bar.
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
	}

	protected abstract void save();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_compose, menu);
		for (int i = 0; i < menu.size(); i++) {
			menu.getItem(i).getIcon().setColorFilter(getResources().getColor(R.color.colorControlNormal), PorterDuff.Mode.SRC_ATOP);
		}
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.compose_ok:
				// save and finish
				save();
				super.onBackPressed();
				return true;
			case android.R.id.home:
				onBackPressed();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(R.string.compose_quit_text)
				.setNegativeButton(R.string.abort, null)
				.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						ComposeActivity.super.onBackPressed();
					}
				})
				.setTitle(R.string.quit_title)
				.show();
	}
}
