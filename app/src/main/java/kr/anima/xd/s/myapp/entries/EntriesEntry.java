package kr.anima.xd.s.myapp.entries;

import android.icu.util.Calendar;
import android.support.annotation.NonNull;

import com.prolificinteractive.materialcalendarview.CalendarDay;

import java.util.Date;

/**
 * Created by PC on 2017-08-28.
 */

public class EntriesEntry implements Comparable<CalendarDay> {


    private int id;
    private Date createDate;
    private String title;
    private String summary;
    private int elementId;  //TODO 배열로 바꿔야함
    private int[] elements=new int[9];
    private boolean hasAttachment;
    private int type;

    private int _id;
    private long date;
    private String title1;
    private String sum;
    private int[] elementsId;
    private int contentType;


    public static final int TYPE_SCHEDULE=0;
    public static final int TYPE_TASK=1;


    public EntriesEntry(int _id, long date, String title1, String sum, int[] elementsId, int contentType) {
        this._id = _id;
        this.date = date;
        this.title1 = title1;
        this.sum = sum;
        this.elementsId = elementsId;
        this.contentType = contentType;
    }

    public EntriesEntry(int id, Date createDate, String title, String summary, int elementId, boolean hasAttachment, int type) {
        this.id = id;
        this.createDate = createDate;
        this.title = title;
        this.summary = summary;
        this.elementId = elementId;
        this.hasAttachment = hasAttachment;
        this.type=type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    public boolean hasAttachment() {
        return hasAttachment;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int compareTo(@NonNull CalendarDay calendarDay) {

        Calendar cal= null;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {

            cal = Calendar.getInstance();

            cal.setTime(createDate);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);

            return Long.valueOf(calendarDay.getCalendar().getTimeInMillis()).compareTo(
                    cal.getTimeInMillis());
        } else return 0;

        // TODO :: N 버젼 이하 리턴값 설정
    }
}
