package qualcar.com.qualcar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Nitish on 7/28/2015.
 */
public class ListFavoritesFragment extends Fragment
{
    private RecyclerView mListRecyclerView;
    private RecyclerView.Adapter mListRecyclerViewAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] mData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.action_list, container, false);

        mData = MainScreen.FAVORITES;

        // Set up the list view
        mListRecyclerView = (RecyclerView) rootView.findViewById(R.id.action_recycler);
        mListRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mListRecyclerView.setLayoutManager(mLayoutManager);

        mListRecyclerViewAdapter = new ListAdapter(mData);
        mListRecyclerView.setAdapter(mListRecyclerViewAdapter);

        return rootView;
    }
}
