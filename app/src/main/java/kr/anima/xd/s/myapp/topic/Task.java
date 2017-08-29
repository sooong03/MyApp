package kr.anima.xd.s.myapp.topic;

/**
 * Created by PC on 2017-08-27.
 */

public class Task implements MyTopic {

    // 대시보드에 보여질 테스크 항목

    private String title;
    private int id;
    private int count;
    private boolean checked=false;
    private long time; // 태스크 실행시간
    private long timeStamp; // 체크한 시간

    public Task(int id, String title, int count, long time) {

        this.id = id;
        this.title = title;
        this.count = count;
        this.time = time;
    }

    public Task(int id, String title, int count) {

        this.id = id;
        this.title = title;
        this.count = count;
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
        return TYPE_TASK;
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
    public void setTime(long time) {
        this.time=time;
    }

    @Override
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

    @Override
    public void setCount(int count) {
        this.count = count;
    }

    public boolean checked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        checked = checked;
    }
}
