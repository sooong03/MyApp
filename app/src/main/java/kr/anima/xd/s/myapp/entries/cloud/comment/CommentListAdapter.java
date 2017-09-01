package kr.anima.xd.s.myapp.entries.cloud.comment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import kr.anima.xd.s.myapp.R;

/**
 * Created by alfo6-10 on 8/31/2017.
 */

public class CommentListAdapter extends BaseAdapter {

    private List<HashMap<String, String>> commentsList;

    public CommentListAdapter(List<HashMap<String, String>> commentsList) {
        this.commentsList = commentsList;
    }

    @Override
    public int getCount() {
        return commentsList.size();
    }

    @Override
    public Object getItem(int position) {
        return commentsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        TextView tvUserId, tvComment;

        if(view==null){
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lv_comment_entries_item, viewGroup, false);
        }

        tvUserId=view.findViewById(R.id.tvUserId);
        tvComment=view.findViewById(R.id.tvComment);

        tvUserId.setText(commentsList.get(position).get("id"));
        tvComment.setText(commentsList.get(position).get("comment"));

        return view;
    }
}
