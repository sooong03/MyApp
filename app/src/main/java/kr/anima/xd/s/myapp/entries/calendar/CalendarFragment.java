package kr.anima.xd.s.myapp.entries.calendar;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.anima.xd.s.myapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalendarFragment extends Fragment {

    private Context mContext;
    RecyclerView rvCalendar;

    public CalendarFragment() {
        // Required empty public constructor
    }

    public CalendarFragment(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_calendar, container, false);

        rvCalendar=view.findViewById(R.id.rvCalendar);
        rvCalendar.setAdapter(new CalendarEntriesAdapter(mContext));

        return view;
    }

}
