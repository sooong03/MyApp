package kr.anima.xd.s.myapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static kr.anima.xd.s.myapp.db.DBStructure.ElementsEntry;
import static kr.anima.xd.s.myapp.db.DBStructure.ObjectiveEntry;
import static kr.anima.xd.s.myapp.db.DBStructure.PurposeEntry;
import static kr.anima.xd.s.myapp.db.DBStructure.ScheduleEntry;
import static kr.anima.xd.s.myapp.db.DBStructure.TaskEntry;
import static kr.anima.xd.s.myapp.db.DBStructure.TrackerEntry;
import static kr.anima.xd.s.myapp.db.DBStructure.DateEntry;

/**
 * Created by PC on 2017-08-26.
 */

public class DBOpener extends SQLiteOpenHelper {

    // myapp.db 에 각각의 테이블 생성

    // TODO :: insert, load url !!!
    public static final String INSERT_URL = "http://sooong03.dothome.co.kr/android/insertDB.php";
    public static final String LOAD_URL = "http://sooong03.dothome.co.kr/android/loadDB.php";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "myapp.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";

    private static final String COMMA_SEP = ",";
    private static final String FOREIGN = " FOREIGN KEY ";
    private static final String REFERENCES = " REFERENCES ";

//    private static final String SQL_CREATE_TOPIC_ENTRIES =
//            "CREATE TABLE " + TopicEntry.TABLE_NAME + " (" +
//                    TopicEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
//                    TopicEntry.COLUMN_TYPE + INTEGER_TYPE +
//                    " )";
//
//    private static final String SQL_CREATE_TOPIC_TYPE_ENTRIES =
//            "CREATE TABLE " + TopicTypeEntry.TABLE_NAME + " (" +
//                    TopicTypeEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
//                    TopicTypeEntry.COLUMN_NAME + INTEGER_TYPE +
//                    " )";

    private static final String SQL_CREATE_PURPOSE_ENTRIES =
            "CREATE TABLE " + PurposeEntry.TABLE_NAME + " (" +
                    PurposeEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                    PurposeEntry.COLUMN_TITLE + TEXT_TYPE + COMMA_SEP +
                    PurposeEntry.COLUMN_TIMESTAMP + INTEGER_TYPE +
                    " )";

    private static final String SQL_CREATE_OBJECTIVE_ENTRIES =
            "CREATE TABLE " + ObjectiveEntry.TABLE_NAME + " (" +
                    ObjectiveEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                    ObjectiveEntry.COLUMN_TITLE + TEXT_TYPE + COMMA_SEP +
                    ObjectiveEntry.COLUMN_TIMESTAMP + INTEGER_TYPE + COMMA_SEP +
                    ObjectiveEntry.COLUMN_REF_PURPOSE__ID + INTEGER_TYPE +
                    " )";


    private static final String SQL_CREATE_SCHEDULE_ENTRIES =
            "CREATE TABLE " + ScheduleEntry.TABLE_NAME + " (" +
                    ScheduleEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                    ScheduleEntry.COLUMN_TITLE + TEXT_TYPE + COMMA_SEP +
                    ScheduleEntry.COLUMN_STATUS + INTEGER_TYPE + COMMA_SEP +
                    ScheduleEntry.COLUMN_START_DATE + INTEGER_TYPE + COMMA_SEP +
                    ScheduleEntry.COLUMN_END_DATE + INTEGER_TYPE + COMMA_SEP +
                    ScheduleEntry.COLUMN_REPEAT_TYPE + INTEGER_TYPE + COMMA_SEP +
                    ScheduleEntry.COLUMN_REPEAT_RULE + INTEGER_TYPE + COMMA_SEP +
                    ScheduleEntry.COLUMN_REPEAT_DATE + INTEGER_TYPE + COMMA_SEP +
                    ScheduleEntry.COLUMN_TRACKER_TYPE + INTEGER_TYPE + COMMA_SEP +
                    ScheduleEntry.COLUMN_ELEMENT_APPEARANCE + INTEGER_TYPE + COMMA_SEP +
                    ScheduleEntry.COLUMN_ELEMENT_BUSINESS + INTEGER_TYPE + COMMA_SEP +
                    ScheduleEntry.COLUMN_ELEMENT_EDUCATION + INTEGER_TYPE + COMMA_SEP +
                    ScheduleEntry.COLUMN_ELEMENT_EMOTION + INTEGER_TYPE + COMMA_SEP +
                    ScheduleEntry.COLUMN_ELEMENT_ENVIRONMENT + INTEGER_TYPE + COMMA_SEP +
                    ScheduleEntry.COLUMN_ELEMENT_FINANCES + INTEGER_TYPE + COMMA_SEP +
                    ScheduleEntry.COLUMN_ELEMENT_HEALTH + INTEGER_TYPE + COMMA_SEP +
                    ScheduleEntry.COLUMN_ELEMENT_RELATIONSHIP + INTEGER_TYPE + COMMA_SEP +
                    ScheduleEntry.COLUMN_ELEMENT_SPIRITUALITY + INTEGER_TYPE + COMMA_SEP +
                    ScheduleEntry.COLUMN_TIMESTAMP + INTEGER_TYPE + COMMA_SEP +
                    ScheduleEntry.COLUMN_REF_OBJECTIVE__ID + INTEGER_TYPE +
                    " )";

    private static final String SQL_CREATE_TASK_ENTRIES =
            "CREATE TABLE " + TaskEntry.TABLE_NAME + " (" +
                    TaskEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                    TaskEntry.COLUMN_TITLE + TEXT_TYPE + COMMA_SEP +
                    TaskEntry.COLUMN_STATUS + INTEGER_TYPE + COMMA_SEP +
                    TaskEntry.COLUMN_REPEAT_TYPE + INTEGER_TYPE + COMMA_SEP +
                    TaskEntry.COLUMN_REPEAT_RULE + INTEGER_TYPE + COMMA_SEP +
                    TaskEntry.COLUMN_REPEAT_DATE + INTEGER_TYPE + COMMA_SEP +
                    TaskEntry.COLUMN_TRACKER_TYPE + INTEGER_TYPE + COMMA_SEP +
                    TaskEntry.COLUMN_ELEMENT_APPEARANCE + INTEGER_TYPE + COMMA_SEP +
                    TaskEntry.COLUMN_ELEMENT_BUSINESS + INTEGER_TYPE + COMMA_SEP +
                    TaskEntry.COLUMN_ELEMENT_EDUCATION + INTEGER_TYPE + COMMA_SEP +
                    TaskEntry.COLUMN_ELEMENT_EMOTION + INTEGER_TYPE + COMMA_SEP +
                    TaskEntry.COLUMN_ELEMENT_ENVIRONMENT + INTEGER_TYPE + COMMA_SEP +
                    TaskEntry.COLUMN_ELEMENT_FINANCES + INTEGER_TYPE + COMMA_SEP +
                    TaskEntry.COLUMN_ELEMENT_HEALTH + INTEGER_TYPE + COMMA_SEP +
                    TaskEntry.COLUMN_ELEMENT_RELATIONSHIP + INTEGER_TYPE + COMMA_SEP +
                    TaskEntry.COLUMN_ELEMENT_SPIRITUALITY + INTEGER_TYPE + COMMA_SEP +
                    TaskEntry.COLUMN_TIMESTAMP + INTEGER_TYPE + COMMA_SEP +
                    TaskEntry.COLUMN_REF_OBJECTIVE__ID + INTEGER_TYPE +
                    " )";

    private static final String SQL_CREATE_TRACKER_ENTRIES =
            "CREATE TABLE " + TrackerEntry.TABLE_NAME + " (" +
                    TrackerEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                    TrackerEntry.COLUMN_DATE + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_TITLE_1 + TEXT_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_TITLE_2 + TEXT_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_TITLE_3 + TEXT_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_TITLE_4 + TEXT_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_TITLE_5 + TEXT_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_STATUS_1 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_STATUS_2 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_STATUS_3 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_STATUS_4 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_STATUS_5 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REPEAT_TYPE_1 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REPEAT_TYPE_2 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REPEAT_TYPE_3 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REPEAT_TYPE_4 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REPEAT_TYPE_5 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REPEAT_RULE_1 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REPEAT_RULE_2 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REPEAT_RULE_3 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REPEAT_RULE_4 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REPEAT_RULE_5 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REPEAT_DATE_1 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REPEAT_DATE_2 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REPEAT_DATE_3 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REPEAT_DATE_4 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REPEAT_DATE_5 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REF_OBJECTIVE__ID_1 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REF_OBJECTIVE__ID_2 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REF_OBJECTIVE__ID_3 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REF_OBJECTIVE__ID_4 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REF_OBJECTIVE__ID_5 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REF_PURPOSE__ID_1 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REF_PURPOSE__ID_2 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REF_PURPOSE__ID_3 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REF_PURPOSE__ID_4 + INTEGER_TYPE + COMMA_SEP +
                    TrackerEntry.COLUMN_REF_PURPOSE__ID_5 + INTEGER_TYPE +
                    " )";

    private static final String SQL_CREATE_ELEMENTS_ENTRIES =
            "CREATE TABLE " + ElementsEntry.TABLE_NAME + " (" +
                    ElementsEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                    ElementsEntry.COLUMN_TITLE + TEXT_TYPE +
                    " )";

    private static final String SQL_CREATE_DATE_ENTRIES =
            "CREATE TABLE " + DateEntry.TABLE_NAME + " (" +
                    DateEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                    DateEntry.COLUMN_TITLE + INTEGER_TYPE + COMMA_SEP +
                    DateEntry.COLUMN_CONTENT_TYPE + INTEGER_TYPE + COMMA_SEP +
                    DateEntry.COLUMN_REF_OBJECTIVE__ID + INTEGER_TYPE + COMMA_SEP +
                    DateEntry.COLUMN_REF_PURPOSE_ID + INTEGER_TYPE +
                    " )";



//    private static final String SQL_CREATE_USER_ENTRIES =
//            "CREATE TABLE " +UserEntry.TABLE_NAME + " (" +
//                    UserEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
//                    UserEntry.COLUMN_PURPOSE + TEXT_TYPE + COMMA_SEP +
//                    UserEntry.COLUMN_COUNT_PURPOSE + INTEGER_TYPE + COMMA_SEP +
//                    UserEntry.COLUMN_ELEMENT_APPEARANCE + INTEGER_TYPE + COMMA_SEP +
//                    UserEntry.COLUMN_ELEMENT_BUSINESS + INTEGER_TYPE + COMMA_SEP +
//                    UserEntry.COLUMN_ELEMENT_EDUCATION + INTEGER_TYPE + COMMA_SEP +
//                    UserEntry.COLUMN_ELEMENT_EMOTION + INTEGER_TYPE + COMMA_SEP +
//                    UserEntry.COLUMN_ELEMENT_ENVIRONMENT + INTEGER_TYPE + COMMA_SEP +
//                    UserEntry.COLUMN_ELEMENT_FINANCES + INTEGER_TYPE + COMMA_SEP +
//                    UserEntry.COLUMN_ELEMENT_HEALTH + INTEGER_TYPE + COMMA_SEP +
//                    UserEntry.COLUMN_ELEMENT_RELATIONSHIP + INTEGER_TYPE + COMMA_SEP +
//                    UserEntry.COLUMN_ELEMENT_SPIRITUALITY + INTEGER_TYPE + COMMA_SEP +
//                    UserEntry.COLUMN_STATUS + INTEGER_TYPE + COMMA_SEP +
//                    UserEntry.COLUMN_TIMESTAMP + INTEGER_TYPE + COMMA_SEP +
//                    UserEntry.COLUMN_FINAL_TIMESTAMP + INTEGER_TYPE + COMMA_SEP +
//                    UserEntry.COLUMN_DELETED + INTEGER_TYPE + COMMA_SEP +
//                    " )";
//
//    private static final String SQL_CREATE_PURPOSE_ENTRIES =
//            "CREATE TABLE " +PurposeEntry.TABLE_NAME + " (" +
//                    PurposeEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
//                    PurposeEntry.COLUMN_OBJECTIVE + TEXT_TYPE + COMMA_SEP +
//                    PurposeEntry.COLUMN_COUNT_CONTENT + INTEGER_TYPE + COMMA_SEP +
//                    PurposeEntry.COLUMN_ELEMENT_APPEARANCE + INTEGER_TYPE + COMMA_SEP +
//                    PurposeEntry.COLUMN_ELEMENT_BUSINESS + INTEGER_TYPE + COMMA_SEP +
//                    PurposeEntry.COLUMN_ELEMENT_EDUCATION + INTEGER_TYPE + COMMA_SEP +
//                    PurposeEntry.COLUMN_ELEMENT_EMOTION + INTEGER_TYPE + COMMA_SEP +
//                    PurposeEntry.COLUMN_ELEMENT_ENVIRONMENT + INTEGER_TYPE + COMMA_SEP +
//                    PurposeEntry.COLUMN_ELEMENT_FINANCES + INTEGER_TYPE + COMMA_SEP +
//                    PurposeEntry.COLUMN_ELEMENT_HEALTH + INTEGER_TYPE + COMMA_SEP +
//                    PurposeEntry.COLUMN_ELEMENT_RELATIONSHIP + INTEGER_TYPE + COMMA_SEP +
//                    PurposeEntry.COLUMN_ELEMENT_SPIRITUALITY + INTEGER_TYPE + COMMA_SEP +
//                    PurposeEntry.COLUMN_STATUS + INTEGER_TYPE + COMMA_SEP +
//                    PurposeEntry.COLUMN_TIMESTAMP + INTEGER_TYPE + COMMA_SEP +
//                    PurposeEntry.COLUMN_FINAL_TIMESTAMP + INTEGER_TYPE + COMMA_SEP +
//                    PurposeEntry.COLUMN_DELETED + INTEGER_TYPE + COMMA_SEP +
//                    " )";
//
//    private static final String SQL_CREATE_OBJECTIVE_ENTRIES =
//            "CREATE TABLE " +ObjectiveEntry.TABLE_NAME + " (" +
//                    ObjectiveEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
//                    ObjectiveEntry.COLUMN_PARENT + TEXT_TYPE + COMMA_SEP +
//                    ObjectiveEntry.COLUMN_CONTENT + TEXT_TYPE + COMMA_SEP +
//                    ObjectiveEntry.COLUMN_CONTENT_TYPE + INTEGER_TYPE + COMMA_SEP +
//                    ObjectiveEntry.COLUMN_COUNT_CONTENT + INTEGER_TYPE + COMMA_SEP +
//                    ObjectiveEntry.COLUMN_ELEMENT_APPEARANCE + INTEGER_TYPE + COMMA_SEP +
//                    ObjectiveEntry.COLUMN_ELEMENT_BUSINESS + INTEGER_TYPE + COMMA_SEP +
//                    ObjectiveEntry.COLUMN_ELEMENT_EDUCATION + INTEGER_TYPE + COMMA_SEP +
//                    ObjectiveEntry.COLUMN_ELEMENT_EMOTION + INTEGER_TYPE + COMMA_SEP +
//                    ObjectiveEntry.COLUMN_ELEMENT_ENVIRONMENT + INTEGER_TYPE + COMMA_SEP +
//                    ObjectiveEntry.COLUMN_ELEMENT_FINANCES + INTEGER_TYPE + COMMA_SEP +
//                    ObjectiveEntry.COLUMN_ELEMENT_HEALTH + INTEGER_TYPE + COMMA_SEP +
//                    ObjectiveEntry.COLUMN_ELEMENT_RELATIONSHIP + INTEGER_TYPE + COMMA_SEP +
//                    ObjectiveEntry.COLUMN_ELEMENT_SPIRITUALITY + INTEGER_TYPE + COMMA_SEP +
//                    ObjectiveEntry.COLUMN_STATUS + INTEGER_TYPE + COMMA_SEP +
//                    ObjectiveEntry.COLUMN_TIMESTAMP + INTEGER_TYPE + COMMA_SEP +
//                    ObjectiveEntry.COLUMN_FINAL_TIMESTAMP + INTEGER_TYPE + COMMA_SEP +
//                    ObjectiveEntry.COLUMN_DELETED + INTEGER_TYPE + COMMA_SEP +
//                    " )";
//
//    private static final String SQL_CREATE_CONTENT_ENTRIES =
//            "CREATE TABLE " +ContentEntry.TABLE_NAME + " (" +
//                    ContentEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
//                    ContentEntry.COLUMN_NAME + TEXT_TYPE + COMMA_SEP +
//                    ContentEntry.COLUMN_TYPE + INTEGER_TYPE + COMMA_SEP +
//                    ContentEntry.COLUMN_ELEMENT_APPEARANCE + INTEGER_TYPE + COMMA_SEP +
//                    ContentEntry.COLUMN_ELEMENT_BUSINESS + INTEGER_TYPE + COMMA_SEP +
//                    ContentEntry.COLUMN_ELEMENT_EDUCATION + INTEGER_TYPE + COMMA_SEP +
//                    ContentEntry.COLUMN_ELEMENT_EMOTION + INTEGER_TYPE + COMMA_SEP +
//                    ContentEntry.COLUMN_ELEMENT_ENVIRONMENT + INTEGER_TYPE + COMMA_SEP +
//                    ContentEntry.COLUMN_ELEMENT_FINANCES + INTEGER_TYPE + COMMA_SEP +
//                    ContentEntry.COLUMN_ELEMENT_HEALTH + INTEGER_TYPE + COMMA_SEP +
//                    ContentEntry.COLUMN_ELEMENT_RELATIONSHIP + INTEGER_TYPE + COMMA_SEP +
//                    ContentEntry.COLUMN_ELEMENT_SPIRITUALITY + INTEGER_TYPE + COMMA_SEP +
//                    ContentEntry.COLUMN_STATUS + INTEGER_TYPE + COMMA_SEP +
//                    ContentEntry.COLUMN_TIMESTAMP + INTEGER_TYPE + COMMA_SEP +
//                    ContentEntry.COLUMN_FINAL_TIMESTAMP + INTEGER_TYPE + COMMA_SEP +
//                    ContentEntry.COLUMN_DELETED + INTEGER_TYPE + COMMA_SEP +
//                    " )";
//
//    private static final String SQL_CREATE_SCHEDULE_ENTRIES =
//            "CREATE TABLE " +ScheduleEntry.TABLE_NAME + " (" +
//                    ScheduleEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
//                    ScheduleEntry.COLUMN_SCHEDULE + TEXT_TYPE + COMMA_SEP +
//                    ScheduleEntry.COLUMN_REPEAT + INTEGER_TYPE + COMMA_SEP +
//                    ScheduleEntry.COLUMN_REPEAT_RULE + INTEGER_TYPE + COMMA_SEP +
//                    ScheduleEntry.COLUMN_REPEAT_DATE + INTEGER_TYPE + COMMA_SEP +
//                    ScheduleEntry.COLUMN_ALARM + INTEGER_TYPE + COMMA_SEP +
//                    ScheduleEntry.COLUMN_ALARM_RULE + INTEGER_TYPE + COMMA_SEP +
//                    ScheduleEntry.COLUMN_ALARM_DATE + INTEGER_TYPE + COMMA_SEP +
//                    ScheduleEntry.COLUMN_ELEMENT_APPEARANCE + INTEGER_TYPE + COMMA_SEP +
//                    ScheduleEntry.COLUMN_ELEMENT_BUSINESS + INTEGER_TYPE + COMMA_SEP +
//                    ScheduleEntry.COLUMN_ELEMENT_EDUCATION + INTEGER_TYPE + COMMA_SEP +
//                    ScheduleEntry.COLUMN_ELEMENT_EMOTION + INTEGER_TYPE + COMMA_SEP +
//                    ScheduleEntry.COLUMN_ELEMENT_ENVIRONMENT + INTEGER_TYPE + COMMA_SEP +
//                    ScheduleEntry.COLUMN_ELEMENT_FINANCES + INTEGER_TYPE + COMMA_SEP +
//                    ScheduleEntry.COLUMN_ELEMENT_HEALTH + INTEGER_TYPE + COMMA_SEP +
//                    ScheduleEntry.COLUMN_ELEMENT_RELATIONSHIP + INTEGER_TYPE + COMMA_SEP +
//                    ScheduleEntry.COLUMN_ELEMENT_SPIRITUALITY + INTEGER_TYPE + COMMA_SEP +
//                    ScheduleEntry.COLUMN_STATUS + INTEGER_TYPE + COMMA_SEP +
//                    ScheduleEntry.COLUMN_TIMESTAMP + INTEGER_TYPE + COMMA_SEP +
//                    ScheduleEntry.COLUMN_FINAL_TIMESTAMP + INTEGER_TYPE + COMMA_SEP +
//                    ScheduleEntry.COLUMN_DELETED + INTEGER_TYPE + COMMA_SEP +
//                    " )";
//
//    private static final String SQL_CREATE_TASK_ENTRIES =
//            "CREATE TABLE " +TaskEntry.TABLE_NAME + " (" +
//                    TaskEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
//                    TaskEntry.COLUMN_TASK + TEXT_TYPE + COMMA_SEP +
//                    TaskEntry.COLUMN_REPEAT + INTEGER_TYPE + COMMA_SEP +
//                    TaskEntry.COLUMN_REPEAT_RULE + INTEGER_TYPE + COMMA_SEP +
//                    TaskEntry.COLUMN_REPEAT_DATE + INTEGER_TYPE + COMMA_SEP +
//                    TaskEntry.COLUMN_ALARM + INTEGER_TYPE + COMMA_SEP +
//                    TaskEntry.COLUMN_ALARM_RULE + INTEGER_TYPE + COMMA_SEP +
//                    TaskEntry.COLUMN_ALARM_DATE + INTEGER_TYPE + COMMA_SEP +
//                    TaskEntry.COLUMN_ELEMENT_APPEARANCE + INTEGER_TYPE + COMMA_SEP +
//                    TaskEntry.COLUMN_ELEMENT_BUSINESS + INTEGER_TYPE + COMMA_SEP +
//                    TaskEntry.COLUMN_ELEMENT_EDUCATION + INTEGER_TYPE + COMMA_SEP +
//                    TaskEntry.COLUMN_ELEMENT_EMOTION + INTEGER_TYPE + COMMA_SEP +
//                    TaskEntry.COLUMN_ELEMENT_ENVIRONMENT + INTEGER_TYPE + COMMA_SEP +
//                    TaskEntry.COLUMN_ELEMENT_FINANCES + INTEGER_TYPE + COMMA_SEP +
//                    TaskEntry.COLUMN_ELEMENT_HEALTH + INTEGER_TYPE + COMMA_SEP +
//                    TaskEntry.COLUMN_ELEMENT_RELATIONSHIP + INTEGER_TYPE + COMMA_SEP +
//                    TaskEntry.COLUMN_ELEMENT_SPIRITUALITY + INTEGER_TYPE + COMMA_SEP +
//                    TaskEntry.COLUMN_STATUS + INTEGER_TYPE + COMMA_SEP +
//                    TaskEntry.COLUMN_TIMESTAMP + INTEGER_TYPE + COMMA_SEP +
//                    TaskEntry.COLUMN_FINAL_TIMESTAMP + INTEGER_TYPE + COMMA_SEP +
//                    TaskEntry.COLUMN_DELETED + INTEGER_TYPE + COMMA_SEP +
//                    " )";
//
//    private static final String SQL_CREATE_TRACKER_ENTRIES =
//            "CREATE TABLE " +TrackerTypeEntry.TABLE_NAME + " (" +
//                    TrackerTypeEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
//                    TrackerTypeEntry.COLUMN_NAME + TEXT_TYPE + COMMA_SEP +
//                    TrackerTypeEntry.COLUMN_REPEAT + INTEGER_TYPE + COMMA_SEP +
//                    TrackerTypeEntry.COLUMN_CHECK + INTEGER_TYPE + COMMA_SEP +
//                    TrackerTypeEntry.COLUMN_ALARM + INTEGER_TYPE + COMMA_SEP +
//                    TrackerTypeEntry.COLUMN_ALARM_RULE + INTEGER_TYPE + COMMA_SEP +
//                    TrackerTypeEntry.COLUMN_ALARM_DATE + INTEGER_TYPE + COMMA_SEP +
//                    TrackerTypeEntry.COLUMN_ELEMENT_APPEARANCE + INTEGER_TYPE + COMMA_SEP +
//                    TrackerTypeEntry.COLUMN_ELEMENT_BUSINESS + INTEGER_TYPE + COMMA_SEP +
//                    TrackerTypeEntry.COLUMN_ELEMENT_EDUCATION + INTEGER_TYPE + COMMA_SEP +
//                    TrackerTypeEntry.COLUMN_ELEMENT_EMOTION + INTEGER_TYPE + COMMA_SEP +
//                    TrackerTypeEntry.COLUMN_ELEMENT_ENVIRONMENT + INTEGER_TYPE + COMMA_SEP +
//                    TrackerTypeEntry.COLUMN_ELEMENT_FINANCES + INTEGER_TYPE + COMMA_SEP +
//                    TrackerTypeEntry.COLUMN_ELEMENT_HEALTH + INTEGER_TYPE + COMMA_SEP +
//                    TrackerTypeEntry.COLUMN_ELEMENT_RELATIONSHIP + INTEGER_TYPE + COMMA_SEP +
//                    TrackerTypeEntry.COLUMN_ELEMENT_SPIRITUALITY + INTEGER_TYPE + COMMA_SEP +
//                    TrackerTypeEntry.COLUMN_STATUS + INTEGER_TYPE + COMMA_SEP +
//                    TrackerTypeEntry.COLUMN_TIMESTAMP + INTEGER_TYPE + COMMA_SEP +
//                    TrackerTypeEntry.COLUMN_FINAL_TIMESTAMP + INTEGER_TYPE + COMMA_SEP +
//                    TrackerTypeEntry.COLUMN_DELETED + INTEGER_TYPE + COMMA_SEP +
//                    " )";
//
//
//    private static final String SQL_CREATE_DATE_ENTRIES =
//            "CREATE TABLE " + DateEntry.TABLE_NAME + " (" +
//                    DateEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
//                    DateEntry.COLUMN_DATE + INTEGER_TYPE + COMMA_SEP +
//                    DateEntry.COLUMN_TIME + INTEGER_TYPE + COMMA_SEP +
//                    DateEntry.COLUMN_COUNT + INTEGER_TYPE + COMMA_SEP +
//                    DateEntry.COLUMN_STATUS + INTEGER_TYPE + COMMA_SEP +
//                    " )";
//
//    private static final String SQL_CREATE_ELEMENTS_ENTRIES =
//            "CREATE TABLE " +ElementsEntry.TABLE_NAME + " (" +
//                    ElementsEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
//                    ElementsEntry.COLUMN_ELEMENT_APPEARANCE + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_APPEARANCE_PURPOSE + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_APPEARANCE_OBJECTIVE + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_APPEARANCE_CONTNET + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_ELEMENT_BUSINESS + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_BUSINESS_PURPOSE + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_BUSINESS_OBJECTIVE + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_BUSINESS_CONTENT + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_ELEMENT_EDUCATION + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_EDUCATION_PURPOSE + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_EDUCATION_OBJECTIVE + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_EDUCATION_CONTENT + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_ELEMENT_EMOTION + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_EMOTION_PURPOSE + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_EMOTION_OBJECTIVE + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_EMOTION_CONTENT + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_ELEMENT_ENVIRONMENT + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_ENVIRONMENT_PURPOSE + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_ENVIRONMENT_OBJECTIVE + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_ENVIRONMENT_CONTENT + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_ELEMENT_FINANCES + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_FINANCES_PURPOSE + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_FINANCES_OBJECTIVE + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_FINANCES_CONTENT + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_ELEMENT_HEALTH + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_HEALTH_PURPOSE + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_HEALTH_OBJECTIVE + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_HEALTH_CONTENT + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_ELEMENT_RELATIONSHIP + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_RELATIONSHIP_PURPOSE + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_RELATIONSHIP_OBJECTIVE + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_RELATIONSHIP_CONTENT + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_ELEMENT_SPIRITUALITY + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_SPIRITUALITY_PURPOSE + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_SPIRITUALITY_OBJECTIVE + INTEGER_TYPE + COMMA_SEP +
//                    ElementsEntry.COLUMN_COUNT_SPIRITUALITY_CONTENT + INTEGER_TYPE + COMMA_SEP +
//                    " )";
//
//
//    private static final String SQL_CREATE_STATUS_ENTRIES =
//            "CREATE TABLE " + StatusEntry.TABLE_NAME + " (" +
//                    StatusEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
//                    StatusEntry.COLUMN_STATUS + INTEGER_TYPE + COMMA_SEP +
//                    StatusEntry.COLUMN_COUNT + INTEGER_TYPE + COMMA_SEP +
//                    " )";
//
//    private static final String SQL_CREATE_STATUS_TYPE_ENTRIES =
//            "CREATE TABLE " + StatusTypeEntry.TABLE_NAME + " (" +
//                    StatusTypeEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
//                    StatusTypeEntry.COLUMN_PURPOSE + TEXT_TYPE + COMMA_SEP +
//                    StatusTypeEntry.COLUMN_OBJECTIVE + TEXT_TYPE + COMMA_SEP +
//                    StatusTypeEntry.COLUMN_CONTENT + TEXT_TYPE + COMMA_SEP +
//                    StatusTypeEntry.COLUMN_TIMESTAMP + INTEGER_TYPE + COMMA_SEP +
//                    StatusTypeEntry.COLUMN_FINAL_TIMESTAMP + INTEGER_TYPE + COMMA_SEP +
//                    StatusTypeEntry.COLUMN_DELETED + INTEGER_TYPE + COMMA_SEP +
//                    " )";
//
//    private static final String SQL_CREATE_ELEMENT_ENTRIES =
//            "CREATE TABLE " + ElementEntry.TABLE_NAME + " (" +
//                    ElementEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
//                    ElementEntry.COLUMN_PURPOSE_NAME + TEXT_TYPE + COMMA_SEP +
//                    ElementEntry.COLUMN_OBJECTIVE_NAME + TEXT_TYPE + COMMA_SEP +
//                    ElementEntry.COLUMN_CONTENT_NAME + TEXT_TYPE + COMMA_SEP +
//                    ElementEntry.COLUMN_STATUS_CONTENT + INTEGER_TYPE + COMMA_SEP +
//                    ElementEntry.COLUMN_TIMESTAMP + INTEGER_TYPE + COMMA_SEP +
//                    ElementEntry.COLUMN_FINAL_TIMESTAMP + INTEGER_TYPE + COMMA_SEP +
//                    ElementEntry.COLUMN_DELETED + INTEGER_TYPE + COMMA_SEP +
//                    " )";

    public DBOpener(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


//        db.execSQL(SQL_CREATE_TOPIC_ENTRIES);
//        db.execSQL(SQL_CREATE_TOPIC_TYPE_ENTRIES);

//        db.execSQL(SQL_CREATE_USER_ENTRIES);

        db.execSQL(SQL_CREATE_PURPOSE_ENTRIES);
//        db.execSQL(SQL_CREATE_DATE_ENTRIES);
        db.execSQL(SQL_CREATE_ELEMENTS_ENTRIES);
//        db.execSQL(SQL_CREATE_STATUS_ENTRIES);

        db.execSQL(SQL_CREATE_OBJECTIVE_ENTRIES);
//        db.execSQL(SQL_CREATE_STATUS_TYPE_ENTRIES);
//        db.execSQL(SQL_CREATE_ELEMENT_ENTRIES);
//
//        db.execSQL(SQL_CREATE_CONTENT_ENTRIES);
        db.execSQL(SQL_CREATE_SCHEDULE_ENTRIES);
        db.execSQL(SQL_CREATE_TASK_ENTRIES);
        db.execSQL(SQL_CREATE_TRACKER_ENTRIES);

        db.execSQL(SQL_CREATE_DATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO :: UPGRADE
    }
}
