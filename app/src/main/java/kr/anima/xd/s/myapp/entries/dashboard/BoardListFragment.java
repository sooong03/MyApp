package kr.anima.xd.s.myapp.entries.dashboard;


import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import kr.anima.xd.s.myapp.R;
import kr.anima.xd.s.myapp.main.PurposeActivity;
import kr.anima.xd.s.myapp.shared.TimeTools;


/**
 * A simple {@link Fragment} subclass.
 */
public class BoardListFragment extends Fragment implements View.OnClickListener{

    private Context mContext;
    private Calendar calendar;
    public final int REQUST_CODE_ADD_CONTENT=0;
    private TimeTools timeTools;

    LinearLayout layout_today;
    TextView tvDate, tvDateMonth;
    ImageView ivPrev, ivNext;
    FloatingActionButton fab;

    RecyclerView rvDashboardEntry;
    private DashboardEntriesAdapter adapter;


    public BoardListFragment() {
    }

    public BoardListFragment(Context mContext) {
        this.mContext = mContext;
        calendar=Calendar.getInstance();
        timeTools=TimeTools.getInstance(mContext);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_board_list, container, false);

        fab=view.findViewById(R.id.fab);
        fab.setOnClickListener(this);
        tvDate=view.findViewById(R.id.tvDateToday);
        tvDateMonth=view.findViewById(R.id.tvDateMonth);
        ivPrev=view.findViewById(R.id.ivPrev);
        ivNext=view.findViewById(R.id.ivNext);

        layout_today=view.findViewById(R.id.layout_today);

        rvDashboardEntry=view.findViewById(R.id.rvDashboardEntry);
        adapter=new DashboardEntriesAdapter(mContext);
        rvDashboardEntry.setAdapter(adapter);
//        entriesFragment= (EntriesFragment) getFragmentManager().findFragmentById(R.id.fragmentEntries);
        ivPrev.setOnClickListener(this);
        ivNext.setOnClickListener(this);
        layout_today.setOnClickListener(this);

        setCurrentTime(true);

        return view;
    }

    private void setCurrentTime(boolean updateCurrentTime) {
        if (updateCurrentTime) {
            calendar.setTimeInMillis(System.currentTimeMillis());
        }
//        tvDate.setText(timeTools.getMonthsFullName()[calendar.get(Calendar.MONTH)]);
        tvDate.setText(calendar.get(Calendar.DATE)+"");
        tvDateMonth.setText(timeTools.getDaysSimpleName()[calendar.get(Calendar.DAY_OF_WEEK)-1]);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ivPrev: // 하루전
                adapter.notifyDataSetChanged();
                Toast.makeText(mContext, "하루전", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ivNext: // 다음날
                adapter.notifyDataSetChanged();
                Toast.makeText(mContext, "다음날", Toast.LENGTH_SHORT).show();
                break;
            case R.id.layout_today: // 날짜 선택하기
                adapter.notifyDataSetChanged();
                Toast.makeText(mContext, "날짜선택", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab: // 새로운 항목 추가
                Intent intent=new Intent(mContext, PurposeActivity.class);
                startActivityForResult(intent, REQUST_CODE_ADD_CONTENT);
                break;
        }
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);

    }
}
