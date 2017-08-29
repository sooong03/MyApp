package kr.anima.xd.s.myapp.entries.item;

import android.view.View;

/**
 * Created by PC on 2017-08-27.
 */

public interface MyItemRow {

    int TYPE_SCHEDULE=0;
    int TYPE_TASK=1;

    void setTitle(String title);

    String getTitle();

    int getType();

    View getView();

}
