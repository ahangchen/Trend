package ahang.trd.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.http.SslError;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by cwh on 16-9-2.
 * for some usual need of webview
 */
public class BaseWebView extends WebView{


	public BaseWebView(Context context) {
		super(context);
		initWebView();
	}

	public BaseWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initWebView();
	}

	public BaseWebView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initWebView();
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	public BaseWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		initWebView();
	}

	public BaseWebView(Context context, AttributeSet attrs, int defStyleAttr, boolean privateBrowsing) {
		super(context, attrs, defStyleAttr, privateBrowsing);
		initWebView();
	}

	private void initWebView() {
		setWebViewClient(new WebViewClient() {
			@Override
			public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
				//handler.cancel(); 默认的处理方式，WebView变成空白页
				handler.proceed();
			}
		});
	}
}
