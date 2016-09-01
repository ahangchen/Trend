package ahang.trend.hot;

import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import ahang.trend.R;
import ahang.trend.about.AboutActivity;
import ahang.trend.about.FeedbackActivity;
import ahang.trend.adapter.ViewPagerAdapter;
import ahang.trend.idea.ComposeIdeaActivity;
import ahang.trend.idea.IdeasFragment;
import ahang.trend.setting.SettingActivity;
import ahang.trd.util.ActivityUtil;

public class MainActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener,
		BaseFragment.OnFragmentInteractionListener {
	private Toolbar toolbar;
	private DrawerLayout drawer;
	private NavigationView navigationView;
	private ViewPager viewPager;
	private TabLayout tabLayout;

	private void initViewPager() {
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
		adapter.addFragment(GithubTrendFragment.newInstance(), getString(R.string.github));
		adapter.addFragment(ArxivFragment.newInstance(), getString(R.string.arxiv));
		adapter.addFragment(IdeasFragment.newInstance(), getString(R.string.ideas));
		viewPager.setAdapter(adapter);
	}

	private void initTabs() {
		tabLayout = (TabLayout) findViewById(R.id.tabs);
		assert tabLayout != null;
		tabLayout.setupWithViewPager(viewPager);
	}

	private void initData() {
		SharedPreferences sps = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String userName = sps.getString(getString(R.string.pref_user_name_key), getString(R.string.pref_default_user_name));
		String userEmail = sps.getString(getString(R.string.pref_user_email_key), getString(R.string.pref_default_user_email));
		((TextView)navigationView.getHeaderView(0).findViewById(R.id.nav_header_user_name)).setText(userName);
		((TextView)navigationView.getHeaderView(0).findViewById(R.id.nav_header_user_email)).setText(userEmail);
	}

	private void init() {
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawer.setDrawerListener(toggle);
		toggle.syncState();

		navigationView = (NavigationView) findViewById(R.id.nav_view);
		assert navigationView != null;
		navigationView.setNavigationItemSelectedListener(this);
		initViewPager();
		initTabs();
	}

	private boolean closeDrawer() {
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
			return true;
		} else {
			return false;
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
	}

	@Override
	protected void onResume() {
		super.onResume();
		initData();
	}

	@Override
	public void onBackPressed() {
		if (!closeDrawer()) {
			super.onBackPressed();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		for (int i = 0; i < menu.size(); i++) {
			menu.getItem(i).getIcon().setColorFilter(getResources().getColor(R.color.colorControlNormal), PorterDuff.Mode.SRC_ATOP);
		}
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.action_note:
				ActivityUtil.to(MainActivity.this, ComposeIdeaActivity.class);
				return true;
		}
		return super.onOptionsItemSelected(item);
	}


	@Override
	public boolean onNavigationItemSelected(MenuItem item) {
		// Handle navigation view item clicks here.
		switch (item.getItemId()) {
			case R.id.nav_favour:
				ActivityUtil.to(MainActivity.this, FavourActivity.class);
				break;
			case R.id.nav_setting:
				ActivityUtil.to(MainActivity.this, SettingActivity.class);
				break;
			case R.id.nav_about:
				ActivityUtil.to(MainActivity.this, AboutActivity.class);
				break;
			case R.id.nav_share:

				break;
			case R.id.nav_feedback:
				ActivityUtil.to(MainActivity.this, FeedbackActivity.class);
				break;
		}

		drawer.closeDrawer(GravityCompat.START);
		return true;
	}

	@Override
	public void onFragmentInteraction(Uri uri) {

	}

}
