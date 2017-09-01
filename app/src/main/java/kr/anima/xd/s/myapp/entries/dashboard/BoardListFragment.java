package kr.anima.xd.s.myapp.entries.dashboard;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.icu.text.SimpleDateFormat;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import io.github.kobakei.materialfabspeeddial.FabSpeedDial;
import io.github.kobakei.materialfabspeeddial.FabSpeedDialMenu;
import kr.anima.xd.s.myapp.R;
import kr.anima.xd.s.myapp.db.DBManager;
import kr.anima.xd.s.myapp.db.DBStructure;
import kr.anima.xd.s.myapp.entries.item.EntriesItem;
import kr.anima.xd.s.myapp.main.PurposeActivity;
import kr.anima.xd.s.myapp.shared.TimeTools;


/**
 * A simple {@link Fragment} subclass.
 */
public class BoardListFragment extends Fragment implements View.OnClickListener{

    private Context mContext;

    // 대시보드에 보여줄 내용 로드
    private DBManager dbManager;

    private TimeTools timeTools;
    private Calendar calendar;
    public final int REQUEST_CODE_ADD_CONTENT =0;

    // 대시보드, 캘린더, 트래커에 전달해야할 리스트
    private List<EntriesItem> entriesItems=new ArrayList<>();

    // UI
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
        calendar.setTimeInMillis(System.currentTimeMillis());
        timeTools=TimeTools.getInstance(mContext);

//        loadDataByDate(selectDate); // 오늘날짜에 맞는 데이타 로드
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_board_list, container, false);

//        fab=view.findViewById(R.id.fab);
        FabSpeedDial fabSpeedDial=view.findViewById(R.id.fab_dial);
        fabSpeedDial.getMainFab().setSize(FloatingActionButton.SIZE_MINI);

        for(int i=0; i<fabSpeedDial.getChildCount(); i++){
            FloatingActionButton t=fabSpeedDial.getMiniFab(i);
            t.setSize(FloatingActionButton.SIZE_MINI);
            t.setImageResource(R.drawable.ic_active_down+i);

        }


//        fabSpeedDial.getMainFab().setBackgroundColor(mContext.getResources().getColor(R.color.myColorDefaultWhite, null));
//        fabSpeedDial.getMiniFab(0).setBackgroundColor(mContext.getResources().getColor(R.color.myColorDefaultWhite, null));
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

    private void loadDashboard(){

    }


    private void setCurrentTime(boolean updateCurrentTime) {

        long todayLong=calendar.getTimeInMillis(); // long 타입의 현재날짜
        tvDate.setText(new SimpleDateFormat("dd", Locale.KOREA).format(new Date(todayLong)));
        tvDateMonth.setText(new SimpleDateFormat("MMMM", Locale.KOREA).format(new Date(todayLong)));



        loadDataByDate(todayLong);
//        tvDate.setText(today.getDate()+"");
//        tvDateMonth.setText(timeTools.getDaysSimpleName()[today.getMonth()-1]);
//        DateFormat dateFormat=new SimpleDateFormat(, Locale.KOREA);

//        if (updateCurrentTime) {
//            calendar.setTimeInMillis(System.currentTimeMillis());
//        }
////        tvDate.setText(timeTools.getMonthsFullName()[calendar.get(Calendar.MONTH)]);
//        tvDate.setText(calendar.get(Calendar.DATE)+"");
//        tvDateMonth.setText(timeTools.getDaysSimpleName()[calendar.get(Calendar.DAY_OF_WEEK)-1]);
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
                startActivityForResult(intent, REQUEST_CODE_ADD_CONTENT);
                break;
        }
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        // 새로운 항목 추가, 취소
    }


    private void loadDataByDate(long date){
        dbManager=new DBManager(mContext);
        dbManager.openDB();
        Cursor cursor=null;

        // 스케쥴
//        cursor=dbManager.selectScheduleByDate(date.getTime());
        while (cursor!=null){
            int id=cursor.getInt(cursor.getColumnIndex(DBStructure.ScheduleEntry._ID));
            String title=cursor.getString(cursor.getColumnIndex(DBStructure.ScheduleEntry.COLUMN_TITLE));
            int[] elements=new int[9];
            for(int j=0; j<elements.length; j++){
                int elementId=cursor.getInt(cursor.getColumnIndex(DBStructure.ScheduleEntry.COLUMN_ELEMENT_APPEARANCE+j));
                elements[j]=elementId;
            }
//            entriesList.add(new EntriesEntry(id, date.getTime(), title, null, elements, EntriesEntry.TYPE_SCHEDULE));
            cursor.moveToNext();
            cursor.close();
        }

//        cursor=dbManager.selectTaskByDate(date.getTime());
//        while (cursor!=null){
//            String str=cursor.getString(cursor.getColumnIndex(DBStructure.TaskEntry.COLUMN_TITLE));
//
//
//        }
//        String title=cursor.getString(cursor.getColumnIndex(DBStructure.ScheduleEntry.COLUMN_TITLE));

//        cursor.close();
        dbManager.closeDB();

    }

}
