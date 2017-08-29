package kr.anima.xd.s.myapp.entries.cloud;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.anima.xd.s.myapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CloudFragment extends Fragment {

    private Context mContext;

    ViewPager pager;

    public CloudFragment() {
        // Required empty public constructor
    }

    public CloudFragment(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_cloud, container, false);
        pager=view.findViewById(R.id.pager);
        pager.setAdapter(new CloudPagerAdapter(mContext));

        return view;
    }

}
