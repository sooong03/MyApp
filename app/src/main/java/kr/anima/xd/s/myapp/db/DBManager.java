package kr.anima.xd.s.myapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import kr.anima.xd.s.myapp.R;

import static kr.anima.xd.s.myapp.db.DBStructure.PurposeEntry;
import static kr.anima.xd.s.myapp.db.DBStructure.ObjectiveEntry;
import static kr.anima.xd.s.myapp.db.DBStructure.ScheduleEntry;
import static kr.anima.xd.s.myapp.db.DBStructure.TaskEntry;
import static kr.anima.xd.s.myapp.db.DBStructure.TrackerEntry;
import static kr.anima.xd.s.myapp.db.DBStructure.ElementsEntry;
import static kr.anima.xd.s.myapp.db.DBStructure.DateEntry;

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

    // Elements

    public long insertElement(String element){
        return db.insert(ElementsEntry.TABLE_NAME, null, this.createElementContentValues(element));
    }

    public ContentValues createElementContentValues(String element){
        ContentValues values=new ContentValues();
        values.put(ElementsEntry.COLUMN_TITLE, element);

        return values;
    }


    // Purpose

    public long insertPurpose(String title, int status, long timestamp){
        return db.insert(title, null, this.createPurposeContentValues(title, timestamp));
    }

    public ContentValues createPurposeContentValues(String title, long timestamp){
        ContentValues values=new ContentValues();
        values.put(PurposeEntry.COLUMN_TITLE, title);
        values.put(PurposeEntry.COLUMN_TIMESTAMP, timestamp);

        return values;
    }

    public long updatePurpose(int purposeId, String title, long timestamp){
        ContentValues values=new ContentValues();
        values.put(PurposeEntry.COLUMN_TITLE, title);
        values.put(PurposeEntry.COLUMN_TIMESTAMP, timestamp);

        return db.update(PurposeEntry.TABLE_NAME, values, PurposeEntry._ID + " = ?", new String[]{String.valueOf(purposeId)});
    }

    public long delPurpose(int purposeId){
        return db.delete(PurposeEntry.TABLE_NAME, PurposeEntry._ID + " = ?",
                new String[]{String.valueOf(purposeId)});
    }

    // Objective

    public long insertObjective(String title, long timestamp, int refPurposeId){
        return db.insert(title, null, this.createObjectiveContentValues(title, timestamp, refPurposeId));
    }

    public ContentValues createObjectiveContentValues(String title, long timestamp, int refPurposeId){
        ContentValues values=new ContentValues();
        values.put(ObjectiveEntry.COLUMN_TITLE, title);
        values.put(ObjectiveEntry.COLUMN_TIMESTAMP, timestamp);
        values.put(ObjectiveEntry.COLUMN_REF_PURPOSE__ID, refPurposeId);

        return values;
    }

    public long updateObjective(int objectiveId, String title, long timestamp, int refPurposeId){
        ContentValues values=new ContentValues();
        values.put(ObjectiveEntry.COLUMN_TITLE, title);
        values.put(ObjectiveEntry.COLUMN_TIMESTAMP, timestamp);
        values.put(ObjectiveEntry.COLUMN_REF_PURPOSE__ID, refPurposeId);

        return db.update(ObjectiveEntry.TABLE_NAME, values, ObjectiveEntry._ID + " = ?",
                new String[]{String.valueOf(objectiveId)});
    }

    public long delObjective(int objectiveId){
        return db.delete(ObjectiveEntry.TABLE_NAME, ObjectiveEntry._ID + " = ?",
                new String[]{String.valueOf(objectiveId)});
    }


    // Schedule


    public long insertSchedule(String title, int status, long startDate, long endDate,
                               int repeatType, int repeatRule, int repeatDate, int trackerType,
                               int appearance, int business, int education, int emotion,
                               int environment, int finances, int health, int spirituality,
                               long timestamp, int refObjectiveId){
        return db.insert(title, null, this.createScheduleContentValues(title, status, startDate,
                endDate, repeatType, repeatRule, repeatDate, trackerType,
                appearance, business, education, emotion, environment, finances, health, spirituality,
                timestamp, refObjectiveId));
    }

    public ContentValues createScheduleContentValues(String title, int status, long startDate, long endDate,
                                                     int repeatType, int repeatRule, int repeatDate, int trackerType,
                                                     int appearance, int business, int education, int emotion,
                                                     int environment, int finances, int health, int spirituality,
                                                     long timestamp, int refObjectiveId){
        ContentValues values=new ContentValues();
        values.put(ScheduleEntry.COLUMN_TITLE, title);
        values.put(ScheduleEntry.COLUMN_STATUS, status);
        values.put(ScheduleEntry.COLUMN_START_DATE, startDate);
        values.put(ScheduleEntry.COLUMN_END_DATE, endDate);
        values.put(ScheduleEntry.COLUMN_REPEAT_TYPE, repeatType);
        values.put(ScheduleEntry.COLUMN_REPEAT_RULE, repeatRule);
        values.put(ScheduleEntry.COLUMN_REPEAT_DATE, repeatDate);
        values.put(ScheduleEntry.COLUMN_TRACKER_TYPE, trackerType);
        values.put(ScheduleEntry.COLUMN_ELEMENT_APPEARANCE, appearance);
        values.put(ScheduleEntry.COLUMN_ELEMENT_BUSINESS, business);
        values.put(ScheduleEntry.COLUMN_ELEMENT_EDUCATION, education);
        values.put(ScheduleEntry.COLUMN_ELEMENT_EMOTION, emotion);
        values.put(ScheduleEntry.COLUMN_ELEMENT_ENVIRONMENT, environment);
        values.put(ScheduleEntry.COLUMN_ELEMENT_FINANCES, finances);
        values.put(ScheduleEntry.COLUMN_ELEMENT_HEALTH, health);
        values.put(ScheduleEntry.COLUMN_ELEMENT_SPIRITUALITY, spirituality);
        values.put(ScheduleEntry.COLUMN_TIMESTAMP, timestamp);
        values.put(ScheduleEntry.COLUMN_REF_OBJECTIVE__ID, refObjectiveId);
        return  values;
    }

    public long updateSchedule(int scheduleId, String title, int status, long startDate, long endDate,
                               int repeatType, int repeatRule, int repeatDate, int trackerType,
                               int appearance, int business, int education, int emotion,
                               int environment, int finances, int health, int spirituality,
                               long timestamp, int refObjectiveId){
        ContentValues values=new ContentValues();
        values.put(ScheduleEntry.COLUMN_TITLE, title);
        values.put(ScheduleEntry.COLUMN_STATUS, status);
        values.put(ScheduleEntry.COLUMN_START_DATE, startDate);
        values.put(ScheduleEntry.COLUMN_END_DATE, endDate);
        values.put(ScheduleEntry.COLUMN_REPEAT_TYPE, repeatType);
        values.put(ScheduleEntry.COLUMN_REPEAT_RULE, repeatRule);
        values.put(ScheduleEntry.COLUMN_REPEAT_DATE, repeatDate);
        values.put(ScheduleEntry.COLUMN_TRACKER_TYPE, trackerType);
        values.put(ScheduleEntry.COLUMN_ELEMENT_APPEARANCE, appearance);
        values.put(ScheduleEntry.COLUMN_ELEMENT_BUSINESS, business);
        values.put(ScheduleEntry.COLUMN_ELEMENT_EDUCATION, education);
        values.put(ScheduleEntry.COLUMN_ELEMENT_EMOTION, emotion);
        values.put(ScheduleEntry.COLUMN_ELEMENT_ENVIRONMENT, environment);
        values.put(ScheduleEntry.COLUMN_ELEMENT_FINANCES, finances);
        values.put(ScheduleEntry.COLUMN_ELEMENT_HEALTH, health);
        values.put(ScheduleEntry.COLUMN_ELEMENT_SPIRITUALITY, spirituality);
        values.put(ScheduleEntry.COLUMN_TIMESTAMP, timestamp);
        values.put(ScheduleEntry.COLUMN_REF_OBJECTIVE__ID, refObjectiveId);
        return db.update(ScheduleEntry.TABLE_NAME, values, ScheduleEntry._ID+ " = ?",
                new String[]{String.valueOf(scheduleId)});
    }


    public long delSchedule(int scheduleId){
        return db.delete(ScheduleEntry.TABLE_NAME, ScheduleEntry._ID + " = ?",
                new String[]{String.valueOf(scheduleId)});
    }

    public Cursor selectScheduleByDate(long date){
        Cursor c=db.query(ScheduleEntry.TABLE_NAME, null, ScheduleEntry._ID + " = ?", new String[]{String.valueOf(date)}, null, null, null);
        if (c!=null){
            c.moveToFirst();
        }
        return c;
    }

    public Cursor selectScheduleByObjective(int objectiveId){
        Cursor c=db.query(ScheduleEntry.TABLE_NAME, null, ScheduleEntry._ID + " = ?", new String[]{String.valueOf(objectiveId)}, null, null, null);
        if (c!=null){
            c.moveToFirst();
        }
        return c;
    }

    public Cursor selectScheduleByPurpose(int purposeId){
        Cursor c=db.query(ScheduleEntry.TABLE_NAME, null, ScheduleEntry._ID + " = ?", new String[]{String.valueOf(purposeId)}, null, null, null);
        if (c!=null){
            c.moveToFirst();
        }
        return c;
    }


//    public Cursor selectScheduleByDate(long date){
////        Cursor c=db.query("select * from "+ScheduleEntry.TABLE_NAME
////                    + " where " + )
//    }




    // Task

    public long insertTask(String title, int status, long startDate, long endDate,
                           int repeatType, int repeatRule, int repeatDate, int trackerType,
                           int appearance, int business, int education, int emotion,
                           int environment, int finances, int health, int spirituality,
                           long timestamp, int refObjectiveId){
        return db.insert(title, null,
                this.createTaskContentValues(title, status, startDate,
                        endDate, repeatType, repeatRule, repeatDate, trackerType,
                        appearance, business, education, emotion, environment, finances, health, spirituality,
                        timestamp, refObjectiveId));
    }

    public ContentValues createTaskContentValues(String title, int status, long startDate, long endDate,
                                                 int repeatType, int repeatRule, int repeatDate, int trackerType,
                                                 int appearance, int business, int education, int emotion,
                                                 int environment, int finances, int health, int spirituality,
                                                 long timestamp, int refObjectiveId){
        ContentValues values=new ContentValues();
        values.put(TaskEntry.COLUMN_TITLE, title);
        values.put(TaskEntry.COLUMN_STATUS, status);
        values.put(TaskEntry.COLUMN_REPEAT_TYPE, repeatType);
        values.put(TaskEntry.COLUMN_REPEAT_RULE, repeatRule);
        values.put(TaskEntry.COLUMN_REPEAT_DATE, repeatDate);
        values.put(ScheduleEntry.COLUMN_TRACKER_TYPE, trackerType);
        values.put(ScheduleEntry.COLUMN_ELEMENT_APPEARANCE, appearance);
        values.put(ScheduleEntry.COLUMN_ELEMENT_BUSINESS, business);
        values.put(ScheduleEntry.COLUMN_ELEMENT_EDUCATION, education);
        values.put(ScheduleEntry.COLUMN_ELEMENT_EMOTION, emotion);
        values.put(ScheduleEntry.COLUMN_ELEMENT_ENVIRONMENT, environment);
        values.put(ScheduleEntry.COLUMN_ELEMENT_FINANCES, finances);
        values.put(ScheduleEntry.COLUMN_ELEMENT_HEALTH, health);
        values.put(ScheduleEntry.COLUMN_ELEMENT_SPIRITUALITY, spirituality);
        values.put(TaskEntry.COLUMN_TIMESTAMP, timestamp);
        values.put(TaskEntry.COLUMN_REF_OBJECTIVE__ID, refObjectiveId);
        return  values;
    }

    public long updateTask(int taskId, String title, int status,
                           int repeatType, int repeatRule, int repeatDate, int trackerType,
                           int appearance, int business, int education, int emotion,
                           int environment, int finances, int health, int spirituality,
                           long timestamp, int refObjectiveId){

        ContentValues values=new ContentValues();

        values.put(TaskEntry.COLUMN_TITLE, title);
        values.put(TaskEntry.COLUMN_STATUS, status);
        values.put(TaskEntry.COLUMN_REPEAT_TYPE, repeatType);
        values.put(TaskEntry.COLUMN_REPEAT_RULE, repeatRule);
        values.put(TaskEntry.COLUMN_REPEAT_DATE, repeatDate);
        values.put(TaskEntry.COLUMN_TRACKER_TYPE, trackerType);
        values.put(TaskEntry.COLUMN_ELEMENT_APPEARANCE, appearance);
        values.put(TaskEntry.COLUMN_ELEMENT_BUSINESS, business);
        values.put(TaskEntry.COLUMN_ELEMENT_EDUCATION, education);
        values.put(TaskEntry.COLUMN_ELEMENT_EMOTION, emotion);
        values.put(TaskEntry.COLUMN_ELEMENT_ENVIRONMENT, environment);
        values.put(TaskEntry.COLUMN_ELEMENT_FINANCES, finances);
        values.put(TaskEntry.COLUMN_ELEMENT_HEALTH, health);
        values.put(TaskEntry.COLUMN_ELEMENT_SPIRITUALITY, spirituality);
        values.put(TaskEntry.COLUMN_TIMESTAMP, timestamp);
        values.put(TaskEntry.COLUMN_REF_OBJECTIVE__ID, refObjectiveId);

        return db.update(TaskEntry.TABLE_NAME, values, TaskEntry._ID+ " = ?",
                new String[]{String.valueOf(taskId)});
    }


    public long delTask(int taskId){
        return db.delete(ScheduleEntry.TABLE_NAME, ScheduleEntry._ID + " = ?",
                new String[]{String.valueOf(taskId)});
    }

    public Cursor selectTaskByDate(long date){
        Cursor c=db.query(TaskEntry.TABLE_NAME, null, TaskEntry._ID + " = ?", new String[]{String.valueOf(date)}, null, null, null);
        if (c!=null){
            c.moveToFirst();
        }
        return c;
    }

    public Cursor selectTaskByObjective(int objectiveId){
        Cursor c=db.query(TaskEntry.TABLE_NAME, null, TaskEntry._ID + " = ?", new String[]{String.valueOf(objectiveId)}, null, null, null);
        if (c!=null){
            c.moveToFirst();
        }
        return c;
    }

    public Cursor selectTaskByPurpose(int purposeId){
        Cursor c=db.query(TaskEntry.TABLE_NAME, null, TaskEntry._ID + " = ?", new String[]{String.valueOf(purposeId)}, null, null, null);
        if (c!=null){
            c.moveToFirst();
        }
        return c;
    }




    // Tracker

    public long insertTracker(long date, String title, int status,
                              int repeatType, int repeatRule, int repeatDate,
                              int refObjectiveId, int refPurposeId, int count){
        return db.insert(title, null, this.createTrackerContentValues(date, title, status, repeatType, repeatRule, repeatDate, refObjectiveId, refPurposeId, count));
    }

    public ContentValues createTrackerContentValues(long date, String title, int status,
                                                    int repeatType, int repeatRule, int repeatDate,
                                                    int refObjectiveId, int refPurposeId, int count){
        ContentValues values=new ContentValues();
        values.put(TrackerEntry.COLUMN_DATE, date);
        switch (count){
            case 0:
                values.put(TrackerEntry.COLUMN_TITLE_1, title);
                values.put(TrackerEntry.COLUMN_STATUS_1, status);
                values.put(TrackerEntry.COLUMN_REPEAT_TYPE_1, repeatType);
                values.put(TrackerEntry.COLUMN_REPEAT_RULE_1, repeatRule);
                values.put(TrackerEntry.COLUMN_REPEAT_DATE_1, repeatDate);
                values.put(TrackerEntry.COLUMN_REF_OBJECTIVE__ID_1, refObjectiveId);
                values.put(TrackerEntry.COLUMN_REF_PURPOSE__ID_1, refPurposeId);
                break;
            case 1:
                values.put(TrackerEntry.COLUMN_TITLE_2, title);
                values.put(TrackerEntry.COLUMN_STATUS_2, status);
                values.put(TrackerEntry.COLUMN_REPEAT_TYPE_2, repeatType);
                values.put(TrackerEntry.COLUMN_REPEAT_RULE_2, repeatRule);
                values.put(TrackerEntry.COLUMN_REPEAT_DATE_2, repeatDate);
                values.put(TrackerEntry.COLUMN_REF_OBJECTIVE__ID_2, refObjectiveId);
                values.put(TrackerEntry.COLUMN_REF_PURPOSE__ID_2, refPurposeId);
                break;
            case 2:
                values.put(TrackerEntry.COLUMN_TITLE_3, title);
                values.put(TrackerEntry.COLUMN_STATUS_3, status);
                values.put(TrackerEntry.COLUMN_REPEAT_TYPE_3, repeatType);
                values.put(TrackerEntry.COLUMN_REPEAT_RULE_3, repeatRule);
                values.put(TrackerEntry.COLUMN_REPEAT_DATE_3, repeatDate);
                values.put(TrackerEntry.COLUMN_REF_OBJECTIVE__ID_3, refObjectiveId);
                values.put(TrackerEntry.COLUMN_REF_PURPOSE__ID_3, refPurposeId);
                break;
            case 3:
                values.put(TrackerEntry.COLUMN_TITLE_4, title);
                values.put(TrackerEntry.COLUMN_STATUS_4, status);
                values.put(TrackerEntry.COLUMN_REPEAT_TYPE_4, repeatType);
                values.put(TrackerEntry.COLUMN_REPEAT_RULE_4, repeatRule);
                values.put(TrackerEntry.COLUMN_REPEAT_DATE_4, repeatDate);
                values.put(TrackerEntry.COLUMN_REF_OBJECTIVE__ID_4, refObjectiveId);
                values.put(TrackerEntry.COLUMN_REF_PURPOSE__ID_4, refPurposeId);
                break;
            case 4:
                values.put(TrackerEntry.COLUMN_TITLE_5, title);
                values.put(TrackerEntry.COLUMN_STATUS_5, status);
                values.put(TrackerEntry.COLUMN_REPEAT_TYPE_5, repeatType);
                values.put(TrackerEntry.COLUMN_REPEAT_RULE_5, repeatRule);
                values.put(TrackerEntry.COLUMN_REPEAT_DATE_5, repeatDate);
                values.put(TrackerEntry.COLUMN_REF_OBJECTIVE__ID_5, refObjectiveId);
                values.put(TrackerEntry.COLUMN_REF_PURPOSE__ID_5, refPurposeId);
                break;
        }

        return  values;
    }

    public long updateTracker(long date, String title, int status,
                              int repeatType, int repeatRule, int repeatDate,
                              int refObjectiveId, int refPurposeId, int count){

        ContentValues values=new ContentValues();
        values.put(TrackerEntry.COLUMN_DATE, date);
        switch (count){
            case 0:
                values.put(TrackerEntry.COLUMN_TITLE_1, title);
                values.put(TrackerEntry.COLUMN_STATUS_1, status);
                values.put(TrackerEntry.COLUMN_REPEAT_TYPE_1, repeatType);
                values.put(TrackerEntry.COLUMN_REPEAT_RULE_1, repeatRule);
                values.put(TrackerEntry.COLUMN_REPEAT_DATE_1, repeatDate);
                values.put(TrackerEntry.COLUMN_REF_OBJECTIVE__ID_1, refObjectiveId);
                values.put(TrackerEntry.COLUMN_REF_PURPOSE__ID_1, refPurposeId);
                break;
            case 1:
                values.put(TrackerEntry.COLUMN_TITLE_2, title);
                values.put(TrackerEntry.COLUMN_STATUS_2, status);
                values.put(TrackerEntry.COLUMN_REPEAT_TYPE_2, repeatType);
                values.put(TrackerEntry.COLUMN_REPEAT_RULE_2, repeatRule);
                values.put(TrackerEntry.COLUMN_REPEAT_DATE_2, repeatDate);
                values.put(TrackerEntry.COLUMN_REF_OBJECTIVE__ID_2, refObjectiveId);
                values.put(TrackerEntry.COLUMN_REF_PURPOSE__ID_2, refPurposeId);
                break;
            case 2:
                values.put(TrackerEntry.COLUMN_TITLE_3, title);
                values.put(TrackerEntry.COLUMN_STATUS_3, status);
                values.put(TrackerEntry.COLUMN_REPEAT_TYPE_3, repeatType);
                values.put(TrackerEntry.COLUMN_REPEAT_RULE_3, repeatRule);
                values.put(TrackerEntry.COLUMN_REPEAT_DATE_3, repeatDate);
                values.put(TrackerEntry.COLUMN_REF_OBJECTIVE__ID_3, refObjectiveId);
                values.put(TrackerEntry.COLUMN_REF_PURPOSE__ID_3, refPurposeId);
                break;
            case 3:
                values.put(TrackerEntry.COLUMN_TITLE_4, title);
                values.put(TrackerEntry.COLUMN_STATUS_4, status);
                values.put(TrackerEntry.COLUMN_REPEAT_TYPE_4, repeatType);
                values.put(TrackerEntry.COLUMN_REPEAT_RULE_4, repeatRule);
                values.put(TrackerEntry.COLUMN_REPEAT_DATE_4, repeatDate);
                values.put(TrackerEntry.COLUMN_REF_OBJECTIVE__ID_4, refObjectiveId);
                values.put(TrackerEntry.COLUMN_REF_PURPOSE__ID_4, refPurposeId);
                break;
            case 4:
                values.put(TrackerEntry.COLUMN_TITLE_5, title);
                values.put(TrackerEntry.COLUMN_STATUS_5, status);
                values.put(TrackerEntry.COLUMN_REPEAT_TYPE_5, repeatType);
                values.put(TrackerEntry.COLUMN_REPEAT_RULE_5, repeatRule);
                values.put(TrackerEntry.COLUMN_REPEAT_DATE_5, repeatDate);
                values.put(TrackerEntry.COLUMN_REF_OBJECTIVE__ID_5, refObjectiveId);
                values.put(TrackerEntry.COLUMN_REF_PURPOSE__ID_5, refPurposeId);
                break;

        }

        return db.update(TaskEntry.TABLE_NAME, values, TaskEntry._ID+ " = ?",
                new String[]{String.valueOf(date)});
    }

    public long delTracker(int trackerId){
        // TODO :: 트래커 번호별로 구분해야하지 않나?
        return db.delete(ScheduleEntry.TABLE_NAME, ScheduleEntry._ID + " = ?",
                new String[]{String.valueOf(trackerId)});
    }

    public long insertDate(long date, int contentType, int refObjectiveId, int refPurposeId){
        return db.insert(DateEntry.TABLE_NAME, null, this.createDateContentValues(date, contentType, refObjectiveId, refPurposeId));
    }

    public ContentValues createDateContentValues(long date, int contentType, int refObjectiveId, int refPurposeId){
        ContentValues values=new ContentValues();
        values.put(DateEntry.COLUMN_TITLE, date);
        values.put(DateEntry.COLUMN_CONTENT_TYPE, contentType);
        values.put(DateEntry.COLUMN_REF_OBJECTIVE__ID, refObjectiveId);
        values.put(DateEntry.COLUMN_REF_PURPOSE_ID, refPurposeId);

        return values;
    }


}
