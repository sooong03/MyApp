package kr.anima.xd.s.myapp.entries.dashboard;

import android.content.Context;
import android.database.Cursor;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import kr.anima.xd.s.myapp.R;
import kr.anima.xd.s.myapp.db.DBManager;
import kr.anima.xd.s.myapp.db.DBStructure;
import kr.anima.xd.s.myapp.entries.EntriesEntry;
import kr.anima.xd.s.myapp.entries.ItemInfoHelper;
import kr.anima.xd.s.myapp.shared.EditMode;

/**
 * Created by PC on 2017-08-27.
 */

public class DashboardEntriesAdapter extends RecyclerView.Adapter implements EditMode{


    private Context mContext;
    private Date selectDate;

    private ArrayList<EntriesEntry> entriesList;
    private DateFormat dateFormat;

    private boolean isEditMode=false;

    private final int NO_ITEM=0;

    private ScheduleViewHolder scheduleViewHolder;
    private TaskViewHolder taskViewHolder;

    public DashboardEntriesAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public DashboardEntriesAdapter(Context mContext, Date selectDate) {
        this.mContext = mContext;
        this.selectDate = selectDate;
        entriesList.add(new EntriesEntry(0, selectDate, "test", "test", 0, false, EntriesEntry.TYPE_SCHEDULE));
    }

    //    public DashboardEntriesAdapter() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            dateFormat=new SimpleDateFormat("HH:mm");
//        }
//    }
//
//    public DashboardEntriesAdapter(List<EntriesEntry> entriesList, EntriesFragment mFragment) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            dateFormat=new SimpleDateFormat("HH:mm");
//        }
//        this.entriesList = (ArrayList<EntriesEntry>) entriesList;
//        this.mFragment = mFragment;
//        this.daysSimpleName=mFragment.getResources().getStringArray(R.array.days_simple_name);
//
//    }

    @Override
    public int getItemViewType(int position) {
        // TODO :: 스케쥴과 태스크 구분
        switch (entriesList.get(position).getType()){
            default: return NO_ITEM;
            case EntriesEntry.TYPE_SCHEDULE:
                return EntriesEntry.TYPE_SCHEDULE;
            case EntriesEntry.TYPE_TASK:
                return EntriesEntry.TYPE_TASK;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=null;

        switch (viewType){
            default:
                view=LayoutInflater.from(parent.getContext()).inflate(R.layout.view_no_entries, parent, false);
                return null;
            case EntriesEntry.TYPE_SCHEDULE:
                view=LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_schedule_entries_item, parent, false);
                scheduleViewHolder=new ScheduleViewHolder(view);
                return scheduleViewHolder;
            case EntriesEntry.TYPE_TASK:
                view=LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_task_entries_item, parent, false);
                taskViewHolder=new TaskViewHolder(view);
                return taskViewHolder;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Calendar calendar= null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            calendar = Calendar.getInstance();
            calendar.setTime(entriesList.get(position).getCreateDate());


        if(holder.itemView==scheduleViewHolder.itemView){
            // TYPE_SCHEDULE
            ((ScheduleViewHolder)holder).getTvTime().setText(String.valueOf(dateFormat.format(calendar.getTime())));
            ((ScheduleViewHolder)holder).getTvTitle().setText(entriesList.get(position).getTitle());
            ((ScheduleViewHolder)holder).getTvSummary().setText(entriesList.get(position).getSummary());

            ((ScheduleViewHolder)holder).getIvElement().setImageResource(ItemInfoHelper.getElementResourceId(entriesList.get(position).getElementId()));



        }else if (holder.itemView==taskViewHolder.itemView){
            // TYPE_TASK

            if (showTaskHeader(position)){
                ((TaskViewHolder) holder).getTvHeader().setVisibility(View.VISIBLE);
                ((TaskViewHolder)holder).getTvHeader().setText(entriesList.get(position).getTitle());
            } else {
                ((TaskViewHolder)holder).getTvHeader().setVisibility(View.GONE);
            }

        }

        }
    }


    @Override
    public int getItemCount() {
        return entriesList.size();
    }


    private boolean showTaskHeader(final int position){
        if (position==0) return true;
        else {
            java.util.Calendar previousCalendar = new GregorianCalendar();
            previousCalendar.setTime(entriesList.get(position - 1).getCreateDate());
            java.util.Calendar currentCalendar = new GregorianCalendar();
            currentCalendar.setTime(entriesList.get(position).getCreateDate());
            if (previousCalendar.get(java.util.Calendar.YEAR) != currentCalendar.get(java.util.Calendar.YEAR)) {
                return true;
            } else {
                if (previousCalendar.get(java.util.Calendar.MONTH) != currentCalendar.get(java.util.Calendar.MONTH)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }




    @Override
    public boolean isEditMode() {
        return false;
    }

    @Override
    public void setEditMode(boolean editMode) {

    }


    protected static class ScheduleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        TextView tvTime, tvAmPm, tvParent, tvTitle, tvSummary;
        ImageView ivElement;
        public static final int TYPE_SCHEDULE=0;

        public ScheduleViewHolder(View itemView) {
            super(itemView);

            tvTime=itemView.findViewById(R.id.tvTime);
            tvAmPm=itemView.findViewById(R.id.tvAmPm);
            tvParent=itemView.findViewById(R.id.tvParent);
            tvTitle=itemView.findViewById(R.id.tvTitle);
            tvSummary=itemView.findViewById(R.id.tvSummary);

            ivElement=itemView.findViewById(R.id.ivElement);

            itemView.setOnClickListener(this);
        }

        public TextView getTvTime() {
            return tvTime;
        }

        public void setTvTime(TextView tvTime) {
            this.tvTime = tvTime;
        }

        public TextView getTvAmPm() {
            return tvAmPm;
        }

        public void setTvAmPm(TextView tvAmPm) {
            this.tvAmPm = tvAmPm;
        }

        public TextView getTvParent() {
            return tvParent;
        }

        public void setTvParent(TextView tvParent) {
            this.tvParent = tvParent;
        }

        public TextView getTvTitle() {
            return tvTitle;
        }

        public void setTvTitle(TextView tvTitle) {
            this.tvTitle = tvTitle;
        }

        public TextView getTvSummary() {
            return tvSummary;
        }

        public void setTvSummary(TextView tvSummary) {
            this.tvSummary = tvSummary;
        }

        public ImageView getIvElement() {
            return ivElement;
        }

        public void setIvElement(ImageView ivElement) {
            this.ivElement = ivElement;
        }

        @Override
        public void onClick(View view) {
            // 스케쥴 상세보기 다이얼로그
            Toast.makeText(itemView.getContext(), "스케쥴 상세보기", Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onLongClick(View view) {
            // 스케쥴 삭제여부 스낵바 또는 다이얼로그
            Toast.makeText(itemView.getContext(), "스케쥴을 삭제할까요?", Toast.LENGTH_SHORT).show();

            return true;
        }
    }

    protected static class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        TextView tvHeader, tvTaskContent;
        public static final int TYPE_TASK=1;

        public TaskViewHolder(View itemView) {
            super(itemView);
            tvHeader=itemView.findViewById(R.id.tvHeader); // objective 마다 구분
            tvHeader.setVisibility(View.GONE);
            tvTaskContent=itemView.findViewById(R.id.tvTaskContent);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public TextView getTvHeader() {
            return tvHeader;
        }

        public void setTvHeader(TextView tvHeader) {
            this.tvHeader = tvHeader;
        }

        public TextView getTvTaskContent() {
            return tvTaskContent;
        }

        public void setTvTaskContent(TextView tvTaskContent) {
            this.tvTaskContent = tvTaskContent;
        }

        @Override
        public void onClick(View view) {
            // 실행 확인, 취소
            Toast.makeText(itemView.getContext(), "테스크 완료", Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onLongClick(View view) {
            // 테스크 수정모드
            Toast.makeText(itemView.getContext(), "테스크 편집모드", Toast.LENGTH_SHORT).show();
            return true;
        }
    }


}
