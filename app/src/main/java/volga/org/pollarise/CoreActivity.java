package volga.org.pollarise;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by User on 12/30/2014.
 */
public class CoreActivity extends Fragment {
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
}
