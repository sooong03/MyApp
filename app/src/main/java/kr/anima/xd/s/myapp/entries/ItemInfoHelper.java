package kr.anima.xd.s.myapp.entries;

import kr.anima.xd.s.myapp.R;

/**
 * Created by daxia on 2016/10/31.
 */

public class ItemInfoHelper {

    public final static int WEATHER_SIZE = 6;
    public final static int WEATHER_SUNNY = 0;
    public final static int WEATHER_CLOUD = 1;
    public final static int WEATHER_WINDY = 2;
    public final static int WEATHER_RAINY = 3;
    public final static int WEATHER_SNOWY = 4;
    public final static int WEATHER_FOGGY = 5;


    public final static int MOOD_SIZE = 3;
    public final static int MOOD_HAPPY = 0;
    public final static int MOOD_SOSO = 1;
    public final static int MOOD_UNHAPPY = 2;

    public final static int ELEMENT_SIZE=9;
    public final static int ELEMENT_APPEARANCE = 0 ;
    public final static int ELEMENT_BUSINESS = 1 ;
    public final static int ELEMENT_EDUCATION = 2 ;
    public final static int ELEMENT_EMOTIONAL = 3 ;
    public final static int ELEMENT_ENVIRONMENT = 4 ;
    public final static int ELEMENT_FINANCES = 5 ;
    public final static int ELEMENT_HEALTH = 6 ;
    public final static int ELEMENT_RELATIONSHIPS = 7 ;
    public final static int ELEMENT_SPIRITUALITY = 8 ;


    /**
     * Weather
     */
    public static int getWeatherResourceId(int weather) {
        int weatherResourceId;
        switch (weather) {
            default:
                weatherResourceId = R.drawable.ic_weather_sunny;
                break;
            case WEATHER_CLOUD:
                weatherResourceId = R.drawable.ic_weather_cloud;
                break;
            case WEATHER_WINDY:
                weatherResourceId = R.drawable.ic_weather_windy;
                break;
            case WEATHER_RAINY:
                weatherResourceId = R.drawable.ic_weather_rainy;
                break;
            case WEATHER_SNOWY:
                weatherResourceId = R.drawable.ic_weather_snowy;
                break;
            case WEATHER_FOGGY:
                weatherResourceId = R.drawable.ic_weather_foggy;
                break;
        }
        return weatherResourceId;
    }


    public static Integer[] getWeatherArray() {
        return new Integer[]{R.drawable.ic_weather_sunny, R.drawable.ic_weather_cloud,
                R.drawable.ic_weather_windy, R.drawable.ic_weather_rainy, R.drawable.ic_weather_snowy,
                R.drawable.ic_weather_foggy};
    }


    /**
     * Mood
     */
    public static int getMoodResourceId(int mood) {
        int moodResourceId;
        switch (mood) {
            default:
                moodResourceId = R.drawable.ic_mood_happy;
                break;
            case MOOD_SOSO:
                moodResourceId = R.drawable.ic_mood_soso;
                break;
            case MOOD_UNHAPPY:
                moodResourceId = R.drawable.ic_mood_unhappy;
                break;
        }
        return moodResourceId;
    }

    public static Integer[] getMoodArray() {
        return new Integer[]{R.drawable.ic_mood_happy, R.drawable.ic_mood_soso,
                R.drawable.ic_mood_unhappy};
    }


    public static int getElementResourceId(int element){
        int elementResourceId;
        switch (element){
            default:
                elementResourceId=R.drawable.ic_sel_ele_appearance;
                break;
            case ELEMENT_APPEARANCE:
                elementResourceId=R.drawable.ic_sel_ele_appearance;
                break;
            case ELEMENT_BUSINESS:
                elementResourceId=R.drawable.ic_sel_ele_business;
                break;
            case ELEMENT_EDUCATION:
                elementResourceId=R.drawable.ic_sel_ele_education;
                break;
            case ELEMENT_EMOTIONAL:
                elementResourceId=R.drawable.ic_sel_ele_emotional;
                break;
            case ELEMENT_ENVIRONMENT:
                elementResourceId=R.drawable.ic_sel_ele_environment;
                break;
            case ELEMENT_FINANCES:
                elementResourceId=R.drawable.ic_sel_ele_finances;
                break;
            case ELEMENT_HEALTH:
                elementResourceId=R.drawable.ic_sel_ele_health;
                break;
            case ELEMENT_RELATIONSHIPS:
                elementResourceId=R.drawable.ic_sel_ele_health;
                break;
            case ELEMENT_SPIRITUALITY:
                elementResourceId=R.drawable.ic_sel_ele_spirituality;
                break;
        }
        return elementResourceId;
    }

    public static Integer[] getElementArray(){
        return new Integer[] {R.drawable.ic_sel_ele_appearance, R.drawable.ic_sel_ele_business, R.drawable.ic_sel_ele_education,
                R.drawable.ic_sel_ele_emotional, R.drawable.ic_sel_ele_environment, R.drawable.ic_sel_ele_finances,
                R.drawable.ic_sel_ele_health, R.drawable.ic_sel_ele_relationships, R.drawable.ic_sel_ele_spirituality};
    }

}
