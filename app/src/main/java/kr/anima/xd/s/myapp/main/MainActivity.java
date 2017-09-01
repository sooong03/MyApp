package kr.anima.xd.s.myapp.main;

import android.content.res.ColorStateList;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kr.anima.xd.s.myapp.db.DBManager;
import kr.anima.xd.s.myapp.db.DBOpener;
import kr.anima.xd.s.myapp.entries.inventory.InventoryFragment;
import kr.anima.xd.s.myapp.R;
import kr.anima.xd.s.myapp.entries.cloud.CloudFragment;
import kr.anima.xd.s.myapp.entries.dashboard.DashboardFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_cloud:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, new CloudFragment(MainActivity.this)).commit();

                    return true;
                case R.id.navigation_dashboard:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, new DashboardFragment(MainActivity.this)).commit();

                    return true;
                case R.id.navigation_inventory:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, new InventoryFragment(MainActivity.this)).commit();

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            navigation.setItemIconTintList(getResources().getColorStateList(R.color.color_tint_list, null));
        }
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_dashboard);

        initElement();
    }


    private void initElement(){

        // elements entries 생성
        DBManager dbManager=new DBManager(this);
        dbManager.openDB();
        String[] days=getResources().getStringArray(R.array.element_kor_list);
        for(int i=0; i<days.length; i++){
            dbManager.insertElement(days[i]);
        }
        dbManager.closeDB();
    }


}
