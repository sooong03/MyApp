package kr.anima.xd.s.myapp.main;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import kr.anima.xd.s.myapp.db.DBManager;
import kr.anima.xd.s.myapp.entries.inventory.InventoryFragment;
import kr.anima.xd.s.myapp.R;
import kr.anima.xd.s.myapp.entries.cloud.CloudFragment;
import kr.anima.xd.s.myapp.entries.dashboard.DashboardFragment;
import kr.anima.xd.s.myapp.entries.item.MyItemRow;
import kr.anima.xd.s.myapp.topic.MyTopic;
import kr.anima.xd.s.myapp.topic.Schedule;
import kr.anima.xd.s.myapp.topic.Task;

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

    private DBManager dbManager;
    private List<MyTopic> itemRows=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_dashboard);

        dbManager=new DBManager(MainActivity.this);
        dbManager.openDB();
        loadData();
        dbManager.closeDB();

    }

    private void loadData(){
        itemRows.clear();
        Cursor itemCursor=dbManager;
        for(int i=0; i<itemCursor.getCount(); i++){
            switch (itemCursor.getInt(2)){
                case MyItemRow.TYPE_SCHEDULE:
                    itemRows.add(new Schedule(itemCursor.getString(1), itemCursor.getInt(5), itemCursor.getLong(0)));
                    break;
                case MyItemRow.TYPE_TASK:
                    itemRows.add(new Task(itemCursor.getInt(5), itemCursor.getString(1), itemCursor.getCount()));
                    break;
            }
            itemCursor.moveToNext();
        }
        itemCursor.close();
    }

}
