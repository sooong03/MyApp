package kr.anima.xd.s.myapp.entries.dashboard;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import kr.anima.xd.s.myapp.entries.calendar.CalendarFragment;
import kr.anima.xd.s.myapp.entries.tracker.TrackerFragment;

/**
 * Created by PC on 2017-08-26.
 */

public class DashboardPagerAdapter extends FragmentStatePagerAdapter {

    static final int NUM_PAGE=3;
    private Context mContext;
    private Fragment[] dashboardFragment=new Fragment[3];


    public DashboardPagerAdapter(FragmentManager fm, Context mContext) {
        super(fm);
        this.mContext = mContext;
        dashboardFragment[0]=new BoardListFragment(mContext);
        dashboardFragment[1]=new CalendarFragment(mContext);
        dashboardFragment[2]=new TrackerFragment(mContext);
    }

    @Override
    public Fragment getItem(int position) {
        return dashboardFragment[position];
    }

    @Override
    public int getCount() {
        return NUM_PAGE;
    }
//
//    public DashboardPagerAdapter() {
//
//    }
//
//    public DashboardPagerAdapter(Context mContext) {
//        this.mContext = mContext;
//    }
//
//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        View view=null;
//
//        switch (position){
//            case 0:
//                view= LayoutInflater.from(mContext).inflate(R.layout.fragment_board_list, container, false);
//                break;
//            case 1:
//                view=LayoutInflater.from(mContext).inflate(R.layout.fragment_calendar, container, false);
//                break;
//            case 2:
//                view=LayoutInflater.from(mContext).inflate(R.layout.fragment_tracker, container, false);
//                break;
//        }
//        container.addView(view);
//        return view;
//    }
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView((View) object);
//    }
//
//    @Override
//    public int getCount() {
//        return NUM_PAGE;
//    }
//
//    @Override
//    public boolean isViewFromObject(View view, Object object) {
//        return view==object;
//    }
}
