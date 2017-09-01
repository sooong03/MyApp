package kr.anima.xd.s.myapp.shared.gui;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import io.github.kobakei.materialfabspeeddial.FabSpeedDial;

/**
 * Created by alfo6-10 on 9/1/2017.
 */

public class Dial extends FabSpeedDial {

    public Dial(@NonNull Context context) {
        super(context);
    }

    public Dial(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Dial(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    @Override
//    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
//        changed=true;
//
//        super.onLayout(changed, left, top, right, bottom);
//    }

}
