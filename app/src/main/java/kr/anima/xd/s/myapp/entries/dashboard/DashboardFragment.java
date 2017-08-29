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

    // 리스트에 보여줄 내용이 있는지 확인
    // 있으면 로드

    private Context mContext;
    private MainActivity mainActivity;

    private long topicId;
    private boolean hasEntries;

    private List<EntriesEntry> entryList=new ArrayList<>();

    ViewPager pager;

    public DashboardFragment() {
        // Required empty public constructor
    }

    public DashboardFragment(Context mContext) {
        this.mContext = mContext;
        mainActivity= (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_dashboard, container, false);

        pager=view.findViewById(R.id.pager);
        pager.setAdapter(new DashboardPagerAdapter(getActivity().getSupportFragmentManager(), mContext));

        return view;
    }

    public void loadEntries(){

        // 기기의 db에서 모든 entries 가져오기

        entryList.clear();
        DBManager dbManager=new DBManager(mContext);
        dbManager.openDB();

        Cursor entriesCursor;
    }

}
