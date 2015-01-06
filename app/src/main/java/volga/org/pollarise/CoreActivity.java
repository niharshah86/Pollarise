package volga.org.pollarise;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.util.List;

/**
 * Created by User on 12/30/2014.
 */
public class CoreActivity extends Fragment {

    protected static String LOG_TAG = "CoreActivity";
    protected static String response = "";
    protected ProgressDialog pDialog;

    protected void setFragment(Fragment fragment) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment).commit();
    }

    protected void setFragmentWithBackstack(Fragment fragment) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(getActivity().getClass().getCanonicalName())
                .commit();
    }

    protected void clearBackstack() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
    }

    protected String getJsonFromURL(String url, int method,
                                    List<NameValuePair> params) {
        // JSON Parsing will be done here
        try {
            // http client
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpEntity httpEntity = null;
            HttpResponse httpResponse = null;

            // Checking http request method type
            if (method == Constants.METHOD_POST) {
                Log.d(LOG_TAG, "API POST Url :- " + url);
                HttpPost httpPost = new HttpPost(url);
                // adding post params
                if (params != null) {
                    httpPost.setEntity(new UrlEncodedFormEntity(params));
                }

                httpResponse = httpClient.execute(httpPost);

            } else if (method == Constants.METHOD_GET) {
                // appending params to url
                if (params != null) {
                    String paramString = URLEncodedUtils
                            .format(params, "utf-8");
                    url += "?" + paramString;
                }
                Log.d(LOG_TAG, "API GET Url :- " + url);
                HttpGet httpGet = new HttpGet(url);

                httpResponse = httpClient.execute(httpGet);

            }
            httpEntity = httpResponse.getEntity();
            response = EntityUtils.toString(httpEntity);
            Log.d(LOG_TAG, "Response From Server :- " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    protected void showProgressDialog(Context context, String message) {
        pDialog = new ProgressDialog(context);
        pDialog.setMessage(message);
        pDialog.setCancelable(false);
        pDialog.show();
    }

    protected void dismissProgressDialog() {
        // Dismiss the progress dialog
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    protected boolean isDialog() {
        return pDialog.isShowing();
    }
}
