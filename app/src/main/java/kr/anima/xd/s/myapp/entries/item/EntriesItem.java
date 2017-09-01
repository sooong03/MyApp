package kr.anima.xd.s.myapp.entries.item;

/**
 * Created by alfo6-10 on 8/31/2017.
 */

public class EntriesItem {

    int TYPE_SCHEDULE=0;
    int TYPE_TASK=1;

    String title;
    int ref_parent_id; // objective id

    boolean isChecked;

    long date;

}
