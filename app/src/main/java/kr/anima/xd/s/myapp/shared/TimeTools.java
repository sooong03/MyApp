package kr.anima.xd.s.myapp.shared;

import android.content.Context;

import kr.anima.xd.s.myapp.R;

/**
 * Created by alfo6-10 on 8/30/2017.
 */

public class TimeTools {

    private String[] monthsFullName;
    private String[] daysFullName;
    private String[] daysSimpleName;

    private static TimeTools instance = null;

    public static TimeTools getInstance(Context context) {
        if (instance == null) {
            instance = new TimeTools( context);
        }
        return instance;
    }

    private TimeTools(Context context) {
        monthsFullName = context.getResources().getStringArray(R.array.months_full_name);
        daysFullName = context.getResources().getStringArray(R.array.days_full_name);
        daysSimpleName = context.getResources().getStringArray(R.array.days_simple_name);
    }

    public String[] getMonthsFullName() {
        return monthsFullName;
    }

    public String[] getDaysFullName() {
        return daysFullName;
    }

    public String[] getDaysSimpleName(){
        return daysSimpleName;
    }

}
