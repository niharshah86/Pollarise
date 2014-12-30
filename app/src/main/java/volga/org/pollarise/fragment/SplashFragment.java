package volga.org.pollarise.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import volga.org.pollarise.CoreActivity;
import volga.org.pollarise.R;

/**
 * Created by User on 12/30/2014.
 */
public class SplashFragment extends CoreActivity {

    protected View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_splash, container, false);
        return mView;
    }
}
