package qualcar.com.qualcar.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import qualcar.com.qualcar.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class rulesFragment extends Fragment {

    public rulesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rules, container, false);
    }
}
