package kr.anima.xd.s.myapp.entries.cloud;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import kr.anima.xd.s.myapp.R;
import kr.anima.xd.s.myapp.entries.item.DataRow;

/**
 * Created by alfo6-10 on 8/31/2017.
 */

public class CloudListAdapter extends RecyclerView.Adapter {

    private List<DataRow> dataRowList;
    private Context mContext;

    public CloudListAdapter(List<DataRow> dataRowList) {
        this.dataRowList = dataRowList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       mContext=parent.getContext();
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_cloud_entries_item, parent, false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataRowList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvTitle, tvBody, tvNumOfStar, tvNumOfDown;
        ImageView ivStar, ivDown;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setTag("item");
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(mContext, CloudItemActivity.class);
                    mContext.startActivity(intent);
                }
            });


            tvTitle=itemView.findViewById(R.id.tvTitle);
            tvBody=itemView.findViewById(R.id.tvBody);
            tvNumOfStar=itemView.findViewById(R.id.tvNumOfStar);
            tvNumOfDown=itemView.findViewById(R.id.tvNumOfDown);

            ivStar=itemView.findViewById(R.id.ivStar);
            ivDown=itemView.findViewById(R.id.ivDown);
            ivStar.setOnClickListener(this);
            ivDown.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.ivStar:
                    break;
                case R.id.ivDown:
                    break;
            }
        }
    }
}
