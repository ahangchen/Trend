package ahang.trend.idea;

import android.net.http.SslError;
import android.support.v4.app.Fragment;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

import ahang.trd.util.SpUtil;
import ahang.trend.R;
import ahang.trend.hot.BaseFragment;

import static ahang.trend.idea.Preference.IDEA_KEY;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link IdeasFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link IdeasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IdeasFragment extends BaseFragment {
	private TextView ideas;
	public static IdeasFragment newInstance() {
		IdeasFragment fragment = new IdeasFragment();
		return fragment;
	}

	public static IdeasFragment newInstance(String param1, String param2) {
		IdeasFragment fragment = new IdeasFragment();
		return fragment;
	}

	public IdeasFragment() {
		super();
		// Required empty public constructor
	}


	@Override
	protected void initDom() {
		ideas = (TextView)getActivity().findViewById(R.id.idea);
	}

	@Override
	protected int createLayout() {
		return R.layout.fragment_ideas;
	}

	@Override
	protected void initData() {
	}

	@Override
	protected void bind() {
		ideas.setText(SpUtil.getString(IDEA_KEY, getActivity()));
	}
}
