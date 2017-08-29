package kr.anima.xd.s.myapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import static kr.anima.xd.s.myapp.db.DBStructure.PurposeEntry;
import static kr.anima.xd.s.myapp.db.DBStructure.ObjectiveEntry;
import static kr.anima.xd.s.myapp.db.DBStructure.ScheduleEntry;
import static kr.anima.xd.s.myapp.db.DBStructure.TaskEntry;
import static kr.anima.xd.s.myapp.db.DBStructure.TrackerEntry;


/**
 * Created by PC on 2017-08-26.
 */

public class DBManager {

    // 각 테이블에 데이타 삽입, 로드, 수정 등

    public static final String RESULT_SUCCESSFUL="SUCCESSFUL";
    public static final String RESULT_FAIL="FAIL";

    private Context context;
    private SQLiteDatabase db;
    private DBOpener opener;

    public DBManager(Context context) {
        this.context = context;
    }

    public DBManager(SQLiteDatabase db) {
        this.db = db;
    }

    public void openDB(){
        opener=new DBOpener(context);
        this.db=opener.getWritableDatabase();
    }

    public void closeDB(){
        opener.close();
    }

    public long insertPurpose(String title, int status, long timestamp, long finalTimestamp, int refElementsId){
        return db.insert(title, null, this.createPurposeContentValues(title, status, timestamp, finalTimestamp, refElementsId));
    }

    public ContentValues createPurposeContentValues(String title, int status, long timestamp, long finalTimestamp, int refElementsId){
        ContentValues values=new ContentValues();
        values.put(PurposeEntry.COLUMN_TITLE, title);
        values.put(PurposeEntry.COLUMN_STATUS, status);
        values.put(PurposeEntry.COLUMN_TIMESTAMP, timestamp);
        values.put(PurposeEntry.COLUMN_FINAL_TIMESTAMP, finalTimestamp);
        values.put(PurposeEntry.COLUMN_REF_ELEMENTS__ID, refElementsId);

        return values;
    }

    public long insertObjective(String title, int status, long timestamp, long finalTimestamp, int refElementId, int refPurposeId){
        return db.insert(title, null, this.createObjectiveContentValues(title, status, timestamp, finalTimestamp, refElementId, refPurposeId));
    }

    public ContentValues createObjectiveContentValues(String title, int status, long timestamp, long finalTimestamp, int refElementId, int refPurposeId){
        ContentValues values=new ContentValues();
        values.put(ObjectiveEntry.COLUMN_TITLE, title);
        values.put(ObjectiveEntry.COLUMN_STATUS, status);
        values.put(ObjectiveEntry.COLUMN_TIMESTAMP, timestamp);
        values.put(ObjectiveEntry.COLUMN_FINAL_TIMESTAMP, finalTimestamp);
        values.put(ObjectiveEntry.COLUMN_REF_ELEMENTS__ID, refElementId);
        values.put(ObjectiveEntry.COLUMN_REF_PURPOSE__ID, refPurposeId);

        return values;
    }

    public long insertSchedule(String title, int status, long startDate, long endDate,
                               int repeatType, int repeatRule, int repeatDate, long timestamp, long finalTimestamp,
                               int refObjectiveId){
        return db.insert(title, null, this.createScheduleContentValues(title, status, startDate,
                endDate, repeatType, repeatRule, repeatDate,
                timestamp, finalTimestamp, refObjectiveId));
    }

    public ContentValues createScheduleContentValues(String title, int status, long startDate, long endDate,
                                                     int repeatType, int repeatRule, int repeatDate, long timestamp, long finalTimestamp,
                                                     int refObjectiveId){
        ContentValues values=new ContentValues();
        values.put(ScheduleEntry.COLUMN_TITLE, title);
        values.put(ScheduleEntry.COLUMN_STATUS, status);
        values.put(ScheduleEntry.COLUMN_START_DATE, startDate);
        values.put(ScheduleEntry.COLUMN_END_DATE, endDate);
        values.put(ScheduleEntry.COLUMN_REPEAT_TYPE, repeatType);
        values.put(ScheduleEntry.COLUMN_REPEAT_RULE, repeatRule);
        values.put(ScheduleEntry.COLUMN_REPEAT_DATE, repeatDate);
        values.put(ScheduleEntry.COLUMN_TIMESTAMP, timestamp);
        values.put(ScheduleEntry.COLUMN_FINAL_TIMESTAMP, finalTimestamp);
        values.put(ScheduleEntry.COLUMN_REF_OBJECTIVE__ID, refObjectiveId);
        return  values;
    }

    public long insertTask(String title, int status,
                           int repeatType, int repeatRule, int repeatDate,
                           long timestamp, long finalTimestamp,
                           int refObjectiveId){
        return db.insert(title, null, this.createTaskContentValues(title, status, repeatType, repeatRule, repeatDate, timestamp, finalTimestamp, refObjectiveId));
    }

    public ContentValues createTaskContentValues(String title, int status,
                                                 int repeatType, int repeatRule, int repeatDate,
                                                 long timestamp, long finalTimestamp,
                                                 int refObjectiveId){
        ContentValues values=new ContentValues();
        values.put(TaskEntry.COLUMN_TITLE, title);
        values.put(TaskEntry.COLUMN_STATUS, status);
        values.put(TaskEntry.COLUMN_REPEAT_TYPE, repeatType);
        values.put(TaskEntry.COLUMN_REPEAT_RULE, repeatRule);
        values.put(TaskEntry.COLUMN_REPEAT_DATE, repeatDate);
        values.put(TaskEntry.COLUMN_TIMESTAMP, timestamp);
        values.put(TaskEntry.COLUMN_FINAL_TIMESTAMP, finalTimestamp);
        values.put(TaskEntry.COLUMN_REF_OBJECTIVE__ID, refObjectiveId);
        return  values;
    }

    public long insertTracker(String title, int status,
                              int repeatType, int repeatRule, int repeatDate,
                              int refObjectiveId, int refPurposeId){
        return db.insert(title, null, this.createTrackerContentValues(title, status, repeatType, repeatRule, repeatDate, refObjectiveId, refPurposeId));
    }

    public ContentValues createTrackerContentValues(String title, int status,
                                                    int repeatType, int repeatRule, int repeatDate,
                                                    int refObjectiveId, int refPurposeId){
        ContentValues values=new ContentValues();
        values.put(TrackerEntry.COLUMN_TITLE, title);
        values.put(TrackerEntry.COLUMN_STATUS, status);
        values.put(TrackerEntry.COLUMN_REPEAT_TYPE, repeatType);
        values.put(TrackerEntry.COLUMN_REPEAT_RULE, repeatRule);
        values.put(TrackerEntry.COLUMN_REPEAT_DATE, repeatDate);
        values.put(TrackerEntry.COLUMN_REF_OBJECTIVE__ID, refObjectiveId);
        values.put(TrackerEntry.COLUMN_REF_PURPOSE__ID, refPurposeId);

        return  values;
    }


}
