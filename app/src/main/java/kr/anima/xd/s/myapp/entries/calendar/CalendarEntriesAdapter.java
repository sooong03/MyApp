package kr.anima.xd.s.myapp.entries.calendar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import kr.anima.xd.s.myapp.R;

/**
 * Created by PC on 2017-08-27.
 */

public class CalendarEntriesAdapter extends RecyclerView.Adapter<CalendarEntriesAdapter.ViewHolder> {

    private Context mContext;

    public CalendarEntriesAdapter() {
    }

    public CalendarEntriesAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public CalendarEntriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.rv_calendar_entries_item, parent, false);
        ViewHolder holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(CalendarEntriesAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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
