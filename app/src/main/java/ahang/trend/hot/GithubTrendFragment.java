package ahang.trend.hot;

import android.Manifest;
import android.app.PendingIntent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.tencent.bugly.crashreport.CrashReport;

import ahang.trd.util.GPSUtil;
import ahang.trd.util.MsgUtil;
import ahang.trd.util.TelUtil;
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
    private LinearLayout urgentButton;
    private PendingIntent sendIntent, backIntent;

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
        urgentButton = getActivity().findViewById(R.id.urgent_button);
    }

    @Override
    protected int createLayout() {
        return R.layout.fragment_github_trend;
    }

    @Override
    protected void initData() {

        super.initData();
        PendingIntent[] intents = MsgUtil.registerMsg(getActivity());
        sendIntent = intents[0];
        backIntent = intents[1];
    }

    @Override
    protected void bind() {

        urgentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                CrashReport.testJavaCrash();
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.SEND_SMS)
                        != PackageManager.PERMISSION_GRANTED ||
                        ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE)
                                != PackageManager.PERMISSION_GRANTED ||
                        ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
                                != PackageManager.PERMISSION_GRANTED ||
                        ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                                != PackageManager.PERMISSION_GRANTED
                        ) {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.SEND_SMS,
                                    Manifest.permission.CALL_PHONE,
                                    Manifest.permission.ACCESS_COARSE_LOCATION,
                                    Manifest.permission.ACCESS_FINE_LOCATION
                    }, URGENT_REQUEST_CODE);
                } else {
                    afterGrant();
                }
            }
        });
    }

    protected String getUrgentMsg(double latitude, double longitude) {
        SharedPreferences sps = PreferenceManager.getDefaultSharedPreferences(getActivity());
        Boolean urgentMsg = sps.getBoolean(getString(R.string.pref_urgent_gps), true);

        return "测试" + (urgentMsg ? "位置：" + latitude + ", " + longitude : "");
    }

    public static final int URGENT_REQUEST_CODE = 0;
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case URGENT_REQUEST_CODE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    afterGrant();

                } else {
                    afterRefuse();
                }
                break;
            }


        }
    }

    public void afterGrant() {
        SharedPreferences sps = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String urgentMsg = sps.getString(getString(R.string.pref_urgent_msg), getString(R.string.pref_default_urgent_msg));
        double[] gps = GPSUtil.getGPS(getActivity());
        Log.d("Foryou", "gps:" + gps[0] + "," + gps[1]);
//        MsgUtil.sendSMS(urgentMsg, getUrgentMsg(gps[0], gps[1]), sendIntent, backIntent);
//
//        String urgentTelNum = sps.getString(getString(R.string.pref_urgent_phone), getString(R.string.pref_default_urgent_phone));
//        TelUtil.call(urgentTelNum, getActivity());
    }

    public void afterRefuse() {
        View baseView = getView();
        if (baseView != null) {
            Snackbar.make(baseView, "没有授予权限", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }


}
