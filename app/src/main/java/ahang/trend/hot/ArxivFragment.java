package ahang.trend.hot;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import ahang.trend.R;

public class ArxivFragment extends BaseFragment {
	private WebView webView;
	public static ArxivFragment newInstance() {
		ArxivFragment fragment = new ArxivFragment();
		return fragment;
	}

	public static ArxivFragment newInstance(String param1, String param2) {
		ArxivFragment fragment = new ArxivFragment();
		return fragment;
	}

	public ArxivFragment() {
		super();
		// Required empty public constructor
	}

	@Override
	protected void initDom() {
		assert getView() != null;
		webView = (WebView)(getView().findViewById(R.id.wv_arxiv));
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
				handler.proceed();
			}
		});
	}

	@Override
	protected void initData() {
		super.initData();
	}

	@Override
	protected void bind() {
		webView.loadUrl("http://arxiv.org/list/cs.NE/recent");
	}

	@Override
	protected int createLayout() {
		return R.layout.fragment_arxiv;
	}
}
