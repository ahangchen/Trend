package ahang.trend.idea;

import android.os.Bundle;
import android.widget.EditText;

import ahang.trd.util.SpUtil;

import ahang.trend.R;

import static ahang.trend.idea.Preference.IDEA_KEY;

public class ComposeIdeaActivity extends ComposeActivity {
	EditText ideaEditor;

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
		ideaEditor = (EditText)findViewById(R.id.idea);
		ideaEditor.setText(SpUtil.getString(IDEA_KEY, this));

	}


	@Override
	protected void save() {
		SpUtil.putString(IDEA_KEY, ideaEditor.getText().toString(), this);
	}
}
