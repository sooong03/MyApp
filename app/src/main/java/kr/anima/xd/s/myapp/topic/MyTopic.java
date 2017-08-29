package kr.anima.xd.s.myapp.topic;

import android.view.View;

/**
 * Created by PC on 2017-08-27.
 */

public interface MyTopic {


    // purpose, objective, content
    int TYPE_PURPOSE=0;
    int TYPE_OBJECTIVE=1;
    int TYPE_SCHEDULE=2;
    int TYPE_TASK=3;

    String getTitle();

    void setTitle(String title);

    int getType();

    int getId();

    void setCount(int count);

    int getCount();

    void setTime(long time); // 일정 실행시간, 사용자설정

    long getTime();

    void setTimeStamp(long timeStamp); // 본 항목이 작성된 시간 받아오기

    long getTimeStamp();

}
