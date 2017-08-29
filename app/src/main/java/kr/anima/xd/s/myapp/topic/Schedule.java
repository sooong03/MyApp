package kr.anima.xd.s.myapp.topic;

/**
 * Created by PC on 2017-08-27.
 */

public class Schedule implements MyTopic {

    // 대시보드에 보여질 스케쥴 항목

    private String title;
    private int id;
    private int count;
    private long time; // 스케쥴 실행시간
    private long timeStamp; // 본 항목이 작성된 시간

    public Schedule(String title, int id, long time) {
        this.title = title;
        this.id = id;
        this.time = time;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getType() {
        return TYPE_SCHEDULE;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }

    public long getTime() {
        return time;
    }

    @Override
    public void setTimeStamp(long timeStamp) {
        this.timeStamp=timeStamp;
    }

    @Override
    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
