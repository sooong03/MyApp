package kr.anima.xd.s.myapp.entries.dashboard;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import kr.anima.xd.s.myapp.R;
import kr.anima.xd.s.myapp.entries.EntriesFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class BoardListFragment extends Fragment implements View.OnClickListener{

    private Context mContext;

    LinearLayout layout_today;
    TextView tvDate, tvDay;
    ImageView ivPrev, ivNext;
    EntriesFragment entriesFragment;
//    RecyclerView rvDashboard;


    public BoardListFragment() {
    }

    public BoardListFragment(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_board_list, container, false);

        tvDate=view.findViewById(R.id.tvDate);
        tvDay=view.findViewById(R.id.tvDay);
        ivPrev=view.findViewById(R.id.ivPrev);
        ivNext=view.findViewById(R.id.ivNext);

        layout_today=view.findViewById(R.id.layout_today);

//        rvDashboard=view.findViewById(R.id.rvDashboard);
//        rvDashboard.setAdapter(new DashboardLEntriesAdapter(mContext));
        entriesFragment= (EntriesFragment) getFragmentManager().findFragmentById(R.id.fragmentEntries);
        ivPrev.setOnClickListener(this);
        ivNext.setOnClickListener(this);
        layout_today.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ivPrev: // 하루전
                Toast.makeText(mContext, "하루전", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ivNext: // 다음날
                Toast.makeText(mContext, "다음날", Toast.LENGTH_SHORT).show();
                break;
            case R.id.layout_today: // 날짜 선택하기
                Toast.makeText(mContext, "날짜선택", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
