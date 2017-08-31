package kr.anima.xd.s.myapp.db;

import android.provider.BaseColumns;

/**
 * Created by PC on 2017-08-26.
 */

public class DBStructure {

    // db 테이블의 스키마값

    // 테이블 설정
    // 목적목록 테이블 : 목적명, 보유 목표개수, 보유 일정(스케쥴+테스크) 개수, 적용요소(최소 1 최대 9), 시작일, 종료일, 작성일, 최종수정일, 진행상황, 삭제여부
    // 요소목록 테이블 : 요소명, 보유 일정개수

    // 각각의 목적 테이블 : 목표명, 보유 일정(스케쥴+테스크) 개수, 적용요소(최소 1 최대 9), 시작일, 종료일, 작성일, 최종수정일, 진행상황, 삭제여부
    // 각각의 목표 테이블 : 일정명, 일정타입(스케쥴 또는 테스크), 적용요소(최소 1 최대 목적테이블의 적용요소 개수), 시작일, 종료일, 반복여부, 반복규칙, 반복날짜, 알람여부, 알람규칙, 알람날짜, 생성일, 최종수정일, 진행상황, 삭제여부
    // 각각의 일정 테이블 : 스케쥴명, 적용요소(최소1 최대 목적테이블의 적용요소 개수), 시작일, 종료일, 반복여부, 반복규칙, 반복날짜, 알람여부, 알람규칙, 알람날짜, 트래커 생성여부, 생성일, 최종수정일, 진행상황, 삭제여부
    // 각각의 할일 테이블 : 할일명, 적용요소(최소1 최대 목적테이블의 적용요소 개수), 시작일, 종료일, 반복여부, 반복규칙, 반복날짜, 알람여부, 알람규칙, 알람날짜, 트래커 생성여부, 생성일, 최종수정일, 진행상황, 삭제여부
    // 각각의 트래커 테이블 : 트래커명, 시행날짜, 시행여부, 진행상황, 삭제여부

    // 목표목록테이블 : 목표명, 해당목적아이디, 적용요소, 시작일, 종료일, 반복여부, 반복규칙, 반복날짜, 생성일, 최종수정일, 진행상황, 삭제여부
    // 일정목록테이블 : 일정명, 해당목표아이디, 적용요소, 시작일, 종료일, 반복여부, 반복규칙, 반복날짜, 생성일, 최종수정일, 진행상황, 삭제여부
    // 할일목록테이블 : 할일명, 해당목표아이디, 적용요소, 시행일, 반복여부, 반복규칙, 반복날짜, 생성일, 최종수정일, 진행상황, 삭제여부
    // 트래커목록테이블 : 타이틀, 타입, 진행상황



    // purpose entry : id, purpose title, status, timeStamp, finalTimeStamp, ref_element_id (1~9)
    // objective entry : id, title, status, timeStamp, finalTimeStamp, ref_element_id, ref_purpose_id
    // schedule entry : id, title, status, startDate, endDate, isRepeat, repeatRule, repeatDate, timeStamp, finalTimeStamp, ref_objective_id
    // task entry : id, title, status, isRepeat, repeatRule, repeatData, timeStamp, finalTimeStamp, ref_objective_id
    // tracker entry : id, title, status, repeatRule, repeatData, (tracker type ??) ref_purpose_id
    // elements entry : id, element name

    public static final String SAMPLE_DATA_LOAD_URL ="http://sooong03.dothome.co.kr/myapp/sampledata/loadDB.php";

    public static final String CLOUD_DATA_LOAD_URL="http://sooong03.dothome.co.kr/myapp/cloud/loadDB.php";
    public static final String CLOUD_DATA_INSERT_URL="http://sooong03.dothome.co.kr/myapp/cloud/insertDB.php";

    public static final String COMMENT_DATA_LOAD_URL="http://sooong03.dothome.co.kr/myapp/comment/loadDB.php";
    public static final String COMMENT_DATA_INSERT_URL="http://sooong03.dothome.co.kr/myapp/comment/insertDB.php";

    // purpose entry : id, purpose title, status, timeStamp, finalTimeStamp, ref_element_id (1~9)
    public static abstract class PurposeEntry implements BaseColumns{
        public static final String TABLE_NAME="purpose_entry";
        public static final String COLUMN_TITLE="purpose_title";
//        public static final String COLUMN_STATUS="purpose_status";
        public static final String COLUMN_TIMESTAMP="purpose_timestamp";
//        public static final String COLUMN_FINAL_TIMESTAMP="purpose_final_timestamp";
//        public static final String COLUMN_REF_ELEMENTS__ID="purpose_ref_elements_id";
    }

    // objective entry : id, title, status, timeStamp, finalTimeStamp, ref_element_id, ref_purpose_id
    public static abstract class ObjectiveEntry implements BaseColumns{
        public static final String TABLE_NAME="objective_entry";
        public static final String COLUMN_TITLE="objective_title";
//        public static final String COLUMN_STATUS="objective_status";
        public static final String COLUMN_TIMESTAMP="objective_timestamp";
//        public static final String COLUMN_FINAL_TIMESTAMP="objective_final_timestamp";
//        public static final String COLUMN_REF_ELEMENTS__ID="objective_ref_elements_id";
        public static final String COLUMN_REF_PURPOSE__ID="objective_ref_purpose_id";
    }

    // schedule entry : id, title, status, startDate, endDate, isRepeat, repeatRule, repeatDate, timeStamp, finalTimeStamp, ref_objective_id
    public static abstract class ScheduleEntry implements BaseColumns{
        public static final String TABLE_NAME="schedule_entry";
        public static final String COLUMN_TITLE="schedule_title";
        public static final String COLUMN_STATUS="schedule_status";
        public static final String COLUMN_START_DATE="schedule_start_date";
        public static final String COLUMN_END_DATE="schedule_end_date";
        public static final String COLUMN_REPEAT_TYPE="schedule_repeat_type";
        public static final String COLUMN_REPEAT_RULE="schedule_repeat_rule";
        public static final String COLUMN_REPEAT_DATE="schedule_repeat_date";
        public static final String COLUMN_TRACKER_TYPE="schedule_tracker_type";
        public static final String COLUMN_ELEMENT_APPEARANCE="schedule_element_appearance"; // 외모
        public static final String COLUMN_ELEMENT_BUSINESS="schedule_element_business"; // 사업
        public static final String COLUMN_ELEMENT_EDUCATION="schedule_element_education"; // 교육
        public static final String COLUMN_ELEMENT_EMOTION="schedule_element_emotion"; // 감정
        public static final String COLUMN_ELEMENT_ENVIRONMENT="schedule_element_environment"; // 환경
        public static final String COLUMN_ELEMENT_FINANCES="schedule_element_finances"; // 재정
        public static final String COLUMN_ELEMENT_HEALTH="schedule_element_health"; // 건강
        public static final String COLUMN_ELEMENT_RELATIONSHIP="schedule_element_relationship"; // 관계
        public static final String COLUMN_ELEMENT_SPIRITUALITY="schedule_element_spirituality"; // 정신
        public static final String COLUMN_TIMESTAMP="schedule_timestamp";
//        public static final String COLUMN_FINAL_TIMESTAMP="schedule_final_timestamp";
        public static final String COLUMN_REF_OBJECTIVE__ID="schedule_ref_objective_id";
    }

    // task entry : id, title, status, isRepeat, repeatRule, repeatData, timeStamp, finalTimeStamp, ref_objective_id
    public static abstract class TaskEntry implements BaseColumns{
        public static final String TABLE_NAME="task_entry";
        public static final String COLUMN_TITLE="task_title";
        public static final String COLUMN_STATUS="task_status";
        public static final String COLUMN_REPEAT_TYPE="task_repeat_type";
        public static final String COLUMN_REPEAT_RULE="task_repeat_rule";
        public static final String COLUMN_REPEAT_DATE="task_repeat_date";
        public static final String COLUMN_TRACKER_TYPE="task_tracker_type";
        public static final String COLUMN_ELEMENT_APPEARANCE="task_element_appearance"; // 외모
        public static final String COLUMN_ELEMENT_BUSINESS="task_element_business"; // 사업
        public static final String COLUMN_ELEMENT_EDUCATION="task_element_education"; // 교육
        public static final String COLUMN_ELEMENT_EMOTION="task_element_emotion"; // 감정
        public static final String COLUMN_ELEMENT_ENVIRONMENT="task_element_environment"; // 환경
        public static final String COLUMN_ELEMENT_FINANCES="task_element_finances"; // 재정
        public static final String COLUMN_ELEMENT_HEALTH="task_element_health"; // 건강
        public static final String COLUMN_ELEMENT_RELATIONSHIP="task_element_relationship"; // 관계
        public static final String COLUMN_ELEMENT_SPIRITUALITY="task_element_spirituality"; // 정신
        public static final String COLUMN_TIMESTAMP="task_timestamp";
//        public static final String COLUMN_FINAL_TIMESTAMP="task_final_timestamp";
        public static final String COLUMN_REF_OBJECTIVE__ID="task_ref_objective_id";
    }


    // tracker entry : id, title, status, repeatRule, repeatData, (tracker type ??) ref_purpose_id
    public static abstract class TrackerEntry implements BaseColumns{
        public static final String TABLE_NAME="tracker_entry";
        public static final String COLUMN_DATE="tracker_date";
        public static final String COLUMN_TITLE_1="tracker_title_1";
        public static final String COLUMN_TITLE_2="tracker_title_2";
        public static final String COLUMN_TITLE_3="tracker_title_3";
        public static final String COLUMN_TITLE_4="tracker_title_4";
        public static final String COLUMN_TITLE_5="tracker_title_5";
        public static final String COLUMN_STATUS_1="tracker_status_1";
        public static final String COLUMN_STATUS_2="tracker_status_2";
        public static final String COLUMN_STATUS_3="tracker_status_3";
        public static final String COLUMN_STATUS_4="tracker_status_4";
        public static final String COLUMN_STATUS_5="tracker_status_5";
        public static final String COLUMN_REPEAT_TYPE_1="tracker_repeat_type_1";
        public static final String COLUMN_REPEAT_TYPE_2="tracker_repeat_type_2";
        public static final String COLUMN_REPEAT_TYPE_3="tracker_repeat_type_3";
        public static final String COLUMN_REPEAT_TYPE_4="tracker_repeat_type_4";
        public static final String COLUMN_REPEAT_TYPE_5="tracker_repeat_type_5";
        public static final String COLUMN_REPEAT_RULE_1="tracker_repeat_rule_1";
        public static final String COLUMN_REPEAT_RULE_2="tracker_repeat_rule_2";
        public static final String COLUMN_REPEAT_RULE_3="tracker_repeat_rule_3";
        public static final String COLUMN_REPEAT_RULE_4="tracker_repeat_rule_4";
        public static final String COLUMN_REPEAT_RULE_5="tracker_repeat_rule_5";
        public static final String COLUMN_REPEAT_DATE_1="tracker_repeat_date_1";
        public static final String COLUMN_REPEAT_DATE_2="tracker_repeat_date_2";
        public static final String COLUMN_REPEAT_DATE_3="tracker_repeat_date_3";
        public static final String COLUMN_REPEAT_DATE_4="tracker_repeat_date_4";
        public static final String COLUMN_REPEAT_DATE_5="tracker_repeat_date_5";
        public static final String COLUMN_REF_OBJECTIVE__ID_1="tracker_ref_objective_id_1";
        public static final String COLUMN_REF_OBJECTIVE__ID_2="tracker_ref_objective_id_2";
        public static final String COLUMN_REF_OBJECTIVE__ID_3="tracker_ref_objective_id_3";
        public static final String COLUMN_REF_OBJECTIVE__ID_4="tracker_ref_objective_id_4";
        public static final String COLUMN_REF_OBJECTIVE__ID_5="tracker_ref_objective_id_5";
        public static final String COLUMN_REF_PURPOSE__ID_1="tracker_ref_purpose_id_1";
        public static final String COLUMN_REF_PURPOSE__ID_2="tracker_ref_purpose_id_2";
        public static final String COLUMN_REF_PURPOSE__ID_3="tracker_ref_purpose_id_3";
        public static final String COLUMN_REF_PURPOSE__ID_4="tracker_ref_purpose_id_4";
        public static final String COLUMN_REF_PURPOSE__ID_5="tracker_ref_purpose_id_5";
    }


    // elements entry : id, element name
    public static abstract class ElementsEntry implements BaseColumns{
        public static final String TABLE_NAME="elements_entry";
        public static final String COLUMN_TITLE="elements_title";
    }

    // date entry : id, date
    public static abstract class DateEntry implements BaseColumns{
        public static final String TABLE_NAME="date_entry";
        public static final String COLUMN_TITLE="date_title";
        public static final String COLUMN_CONTENT_TYPE="date_content_type";
        public static final String COLUMN_REF_OBJECTIVE__ID="date_ref_objective_id";
        public static final String COLUMN_REF_PURPOSE_ID="date_ref_purpose_id";
    }


//
//
//    // 테이블 이름, 항목명, 항목개수, 요소포함 여부, 포함요소, 진행상황, 생성일, 최종수정일, 삭제여부, 토픽 아이디
//
//    // 사용자 DB
//    // user/user name.db
//    public static abstract class UserEntry implements BaseColumns{
//        public static final String TABLE_NAME="table of content";
//        public static final String COLUMN_PURPOSE="purpose_name";
//        public static final String COLUMN_COUNT_PURPOSE="purpose_count"; // 보유 목적 개수
//        public static final String COLUMN_ELEMENT="purpose_element";
//        public static final String COLUMN_ELEMENT_APPEARANCE="purpose_element_appearance"; // 외모
//        public static final String COLUMN_ELEMENT_BUSINESS="purpose_element_business"; // 사업
//        public static final String COLUMN_ELEMENT_EDUCATION="purpose_element_education"; // 교육
//        public static final String COLUMN_ELEMENT_EMOTION="purpose_element_emotion"; // 감정
//        public static final String COLUMN_ELEMENT_ENVIRONMENT="purpose_element_environment"; // 환경
//        public static final String COLUMN_ELEMENT_FINANCES="purpose_element_finances"; // 재정
//        public static final String COLUMN_ELEMENT_HEALTH="purpose_element_health"; // 건강
//        public static final String COLUMN_ELEMENT_RELATIONSHIP="purpose_element_relationship"; // 관계
//        public static final String COLUMN_ELEMENT_SPIRITUALITY="purpose_element_spirituality"; // 정신
//        public static final String COLUMN_STATUS="purpose_status"; // 진행상황
//        public static final String COLUMN_TIMESTAMP="purpose_timestamp"; // 생성일
//        public static final String COLUMN_FINAL_TIMESTAMP="purpose_final_timestamp"; // 최종수정일
//        public static final String COLUMN_DELETED="purpose_deleted"; // 삭제여부
//        public static final String COLUMN_REF_TOPIC__ID="purpose_ref_topic_id";
//    }
//
//    // 1차 카테고리 : purpose, date, elements, status
//    // 사용자 DB, purpose
//    // user/user name/purpose name.db
//    public static abstract class PurposeEntry implements BaseColumns{
//        public static final String TABLE_NAME="purpose_entry";
//        public static final String COLUMN_OBJECTIVE="purpose_objective_name";
//        public static final String COLUMN_COUNT_CONTENT="purpose_count_content"; // 보유 목표 개수
//        public static final String COLUMN_ELEMENT="purpose_objective_element";
//        public static final String COLUMN_ELEMENT_APPEARANCE="purpose_element_appearance"; // 외모
//        public static final String COLUMN_ELEMENT_BUSINESS="purpose_element_business"; // 사업
//        public static final String COLUMN_ELEMENT_EDUCATION="purpose_element_education"; // 교육
//        public static final String COLUMN_ELEMENT_EMOTION="purpose_element_emotion"; // 감정
//        public static final String COLUMN_ELEMENT_ENVIRONMENT="purpose_element_environment"; // 환경
//        public static final String COLUMN_ELEMENT_FINANCES="purpose_element_finances"; // 재정
//        public static final String COLUMN_ELEMENT_HEALTH="purpose_element_health"; // 건강
//        public static final String COLUMN_ELEMENT_RELATIONSHIP="purpose_element_relationship"; // 관계
//        public static final String COLUMN_ELEMENT_SPIRITUALITY="purpose_element_spirituality"; // 정신
//        public static final String COLUMN_STATUS="purpose_objective_status"; // 진행상황
//        public static final String COLUMN_TIMESTAMP="purpose_objective_timestamp"; // 생성일
//        public static final String COLUMN_FINAL_TIMESTAMP="purpose_objective_final_timestamp"; // 최종수정일
//        public static final String COLUMN_DELETED="purpose_objective_deleted"; // 삭제여부
//        public static final String COLUMN_REF_TOPIC__ID="purpose_objective_ref_topic_id";
//    }
//
//    // 1차 카테고리 : purpose, date, elements, status
//    // 사용자 DB, date
//    // user/user name/date.db
//    public static abstract class DateEntry implements BaseColumns{
//        public static final String TABLE_NAME="date_entry";
//        public static final String COLUMN_DATE="date_date";
//        public static final String COLUMN_TIME="date_time";
//        public static final String COLUMN_COUNT="date_count"; // 보유 컨텐츠 개수
//        public static final String COLUMN_STATUS="date_status"; // 진행상황
//        public static final String COLUMN_REF_TOPIC__ID="date_ref_topic_id";
//    }
//
//    // 1차 카테고리 : purpose, date, elements, status
//    // 사용자 DB, elements
//    // user/user name/elements.db
//    public static abstract class ElementsEntry implements BaseColumns{
//        public static final String TABLE_NAME="elements_entry";
//        public static final String COLUMN_ELEMENT="elements_name";
//        public static final String COLUMN_ELEMENT_APPEARANCE="elements_element_appearance"; // 외모
//        public static final String COLUMN_COUNT_APPEARANCE_PURPOSE="elements_count_appearance_purpose"; // 외모의 목적 개수
//        public static final String COLUMN_COUNT_APPEARANCE_OBJECTIVE="elements_count_appearance_objective"; // 외모의 목표 개수
//        public static final String COLUMN_COUNT_APPEARANCE_CONTNET="elements_count_appearance_content"; // 외모의 컨텐츠 개수
//        public static final String COLUMN_ELEMENT_BUSINESS="elements_element_business"; // 사업
//        public static final String COLUMN_COUNT_BUSINESS_PURPOSE="elements_count_business_purpose"; // 사업의 목적 개수
//        public static final String COLUMN_COUNT_BUSINESS_OBJECTIVE="elements_count_business_objective"; // 사업의 목표 개수
//        public static final String COLUMN_COUNT_BUSINESS_CONTENT="elements_count_business_content"; // 사업의 컨텐츠 개수
//        public static final String COLUMN_ELEMENT_EDUCATION="elements_element_education"; // 교육
//        public static final String COLUMN_COUNT_EDUCATION_PURPOSE="elements_count_education"; // 교육의 목적 개수
//        public static final String COLUMN_COUNT_EDUCATION_OBJECTIVE="elements_count_education"; // 교육의 목표 개수
//        public static final String COLUMN_COUNT_EDUCATION_CONTENT="elements_count_education"; // 교육의 컨텐츠 개수
//        public static final String COLUMN_ELEMENT_EMOTION="elements_element_emotion"; // 감정
//        public static final String COLUMN_COUNT_EMOTION_PURPOSE="elements_count_emotion"; // 감정의 목적 개수
//        public static final String COLUMN_COUNT_EMOTION_OBJECTIVE="elements_count_emotion"; // 감정의 목표 개수
//        public static final String COLUMN_COUNT_EMOTION_CONTENT="elements_count_emotion"; // 감정의 컨텐츠 개수
//        public static final String COLUMN_ELEMENT_ENVIRONMENT="elements_element_environment"; // 환경
//        public static final String COLUMN_COUNT_ENVIRONMENT_PURPOSE="elements_count_environment"; // 환경의 목적 개수
//        public static final String COLUMN_COUNT_ENVIRONMENT_OBJECTIVE="elements_count_environment"; // 환경의 목표 개수
//        public static final String COLUMN_COUNT_ENVIRONMENT_CONTENT="elements_count_environment"; // 환경의 컨텐츠 개수
//        public static final String COLUMN_ELEMENT_FINANCES="elements_element_finances"; // 재정
//        public static final String COLUMN_COUNT_FINANCES_PURPOSE="elements_count_finances"; // 재정의 목적 개수
//        public static final String COLUMN_COUNT_FINANCES_OBJECTIVE="elements_count_finances"; // 재정의 목표 개수
//        public static final String COLUMN_COUNT_FINANCES_CONTENT="elements_count_finances"; // 재정의 컨텐츠 개수
//        public static final String COLUMN_ELEMENT_HEALTH="elements_element_health"; // 건강
//        public static final String COLUMN_COUNT_HEALTH_PURPOSE="elements_count_health"; // 건강의 목적 개수
//        public static final String COLUMN_COUNT_HEALTH_OBJECTIVE="elements_count_health"; // 건강의 목표 개수
//        public static final String COLUMN_COUNT_HEALTH_CONTENT="elements_count_health"; // 건강의 컨텐츠 개수
//        public static final String COLUMN_ELEMENT_RELATIONSHIP="elements_element_relationship"; // 관계
//        public static final String COLUMN_COUNT_RELATIONSHIP_PURPOSE="elements_count_relationship"; // 관계의 목적 개수
//        public static final String COLUMN_COUNT_RELATIONSHIP_OBJECTIVE="elements_count_relationship"; // 관계의 목표 개수
//        public static final String COLUMN_COUNT_RELATIONSHIP_CONTENT="elements_count_relationship"; // 관계의 컨텐츠 개수
//        public static final String COLUMN_ELEMENT_SPIRITUALITY="elements_element_spirituality"; // 정신
//        public static final String COLUMN_COUNT_SPIRITUALITY_PURPOSE="elements_count_spirituality"; // 정신의 목적 개수
//        public static final String COLUMN_COUNT_SPIRITUALITY_OBJECTIVE="elements_count_spirituality"; // 정신의 목표 개수
//        public static final String COLUMN_COUNT_SPIRITUALITY_CONTENT="elements_count_spirituality"; // 정신의 컨텐츠 개수
//        public static final String COLUMN_REF_TOPIC__ID="elements_element_ref_topic_id";
//    }
//
//    // 1차 카테고리 : purpose, date, elements, status
//    // 사용자 DB, status
//    // user/user name/status.db
//    public static abstract class StatusEntry implements BaseColumns{
//        public static final String TABLE_NAME="status_entry";
//        public static final String COLUMN_STATUS="status_name";
//        public static final String COLUMN_COUNT="status_count"; // 개수
//        public static final String COLUMN_REF_TOPIC__ID="status_ref_topic_id";
//    }
//
//    // 2차 카테고리 : status type, objective name, element name
//    // 사용자 DB, status type
//    // user/user name/status/status type.db
//    public static abstract class StatusTypeEntry implements BaseColumns{
//        public static final String TABLE_NAME="status_type_entry";
//        public static final String COLUMN_PURPOSE="status_type_purpose_name";
//        public static final String COLUMN_OBJECTIVE="status_type_objective_name";
//        public static final String COLUMN_CONTENT="status_type_content_name";
//        public static final String COLUMN_TIMESTAMP="status_type_timestamp"; // 생성일
//        public static final String COLUMN_FINAL_TIMESTAMP="status_type_final_timestamp"; // 최종수정일
//        public static final String COLUMN_DELETED="status_type_deleted"; // 삭제여부
//        public static final String COLUMN_REF_TOPIC__ID="status_type_ref_topic_id";
//    }
//
//    // 2차 카테고리 : status type, objective name, element name
//    // 사용자 DB, objective name
//    // user/user name/purpose/objective name.db
//    public static abstract class ObjectiveEntry implements BaseColumns{
//        public static final String TABLE_NAME="objective_entry";
//        public static final String COLUMN_PARENT="objective_parent"; // 상위 항목명
//        public static final String COLUMN_CONTENT="objective_content_name";
//        public static final String COLUMN_CONTENT_TYPE="objective_content_type";
//        public static final String COLUMN_COUNT_CONTENT="objective_count_content"; // 보유 컨텐츠 타입의 개수
//        public static final String COLUMN_ELEMENT="objective_element";
//        public static final String COLUMN_ELEMENT_APPEARANCE="objective_element_appearance"; // 외모
//        public static final String COLUMN_ELEMENT_BUSINESS="objective_element_business"; // 사업
//        public static final String COLUMN_ELEMENT_EDUCATION="objective_element_education"; // 교육
//        public static final String COLUMN_ELEMENT_EMOTION="objective_element_emotion"; // 감정
//        public static final String COLUMN_ELEMENT_ENVIRONMENT="objective_element_environment"; // 환경
//        public static final String COLUMN_ELEMENT_FINANCES="objective_element_finances"; // 재정
//        public static final String COLUMN_ELEMENT_HEALTH="objective_element_health"; // 건강
//        public static final String COLUMN_ELEMENT_RELATIONSHIP="objective_element_relationship"; // 관계
//        public static final String COLUMN_ELEMENT_SPIRITUALITY="objective_element_spirituality"; // 정신
//        public static final String COLUMN_STATUS="objective_status"; // 진행상황
//        public static final String COLUMN_TIMESTAMP="objective_timestamp"; // 생성일
//        public static final String COLUMN_FINAL_TIMESTAMP="objective_final_timestamp"; // 최종수정일
//        public static final String COLUMN_DELETED="objective_deleted"; // 삭제여부
//        public static final String COLUMN_REF_TOPIC__ID="objective_ref_topic_id";
//    }
//
//    // 2차 카테고리 : status type, objective name, element name
//    // 사용자 DB, element name
//    // user/user name/elements/element name.db
//    public static abstract class ElementEntry implements BaseColumns{
//        public static final String TABLE_NAME="element_entry";
//        public static final String COLUMN_PURPOSE_NAME="element_purpose_name"; // 해당 목적명
//        public static final String COLUMN_OBJECTIVE_NAME="element_objective_name"; // 해당 목표명
//        public static final String COLUMN_CONTENT_NAME="element_content_name"; // 해당 컨텐츠명
//        public static final String COLUMN_STATUS_CONTENT="element_status_content"; // 보유 컨텐츠 진행상황
//        public static final String COLUMN_TIMESTAMP="element_timestamp"; // 생성일
//        public static final String COLUMN_FINAL_TIMESTAMP="element_final_timestamp"; // 최종수정일
//        public static final String COLUMN_DELETED="element_deleted"; // 삭제여부
//        public static final String COLUMN_REF_TOPIC__ID="element_ref_topic_id";
//    }
//
//
//
//    // 3차 카테고리 : content name, content schedule, content task
//    // 사용자 DB, content name
//    // user/user name/purpose/objective name/content name.db
//    public static abstract class ContentEntry implements BaseColumns{
//        public static final String TABLE_NAME="content_entry";
//        public static final String COLUMN_NAME="content_name";
//        public static final String COLUMN_TYPE="content_type";
//        public static final String COLUMN_ELEMENT="content_element";
//        public static final String COLUMN_ELEMENT_APPEARANCE="content_element_appearance"; // 외모
//        public static final String COLUMN_ELEMENT_BUSINESS="content_element_business"; // 사업
//        public static final String COLUMN_ELEMENT_EDUCATION="content_element_education"; // 교육
//        public static final String COLUMN_ELEMENT_EMOTION="content_element_emotion"; // 감정
//        public static final String COLUMN_ELEMENT_ENVIRONMENT="content_element_environment"; // 환경
//        public static final String COLUMN_ELEMENT_FINANCES="content_element_finances"; // 재정
//        public static final String COLUMN_ELEMENT_HEALTH="content_element_health"; // 건강
//        public static final String COLUMN_ELEMENT_RELATIONSHIP="content_element_relationship"; // 관계
//        public static final String COLUMN_ELEMENT_SPIRITUALITY="content_element_spirituality"; // 정신
//        public static final String COLUMN_STATUS="content_status"; // 진행상황
//        public static final String COLUMN_TIMESTAMP="content_timestamp"; // 생성일
//        public static final String COLUMN_FINAL_TIMESTAMP="content_final_timestamp"; // 최종수정일
//        public static final String COLUMN_DELETED="content_deleted"; // 삭제여부
//        public static final String COLUMN_REF_TOPIC__ID="content_ref_topic_id";
//    }
//
//    // 3차 카테고리 : content name, content schedule, content task
//    // 사용자 DB, content schedule
//    // user/user name/purpose/objective name/content schedule.db (content type.db)
//    public static abstract class ScheduleEntry implements BaseColumns{
//        public static final String TABLE_NAME="schedule_entry";
//        public static final String COLUMN_SCHEDULE="schedule_name";
//        public static final String COLUMN_REPEAT="schedule_repeat"; // 반복여부
//        public static final String COLUMN_REPEAT_RULE="schedule_repeat_rule"; // 반복 규칙
//        public static final String COLUMN_REPEAT_DATE="schedule_repeat_DATE"; // 반복 날짜
//        public static final String COLUMN_ALARM="schedule_alarm"; // 알람여부
//        public static final String COLUMN_ALARM_RULE="schedule_alarm_rule"; // 알람 규칙
//        public static final String COLUMN_ALARM_DATE="schedule_alarm_DATE"; // 알람 날짜
//        public static final String COLUMN_ELEMENT="schedule_element";
//        public static final String COLUMN_ELEMENT_APPEARANCE="schedule_element_appearance"; // 외모
//        public static final String COLUMN_ELEMENT_BUSINESS="schedule_element_business"; // 사업
//        public static final String COLUMN_ELEMENT_EDUCATION="schedule_element_education"; // 교육
//        public static final String COLUMN_ELEMENT_EMOTION="schedule_element_emotion"; // 감정
//        public static final String COLUMN_ELEMENT_ENVIRONMENT="schedule_element_environment"; // 환경
//        public static final String COLUMN_ELEMENT_FINANCES="schedule_element_finances"; // 재정
//        public static final String COLUMN_ELEMENT_HEALTH="schedule_element_health"; // 건강
//        public static final String COLUMN_ELEMENT_RELATIONSHIP="schedule_element_relationship"; // 관계
//        public static final String COLUMN_ELEMENT_SPIRITUALITY="schedule_element_spirituality"; // 정신
//        public static final String COLUMN_STATUS="schedule_status"; // 진행상황
//        public static final String COLUMN_TIMESTAMP="schedule_timestamp"; // 생성일
//        public static final String COLUMN_FINAL_TIMESTAMP="schedule_final_timestamp"; // 최종수정일
//        public static final String COLUMN_DELETED="schedule_deleted"; // 삭제여부
//        public static final String COLUMN_REF_TOPIC__ID="schedule_ref_topic_id";
//    }
//
//    // 3차 카테고리 : content name, content schedule, content task
//    // 사용자 DB, content task
//    // user/user name/purpose/objective name/content task.db (content type.db)
//    public static abstract class TaskEntry implements BaseColumns{
//        public static final String TABLE_NAME="task_entry";
//        public static final String COLUMN_TASK="task_name";
//        public static final String COLUMN_REPEAT="task_repeat"; // 반복여부
//        public static final String COLUMN_REPEAT_RULE="task_repeat_rule"; // 반복 규칙
//        public static final String COLUMN_REPEAT_DATE="task_repeat_DATE"; // 반복 날짜
//        public static final String COLUMN_ALARM="task_alarm"; // 알람여부
//        public static final String COLUMN_ALARM_RULE="task_alarm_rule"; // 알람 규칙
//        public static final String COLUMN_ALARM_DATE="task_alarm_DATE"; // 알람 날짜
//        public static final String COLUMN_ELEMENT="task_element";
//        public static final String COLUMN_ELEMENT_APPEARANCE="task_element_appearance"; // 외모
//        public static final String COLUMN_ELEMENT_BUSINESS="task_element_business"; // 사업
//        public static final String COLUMN_ELEMENT_EDUCATION="task_element_education"; // 교육
//        public static final String COLUMN_ELEMENT_EMOTION="task_element_emotion"; // 감정
//        public static final String COLUMN_ELEMENT_ENVIRONMENT="task_element_environment"; // 환경
//        public static final String COLUMN_ELEMENT_FINANCES="task_element_finances"; // 재정
//        public static final String COLUMN_ELEMENT_HEALTH="task_element_health"; // 건강
//        public static final String COLUMN_ELEMENT_RELATIONSHIP="task_element_relationship"; // 관계
//        public static final String COLUMN_ELEMENT_SPIRITUALITY="task_element_spirituality"; // 정신
//        public static final String COLUMN_STATUS="task_status"; // 진행상황
//        public static final String COLUMN_TIMESTAMP="task_timestamp"; // 생성일
//        public static final String COLUMN_FINAL_TIMESTAMP="task_final_timestamp"; // 최종수정일
//        public static final String COLUMN_DELETED="task_deleted"; // 삭제여부
//        public static final String COLUMN_REF_TOPIC__ID="task_ref_topic_id";
//    }
//
//    public static abstract class TrackerTypeEntry implements BaseColumns {
//        public static final String TABLE_NAME = "tracker_name";
//        public static final String COLUMN_NAME = "tracker_content_name"; // 트래커 컨텐츠명
//        public static final String COLUMN_REPEAT = "tracker_repeat"; // 확인 주기
//        public static final String COLUMN_CHECK = "tracker_check"; // 확인 여부
//        public static final String COLUMN_ALARM="tracker_alarm"; // 트래커 알람 여부
//        public static final String COLUMN_ALARM_RULE="tracker_alarm_rule"; // 트래커 알람 규칙
//        public static final String COLUMN_ALARM_DATE="tracker_alarm_DATE"; // 트래커 알람 날짜
//        public static final String COLUMN_ELEMENT="tracker_element";
//        public static final String COLUMN_ELEMENT_APPEARANCE="tracker_element_appearance"; // 외모
//        public static final String COLUMN_ELEMENT_BUSINESS="tracker_element_business"; // 사업
//        public static final String COLUMN_ELEMENT_EDUCATION="tracker_element_education"; // 교육
//        public static final String COLUMN_ELEMENT_EMOTION="tracker_element_emotion"; // 감정
//        public static final String COLUMN_ELEMENT_ENVIRONMENT="tracker_element_environment"; // 환경
//        public static final String COLUMN_ELEMENT_FINANCES="tracker_element_finances"; // 재정
//        public static final String COLUMN_ELEMENT_HEALTH="tracker_element_health"; // 건강
//        public static final String COLUMN_ELEMENT_RELATIONSHIP="tracker_element_relationship"; // 관계
//        public static final String COLUMN_ELEMENT_SPIRITUALITY="tracker_element_spirituality"; // 정신
//        public static final String COLUMN_STATUS="tracker_status"; // 진행상황
//        public static final String COLUMN_TIMESTAMP="tracker_timestamp"; // 생성일
//        public static final String COLUMN_FINAL_TIMESTAMP="tracker_final_timestamp"; // 최종수정일
//        public static final String COLUMN_DELETED="tracker_deleted"; // 삭제여부
//        public static final String COLUMN_REF_TOPIC__ID = "tracker_ref_topic_id";
//    }


    // Topic : Purpose, Objective, Schedule(content), Task(content), Tracker(content ??)
//    public static abstract class TopicEntry implements BaseColumns {
//        public static final String TABLE_NAME = "topic_entry";
//        public static final String COLUMN_TYPE = "topic_type";
//    }
//
//    public static abstract class TopicTypeEntry implements BaseColumns {
//        public static final String TABLE_NAME = "topic_name";
//        public static final String COLUMN_NAME = "topic_type_name";
//        public static final String COLUMN_REF_TOPIC__ID = "topic_type_ref_topic_id";
//    }



    // 관리자 DB
    // admin/user.db
//    public static abstract class AdminEntry implements BaseColumns {
//        public static final String TABLE_NAME="admin_entry";
//        public static final String COLUMN_NAME="admin_name";
//    }
//
//    // 관리자 DB
//    // admin/calendar.db
//    public static abstract class CalendarEntry implements BaseColumns{
//        public static final String TABLE_NAME="calendar_entry";
//    }


}
