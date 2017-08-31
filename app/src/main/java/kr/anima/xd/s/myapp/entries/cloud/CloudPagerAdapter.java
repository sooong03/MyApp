package kr.anima.xd.s.myapp.entries.cloud;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.anima.xd.s.myapp.R;

/**
 * Created by PC on 2017-08-26.
 */

public class CloudPagerAdapter extends PagerAdapter {

    static final int NUM_PAGE=1;
    private Context mContext;

    public CloudPagerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view=null;
        switch (position){
            case 0:
                view= LayoutInflater.from(mContext).inflate(R.layout.fragment_cloud_list, container, false);
                break;
//            case 1:
//                view=LayoutInflater.from(mContext).inflate(R.layout.fragment_my_cloud, container, false);
//                break;
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return NUM_PAGE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
