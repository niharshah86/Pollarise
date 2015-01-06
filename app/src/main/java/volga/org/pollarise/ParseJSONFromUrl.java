package volga.org.pollarise;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by User on 1/6/2015.
 */
public abstract class ParseJSONFromUrl<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {

    protected ProgressDialog pDialog;
    public Context context;

    public ParseJSONFromUrl<Params, Progress, Result> setContext(Context c){
        this.context = c;
        Log.d("nihar testing","git testing");
        return this;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(this.context);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
    }

}