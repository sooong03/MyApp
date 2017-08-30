package kr.anima.xd.s.myapp.entries.dashboard;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kr.anima.xd.s.myapp.R;
import kr.anima.xd.s.myapp.db.DBManager;
import kr.anima.xd.s.myapp.entries.EntriesEntry;
import kr.anima.xd.s.myapp.main.MainActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {


    private Context mContext;

    ViewPager pager;

    public DashboardFragment() {
        // Required empty public constructor
    }

    public DashboardFragment(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_dashboard, container, false);

        pager=view.findViewById(R.id.pager);
        pager.setAdapter(new DashboardPagerAdapter(getActivity().getSupportFragmentManager(), mContext));

        return view;
    }

}
