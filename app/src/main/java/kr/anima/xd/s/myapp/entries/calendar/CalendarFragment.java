package kr.anima.xd.s.myapp.entries.calendar;


import android.content.Context;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import java.util.Date;

import kr.anima.xd.s.myapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalendarFragment extends Fragment implements CalendarView.OnDateChangeListener{

    private Context mContext;

    CalendarView calendarView;
    RecyclerView rvCalendar;
    FloatingActionButton fab;
    private CalendarEntriesAdapter adapter;
    private long selectDate;
    private long currentTime;

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

        calendarView=view.findViewById(R.id.calendar);
        calendarView.setOnDateChangeListener(this);

        fab=view.findViewById(R.id.fab);
        rvCalendar=view.findViewById(R.id.rvCalendar);
        adapter=new CalendarEntriesAdapter(mContext, selectDate);
        rvCalendar.setAdapter(adapter);

        return view;
    }

    @Override
    public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfWeek) {
        selectDate=calendarView.getDate(); // TODO :: adapter 에게 새로운 날짜 전송
        adapter.notifyDataSetChanged();

    }
}
