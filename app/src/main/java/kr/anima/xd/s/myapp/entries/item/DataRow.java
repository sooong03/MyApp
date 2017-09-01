package kr.anima.xd.s.myapp.entries.item;

import android.view.View;

/**
 * Created by alfo6-10 on 8/30/2017.
 */

public interface DataRow {

    int TYPE_SCHEDULE=0;
    int TYPE_TASK=1;

    void setTitle(String title);

    String getTitle();

    int getType();

    // 시행여부
    boolean hasChecked();

    void setChecked(boolean checked);

    // Objective 카테고리
    int getObjective();

    void setObjective(String objective);

    long getDate();

    void setDate(long date);

}
