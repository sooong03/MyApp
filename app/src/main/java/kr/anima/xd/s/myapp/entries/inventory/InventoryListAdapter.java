package kr.anima.xd.s.myapp.entries.inventory;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import kr.anima.xd.s.myapp.R;

/**
 * Created by alfo6-10 on 8/31/2017.
 */

public class InventoryListAdapter extends RecyclerView.Adapter {

    final int NO_ITEM=0;
    private List<String> purposeList;

    public InventoryListAdapter() {
    }

    public InventoryListAdapter(List<String> purposeList) {
        this.purposeList = purposeList;
    }

    @Override
    public int getItemViewType(int position) {

        if (purposeList.size()==0) return NO_ITEM;
        else return 1;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
        ViewHolder holder=null;

        switch (viewType){
            case NO_ITEM:
                break;
            case 1:
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_purpose_entries_item, parent, false);
                holder=new ViewHolder(view);
                break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).tvTitle.setText(purposeList.get(position));
    }

    @Override
    public int getItemCount() {
        return purposeList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvTitle=itemView.findViewById(R.id.tvTitle);

        }

        @Override
        public void onClick(View view) {
            // 미션 세부 사항보기기
        }
    }

}
