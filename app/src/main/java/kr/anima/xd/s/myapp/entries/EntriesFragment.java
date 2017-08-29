package kr.anima.xd.s.myapp.entries;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.anima.xd.s.myapp.R;
import kr.anima.xd.s.myapp.entries.dashboard.DashboardEntriesAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class EntriesFragment extends MyFragment {

    private Context mContext;
    RecyclerView rvDashboardEntry;

    public EntriesFragment() {
        // Required empty public constructor
    }

    public EntriesFragment(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_entries, container, false);

        rvDashboardEntry=view.findViewById(R.id.rvDashboardEntry);
//        rvDashboardEntry.setAdapter(new DashboardEntriesAdapter(getEntriesList(), EntriesFragment.this));

        return view;
    }

}
