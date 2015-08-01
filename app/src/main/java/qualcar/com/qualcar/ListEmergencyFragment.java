package qualcar.com.qualcar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Greg-Knox on 8/1/2015.
 */
public class ListEmergencyFragment extends Fragment {

    private RecyclerView mListRecyclerView;
    private RecyclerView.Adapter mListRecyclerViewAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] mData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.emergencies, container, false);

        return rootView;
    }
}
