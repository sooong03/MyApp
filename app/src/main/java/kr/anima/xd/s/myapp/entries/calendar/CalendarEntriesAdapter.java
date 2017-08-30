package kr.anima.xd.s.myapp.entries.calendar;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.anima.xd.s.myapp.R;
import kr.anima.xd.s.myapp.db.DBManager;
import kr.anima.xd.s.myapp.db.DBStructure;
import kr.anima.xd.s.myapp.entries.EntriesEntry;

/**
 * Created by PC on 2017-08-27.
 */

public class CalendarEntriesAdapter extends RecyclerView.Adapter<CalendarEntriesAdapter.ViewHolder> {

    // 선택 날짜에 맞는 데이타 로드

    private Context mContext;
    private long selectDate;
    private DBManager dbManager;

    private List<EntriesEntry> entryList=new ArrayList<>();

    public CalendarEntriesAdapter() {
    }

    public CalendarEntriesAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public CalendarEntriesAdapter(Context mContext, long selectDate) {
        this.mContext = mContext;
        this.selectDate = selectDate;
    }

    @Override
    public CalendarEntriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.rv_calendar_entries_item, parent, false);
        loadDataByDate(selectDate);

        ViewHolder holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(CalendarEntriesAdapter.ViewHolder holder, int position) {
        holder.tvTitle.setText(entryList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return entryList.size();
    }


    private void loadDataByDate(long selectDate){

        entryList.clear();
        dbManager=new DBManager(mContext);
        dbManager.openDB();

        Cursor scheduleListCursor=dbManager.selectScheduleByDate(selectDate);

        for(int i=0; i<scheduleListCursor.getCount(); i++){
            String title=scheduleListCursor.getString(scheduleListCursor.getColumnIndex(DBStructure.ScheduleEntry.COLUMN_TITLE));
            EntriesEntry entry=new EntriesEntry(scheduleListCursor.getInt(0),
                    new Date(scheduleListCursor.getLong(1)),
                    title, "", 0, false, EntriesEntry.TYPE_SCHEDULE);

            entryList.add(entry);
            scheduleListCursor.moveToNext();
        }

        scheduleListCursor.close();

        Cursor taskListCursor=dbManager.selectTaskByDate(selectDate);
        for(int i=0; i<taskListCursor.getCount(); i++){
            String title=taskListCursor.getString(taskListCursor.getColumnIndex(DBStructure.TaskEntry.COLUMN_TITLE));
            EntriesEntry entry=new EntriesEntry(taskListCursor.getInt(0),
                    new Date(taskListCursor.getLong(1)), title, "", 0, false, EntriesEntry.TYPE_TASK);

            entryList.add(entry);
            taskListCursor.moveToNext();
        }
        taskListCursor.close();
        dbManager.closeDB();
    }




    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        TextView tvHeader, tvDate, tvDay, tvTime, tvTitle, tvSummary;
        ImageView ivWeather, ivMood, ivBookmark, ivAttachment;


        public ViewHolder(View itemView) {
            super(itemView);

            tvHeader=itemView.findViewById(R.id.tvHeader);
            tvDate=itemView.findViewById(R.id.tvDate);
            tvDay=itemView.findViewById(R.id.tvDay);
            tvTime=itemView.findViewById(R.id.tvTime);
            tvTitle=itemView.findViewById(R.id.tvTitle);
            tvSummary=itemView.findViewById(R.id.tvSummary);

            ivWeather=itemView.findViewById(R.id.ivWeather);
            ivMood=itemView.findViewById(R.id.ivMood);
            ivBookmark=itemView.findViewById(R.id.ivBookmark);
            ivAttachment=itemView.findViewById(R.id.ivAttachment);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }

        @Override
        public void onClick(View view) {
            // 상세보기

        }

        @Override
        public boolean onLongClick(View view) {
            // 수정 및 삭제 모드

            return true;
        }
    }
}
