package kr.anima.xd.s.myapp.topic;

/**
 * Created by PC on 2017-08-27.
 */

public class Tracker implements MyTopic {

    // 트래커 리스트에 보여질 트래커 항목

    private String title;
    private int id;
    private int count;
    private boolean checked=false;

    public Tracker(String title, int id, int count) {
        this.title = title;
        this.id = id;
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

    }

    @Override
    public long getTime() {
        return 0;
    }

    @Override
    public void setTimeStamp(long timeStamp) {

    }

    @Override
    public long getTimeStamp() {
        return 0;
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
