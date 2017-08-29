package kr.anima.xd.s.myapp;


import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Spinner;

import kr.anima.xd.s.myapp.db.DBManager;
import kr.anima.xd.s.myapp.entries.ImageArrayAdapter;
import kr.anima.xd.s.myapp.entries.ItemInfoHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class EntryItemDialogFragment extends DialogFragment {

    // 상세보기 했을 때 띄울 다이얼로그

    public interface EntryItemCallback{
        void deleteItem();
        void updateItem();
    }


    private boolean isEditMode=false;
    // 기본정보
    private int itemId;

    // 수정 및 삭제 모드
    private Calendar calendar;
    private SimpleDateFormat format;

    Spinner spiWeather, spiMood;

    public static EntryItemDialogFragment newInstance(int itemId, boolean isEditMode){
        Bundle arg=new Bundle();
        EntryItemDialogFragment fragment=new EntryItemDialogFragment();
        arg.putInt("itemId", itemId);
        arg.putBoolean("isEditMode", isEditMode);
        fragment.setArguments(arg);
        return fragment;
    }

    public EntryItemDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isEditMode=getArguments().getBoolean("isEditMode", false);  // 수정모드인지 확인
    }
//
//    @NonNull
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        Dialog dialog=new Dialog(getActivity(), getTheme()){
//            @Override
//            public void onBackPressed() {
//                if (isEditMode){
//
//                    // TODO
//
//                }else {
//                    super.onBackPressed();
//                }
//            }
//        };
//
//        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//        dialog.getWindow().getDecorView().setAlpha(0);
//
//        return dialog;
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        this.getDialog().setCanceledOnTouchOutside(false);
//        View view=inflater.inflate(R.layout.fragment_entres_item_dialog, container, false);
//
//        spiMood=view.findViewById(R.id.spiMood);
//        spiWeather=view.findViewById(R.id.spiWeather);
//
//        initView(view);
//        return view;
//    }
//
//    @Override
//    public void onDismiss(DialogInterface dialog) {
//        super.onDismiss(dialog);
//    }
//
//    private void initData(){
//        DBManager dbManager=new DBManager(getActivity());
//        dbManager.openDB();
//        Cursor itemInfoCursor=dbManager.selectItemInfoByItemId(itemId);
//
//        calendar=Calendar.getInstance();
//        calendar.setTimeInMillis(itemInfoCursor.getLong(1));
//
//        format=new SimpleDateFormat("HH:mm");
//        setTime();
//
//        if(isEditMode){
//            // 수정시간 반영
//        }
//
//        itemInfoCursor.close();
//        loadItemContent(dbManager);
//        dbManager.closeDB();
//    }
//
//
//    private void initView(View rootView){
//        if(isEditMode){
//            initMoodSpinner();
//            initWeatherSpinner();
//        }
//    }
//
//    private void initMoodSpinner() {
//        ImageArrayAdapter moodArrayAdapter = new ImageArrayAdapter(getActivity(), ItemInfoHelper.getMoodArray());
//        SP_diary_mood.setAdapter(moodArrayAdapter);
//    }
//
//    private void initWeatherSpinner() {
//        ImageArrayAdapter weatherArrayAdapter = new ImageArrayAdapter(getActivity(), ItemInfoHelper.getWeatherArray());
//        SP_diary_weather.setAdapter(weatherArrayAdapter);
//    }
//
//    private void loadItemContent(DBManager dbManager){
//        Cursor itemContentCursor=dbManager.selectItemContentByItemId(itemId);
//
//        itemContentCursor.close();
//    }
//
//    private void setTime(){
//
//    }



}
