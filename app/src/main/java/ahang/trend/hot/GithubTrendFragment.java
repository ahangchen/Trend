package ahang.trend.hot;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import ahang.trend.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GithubTrendFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GithubTrendFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GithubTrendFragment extends BaseFragment {

	private WebView webView;
	public static GithubTrendFragment newInstance() {
		GithubTrendFragment fragment = new GithubTrendFragment();
		return fragment;
	}

	public static GithubTrendFragment newInstance(String param1, String param2) {
		GithubTrendFragment fragment = new GithubTrendFragment();
		return fragment;
	}

	public GithubTrendFragment() {
		super();
		// Required empty public constructor
	}

	@Override
	protected void initDom() {
		assert getView() != null;
		webView = (WebView)(getView().findViewById(R.id.wv_github));
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
				//handler.cancel(); 默认的处理方式，WebView变成空白页
				handler.proceed();
			}
		});
	}

	@Override
	protected int createLayout() {
		return R.layout.fragment_github_trend;
	}

	@Override
	protected void initData() {
		super.initData();
	}

	@Override
	protected void bind() {
		webView.loadUrl("https://github.com/trending");
	}
}
