package kr.anima.xd.s.myapp.entries;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 2017-08-28.
 */

public class EntriesActivity extends FragmentActivity {

    private int topicId;
    private boolean hasEntried;

    private List<EntriesEntry> entryEntries=new ArrayList<>();
    private static final int MAX_TEXT_LENGTH=18;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


}


